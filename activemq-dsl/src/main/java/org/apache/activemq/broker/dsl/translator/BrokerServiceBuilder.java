/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.broker.dsl.translator;

import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.apache.activemq.broker.dsl.*;
import org.apache.activemq.broker.jmx.ManagementContext;
import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.activemq.broker.region.policy.PolicyMap;
import org.apache.activemq.network.DiscoveryNetworkConnector;
import org.apache.activemq.network.NetworkConnector;
import org.apache.activemq.security.AuthenticationUser;
import org.apache.activemq.security.SimpleAuthenticationPlugin;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder class used to construct a BrokerService from a {@link org.apache.activemq.broker.dsl.BrokerBuilder}.
 *
 * @author jkorab
 */
public class BrokerServiceBuilder {

    public BrokerService build(BrokerBuilder brokerBuilder) {
        BrokerService brokerService = new BrokerService();
        brokerService.setBrokerName(brokerBuilder.getBrokerName());
        brokerService.setUseJmx(brokerBuilder.isUseJmx());
        brokerService.setPersistent(brokerBuilder.isPersistent());

        addDestinationPolicy(brokerService, brokerBuilder.getDestinationPolicyBuilder());
        addManagementContext(brokerService, brokerBuilder.getManagementContextBuilder());
        addNetworkConnectors(brokerService, brokerBuilder.getNetworkConnectorsBuilder());
        addPlugins(brokerService, brokerBuilder.getPluginsBuilder());
        addTransportConnectors(brokerService, brokerBuilder.getTransportConnectorsBuilder());
        return brokerService;
    }

    private void addDestinationPolicy(BrokerService brokerService, DestinationPolicyBuilder destinationPolicyBuilder) {
        if (destinationPolicyBuilder == null)  return;

        PolicyMapBuilder policyMapBuilder = destinationPolicyBuilder.getPolicyMapBuilder();
        if (policyMapBuilder == null) return;

        PolicyMap policyMap = new PolicyMap();
        brokerService.setDestinationPolicy(policyMap);

        policyMap.setDefaultEntry(buildPolicyEntry(policyMapBuilder.getDefaultPolicyEntryBuilder()));

        PolicyEntriesBuilder policyEntriesBuilder = policyMapBuilder.getPolicyEntriesBuilder();
        addPolicyEntries(policyMap, policyEntriesBuilder);
    }

    private PolicyEntry buildPolicyEntry(DefaultPolicyEntryBuilder definition) {
        if (definition == null) return null;

        PolicyEntry policyEntry = new PolicyEntryBuilder().build(definition);
        return policyEntry;
    }


    private void addPolicyEntries(PolicyMap policyMap, PolicyEntriesBuilder policyEntriesBuilder) {
        if (policyEntriesBuilder == null) return;

        List<org.apache.activemq.broker.dsl.PolicyEntryBuilder> policyEntryBuilders = policyEntriesBuilder.getPolicyEntryDefinitions();
        List<PolicyEntry> policyEntries = new ArrayList<>();
        for (org.apache.activemq.broker.dsl.PolicyEntryBuilder policyEntryBuilder : policyEntryBuilders) {
            PolicyEntry policyEntry = new PolicyEntryBuilder().build(policyEntryBuilder);
            policyEntries.add(policyEntry);
        }

        policyMap.setPolicyEntries(policyEntries);
    }


    private void addPlugins(BrokerService brokerService, PluginsBuilder pluginsBuilder) {
        if (pluginsBuilder == null) return;

        List<BrokerPlugin> brokerPluginList = new ArrayList<>();

        addSimpleAuthenticationPlugin(brokerPluginList, pluginsBuilder.getSimpleAuthenticationPluginBuilder());

        if (!brokerPluginList.isEmpty()) {
            brokerService.setPlugins(brokerPluginList.toArray(new BrokerPlugin[]{}));
        }
    }

    private void addSimpleAuthenticationPlugin(List<BrokerPlugin> brokerPluginList, SimpleAuthenticationPluginBuilder simpleAuthenticationPluginBuilder) {
        assert (brokerPluginList != null);
        if (simpleAuthenticationPluginBuilder == null) return;

        SimpleAuthenticationPlugin simpleAuthenticationPlugin = new SimpleAuthenticationPlugin();
        UsersBuilder usersBuilder = simpleAuthenticationPluginBuilder.getUsersBuilder();
        if (usersBuilder == null) return;

        List<AuthenticationUserBuilder> authenticationUserBuilders = usersBuilder.getAuthenticationUserBuilders();
        List<AuthenticationUser> authenticationUsers = new ArrayList<>();
        for (AuthenticationUserBuilder authenticationUserBuilder : authenticationUserBuilders) {
            authenticationUsers.add(new AuthenticationUser(
                    authenticationUserBuilder.getUsername(),
                    authenticationUserBuilder.getPassword(),
                    authenticationUserBuilder.getGroups()));
        }

        simpleAuthenticationPlugin.setUsers(authenticationUsers);
        brokerPluginList.add(simpleAuthenticationPlugin);
    }

    private void addManagementContext(BrokerService brokerService, ManagementContextBuilder managementContextBuilder) {
        if (managementContextBuilder == null) return;

        ManagementContext1Builder managementContext1Builder = managementContextBuilder.getManagementContext1Builder();
        if (managementContext1Builder == null) return;

        ManagementContext managementContext = new ManagementContext();
        managementContext.setCreateConnector(managementContext1Builder.isCreateConnector());
        brokerService.setManagementContext(managementContext);

    }

    private void addTransportConnectors(BrokerService brokerService, TransportConnectorsBuilder transportConnectorsBuilder) {
        if (transportConnectorsBuilder == null) return;

        for (TransportConnectorBuilder tcDefinition : transportConnectorsBuilder.getTransportConnectorDefinitions()) {
            TransportConnector transportConnector = new TransportConnector();
            transportConnector.setName(tcDefinition.getName());
            transportConnector.setUri(URI.create(tcDefinition.getUri()));
            try {
                brokerService.addConnector(transportConnector);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void addNetworkConnectors(BrokerService brokerService, NetworkConnectorsBuilder networkConnectorsBuilder) {
        if (networkConnectorsBuilder == null) return;

        for (NetworkConnectorBuilder ncDefinition : networkConnectorsBuilder.getNetworkConnectorDefinitions()) {
            NetworkConnector networkConnector;
            try {
                networkConnector = new DiscoveryNetworkConnector(URI.create(ncDefinition.getUri()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            networkConnector.setName(ncDefinition.getName());
            try {
                brokerService.addNetworkConnector(networkConnector);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}

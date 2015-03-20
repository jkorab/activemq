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
 * Builder class used to construct a BrokerService from a {@link org.apache.activemq.broker.dsl.BrokerDefinition}.
 *
 * @author jkorab
 */
public class BrokerServiceBuilder {

    public BrokerService build(BrokerDefinition brokerDefinition) {
        BrokerService brokerService = new BrokerService();
        brokerService.setBrokerName(brokerDefinition.getBrokerName());
        brokerService.setUseJmx(brokerDefinition.isUseJmx());
        brokerService.setPersistent(brokerDefinition.isPersistent());

        addDestinationPolicy(brokerService, brokerDefinition.getDestinationPolicyDefinition());
        addManagementContext(brokerService, brokerDefinition.getManagementContextDefinition());
        addNetworkConnectors(brokerService, brokerDefinition.getNetworkConnectorsDefinition());
        addPlugins(brokerService, brokerDefinition.getPluginsDefinition());
        addTransportConnectors(brokerService, brokerDefinition.getTransportConnectorsDefinition());
        return brokerService;
    }

    private void addDestinationPolicy(BrokerService brokerService, DestinationPolicyDefinition destinationPolicyDefinition) {
        if (destinationPolicyDefinition == null)  return;

        PolicyMapDefinition policyMapDefinition = destinationPolicyDefinition.getPolicyMapDefinition();
        if (policyMapDefinition == null) return;

        PolicyMap policyMap = new PolicyMap();
        brokerService.setDestinationPolicy(policyMap);

        policyMap.setDefaultEntry(buildPolicyEntry(policyMapDefinition.getDefaultPolicyEntryDefinition()));

        PolicyEntriesDefinition policyEntriesDefinition = policyMapDefinition.getPolicyEntriesDefinition();
        addPolicyEntries(policyMap, policyEntriesDefinition);
    }

    private PolicyEntry buildPolicyEntry(DefaultPolicyEntryDefinition definition) {
        if (definition == null) return null;

        PolicyEntry policyEntry = new PolicyEntryBuilder().build(definition);
        return policyEntry;
    }


    private void addPolicyEntries(PolicyMap policyMap, PolicyEntriesDefinition policyEntriesDefinition) {
        if (policyEntriesDefinition == null) return;

        List<PolicyEntryDefinition> policyEntryDefinitions = policyEntriesDefinition.getPolicyEntryDefinitions();
        List<PolicyEntry> policyEntries = new ArrayList<>();
        for (PolicyEntryDefinition policyEntryDefinition: policyEntryDefinitions) {
            PolicyEntry policyEntry = new PolicyEntryBuilder().build(policyEntryDefinition);
            policyEntries.add(policyEntry);
        }

        policyMap.setPolicyEntries(policyEntries);
    }


    private void addPlugins(BrokerService brokerService, PluginsDefinition pluginsDefinition) {
        if (pluginsDefinition == null) return;

        List<BrokerPlugin> brokerPluginList = new ArrayList<>();

        addSimpleAuthenticationPlugin(brokerPluginList, pluginsDefinition.getSimpleAuthenticationPluginDefinition());

        if (!brokerPluginList.isEmpty()) {
            brokerService.setPlugins(brokerPluginList.toArray(new BrokerPlugin[]{}));
        }
    }

    private void addSimpleAuthenticationPlugin(List<BrokerPlugin> brokerPluginList, SimpleAuthenticationPluginDefinition simpleAuthenticationPluginDefinition) {
        assert (brokerPluginList != null);
        if (simpleAuthenticationPluginDefinition == null) return;

        SimpleAuthenticationPlugin simpleAuthenticationPlugin = new SimpleAuthenticationPlugin();
        UsersDefinition usersDefinition = simpleAuthenticationPluginDefinition.getUsersDefinition();
        if (usersDefinition == null) return;

        List<AuthenticationUserDefinition> authenticationUserDefinitions = usersDefinition.getAuthenticationUserDefinitions();
        List<AuthenticationUser> authenticationUsers = new ArrayList<>();
        for (AuthenticationUserDefinition authenticationUserDefinition : authenticationUserDefinitions) {
            authenticationUsers.add(new AuthenticationUser(
                    authenticationUserDefinition.getUsername(),
                    authenticationUserDefinition.getPassword(),
                    authenticationUserDefinition.getGroups()));
        }

        simpleAuthenticationPlugin.setUsers(authenticationUsers);
        brokerPluginList.add(simpleAuthenticationPlugin);
    }

    private void addManagementContext(BrokerService brokerService, ManagementContextDefinition managementContextDefinition) {
        if (managementContextDefinition == null) return;

        ManagementContext1Definition managementContext1Definition = managementContextDefinition.getManagementContext1Definition();
        if (managementContext1Definition == null) return;

        ManagementContext managementContext = new ManagementContext();
        managementContext.setCreateConnector(managementContext1Definition.isCreateConnector());
        brokerService.setManagementContext(managementContext);

    }

    private void addTransportConnectors(BrokerService brokerService, TransportConnectorsDefinition transportConnectorsDefinition) {
        if (transportConnectorsDefinition == null) return;

        for (TransportConnectorDefinition tcDefinition : transportConnectorsDefinition.getTransportConnectorDefinitions()) {
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

    private void addNetworkConnectors(BrokerService brokerService, NetworkConnectorsDefinition networkConnectorsDefinition) {
        if (networkConnectorsDefinition == null) return;

        for (NetworkConnectorDefinition ncDefinition : networkConnectorsDefinition.getNetworkConnectorDefinitions()) {
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

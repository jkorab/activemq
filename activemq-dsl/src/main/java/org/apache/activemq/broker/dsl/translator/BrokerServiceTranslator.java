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
import org.apache.activemq.broker.dsl.model.*;
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
 * Translator class used to construct a BrokerService from a {@link org.apache.activemq.broker.dsl.model.BrokerDef}.
 *
 * @author jkorab
 */
public class BrokerServiceTranslator {

    public BrokerService translate(BrokerDef brokerDef) {
        BrokerService brokerService = new BrokerService();
        brokerService.setBrokerName(brokerDef.getBrokerName());
        brokerService.setUseJmx(brokerDef.getUseJmx());
        brokerService.setPersistent(brokerDef.getPersistent());

        addDestinationPolicy(brokerService, brokerDef.getDestinationPolicyDef());
        addManagementContext(brokerService, brokerDef.getManagementContextDef());
        addNetworkConnectors(brokerService, brokerDef.getNetworkConnectorDefs());
        addPlugins(brokerService, brokerDef.getPluginsDef());
        addTransportConnectors(brokerService, brokerDef.getTransportConnectorDefs());
        return brokerService;
    }

    private void addDestinationPolicy(BrokerService brokerService, DestinationPolicyDef destinationPolicyDef) {
        if (destinationPolicyDef == null)  return;

        PolicyMapDef policyMapDef = destinationPolicyDef.getPolicyMapDef();
        if (policyMapDef == null) return;

        PolicyMap policyMap = new PolicyMap();
        brokerService.setDestinationPolicy(policyMap);

        policyMap.setDefaultEntry(buildPolicyEntry(policyMapDef.getDefaultPolicyEntryDef()));

        addPolicyEntries(policyMap, policyMapDef.getPolicyEntryDefs());
    }

    private PolicyEntry buildPolicyEntry(DefaultPolicyEntryDef policyEntryDef) {
        if (policyEntryDef == null) return null;

        PolicyEntry policyEntry = new PolicyEntryTranslator().translate(policyEntryDef);
        return policyEntry;
    }


    private void addPolicyEntries(PolicyMap policyMap, List<PolicyEntryDef> policyEntryDefs) {
        if (policyEntryDefs == null) return;

        List<PolicyEntry> policyEntries = new ArrayList<>();
        for (PolicyEntryDef policyEntryDef : policyEntryDefs) {
            PolicyEntry policyEntry = new PolicyEntryTranslator().translate(policyEntryDef);
            policyEntries.add(policyEntry);
        }

        policyMap.setPolicyEntries(policyEntries);
    }


    private void addPlugins(BrokerService brokerService, PluginsDef pluginsDef) {
        if (pluginsDef == null) return;

        List<BrokerPlugin> brokerPluginList = new ArrayList<>();

        addSimpleAuthenticationPlugin(brokerPluginList, pluginsDef.getSimpleAuthenticationPluginDef());

        if (!brokerPluginList.isEmpty()) {
            brokerService.setPlugins(brokerPluginList.toArray(new BrokerPlugin[]{}));
        }
    }

    private void addSimpleAuthenticationPlugin(List<BrokerPlugin> brokerPluginList,
                                               SimpleAuthenticationPluginDef simpleAuthenticationPluginDef) {
        assert (brokerPluginList != null);
        if (simpleAuthenticationPluginDef == null) return;

        SimpleAuthenticationPlugin simpleAuthenticationPlugin = new SimpleAuthenticationPlugin();
        List<AuthenticationUserDef> authenticationUserDefs = simpleAuthenticationPluginDef.getAuthenticationUserDefs();
        List<AuthenticationUser> authenticationUsers = new ArrayList<>();
        for (AuthenticationUserDef authenticationUserDef : authenticationUserDefs) {
            authenticationUsers.add(new AuthenticationUser(
                    authenticationUserDef.getUsername(),
                    authenticationUserDef.getPassword(),
                    authenticationUserDef.getGroups()));
        }

        simpleAuthenticationPlugin.setUsers(authenticationUsers);
        brokerPluginList.add(simpleAuthenticationPlugin);
    }

    private void addManagementContext(BrokerService brokerService, ManagementContextDef managementContextDef) {
        if (managementContextDef == null) return;

        ManagementContext1Def managementContext1Def = managementContextDef.getManagementContext1Def();
        if (managementContext1Def == null) return;

        ManagementContext managementContext = new ManagementContext();
        managementContext.setCreateConnector(managementContext1Def.getCreateConnector());
        brokerService.setManagementContext(managementContext);

    }

    private void addTransportConnectors(BrokerService brokerService,
                                        List<TransportConnectorDef> transportConnectorDefs) {
        for (TransportConnectorDef transportConnectorDef : transportConnectorDefs) {
            TransportConnector transportConnector = new TransportConnector();
            transportConnector.setName(transportConnectorDef.getName());
            transportConnector.setUri(URI.create(transportConnectorDef.getUri()));
            try {
                brokerService.addConnector(transportConnector);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void addNetworkConnectors(BrokerService brokerService, List<NetworkConnectorDef> networkConnectorDefs) {
        if (networkConnectorDefs == null) return;

        for (NetworkConnectorDef networkConnectorDef : networkConnectorDefs) {
            NetworkConnector networkConnector;
            try {
                networkConnector = new DiscoveryNetworkConnector(URI.create(networkConnectorDef.getUri()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            networkConnector.setName(networkConnectorDef.getName());
            try {
                brokerService.addNetworkConnector(networkConnector);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}

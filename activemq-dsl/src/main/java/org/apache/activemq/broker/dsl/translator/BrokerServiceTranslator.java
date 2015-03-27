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
import org.apache.activemq.network.NetworkConnector;
import org.apache.activemq.security.AuthenticationUser;
import org.apache.activemq.security.SimpleAuthenticationPlugin;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.io.File;
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
        if (brokerDef.getAdvisorySupport() != null) {
            brokerService.setAdvisorySupport(brokerDef.getAdvisorySupport());
        }
        if (brokerDef.getAllowTempAutoCreationOnSend() != null) {
            brokerService.setAllowTempAutoCreationOnSend(brokerDef.getAllowTempAutoCreationOnSend());
        }
        if (brokerDef.getBrokerId() != null) {
            brokerService.setBrokerId(brokerDef.getBrokerId());
        }
        if (brokerDef.getBrokerName() != null) {
            brokerService.setBrokerName(brokerDef.getBrokerName());
        }
        if (brokerDef.getBrokerObjectName() != null) {
            try {
                brokerService.setBrokerObjectName(new ObjectName(brokerDef.getBrokerObjectName()));
            } catch (MalformedObjectNameException e) {
                throw new RuntimeException(e);
            }
        }
        if (brokerDef.getCacheTempDestinations() != null) {
            brokerService.setCacheTempDestinations(brokerDef.getCacheTempDestinations());
        }
        if (brokerDef.getConsumerSystemUsagePortion() != null) {
            brokerService.setConsumerSystemUsagePortion(brokerDef.getConsumerSystemUsagePortion());
        }
        if (brokerDef.getDataDirectory() != null) {
            brokerService.setDataDirectory(brokerDef.getDataDirectory());
        }
        if (brokerDef.getDataDirectoryFile() != null) {
            brokerService.setDataDirectoryFile(new File(brokerDef.getDataDirectoryFile()));
        }
        if (brokerDef.getDedicatedTaskRunner() != null) {
            brokerService.setDedicatedTaskRunner(brokerDef.getDedicatedTaskRunner());
        }
        if (brokerDef.getDeleteAllMessagesOnStartup() != null) {
            brokerService.setDeleteAllMessagesOnStartup(brokerDef.getDeleteAllMessagesOnStartup());
        }
        if (brokerDef.getEnableStatistics() != null) {
            brokerService.setEnableStatistics(brokerDef.getEnableStatistics());
        }
        if (brokerDef.getKeepDurableSubsActive() != null) {
            brokerService.setKeepDurableSubsActive(brokerDef.getKeepDurableSubsActive());
        }
        if (brokerDef.getMaxPurgedDestinationsPerSweep() != null) {
            brokerService.setMaxPurgedDestinationsPerSweep(brokerDef.getMaxPurgedDestinationsPerSweep());
        }
        if (brokerDef.getMbeanInvocationTimeout() != null) {
            brokerService.setMbeanInvocationTimeout(brokerDef.getMbeanInvocationTimeout());
        }
        if (brokerDef.getMonitorConnectionSplits() != null) {
            brokerService.setMonitorConnectionSplits(brokerDef.getMonitorConnectionSplits());
        }
        if (brokerDef.getNetworkConnectorStartAsync() != null) {
            brokerService.setNetworkConnectorStartAsync(brokerDef.getNetworkConnectorStartAsync());
        }
        if (brokerDef.getOfflineDurableSubscriberTaskSchedule() != null) {
            brokerService.setOfflineDurableSubscriberTaskSchedule(brokerDef.getOfflineDurableSubscriberTaskSchedule());
        }
        if (brokerDef.getOfflineDurableSubscriberTimeout() != null) {
            brokerService.setOfflineDurableSubscriberTimeout(brokerDef.getOfflineDurableSubscriberTimeout());
        }
        if (brokerDef.getPassiveSlave() != null) {
            brokerService.setPassiveSlave(brokerDef.getPassiveSlave());
        }
        if (brokerDef.getPersistenceThreadPriority() != null) {
            brokerService.setPersistenceThreadPriority(brokerDef.getPersistenceThreadPriority());
        }
        if (brokerDef.getPersistent() != null) {
            brokerService.setPersistent(brokerDef.getPersistent());
        }
        if (brokerDef.getPopulateJMSXUserID() != null) {
            brokerService.setPopulateJMSXUserID(brokerDef.getPopulateJMSXUserID());
        }
        if (brokerDef.getPopulateUserNameInMBeans() != null) {
            brokerService.setPopulateUserNameInMBeans(brokerDef.getPopulateUserNameInMBeans());
        }
        if (brokerDef.getProducerSystemUsagePortion() != null) {
            brokerService.setProducerSystemUsagePortion(brokerDef.getProducerSystemUsagePortion());
        }
        if (brokerDef.getRestartAllowed() != null) {
            brokerService.setRestartAllowed(brokerDef.getRestartAllowed());
        }
        if (brokerDef.getSchedulePeriodForDestinationPurge() != null) {
            brokerService.setSchedulePeriodForDestinationPurge(brokerDef.getSchedulePeriodForDestinationPurge());
        }
        if (brokerDef.getSchedulerDirectory() != null) {
            brokerService.setSchedulerDirectory(brokerDef.getSchedulerDirectory());
        }
        if (brokerDef.getSchedulerDirectoryFile() != null) {
            brokerService.setSchedulerDirectoryFile(new File(brokerDef.getSchedulerDirectoryFile()));
        }
        if (brokerDef.getSchedulerSupport() != null) {
            brokerService.setSchedulerSupport(brokerDef.getSchedulerSupport());
        }
        if (brokerDef.getShutdownOnMasterFailure() != null) {
            brokerService.setShutdownOnMasterFailure(brokerDef.getShutdownOnMasterFailure());
        }
        if (brokerDef.getShutdownOnSlaveFailure() != null) {
            brokerService.setShutdownOnSlaveFailure(brokerDef.getShutdownOnSlaveFailure());
        }
        if (brokerDef.getSplitSystemUsageForProducersConsumers() != null) {
            brokerService.setSplitSystemUsageForProducersConsumers(brokerDef.getSplitSystemUsageForProducersConsumers());
        }
        /*
        TODO work out what is currently being done with this flag
        if (brokerDef.getStart() != null) {
            brokerService.setStart(brokerDef.getStart());
        }
        */
        if (brokerDef.getStartAsync() != null) {
            brokerService.setStartAsync(brokerDef.getStartAsync());
        }
        if (brokerDef.getStoreOpenWireVersion() != null) {
            brokerService.setStoreOpenWireVersion(brokerDef.getStoreOpenWireVersion());
        }
        if (brokerDef.getSupportFailOver() != null) {
            brokerService.setSupportFailOver(brokerDef.getSupportFailOver());
        }
        if (brokerDef.getSystemExitOnShutdown() != null) {
            brokerService.setSystemExitOnShutdown(brokerDef.getSystemExitOnShutdown());
        }
        if (brokerDef.getSystemExitOnShutdownExitCode() != null) {
            brokerService.setSystemExitOnShutdownExitCode(brokerDef.getSystemExitOnShutdownExitCode());
        }
        if (brokerDef.getTaskRunnerPriority() != null) {
            brokerService.setTaskRunnerPriority(brokerDef.getTaskRunnerPriority());
        }
        if (brokerDef.getTimeBeforePurgeTempDestinations() != null) {
            brokerService.setTimeBeforePurgeTempDestinations(brokerDef.getTimeBeforePurgeTempDestinations());
        }
        if (brokerDef.getTmpDataDirectory() != null) {
            brokerService.setTmpDataDirectory(new File(brokerDef.getTmpDataDirectory()));
        }
        if (brokerDef.getUseAuthenticatedPrincipalForJMSXUserID() != null) {
            brokerService.setUseAuthenticatedPrincipalForJMSXUserID(brokerDef.getUseAuthenticatedPrincipalForJMSXUserID());
        }
        if (brokerDef.getUseJmx() != null) {
            brokerService.setUseJmx(brokerDef.getUseJmx());
        }
        if (brokerDef.getUseLocalHostBrokerName() != null) {
            brokerService.setUseLocalHostBrokerName(brokerDef.getUseLocalHostBrokerName());
        }
        if (brokerDef.getUseLoggingForShutdownErrors() != null) {
            brokerService.setUseLoggingForShutdownErrors(brokerDef.getUseLoggingForShutdownErrors());
        }
        if (brokerDef.getUseMirroredQueues() != null) {
            brokerService.setUseMirroredQueues(brokerDef.getUseMirroredQueues());
        }
        if (brokerDef.getUseShutdownHook() != null) {
            brokerService.setUseShutdownHook(brokerDef.getUseShutdownHook());
        }
        if (brokerDef.getUseTempMirroredQueues() != null) {
            brokerService.setUseTempMirroredQueues(brokerDef.getUseTempMirroredQueues());
        }
        if (brokerDef.getUseVirtualTopics() != null) {
            brokerService.setUseVirtualTopics(brokerDef.getUseVirtualTopics());
        }
        if (brokerDef.getVmConnectorURI() != null) {
            brokerService.setVmConnectorURI(URI.create(brokerDef.getVmConnectorURI()));
        }
        if (brokerDef.getWaitForSlave() != null) {
            brokerService.setWaitForSlave(brokerDef.getWaitForSlave());
        }
        if (brokerDef.getWaitForSlaveTimeout() != null) {
            brokerService.setWaitForSlaveTimeout(brokerDef.getWaitForSlaveTimeout());
        }

        addDestinationPolicy(brokerService, brokerDef.getDestinationPolicyDef());
        addManagementContext(brokerService, brokerDef.getManagementContextDef());
        addNetworkConnectors(brokerService, brokerDef.getNetworkConnectorDefs());
        addPlugins(brokerService, brokerDef.getPluginsDef());
        addTransportConnectors(brokerService, brokerDef.getTransportConnectorDefs());
        return brokerService;
    }

    private void addDestinationPolicy(BrokerService brokerService, DestinationPolicyDef destinationPolicyDef) {
        if (destinationPolicyDef == null) return;

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
            TransportConnector transportConnector = new TransportConnectorTranslator().translate(transportConnectorDef);
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
            NetworkConnector networkConnector = new NetworkConnectorTranslator().translate(networkConnectorDef);
            try {
                brokerService.addNetworkConnector(networkConnector);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}

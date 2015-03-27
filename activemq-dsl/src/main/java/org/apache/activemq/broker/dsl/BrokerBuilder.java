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
package org.apache.activemq.broker.dsl;

import org.apache.activemq.broker.dsl.model.BrokerDef;

/**
 * @author jkorab
 */
public class BrokerBuilder {

    private DestinationPolicyBuilder destinationPolicyBuilder;
    private ManagementContextBuilder managementContextBuilder;
    private NetworkConnectorsBuilder networkConnectorsBuilder;
    private PluginsBuilder pluginsBuilder;
    private TransportConnectorsBuilder transportConnectorsBuilder;

    private BrokerDef brokerDef;

    BrokerBuilder(String brokerName) {
        brokerDef = new BrokerDef();
        brokerDef.setBrokerName(brokerName);
    }

    public BrokerBuilder advisorySupport(Boolean advisorySupport) {
        brokerDef.setAdvisorySupport(advisorySupport);
        return this;
    }

    public BrokerBuilder allowTempAutoCreationOnSend(Boolean allowTempAutoCreationOnSend) {
        brokerDef.setAllowTempAutoCreationOnSend(allowTempAutoCreationOnSend);
        return this;
    }

    public BrokerBuilder brokerId(String brokerId) {
        brokerDef.setBrokerId(brokerId);
        return this;
    }

    public BrokerBuilder brokerName(String brokerName) {
        brokerDef.setBrokerName(brokerName);
        return this;
    }

    public BrokerBuilder brokerObjectName(String brokerObjectName) {
        brokerDef.setBrokerObjectName(brokerObjectName);
        return this;
    }

    public BrokerBuilder cacheTempDestinations(Boolean cacheTempDestinations) {
        brokerDef.setCacheTempDestinations(cacheTempDestinations);
        return this;
    }

    public BrokerBuilder consumerSystemUsagePortion(Integer consumerSystemUsagePortion) {
        brokerDef.setConsumerSystemUsagePortion(consumerSystemUsagePortion);
        return this;
    }

    public BrokerBuilder dataDirectory(String dataDirectory) {
        brokerDef.setDataDirectory(dataDirectory);
        return this;
    }

    public BrokerBuilder dataDirectoryFile(String dataDirectoryFile) {
        brokerDef.setDataDirectoryFile(dataDirectoryFile);
        return this;
    }

    public BrokerBuilder dedicatedTaskRunner(Boolean dedicatedTaskRunner) {
        brokerDef.setDedicatedTaskRunner(dedicatedTaskRunner);
        return this;
    }

    public BrokerBuilder deleteAllMessagesOnStartup(Boolean deleteAllMessagesOnStartup) {
        brokerDef.setDeleteAllMessagesOnStartup(deleteAllMessagesOnStartup);
        return this;
    }

    public BrokerBuilder enableStatistics(Boolean enableStatistics) {
        brokerDef.setEnableStatistics(enableStatistics);
        return this;
    }

    public BrokerBuilder keepDurableSubsActive(Boolean keepDurableSubsActive) {
        brokerDef.setKeepDurableSubsActive(keepDurableSubsActive);
        return this;
    }

    public BrokerBuilder maxPurgedDestinationsPerSweep(Integer maxPurgedDestinationsPerSweep) {
        brokerDef.setMaxPurgedDestinationsPerSweep(maxPurgedDestinationsPerSweep);
        return this;
    }

    public BrokerBuilder mbeanInvocationTimeout(Long mbeanInvocationTimeout) {
        brokerDef.setMbeanInvocationTimeout(mbeanInvocationTimeout);
        return this;
    }

    public BrokerBuilder monitorConnectionSplits(Boolean monitorConnectionSplits) {
        brokerDef.setMonitorConnectionSplits(monitorConnectionSplits);
        return this;
    }

    public BrokerBuilder networkConnectorStartAsync(Boolean networkConnectorStartAsync) {
        brokerDef.setNetworkConnectorStartAsync(networkConnectorStartAsync);
        return this;
    }

    public BrokerBuilder offlineDurableSubscriberTaskSchedule(Long offlineDurableSubscriberTaskSchedule) {
        brokerDef.setOfflineDurableSubscriberTaskSchedule(offlineDurableSubscriberTaskSchedule);
        return this;
    }

    public BrokerBuilder offlineDurableSubscriberTimeout(Long offlineDurableSubscriberTimeout) {
        brokerDef.setOfflineDurableSubscriberTimeout(offlineDurableSubscriberTimeout);
        return this;
    }

    public BrokerBuilder passiveSlave(Boolean passiveSlave) {
        brokerDef.setPassiveSlave(passiveSlave);
        return this;
    }

    public BrokerBuilder persistenceThreadPriority(Integer persistenceThreadPriority) {
        brokerDef.setPersistenceThreadPriority(persistenceThreadPriority);
        return this;
    }

    public BrokerBuilder persistent(Boolean persistent) {
        brokerDef.setPersistent(persistent);
        return this;
    }

    public BrokerBuilder populateJMSXUserID(Boolean populateJMSXUserID) {
        brokerDef.setPopulateJMSXUserID(populateJMSXUserID);
        return this;
    }

    public BrokerBuilder populateUserNameInMBeans(Boolean populateUserNameInMBeans) {
        brokerDef.setPopulateUserNameInMBeans(populateUserNameInMBeans);
        return this;
    }

    public BrokerBuilder producerSystemUsagePortion(Integer producerSystemUsagePortion) {
        brokerDef.setProducerSystemUsagePortion(producerSystemUsagePortion);
        return this;
    }

    public BrokerBuilder restartAllowed(Boolean restartAllowed) {
        brokerDef.setRestartAllowed(restartAllowed);
        return this;
    }

    public BrokerBuilder schedulePeriodForDestinationPurge(Integer schedulePeriodForDestinationPurge) {
        brokerDef.setSchedulePeriodForDestinationPurge(schedulePeriodForDestinationPurge);
        return this;
    }

    public BrokerBuilder schedulerDirectory(String schedulerDirectory) {
        brokerDef.setSchedulerDirectory(schedulerDirectory);
        return this;
    }

    public BrokerBuilder schedulerDirectoryFile(String schedulerDirectoryFile) {
        brokerDef.setSchedulerDirectoryFile(schedulerDirectoryFile);
        return this;
    }

    public BrokerBuilder schedulerSupport(Boolean schedulerSupport) {
        brokerDef.setSchedulerSupport(schedulerSupport);
        return this;
    }

    public BrokerBuilder shutdownOnMasterFailure(Boolean shutdownOnMasterFailure) {
        brokerDef.setShutdownOnMasterFailure(shutdownOnMasterFailure);
        return this;
    }

    public BrokerBuilder shutdownOnSlaveFailure(Boolean shutdownOnSlaveFailure) {
        brokerDef.setShutdownOnSlaveFailure(shutdownOnSlaveFailure);
        return this;
    }

    public BrokerBuilder splitSystemUsageForProducersConsumers(Boolean splitSystemUsageForProducersConsumers) {
        brokerDef.setSplitSystemUsageForProducersConsumers(splitSystemUsageForProducersConsumers);
        return this;
    }

    public BrokerBuilder start(Boolean start) {
        brokerDef.setStart(start);
        return this;
    }

    public BrokerBuilder startAsync(Boolean startAsync) {
        brokerDef.setStartAsync(startAsync);
        return this;
    }

    public BrokerBuilder storeOpenWireVersion(Integer storeOpenWireVersion) {
        brokerDef.setStoreOpenWireVersion(storeOpenWireVersion);
        return this;
    }

    public BrokerBuilder supportFailOver(Boolean supportFailOver) {
        brokerDef.setSupportFailOver(supportFailOver);
        return this;
    }

    public BrokerBuilder systemExitOnShutdown(Boolean systemExitOnShutdown) {
        brokerDef.setSystemExitOnShutdown(systemExitOnShutdown);
        return this;
    }

    public BrokerBuilder systemExitOnShutdownExitCode(Integer systemExitOnShutdownExitCode) {
        brokerDef.setSystemExitOnShutdownExitCode(systemExitOnShutdownExitCode);
        return this;
    }

    public BrokerBuilder taskRunnerPriority(Integer taskRunnerPriority) {
        brokerDef.setTaskRunnerPriority(taskRunnerPriority);
        return this;
    }

    public BrokerBuilder timeBeforePurgeTempDestinations(Integer timeBeforePurgeTempDestinations) {
        brokerDef.setTimeBeforePurgeTempDestinations(timeBeforePurgeTempDestinations);
        return this;
    }

    public BrokerBuilder tmpDataDirectory(String tmpDataDirectory) {
        brokerDef.setTmpDataDirectory(tmpDataDirectory);
        return this;
    }

    public BrokerBuilder useAuthenticatedPrincipalForJMSXUserID(Boolean useAuthenticatedPrincipalForJMSXUserID) {
        brokerDef.setUseAuthenticatedPrincipalForJMSXUserID(useAuthenticatedPrincipalForJMSXUserID);
        return this;
    }

    public BrokerBuilder useJmx(Boolean useJmx) {
        brokerDef.setUseJmx(useJmx);
        return this;
    }

    public BrokerBuilder useLocalHostBrokerName(Boolean useLocalHostBrokerName) {
        brokerDef.setUseLocalHostBrokerName(useLocalHostBrokerName);
        return this;
    }

    public BrokerBuilder useLoggingForShutdownErrors(Boolean useLoggingForShutdownErrors) {
        brokerDef.setUseLoggingForShutdownErrors(useLoggingForShutdownErrors);
        return this;
    }

    public BrokerBuilder useMirroredQueues(Boolean useMirroredQueues) {
        brokerDef.setUseMirroredQueues(useMirroredQueues);
        return this;
    }

    public BrokerBuilder useShutdownHook(Boolean useShutdownHook) {
        brokerDef.setUseShutdownHook(useShutdownHook);
        return this;
    }

    public BrokerBuilder useTempMirroredQueues(Boolean useTempMirroredQueues) {
        brokerDef.setUseTempMirroredQueues(useTempMirroredQueues);
        return this;
    }

    public BrokerBuilder useVirtualTopics(Boolean useVirtualTopics) {
        brokerDef.setUseVirtualTopics(useVirtualTopics);
        return this;
    }

    public BrokerBuilder vmConnectorURI(String vmConnectorURI) {
        brokerDef.setVmConnectorURI(vmConnectorURI);
        return this;
    }

    public BrokerBuilder waitForSlave(Boolean waitForSlave) {
        brokerDef.setWaitForSlave(waitForSlave);
        return this;
    }

    public BrokerBuilder waitForSlaveTimeout(Long waitForSlaveTimeout) {
        brokerDef.setWaitForSlaveTimeout(waitForSlaveTimeout);
        return this;
    }

    public DestinationPolicyBuilder destinationPolicy() {
        destinationPolicyBuilder = new DestinationPolicyBuilder(this);
        return destinationPolicyBuilder;
    }

    public ManagementContextBuilder managementContext() {
        managementContextBuilder = new ManagementContextBuilder(this);
        return managementContextBuilder;
    }

    public NetworkConnectorsBuilder networkConnectors() {
        networkConnectorsBuilder = new NetworkConnectorsBuilder(this);
        return networkConnectorsBuilder;
    }

    public PluginsBuilder plugins() {
        pluginsBuilder = new PluginsBuilder(this);
        return pluginsBuilder;
    }

    public TransportConnectorsBuilder transportConnectors() {
        transportConnectorsBuilder = new TransportConnectorsBuilder(this);
        return transportConnectorsBuilder;
    }

    public BrokerDef build() {
        if (destinationPolicyBuilder != null) {
            brokerDef.setDestinationPolicyDef(destinationPolicyBuilder.build());
        }
        if (managementContextBuilder != null) {
            brokerDef.setManagementContextDef(managementContextBuilder.build());
        }
        if (networkConnectorsBuilder != null) {
            brokerDef.setNetworkConnectorDefs(networkConnectorsBuilder.build());
        }
        if (pluginsBuilder != null) {
            brokerDef.setPluginsDef(pluginsBuilder.build());
        }
        if (transportConnectorsBuilder != null) {
            brokerDef.setTransportConnectorDefs(transportConnectorsBuilder.build());
        }
        return brokerDef;
    }
}

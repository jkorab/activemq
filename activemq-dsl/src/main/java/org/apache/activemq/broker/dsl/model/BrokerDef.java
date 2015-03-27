/*
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

package org.apache.activemq.broker.dsl.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author jkorab
 */
@XmlRootElement(name = "broker")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class BrokerDef {

    @XmlAttribute
    private Boolean advisorySupport;
    @XmlAttribute
    private Boolean allowTempAutoCreationOnSend;
    @XmlAttribute
    private String brokerId;
    @XmlAttribute
    private String brokerName;
    @XmlAttribute
    private String brokerObjectName;
    @XmlAttribute
    private Boolean cacheTempDestinations;
    @XmlAttribute
    private Integer consumerSystemUsagePortion;
    @XmlAttribute
    private String dataDirectory;
    @XmlAttribute
    private String dataDirectoryFile;
    @XmlAttribute
    private Boolean dedicatedTaskRunner;
    @XmlAttribute
    private Boolean deleteAllMessagesOnStartup;
    @XmlAttribute
    private Boolean enableStatistics;
    @XmlAttribute
    private Boolean keepDurableSubsActive;
    @XmlAttribute
    private Integer maxPurgedDestinationsPerSweep;
    @XmlAttribute
    private Long mbeanInvocationTimeout;
    @XmlAttribute
    private Boolean monitorConnectionSplits;
    @XmlAttribute
    private Boolean networkConnectorStartAsync;
    @XmlAttribute
    private Long offlineDurableSubscriberTaskSchedule;
    @XmlAttribute
    private Long offlineDurableSubscriberTimeout;
    @XmlAttribute
    private Boolean passiveSlave;
    @XmlAttribute
    private Integer persistenceThreadPriority;
    @XmlAttribute
    private Boolean persistent;
    @XmlAttribute
    private Boolean populateJMSXUserID;
    @XmlAttribute
    private Boolean populateUserNameInMBeans;
    @XmlAttribute
    private Integer producerSystemUsagePortion;
    @XmlAttribute
    private Boolean restartAllowed;
    @XmlAttribute
    private Integer schedulePeriodForDestinationPurge;
    @XmlAttribute
    private String schedulerDirectory;
    @XmlAttribute
    private String schedulerDirectoryFile;
    @XmlAttribute
    private Boolean schedulerSupport;
    @XmlAttribute
    private Boolean shutdownOnMasterFailure;
    @XmlAttribute
    private Boolean shutdownOnSlaveFailure;
    @XmlAttribute
    private Boolean splitSystemUsageForProducersConsumers;
    @XmlAttribute
    private Boolean start;
    @XmlAttribute
    private Boolean startAsync;
    @XmlAttribute
    private Integer storeOpenWireVersion;
    @XmlAttribute
    private Boolean supportFailOver;
    @XmlAttribute
    private Boolean systemExitOnShutdown;
    @XmlAttribute
    private Integer systemExitOnShutdownExitCode;
    @XmlAttribute
    private Integer taskRunnerPriority;
    @XmlAttribute
    private Integer timeBeforePurgeTempDestinations;
    @XmlAttribute
    private String tmpDataDirectory;
    @XmlAttribute
    private Boolean useAuthenticatedPrincipalForJMSXUserID;
    @XmlAttribute
    private Boolean useJmx;
    @XmlAttribute
    private Boolean useLocalHostBrokerName;
    @XmlAttribute
    private Boolean useLoggingForShutdownErrors;
    @XmlAttribute
    private Boolean useMirroredQueues;
    @XmlAttribute
    private Boolean useShutdownHook;
    @XmlAttribute
    private Boolean useTempMirroredQueues;
    @XmlAttribute
    private Boolean useVirtualTopics;
    @XmlAttribute
    private String vmConnectorURI;
    @XmlAttribute
    private Boolean waitForSlave;
    @XmlAttribute
    private Long waitForSlaveTimeout;

    @XmlElement(name = "destinationPolicy")
    private DestinationPolicyDef destinationPolicyDef;

    @XmlElement(name = "managementContext")
    private ManagementContextDef managementContextDef;

    @XmlElementWrapper(name = "networkConnectors")
    @XmlElement(name = "networkConnector")
    private List<NetworkConnectorDef> networkConnectorDefs;

    @XmlElement(name = "plugins")
    private PluginsDef pluginsDef;

    @XmlElementWrapper(name = "transportConnectors")
    @XmlElement(name = "transportConnector")
    private List<TransportConnectorDef> transportConnectorDefs;

    public Boolean getAdvisorySupport() {
        return advisorySupport;
    }

    public void setAdvisorySupport(Boolean advisorySupport) {
        this.advisorySupport = advisorySupport;
    }

    public Boolean getAllowTempAutoCreationOnSend() {
        return allowTempAutoCreationOnSend;
    }

    public void setAllowTempAutoCreationOnSend(Boolean allowTempAutoCreationOnSend) {
        this.allowTempAutoCreationOnSend = allowTempAutoCreationOnSend;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getBrokerObjectName() {
        return brokerObjectName;
    }

    public void setBrokerObjectName(String brokerObjectName) {
        this.brokerObjectName = brokerObjectName;
    }

    public Boolean getCacheTempDestinations() {
        return cacheTempDestinations;
    }

    public void setCacheTempDestinations(Boolean cacheTempDestinations) {
        this.cacheTempDestinations = cacheTempDestinations;
    }

    public Integer getConsumerSystemUsagePortion() {
        return consumerSystemUsagePortion;
    }

    public void setConsumerSystemUsagePortion(Integer consumerSystemUsagePortion) {
        this.consumerSystemUsagePortion = consumerSystemUsagePortion;
    }

    public String getDataDirectory() {
        return dataDirectory;
    }

    public void setDataDirectory(String dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    public String getDataDirectoryFile() {
        return dataDirectoryFile;
    }

    public void setDataDirectoryFile(String dataDirectoryFile) {
        this.dataDirectoryFile = dataDirectoryFile;
    }

    public Boolean getDedicatedTaskRunner() {
        return dedicatedTaskRunner;
    }

    public void setDedicatedTaskRunner(Boolean dedicatedTaskRunner) {
        this.dedicatedTaskRunner = dedicatedTaskRunner;
    }

    public Boolean getDeleteAllMessagesOnStartup() {
        return deleteAllMessagesOnStartup;
    }

    public void setDeleteAllMessagesOnStartup(Boolean deleteAllMessagesOnStartup) {
        this.deleteAllMessagesOnStartup = deleteAllMessagesOnStartup;
    }

    public Boolean getEnableStatistics() {
        return enableStatistics;
    }

    public void setEnableStatistics(Boolean enableStatistics) {
        this.enableStatistics = enableStatistics;
    }

    public Boolean getKeepDurableSubsActive() {
        return keepDurableSubsActive;
    }

    public void setKeepDurableSubsActive(Boolean keepDurableSubsActive) {
        this.keepDurableSubsActive = keepDurableSubsActive;
    }

    public Integer getMaxPurgedDestinationsPerSweep() {
        return maxPurgedDestinationsPerSweep;
    }

    public void setMaxPurgedDestinationsPerSweep(Integer maxPurgedDestinationsPerSweep) {
        this.maxPurgedDestinationsPerSweep = maxPurgedDestinationsPerSweep;
    }

    public Long getMbeanInvocationTimeout() {
        return mbeanInvocationTimeout;
    }

    public void setMbeanInvocationTimeout(Long mbeanInvocationTimeout) {
        this.mbeanInvocationTimeout = mbeanInvocationTimeout;
    }

    public Boolean getMonitorConnectionSplits() {
        return monitorConnectionSplits;
    }

    public void setMonitorConnectionSplits(Boolean monitorConnectionSplits) {
        this.monitorConnectionSplits = monitorConnectionSplits;
    }

    public Boolean getNetworkConnectorStartAsync() {
        return networkConnectorStartAsync;
    }

    public void setNetworkConnectorStartAsync(Boolean networkConnectorStartAsync) {
        this.networkConnectorStartAsync = networkConnectorStartAsync;
    }

    public Long getOfflineDurableSubscriberTaskSchedule() {
        return offlineDurableSubscriberTaskSchedule;
    }

    public void setOfflineDurableSubscriberTaskSchedule(Long offlineDurableSubscriberTaskSchedule) {
        this.offlineDurableSubscriberTaskSchedule = offlineDurableSubscriberTaskSchedule;
    }

    public Long getOfflineDurableSubscriberTimeout() {
        return offlineDurableSubscriberTimeout;
    }

    public void setOfflineDurableSubscriberTimeout(Long offlineDurableSubscriberTimeout) {
        this.offlineDurableSubscriberTimeout = offlineDurableSubscriberTimeout;
    }

    public Boolean getPassiveSlave() {
        return passiveSlave;
    }

    public void setPassiveSlave(Boolean passiveSlave) {
        this.passiveSlave = passiveSlave;
    }

    public Integer getPersistenceThreadPriority() {
        return persistenceThreadPriority;
    }

    public void setPersistenceThreadPriority(Integer persistenceThreadPriority) {
        this.persistenceThreadPriority = persistenceThreadPriority;
    }

    public Boolean getPersistent() {
        return persistent;
    }

    public void setPersistent(Boolean persistent) {
        this.persistent = persistent;
    }

    public Boolean getPopulateJMSXUserID() {
        return populateJMSXUserID;
    }

    public void setPopulateJMSXUserID(Boolean populateJMSXUserID) {
        this.populateJMSXUserID = populateJMSXUserID;
    }

    public Boolean getPopulateUserNameInMBeans() {
        return populateUserNameInMBeans;
    }

    public void setPopulateUserNameInMBeans(Boolean populateUserNameInMBeans) {
        this.populateUserNameInMBeans = populateUserNameInMBeans;
    }

    public Integer getProducerSystemUsagePortion() {
        return producerSystemUsagePortion;
    }

    public void setProducerSystemUsagePortion(Integer producerSystemUsagePortion) {
        this.producerSystemUsagePortion = producerSystemUsagePortion;
    }

    public Boolean getRestartAllowed() {
        return restartAllowed;
    }

    public void setRestartAllowed(Boolean restartAllowed) {
        this.restartAllowed = restartAllowed;
    }

    public Integer getSchedulePeriodForDestinationPurge() {
        return schedulePeriodForDestinationPurge;
    }

    public void setSchedulePeriodForDestinationPurge(Integer schedulePeriodForDestinationPurge) {
        this.schedulePeriodForDestinationPurge = schedulePeriodForDestinationPurge;
    }

    public String getSchedulerDirectory() {
        return schedulerDirectory;
    }

    public void setSchedulerDirectory(String schedulerDirectory) {
        this.schedulerDirectory = schedulerDirectory;
    }

    public String getSchedulerDirectoryFile() {
        return schedulerDirectoryFile;
    }

    public void setSchedulerDirectoryFile(String schedulerDirectoryFile) {
        this.schedulerDirectoryFile = schedulerDirectoryFile;
    }

    public Boolean getSchedulerSupport() {
        return schedulerSupport;
    }

    public void setSchedulerSupport(Boolean schedulerSupport) {
        this.schedulerSupport = schedulerSupport;
    }

    public Boolean getShutdownOnMasterFailure() {
        return shutdownOnMasterFailure;
    }

    public void setShutdownOnMasterFailure(Boolean shutdownOnMasterFailure) {
        this.shutdownOnMasterFailure = shutdownOnMasterFailure;
    }

    public Boolean getShutdownOnSlaveFailure() {
        return shutdownOnSlaveFailure;
    }

    public void setShutdownOnSlaveFailure(Boolean shutdownOnSlaveFailure) {
        this.shutdownOnSlaveFailure = shutdownOnSlaveFailure;
    }

    public Boolean getSplitSystemUsageForProducersConsumers() {
        return splitSystemUsageForProducersConsumers;
    }

    public void setSplitSystemUsageForProducersConsumers(Boolean splitSystemUsageForProducersConsumers) {
        this.splitSystemUsageForProducersConsumers = splitSystemUsageForProducersConsumers;
    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(Boolean start) {
        this.start = start;
    }

    public Boolean getStartAsync() {
        return startAsync;
    }

    public void setStartAsync(Boolean startAsync) {
        this.startAsync = startAsync;
    }

    public Integer getStoreOpenWireVersion() {
        return storeOpenWireVersion;
    }

    public void setStoreOpenWireVersion(Integer storeOpenWireVersion) {
        this.storeOpenWireVersion = storeOpenWireVersion;
    }

    public Boolean getSupportFailOver() {
        return supportFailOver;
    }

    public void setSupportFailOver(Boolean supportFailOver) {
        this.supportFailOver = supportFailOver;
    }

    public Boolean getSystemExitOnShutdown() {
        return systemExitOnShutdown;
    }

    public void setSystemExitOnShutdown(Boolean systemExitOnShutdown) {
        this.systemExitOnShutdown = systemExitOnShutdown;
    }

    public Integer getSystemExitOnShutdownExitCode() {
        return systemExitOnShutdownExitCode;
    }

    public void setSystemExitOnShutdownExitCode(Integer systemExitOnShutdownExitCode) {
        this.systemExitOnShutdownExitCode = systemExitOnShutdownExitCode;
    }

    public Integer getTaskRunnerPriority() {
        return taskRunnerPriority;
    }

    public void setTaskRunnerPriority(Integer taskRunnerPriority) {
        this.taskRunnerPriority = taskRunnerPriority;
    }

    public Integer getTimeBeforePurgeTempDestinations() {
        return timeBeforePurgeTempDestinations;
    }

    public void setTimeBeforePurgeTempDestinations(Integer timeBeforePurgeTempDestinations) {
        this.timeBeforePurgeTempDestinations = timeBeforePurgeTempDestinations;
    }

    public String getTmpDataDirectory() {
        return tmpDataDirectory;
    }

    public void setTmpDataDirectory(String tmpDataDirectory) {
        this.tmpDataDirectory = tmpDataDirectory;
    }

    public Boolean getUseAuthenticatedPrincipalForJMSXUserID() {
        return useAuthenticatedPrincipalForJMSXUserID;
    }

    public void setUseAuthenticatedPrincipalForJMSXUserID(Boolean useAuthenticatedPrincipalForJMSXUserID) {
        this.useAuthenticatedPrincipalForJMSXUserID = useAuthenticatedPrincipalForJMSXUserID;
    }

    public Boolean getUseJmx() {
        return useJmx;
    }

    public void setUseJmx(Boolean useJmx) {
        this.useJmx = useJmx;
    }

    public Boolean getUseLocalHostBrokerName() {
        return useLocalHostBrokerName;
    }

    public void setUseLocalHostBrokerName(Boolean useLocalHostBrokerName) {
        this.useLocalHostBrokerName = useLocalHostBrokerName;
    }

    public Boolean getUseLoggingForShutdownErrors() {
        return useLoggingForShutdownErrors;
    }

    public void setUseLoggingForShutdownErrors(Boolean useLoggingForShutdownErrors) {
        this.useLoggingForShutdownErrors = useLoggingForShutdownErrors;
    }

    public Boolean getUseMirroredQueues() {
        return useMirroredQueues;
    }

    public void setUseMirroredQueues(Boolean useMirroredQueues) {
        this.useMirroredQueues = useMirroredQueues;
    }

    public Boolean getUseShutdownHook() {
        return useShutdownHook;
    }

    public void setUseShutdownHook(Boolean useShutdownHook) {
        this.useShutdownHook = useShutdownHook;
    }

    public Boolean getUseTempMirroredQueues() {
        return useTempMirroredQueues;
    }

    public void setUseTempMirroredQueues(Boolean useTempMirroredQueues) {
        this.useTempMirroredQueues = useTempMirroredQueues;
    }

    public Boolean getUseVirtualTopics() {
        return useVirtualTopics;
    }

    public void setUseVirtualTopics(Boolean useVirtualTopics) {
        this.useVirtualTopics = useVirtualTopics;
    }

    public String getVmConnectorURI() {
        return vmConnectorURI;
    }

    public void setVmConnectorURI(String vmConnectorURI) {
        this.vmConnectorURI = vmConnectorURI;
    }

    public Boolean getWaitForSlave() {
        return waitForSlave;
    }

    public void setWaitForSlave(Boolean waitForSlave) {
        this.waitForSlave = waitForSlave;
    }

    public Long getWaitForSlaveTimeout() {
        return waitForSlaveTimeout;
    }

    public void setWaitForSlaveTimeout(Long waitForSlaveTimeout) {
        this.waitForSlaveTimeout = waitForSlaveTimeout;
    }

    public List<TransportConnectorDef> getTransportConnectorDefs() {
        return transportConnectorDefs;
    }

    public void setTransportConnectorDefs(List<TransportConnectorDef> transportConnectorDefs) {
        this.transportConnectorDefs = transportConnectorDefs;
    }

    public DestinationPolicyDef getDestinationPolicyDef() {
        return destinationPolicyDef;
    }

    public void setDestinationPolicyDef(DestinationPolicyDef destinationPolicyDef) {
        this.destinationPolicyDef = destinationPolicyDef;
    }

    public ManagementContextDef getManagementContextDef() {
        return managementContextDef;
    }

    public void setManagementContextDef(ManagementContextDef managementContextDef) {
        this.managementContextDef = managementContextDef;
    }

    public List<NetworkConnectorDef> getNetworkConnectorDefs() {
        return networkConnectorDefs;
    }

    public void setNetworkConnectorDefs(List<NetworkConnectorDef> networkConnectorDefs) {
        this.networkConnectorDefs = networkConnectorDefs;
    }

    public PluginsDef getPluginsDef() {
        return pluginsDef;
    }

    public void setPluginsDef(PluginsDef pluginsDef) {
        this.pluginsDef = pluginsDef;
    }
}

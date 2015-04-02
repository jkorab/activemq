package org.apache.activemq.broker.dsl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by jkorab on 02/04/2015.
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseNetworkConnectorDef {

    @XmlAttribute
    protected Boolean advisoryForFailedForward;
    @XmlAttribute
    protected Boolean alwaysSyncSend;
    @XmlAttribute
    protected Boolean bridgeTempDestinations;
    @XmlAttribute
    protected String brokerName;
    @XmlAttribute
    protected String brokerURL;
    @XmlAttribute
    protected Boolean checkDuplicateMessagesOnDuplex;
    @XmlAttribute
    protected Boolean conduitSubscriptions;
    @XmlAttribute
    protected Integer consumerPriorityBase;
    @XmlAttribute
    protected Integer consumerTTL;
    @XmlAttribute
    protected Boolean decreaseNetworkConsumerPriority;
    @XmlAttribute
    protected String destinationFilter;
    @XmlAttribute
    protected Boolean dispatchAsync;
    @XmlAttribute
    protected Boolean duplex;
    @XmlAttribute
    protected Boolean dynamicOnly;
    @XmlAttribute
    protected Boolean gcDestinationViews;
    @XmlAttribute
    protected Long gcSweepTime;
    @XmlAttribute
    protected String localUri;
    @XmlAttribute
    protected Integer messageTTL;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected Integer networkTTL;
    @XmlAttribute
    protected String objectName;
    @XmlAttribute
    protected String password;
    @XmlAttribute
    protected Integer prefetchSize;
    @XmlAttribute
    protected Boolean staticBridge;
    @XmlAttribute
    protected Boolean suppressDuplicateQueueSubscriptions;
    @XmlAttribute
    protected Boolean suppressDuplicateTopicSubscriptions;
    @XmlAttribute
    protected Boolean useBrokerNameAsIdSees;
    @XmlAttribute
    protected Boolean useCompression;
    @XmlAttribute
    protected String userName;

    public Boolean getAdvisoryForFailedForward() {
        return advisoryForFailedForward;
    }

    public void setAdvisoryForFailedForward(Boolean advisoryForFailedForward) {
        this.advisoryForFailedForward = advisoryForFailedForward;
    }

    public Boolean getAlwaysSyncSend() {
        return alwaysSyncSend;
    }

    public void setAlwaysSyncSend(Boolean alwaysSyncSend) {
        this.alwaysSyncSend = alwaysSyncSend;
    }

    public Boolean getBridgeTempDestinations() {
        return bridgeTempDestinations;
    }

    public void setBridgeTempDestinations(Boolean bridgeTempDestinations) {
        this.bridgeTempDestinations = bridgeTempDestinations;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getBrokerURL() {
        return brokerURL;
    }

    public void setBrokerURL(String brokerURL) {
        this.brokerURL = brokerURL;
    }

    public Boolean getCheckDuplicateMessagesOnDuplex() {
        return checkDuplicateMessagesOnDuplex;
    }

    public void setCheckDuplicateMessagesOnDuplex(Boolean checkDuplicateMessagesOnDuplex) {
        this.checkDuplicateMessagesOnDuplex = checkDuplicateMessagesOnDuplex;
    }

    public Boolean getConduitSubscriptions() {
        return conduitSubscriptions;
    }

    public void setConduitSubscriptions(Boolean conduitSubscriptions) {
        this.conduitSubscriptions = conduitSubscriptions;
    }

    public Integer getConsumerPriorityBase() {
        return consumerPriorityBase;
    }

    public void setConsumerPriorityBase(Integer consumerPriorityBase) {
        this.consumerPriorityBase = consumerPriorityBase;
    }

    public Integer getConsumerTTL() {
        return consumerTTL;
    }

    public void setConsumerTTL(Integer consumerTTL) {
        this.consumerTTL = consumerTTL;
    }

    public Boolean getDecreaseNetworkConsumerPriority() {
        return decreaseNetworkConsumerPriority;
    }

    public void setDecreaseNetworkConsumerPriority(Boolean decreaseNetworkConsumerPriority) {
        this.decreaseNetworkConsumerPriority = decreaseNetworkConsumerPriority;
    }

    public String getDestinationFilter() {
        return destinationFilter;
    }

    public void setDestinationFilter(String destinationFilter) {
        this.destinationFilter = destinationFilter;
    }

    public Boolean getDispatchAsync() {
        return dispatchAsync;
    }

    public void setDispatchAsync(Boolean dispatchAsync) {
        this.dispatchAsync = dispatchAsync;
    }

    public Boolean getDuplex() {
        return duplex;
    }

    public void setDuplex(Boolean duplex) {
        this.duplex = duplex;
    }

    public Boolean getDynamicOnly() {
        return dynamicOnly;
    }

    public void setDynamicOnly(Boolean dynamicOnly) {
        this.dynamicOnly = dynamicOnly;
    }

    public Boolean getGcDestinationViews() {
        return gcDestinationViews;
    }

    public void setGcDestinationViews(Boolean gcDestinationViews) {
        this.gcDestinationViews = gcDestinationViews;
    }

    public Long getGcSweepTime() {
        return gcSweepTime;
    }

    public void setGcSweepTime(Long gcSweepTime) {
        this.gcSweepTime = gcSweepTime;
    }

    public String getLocalUri() {
        return localUri;
    }

    public void setLocalUri(String localUri) {
        this.localUri = localUri;
    }

    public Integer getMessageTTL() {
        return messageTTL;
    }

    public void setMessageTTL(Integer messageTTL) {
        this.messageTTL = messageTTL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNetworkTTL() {
        return networkTTL;
    }

    public void setNetworkTTL(Integer networkTTL) {
        this.networkTTL = networkTTL;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPrefetchSize() {
        return prefetchSize;
    }

    public void setPrefetchSize(Integer prefetchSize) {
        this.prefetchSize = prefetchSize;
    }

    public Boolean getStaticBridge() {
        return staticBridge;
    }

    public void setStaticBridge(Boolean staticBridge) {
        this.staticBridge = staticBridge;
    }

    public Boolean getSuppressDuplicateQueueSubscriptions() {
        return suppressDuplicateQueueSubscriptions;
    }

    public void setSuppressDuplicateQueueSubscriptions(Boolean suppressDuplicateQueueSubscriptions) {
        this.suppressDuplicateQueueSubscriptions = suppressDuplicateQueueSubscriptions;
    }

    public Boolean getSuppressDuplicateTopicSubscriptions() {
        return suppressDuplicateTopicSubscriptions;
    }

    public void setSuppressDuplicateTopicSubscriptions(Boolean suppressDuplicateTopicSubscriptions) {
        this.suppressDuplicateTopicSubscriptions = suppressDuplicateTopicSubscriptions;
    }

    public Boolean getUseBrokerNameAsIdSees() {
        return useBrokerNameAsIdSees;
    }

    public void setUseBrokerNameAsIdSees(Boolean useBrokerNameAsIdSees) {
        this.useBrokerNameAsIdSees = useBrokerNameAsIdSees;
    }

    public Boolean getUseCompression() {
        return useCompression;
    }

    public void setUseCompression(Boolean useCompression) {
        this.useCompression = useCompression;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

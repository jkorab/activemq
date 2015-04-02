package org.apache.activemq.broker.dsl;

import org.apache.activemq.broker.dsl.model.BaseNetworkConnectorDef;
import org.apache.activemq.broker.dsl.model.NetworkConnectorDef;

/**
 * Created by jkorab on 02/04/2015.
 */
public abstract class BaseNetworkConnectorBuilder<D extends BaseNetworkConnectorDef, B extends BaseNetworkConnectorBuilder> {

    protected final D networkConnectorDef;
    protected final NetworkConnectorsBuilder networkConnectorsBuilder;

    public BaseNetworkConnectorBuilder(D networkConnectorDef, NetworkConnectorsBuilder networkConnectorsBuilder) {
        assert (networkConnectorDef != null);
        assert (networkConnectorsBuilder != null);
        this.networkConnectorDef = networkConnectorDef;
        this.networkConnectorsBuilder = networkConnectorsBuilder;
    }

    public B advisoryForFailedForward(Boolean advisoryForFailedForward) {
        networkConnectorDef.setAdvisoryForFailedForward(advisoryForFailedForward);
        return (B) this;
    }

    public B alwaysSyncSend(Boolean alwaysSyncSend) {
        networkConnectorDef.setAlwaysSyncSend(alwaysSyncSend);
        return (B) this;
    }

    public B bridgeTempDestinations(Boolean bridgeTempDestinations) {
        networkConnectorDef.setBridgeTempDestinations(bridgeTempDestinations);
        return (B) this;
    }

    public B brokerName(String brokerName) {
        networkConnectorDef.setBrokerName(brokerName);
        return (B) this;
    }

    public B brokerURL(String brokerURL) {
        networkConnectorDef.setBrokerURL(brokerURL);
        return (B) this;
    }

    public B checkDuplicateMessagesOnDuplex(Boolean checkDuplicateMessagesOnDuplex) {
        networkConnectorDef.setCheckDuplicateMessagesOnDuplex(checkDuplicateMessagesOnDuplex);
        return (B) this;
    }

    public B conduitSubscriptions(Boolean conduitSubscriptions) {
        networkConnectorDef.setConduitSubscriptions(conduitSubscriptions);
        return (B) this;
    }

    public B consumerPriorityBase(Integer consumerPriorityBase) {
        networkConnectorDef.setConsumerPriorityBase(consumerPriorityBase);
        return (B) this;
    }

    public B consumerTTL(Integer consumerTTL) {
        networkConnectorDef.setConsumerTTL(consumerTTL);
        return (B) this;
    }

    public B decreaseNetworkConsumerPriority(Boolean decreaseNetworkConsumerPriority) {
        networkConnectorDef.setDecreaseNetworkConsumerPriority(decreaseNetworkConsumerPriority);
        return (B) this;
    }

    public B destinationFilter(String destinationFilter) {
        networkConnectorDef.setDestinationFilter(destinationFilter);
        return (B) this;
    }

    public B dispatchAsync(Boolean dispatchAsync) {
        networkConnectorDef.setDispatchAsync(dispatchAsync);
        return (B) this;
    }

    public B duplex(Boolean duplex) {
        networkConnectorDef.setDuplex(duplex);
        return (B) this;
    }

    public B dynamicOnly(Boolean dynamicOnly) {
        networkConnectorDef.setDynamicOnly(dynamicOnly);
        return (B) this;
    }

    public B gcDestinationViews(Boolean gcDestinationViews) {
        networkConnectorDef.setGcDestinationViews(gcDestinationViews);
        return (B) this;
    }

    public B gcSweepTime(Long gcSweepTime) {
        networkConnectorDef.setGcSweepTime(gcSweepTime);
        return (B) this;
    }

    public B localUri(String localUri) {
        networkConnectorDef.setLocalUri(localUri);
        return (B) this;
    }

    public B messageTTL(Integer messageTTL) {
        networkConnectorDef.setMessageTTL(messageTTL);
        return (B) this;
    }

    public B name(String name) {
        networkConnectorDef.setName(name);
        return (B) this;
    }

    public B networkTTL(Integer networkTTL) {
        networkConnectorDef.setNetworkTTL(networkTTL);
        return (B) this;
    }

    public B objectName(String objectName) {
        networkConnectorDef.setObjectName(objectName);
        return (B) this;
    }

    public B password(String password) {
        networkConnectorDef.setPassword(password);
        return (B) this;
    }

    public B prefetchSize(Integer prefetchSize) {
        networkConnectorDef.setPrefetchSize(prefetchSize);
        return (B) this;
    }

    public B staticBridge(Boolean staticBridge) {
        networkConnectorDef.setStaticBridge(staticBridge);
        return (B) this;
    }

    public B suppressDuplicateQueueSubscriptions(Boolean suppressDuplicateQueueSubscriptions) {
        networkConnectorDef.setSuppressDuplicateQueueSubscriptions(suppressDuplicateQueueSubscriptions);
        return (B) this;
    }

    public B suppressDuplicateTopicSubscriptions(Boolean suppressDuplicateTopicSubscriptions) {
        networkConnectorDef.setSuppressDuplicateTopicSubscriptions(suppressDuplicateTopicSubscriptions);
        return (B) this;
    }


    public B useBrokerNameAsIdSees(Boolean useBrokerNameAsIdSees) {
        networkConnectorDef.setUseBrokerNameAsIdSees(useBrokerNameAsIdSees);
        return (B) this;
    }

    public B useCompression(Boolean useCompression) {
        networkConnectorDef.setUseCompression(useCompression);
        return (B) this;
    }

    public B userName(String userName) {
        networkConnectorDef.setUserName(userName);
        return (B) this;
    }

    /**
     * Adds a new networkConnector.
     */
    public NetworkConnectorBuilder networkConnector(String name, String uri) {
        return networkConnectorsBuilder.networkConnector(name, uri);
    }

    /**
     * Closes off the networkConnectors block.
     */
    public BrokerBuilder end() {
        return networkConnectorsBuilder.end();
    }

    public D build() {
        return networkConnectorDef;
    }

    public String getName() {
        return networkConnectorDef.getName();
    }

}

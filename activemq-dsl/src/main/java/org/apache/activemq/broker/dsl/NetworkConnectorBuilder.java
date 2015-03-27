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

import org.apache.activemq.broker.dsl.model.NetworkConnectorDef;

/**
 * @author jkorab
 */
public class NetworkConnectorBuilder {

    private final NetworkConnectorsBuilder networkConnectorsBuilder;
    private final NetworkConnectorDef networkConnectorDef;

    NetworkConnectorBuilder(NetworkConnectorsBuilder networkConnectorsBuilder, String name, String uri) {
        assert (networkConnectorsBuilder != null);
        assert (name != null);
        assert (uri != null);

        this.networkConnectorsBuilder = networkConnectorsBuilder;
        this.networkConnectorDef = new NetworkConnectorDef();
        networkConnectorDef.setUri(uri);
        networkConnectorDef.setName(name);
    }

    public NetworkConnectorBuilder advisoryForFailedForward(Boolean advisoryForFailedForward) {
        networkConnectorDef.setAdvisoryForFailedForward(advisoryForFailedForward);
        return this;
    }

    public NetworkConnectorBuilder alwaysSyncSend(Boolean alwaysSyncSend) {
        networkConnectorDef.setAlwaysSyncSend(alwaysSyncSend);
        return this;
    }

    public NetworkConnectorBuilder bridgeTempDestinations(Boolean bridgeTempDestinations) {
        networkConnectorDef.setBridgeTempDestinations(bridgeTempDestinations);
        return this;
    }

    public NetworkConnectorBuilder brokerName(String brokerName) {
        networkConnectorDef.setBrokerName(brokerName);
        return this;
    }

    public NetworkConnectorBuilder brokerURL(String brokerURL) {
        networkConnectorDef.setBrokerURL(brokerURL);
        return this;
    }

    public NetworkConnectorBuilder checkDuplicateMessagesOnDuplex(Boolean checkDuplicateMessagesOnDuplex) {
        networkConnectorDef.setCheckDuplicateMessagesOnDuplex(checkDuplicateMessagesOnDuplex);
        return this;
    }

    public NetworkConnectorBuilder conduitSubscriptions(Boolean conduitSubscriptions) {
        networkConnectorDef.setConduitSubscriptions(conduitSubscriptions);
        return this;
    }

    public NetworkConnectorBuilder consumerPriorityBase(Integer consumerPriorityBase) {
        networkConnectorDef.setConsumerPriorityBase(consumerPriorityBase);
        return this;
    }

    public NetworkConnectorBuilder consumerTTL(Integer consumerTTL) {
        networkConnectorDef.setConsumerTTL(consumerTTL);
        return this;
    }

    public NetworkConnectorBuilder decreaseNetworkConsumerPriority(Boolean decreaseNetworkConsumerPriority) {
        networkConnectorDef.setDecreaseNetworkConsumerPriority(decreaseNetworkConsumerPriority);
        return this;
    }

    public NetworkConnectorBuilder destinationFilter(String destinationFilter) {
        networkConnectorDef.setDestinationFilter(destinationFilter);
        return this;
    }

    public NetworkConnectorBuilder discoveryURI(String discoveryURI) {
        networkConnectorDef.setDiscoveryURI(discoveryURI);
        return this;
    }

    public NetworkConnectorBuilder dispatchAsync(Boolean dispatchAsync) {
        networkConnectorDef.setDispatchAsync(dispatchAsync);
        return this;
    }

    public NetworkConnectorBuilder duplex(Boolean duplex) {
        networkConnectorDef.setDuplex(duplex);
        return this;
    }

    public NetworkConnectorBuilder dynamicOnly(Boolean dynamicOnly) {
        networkConnectorDef.setDynamicOnly(dynamicOnly);
        return this;
    }

    public NetworkConnectorBuilder gcDestinationViews(Boolean gcDestinationViews) {
        networkConnectorDef.setGcDestinationViews(gcDestinationViews);
        return this;
    }

    public NetworkConnectorBuilder gcSweepTime(Long gcSweepTime) {
        networkConnectorDef.setGcSweepTime(gcSweepTime);
        return this;
    }

    public NetworkConnectorBuilder localUri(String localUri) {
        networkConnectorDef.setLocalUri(localUri);
        return this;
    }

    public NetworkConnectorBuilder messageTTL(Integer messageTTL) {
        networkConnectorDef.setMessageTTL(messageTTL);
        return this;
    }

    public NetworkConnectorBuilder name(String name) {
        networkConnectorDef.setName(name);
        return this;
    }

    public NetworkConnectorBuilder networkTTL(Integer networkTTL) {
        networkConnectorDef.setNetworkTTL(networkTTL);
        return this;
    }

    public NetworkConnectorBuilder objectName(String objectName) {
        networkConnectorDef.setObjectName(objectName);
        return this;
    }

    public NetworkConnectorBuilder password(String password) {
        networkConnectorDef.setPassword(password);
        return this;
    }

    public NetworkConnectorBuilder prefetchSize(Integer prefetchSize) {
        networkConnectorDef.setPrefetchSize(prefetchSize);
        return this;
    }

    public NetworkConnectorBuilder staticBridge(Boolean staticBridge) {
        networkConnectorDef.setStaticBridge(staticBridge);
        return this;
    }

    public NetworkConnectorBuilder suppressDuplicateQueueSubscriptions(Boolean suppressDuplicateQueueSubscriptions) {
        networkConnectorDef.setSuppressDuplicateQueueSubscriptions(suppressDuplicateQueueSubscriptions);
        return this;
    }

    public NetworkConnectorBuilder suppressDuplicateTopicSubscriptions(Boolean suppressDuplicateTopicSubscriptions) {
        networkConnectorDef.setSuppressDuplicateTopicSubscriptions(suppressDuplicateTopicSubscriptions);
        return this;
    }

    public NetworkConnectorBuilder uri(String uri) {
        networkConnectorDef.setUri(uri);
        return this;
    }

    public NetworkConnectorBuilder useBrokerNameAsIdSees(Boolean useBrokerNameAsIdSees) {
        networkConnectorDef.setUseBrokerNameAsIdSees(useBrokerNameAsIdSees);
        return this;
    }

    public NetworkConnectorBuilder useCompression(Boolean useCompression) {
        networkConnectorDef.setUseCompression(useCompression);
        return this;
    }

    public NetworkConnectorBuilder userName(String userName) {
        networkConnectorDef.setUserName(userName);
        return this;
    }

    /**
     * TODO
     */
    public DestinationsDefinition staticallyIncludedDestinations() {
        DestinationsDefinition destinationsDefinition = new DestinationsDefinition(this);
        return destinationsDefinition;
    }

    /**
     * Adds a new transportConnector.
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

    public NetworkConnectorDef build() {
        return networkConnectorDef;
    }

    public String getName() {
        return networkConnectorDef.getName();
    }
}

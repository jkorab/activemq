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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author jkorab
 */
@XmlType(name = "networkConnector")
@XmlAccessorType(XmlAccessType.FIELD)
public class NetworkConnectorDef {

    @XmlAttribute
    private Boolean advisoryForFailedForward;
    @XmlAttribute
    private Boolean alwaysSyncSend;
    @XmlAttribute
    private Boolean bridgeTempDestinations;
    @XmlAttribute
    private String brokerName;
    @XmlAttribute
    private String brokerURL;
    @XmlAttribute
    private Boolean checkDuplicateMessagesOnDuplex;
    @XmlAttribute
    private Boolean conduitSubscriptions;
    @XmlAttribute
    private Integer consumerPriorityBase;
    @XmlAttribute
    private Integer consumerTTL;
    @XmlAttribute
    private Boolean decreaseNetworkConsumerPriority;
    @XmlAttribute
    private String destinationFilter;
    @XmlAttribute
    private String discoveryURI;
    @XmlAttribute
    private Boolean dispatchAsync;
    @XmlAttribute
    private Boolean duplex;
    @XmlAttribute
    private Boolean dynamicOnly;
    @XmlAttribute
    private Boolean gcDestinationViews;
    @XmlAttribute
    private Long gcSweepTime;
    @XmlAttribute
    private String localUri;
    @XmlAttribute
    private Integer messageTTL;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private Integer networkTTL;
    @XmlAttribute
    private String objectName;
    @XmlAttribute
    private String password;
    @XmlAttribute
    private Integer prefetchSize;
    @XmlAttribute
    private Boolean staticBridge;
    @XmlAttribute
    private Boolean suppressDuplicateQueueSubscriptions;
    @XmlAttribute
    private Boolean suppressDuplicateTopicSubscriptions;
    @XmlAttribute
    private String uri;
    @XmlAttribute
    private Boolean useBrokerNameAsIdSees;
    @XmlAttribute
    private Boolean useCompression;
    @XmlAttribute
    private String userName;

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

    public String getDiscoveryURI() {
        return discoveryURI;
    }

    public void setDiscoveryURI(String discoveryURI) {
        this.discoveryURI = discoveryURI;
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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

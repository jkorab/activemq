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

/**
 * @author jkorab
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TransportConnectorDef {

    @XmlAttribute
    private Boolean allowLinkStealing;
    @XmlAttribute
    private Boolean auditNetworkProducers;
    @XmlAttribute
    private Boolean disableAsyncDispatch;
    @XmlAttribute
    private String discoveryUri;
    @XmlAttribute
    private Boolean enableStatusMonitor;
    @XmlAttribute
    private Integer maximumConsumersAllowedPerConnection;
    @XmlAttribute
    private Integer maximumProducersAllowedPerConnection;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private Boolean rebalanceClusterClients;
    @XmlAttribute
    private Boolean updateClusterClients;
    @XmlAttribute
    private Boolean updateClusterClientsOnRemove;
    @XmlAttribute
    private String updateClusterFilter;
    @XmlAttribute
    private String uri;

    public Boolean getAllowLinkStealing() {
        return allowLinkStealing;
    }

    public void setAllowLinkStealing(Boolean allowLinkStealing) {
        this.allowLinkStealing = allowLinkStealing;
    }

    public Boolean getAuditNetworkProducers() {
        return auditNetworkProducers;
    }

    public void setAuditNetworkProducers(Boolean auditNetworkProducers) {
        this.auditNetworkProducers = auditNetworkProducers;
    }

    public Boolean getDisableAsyncDispatch() {
        return disableAsyncDispatch;
    }

    public void setDisableAsyncDispatch(Boolean disableAsyncDispatch) {
        this.disableAsyncDispatch = disableAsyncDispatch;
    }

    public String getDiscoveryUri() {
        return discoveryUri;
    }

    public void setDiscoveryUri(String discoveryUri) {
        this.discoveryUri = discoveryUri;
    }

    public Boolean getEnableStatusMonitor() {
        return enableStatusMonitor;
    }

    public void setEnableStatusMonitor(Boolean enableStatusMonitor) {
        this.enableStatusMonitor = enableStatusMonitor;
    }

    public Integer getMaximumConsumersAllowedPerConnection() {
        return maximumConsumersAllowedPerConnection;
    }

    public void setMaximumConsumersAllowedPerConnection(Integer maximumConsumersAllowedPerConnection) {
        this.maximumConsumersAllowedPerConnection = maximumConsumersAllowedPerConnection;
    }

    public Integer getMaximumProducersAllowedPerConnection() {
        return maximumProducersAllowedPerConnection;
    }

    public void setMaximumProducersAllowedPerConnection(Integer maximumProducersAllowedPerConnection) {
        this.maximumProducersAllowedPerConnection = maximumProducersAllowedPerConnection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRebalanceClusterClients() {
        return rebalanceClusterClients;
    }

    public void setRebalanceClusterClients(Boolean rebalanceClusterClients) {
        this.rebalanceClusterClients = rebalanceClusterClients;
    }

    public Boolean getUpdateClusterClients() {
        return updateClusterClients;
    }

    public void setUpdateClusterClients(Boolean updateClusterClients) {
        this.updateClusterClients = updateClusterClients;
    }

    public Boolean getUpdateClusterClientsOnRemove() {
        return updateClusterClientsOnRemove;
    }

    public void setUpdateClusterClientsOnRemove(Boolean updateClusterClientsOnRemove) {
        this.updateClusterClientsOnRemove = updateClusterClientsOnRemove;
    }

    public String getUpdateClusterFilter() {
        return updateClusterFilter;
    }

    public void setUpdateClusterFilter(String updateClusterFilter) {
        this.updateClusterFilter = updateClusterFilter;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
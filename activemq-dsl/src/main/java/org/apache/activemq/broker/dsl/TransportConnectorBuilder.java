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

import org.apache.activemq.broker.dsl.model.TransportConnectorDef;

/**
 * @author jkorab
 */
public class TransportConnectorBuilder {

    private final TransportConnectorsBuilder transportConnectorsBuilder;
    private final TransportConnectorDef transportConnectorDef;

    public TransportConnectorBuilder(TransportConnectorsBuilder transportConnectorsBuilder, String name, String uri) {
        assert (transportConnectorsBuilder != null);
        assert (name != null);
        assert (uri != null);
        this.transportConnectorsBuilder = transportConnectorsBuilder;
        transportConnectorDef = new TransportConnectorDef();
        transportConnectorDef.setName(name);
        transportConnectorDef.setUri(uri);
    }

    /**
     * Adds a new transportConnector.
     */
    public TransportConnectorBuilder transportConnector(String name, String uri) {
        return transportConnectorsBuilder.transportConnector(name, uri);
    }

    public TransportConnectorBuilder allowLinkStealing(Boolean allowLinkStealing) {
        transportConnectorDef.setAllowLinkStealing(allowLinkStealing);
        return this;
    }

    public TransportConnectorBuilder auditNetworkProducers(Boolean auditNetworkProducers) {
        transportConnectorDef.setAuditNetworkProducers(auditNetworkProducers);
        return this;
    }

    public TransportConnectorBuilder disableAsyncDispatch(Boolean disableAsyncDispatch) {
        transportConnectorDef.setDisableAsyncDispatch(disableAsyncDispatch);
        return this;
    }

    public TransportConnectorBuilder discoveryUri(String discoveryUri) {
        transportConnectorDef.setDiscoveryUri(discoveryUri);
        return this;
    }

    public TransportConnectorBuilder enableStatusMonitor(Boolean enableStatusMonitor) {
        transportConnectorDef.setEnableStatusMonitor(enableStatusMonitor);
        return this;
    }

    public TransportConnectorBuilder maximumConsumersAllowedPerConnection(Integer maximumConsumersAllowedPerConnection) {
        transportConnectorDef.setMaximumConsumersAllowedPerConnection(maximumConsumersAllowedPerConnection);
        return this;
    }

    public TransportConnectorBuilder maximumProducersAllowedPerConnection(Integer maximumProducersAllowedPerConnection) {
        transportConnectorDef.setMaximumProducersAllowedPerConnection(maximumProducersAllowedPerConnection);
        return this;
    }

    public TransportConnectorBuilder rebalanceClusterClients(Boolean rebalanceClusterClients) {
        transportConnectorDef.setRebalanceClusterClients(rebalanceClusterClients);
        return this;
    }

    public TransportConnectorBuilder updateClusterClients(Boolean updateClusterClients) {
        transportConnectorDef.setUpdateClusterClients(updateClusterClients);
        return this;
    }

    public TransportConnectorBuilder updateClusterClientsOnRemove(Boolean updateClusterClientsOnRemove) {
        transportConnectorDef.setUpdateClusterClientsOnRemove(updateClusterClientsOnRemove);
        return this;
    }

    public TransportConnectorBuilder updateClusterFilter(String updateClusterFilter) {
        transportConnectorDef.setUpdateClusterFilter(updateClusterFilter);
        return this;
    }

    /**
     * Closes off the transportConnectors block.
     */
    public BrokerBuilder end() {
        return transportConnectorsBuilder.end();
    }

    public TransportConnectorDef build() {
        return transportConnectorDef;
    }
}

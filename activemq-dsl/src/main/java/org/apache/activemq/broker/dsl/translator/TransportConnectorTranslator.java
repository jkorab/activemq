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

package org.apache.activemq.broker.dsl.translator;

import org.apache.activemq.broker.TransportConnector;
import org.apache.activemq.broker.dsl.model.TransportConnectorDef;

import java.net.URI;

/**
 * @author jkorab
 */
class TransportConnectorTranslator {

    TransportConnector translate(TransportConnectorDef transportConnectorDef) {
        TransportConnector transportConnector = new TransportConnector();
        if (transportConnectorDef.getAllowLinkStealing() != null) {
            transportConnector.setAllowLinkStealing(transportConnectorDef.getAllowLinkStealing());
        }
        if (transportConnectorDef.getAuditNetworkProducers() != null) {
            transportConnector.setAuditNetworkProducers(transportConnectorDef.getAuditNetworkProducers());
        }
        if (transportConnectorDef.getDisableAsyncDispatch() != null) {
            transportConnector.setDisableAsyncDispatch(transportConnectorDef.getDisableAsyncDispatch());
        }
        if (transportConnectorDef.getDiscoveryUri() != null) {
            transportConnector.setDiscoveryUri(URI.create(transportConnectorDef.getDiscoveryUri()));
        }
        if (transportConnectorDef.getEnableStatusMonitor() != null) {
            transportConnector.setEnableStatusMonitor(transportConnectorDef.getEnableStatusMonitor());
        }
        if (transportConnectorDef.getMaximumConsumersAllowedPerConnection() != null) {
            transportConnector.setMaximumConsumersAllowedPerConnection(transportConnectorDef.getMaximumConsumersAllowedPerConnection());
        }
        if (transportConnectorDef.getMaximumProducersAllowedPerConnection() != null) {
            transportConnector.setMaximumProducersAllowedPerConnection(transportConnectorDef.getMaximumProducersAllowedPerConnection());
        }
        if (transportConnectorDef.getName() != null) {
            transportConnector.setName(transportConnectorDef.getName());
        }
        if (transportConnectorDef.getRebalanceClusterClients() != null) {
            transportConnector.setRebalanceClusterClients(transportConnectorDef.getRebalanceClusterClients());
        }
        if (transportConnectorDef.getUpdateClusterClients() != null) {
            transportConnector.setUpdateClusterClients(transportConnectorDef.getUpdateClusterClients());
        }
        if (transportConnectorDef.getUpdateClusterClientsOnRemove() != null) {
            transportConnector.setUpdateClusterClientsOnRemove(transportConnectorDef.getUpdateClusterClientsOnRemove());
        }
        if (transportConnectorDef.getUpdateClusterFilter() != null) {
            transportConnector.setUpdateClusterFilter(transportConnectorDef.getUpdateClusterFilter());
        }
        if (transportConnectorDef.getUri() != null) {
            transportConnector.setUri(URI.create(transportConnectorDef.getUri()));
        }
        return transportConnector;
    }

}

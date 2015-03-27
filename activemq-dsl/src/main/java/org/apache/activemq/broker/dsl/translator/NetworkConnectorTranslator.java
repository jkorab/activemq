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

import org.apache.activemq.broker.dsl.model.NetworkConnectorDef;
import org.apache.activemq.network.DiscoveryNetworkConnector;
import org.apache.activemq.network.NetworkConnector;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.io.IOException;
import java.net.URI;

/**
 * @author jkorab
 */
class NetworkConnectorTranslator {

    NetworkConnector translate(NetworkConnectorDef networkConnectorDef) {
        NetworkConnector networkConnector;
        try {
            networkConnector = new DiscoveryNetworkConnector(URI.create(networkConnectorDef.getUri()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (networkConnectorDef.getAdvisoryForFailedForward() != null) {
            networkConnector.setAdvisoryForFailedForward(networkConnectorDef.getAdvisoryForFailedForward());
        }
        if (networkConnectorDef.getAlwaysSyncSend() != null) {
            networkConnector.setAlwaysSyncSend(networkConnectorDef.getAlwaysSyncSend());
        }
        if (networkConnectorDef.getBridgeTempDestinations() != null) {
            networkConnector.setBridgeTempDestinations(networkConnectorDef.getBridgeTempDestinations());
        }
        if (networkConnectorDef.getBrokerName() != null) {
            networkConnector.setBrokerName(networkConnectorDef.getBrokerName());
        }
        if (networkConnectorDef.getBrokerURL() != null) {
            networkConnector.setBrokerURL(networkConnectorDef.getBrokerURL());
        }
        if (networkConnectorDef.getCheckDuplicateMessagesOnDuplex() != null) {
            networkConnector.setCheckDuplicateMessagesOnDuplex(networkConnectorDef.getCheckDuplicateMessagesOnDuplex());
        }
        if (networkConnectorDef.getConduitSubscriptions() != null) {
            networkConnector.setConduitSubscriptions(networkConnectorDef.getConduitSubscriptions());
        }
        if (networkConnectorDef.getConsumerPriorityBase() != null) {
            networkConnector.setConsumerPriorityBase(networkConnectorDef.getConsumerPriorityBase());
        }
        if (networkConnectorDef.getConsumerTTL() != null) {
            networkConnector.setConsumerTTL(networkConnectorDef.getConsumerTTL());
        }
        if (networkConnectorDef.getDecreaseNetworkConsumerPriority() != null) {
            networkConnector.setDecreaseNetworkConsumerPriority(networkConnectorDef.getDecreaseNetworkConsumerPriority());
        }
        if (networkConnectorDef.getDestinationFilter() != null) {
            networkConnector.setDestinationFilter(networkConnectorDef.getDestinationFilter());
        }
            /*
            FIXME there is no setDiscoveryURI - find out where it goes
            if (networkConnectorDef.getDiscoveryURI() != null) {
                networkConnector.setDiscoveryURI(URI.create(networkConnectorDef.getDiscoveryURI()));
            }
             */
        if (networkConnectorDef.getDispatchAsync() != null) {
            networkConnector.setDispatchAsync(networkConnectorDef.getDispatchAsync());
        }
        if (networkConnectorDef.getDuplex() != null) {
            networkConnector.setDuplex(networkConnectorDef.getDuplex());
        }
        if (networkConnectorDef.getDynamicOnly() != null) {
            networkConnector.setDynamicOnly(networkConnectorDef.getDynamicOnly());
        }
        if (networkConnectorDef.getGcDestinationViews() != null) {
            networkConnector.setGcDestinationViews(networkConnectorDef.getGcDestinationViews());
        }
        if (networkConnectorDef.getGcSweepTime() != null) {
            networkConnector.setGcSweepTime(networkConnectorDef.getGcSweepTime());
        }
        if (networkConnectorDef.getLocalUri() != null) {
            networkConnector.setLocalUri(URI.create(networkConnectorDef.getLocalUri()));
        }
        if (networkConnectorDef.getMessageTTL() != null) {
            networkConnector.setMessageTTL(networkConnectorDef.getMessageTTL());
        }
        if (networkConnectorDef.getName() != null) {
            networkConnector.setName(networkConnectorDef.getName());
        }
        if (networkConnectorDef.getNetworkTTL() != null) {
            networkConnector.setNetworkTTL(networkConnectorDef.getNetworkTTL());
        }
        if (networkConnectorDef.getObjectName() != null) {
            try {
                networkConnector.setObjectName(new ObjectName(networkConnectorDef.getObjectName()));
            } catch (MalformedObjectNameException e) {
                throw new RuntimeException(e);
            }
        }
        if (networkConnectorDef.getPassword() != null) {
            networkConnector.setPassword(networkConnectorDef.getPassword());
        }
        if (networkConnectorDef.getPrefetchSize() != null) {
            networkConnector.setPrefetchSize(networkConnectorDef.getPrefetchSize());
        }
        if (networkConnectorDef.getStaticBridge() != null) {
            networkConnector.setStaticBridge(networkConnectorDef.getStaticBridge());
        }
        if (networkConnectorDef.getSuppressDuplicateQueueSubscriptions() != null) {
            networkConnector.setSuppressDuplicateQueueSubscriptions(networkConnectorDef.getSuppressDuplicateQueueSubscriptions());
        }
        if (networkConnectorDef.getSuppressDuplicateTopicSubscriptions() != null) {
            networkConnector.setSuppressDuplicateTopicSubscriptions(networkConnectorDef.getSuppressDuplicateTopicSubscriptions());
        }
            /* FIXME there is no setUri(), only a setLocalUri()
            if (networkConnectorDef.getUri() != null) {
                networkConnector.setUri(URI.create(networkConnectorDef.getUri()));
            }
            */
        if (networkConnectorDef.getUseBrokerNameAsIdSees() != null) {
            networkConnector.setUseBrokerNameAsIdSees(networkConnectorDef.getUseBrokerNameAsIdSees());
        }
        if (networkConnectorDef.getUseCompression() != null) {
            networkConnector.setUseCompression(networkConnectorDef.getUseCompression());
        }
        if (networkConnectorDef.getUserName() != null) {
            networkConnector.setUserName(networkConnectorDef.getUserName());
        }
        return networkConnector;
    }

}

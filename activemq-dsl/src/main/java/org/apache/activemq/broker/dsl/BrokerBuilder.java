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

    public BrokerBuilder persistent(boolean persistent) {
        brokerDef.setPersistent(persistent);
        return this;
    }

    public BrokerBuilder useJmx(boolean useJmx) {
        brokerDef.setUseJmx(useJmx);
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

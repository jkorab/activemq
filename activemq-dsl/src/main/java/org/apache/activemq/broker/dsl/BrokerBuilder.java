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

/**
 * @author jkorab
 */
public class BrokerBuilder {

    private final String brokerName;
    private boolean useJmx = false;
    private boolean persistent = true;
    private DestinationPolicyBuilder destinationPolicyBuilder;
    private ManagementContextBuilder managementContextBuilder;
    private NetworkConnectorsBuilder networkConnectorsBuilder;
    private TransportConnectorsBuilder transportConnectorsBuilder;
    private PluginsBuilder pluginsBuilder;

    BrokerBuilder(String brokerName) {
        this.brokerName = brokerName;
    }

    public BrokerBuilder persistent(boolean persistent) {
        this.persistent = persistent;
        return this;
    }

    public BrokerBuilder useJmx(boolean useJmx) {
        this.useJmx = useJmx;
        return this;
    }

    public ManagementContextBuilder managementContext() {
        managementContextBuilder = new ManagementContextBuilder(this);
        return managementContextBuilder;
    }

    public NetworkConnectorsBuilder networkConnectors() {
        networkConnectorsBuilder = new NetworkConnectorsBuilder(this);
        return networkConnectorsBuilder;
    }

    public TransportConnectorsBuilder transportConnectors() {
        transportConnectorsBuilder = new TransportConnectorsBuilder(this);
        return transportConnectorsBuilder;
    }

    public boolean isPersistent() {
        return persistent;
    }

    public boolean isUseJmx() {
        return useJmx;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public ManagementContextBuilder getManagementContextBuilder() {
        return managementContextBuilder;
    }

    public NetworkConnectorsBuilder getNetworkConnectorsBuilder() {
        return networkConnectorsBuilder;
    }

    public TransportConnectorsBuilder getTransportConnectorsBuilder() {
        return transportConnectorsBuilder;
    }

    public PluginsBuilder plugins() {
        pluginsBuilder = new PluginsBuilder(this);
        return pluginsBuilder;
    }

    public PluginsBuilder getPluginsBuilder() {
        return pluginsBuilder;
    }

    public DestinationPolicyBuilder destinationPolicy() {
        destinationPolicyBuilder = new DestinationPolicyBuilder(this);
        return destinationPolicyBuilder;
    }

    public DestinationPolicyBuilder getDestinationPolicyBuilder() {
        return destinationPolicyBuilder;
    }
}

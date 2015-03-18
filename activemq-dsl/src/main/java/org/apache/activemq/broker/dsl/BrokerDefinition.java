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
public class BrokerDefinition {

    private final String brokerName;
    private boolean useJmx = false;
    private boolean persistent = true;
    private DestinationPolicyDefinition destinationPolicyDefinition;
    private ManagementContextDefinition managementContextDefinition;
    private NetworkConnectorsDefinition networkConnectorsDefinition;
    private TransportConnectorsDefinition transportConnectorsDefinition;
    private PluginsDefinition pluginsDefinition;

    BrokerDefinition(String brokerName) {
        this.brokerName = brokerName;
    }

    public BrokerDefinition persistent(boolean persistent) {
        this.persistent = persistent;
        return this;
    }

    public BrokerDefinition useJmx(boolean useJmx) {
        this.useJmx = useJmx;
        return this;
    }

    public ManagementContextDefinition managementContext() {
        managementContextDefinition = new ManagementContextDefinition(this);
        return managementContextDefinition;
    }

    public NetworkConnectorsDefinition networkConnectors() {
        networkConnectorsDefinition = new NetworkConnectorsDefinition(this);
        return networkConnectorsDefinition;
    }

    public TransportConnectorsDefinition transportConnectors() {
        transportConnectorsDefinition = new TransportConnectorsDefinition(this);
        return transportConnectorsDefinition;
    }

    boolean isPersistent() {
        return persistent;
    }

    boolean isUseJmx() {
        return useJmx;
    }

    String getBrokerName() {
        return brokerName;
    }

    ManagementContextDefinition getManagementContextDefinition() {
        return managementContextDefinition;
    }

    NetworkConnectorsDefinition getNetworkConnectorsDefinition() {
        return networkConnectorsDefinition;
    }

    public TransportConnectorsDefinition getTransportConnectorsDefinition() {
        return transportConnectorsDefinition;
    }

    public PluginsDefinition plugins() {
        pluginsDefinition = new PluginsDefinition(this);
        return pluginsDefinition;
    }

    PluginsDefinition getPluginsDefinition() {
        return pluginsDefinition;
    }

    public DestinationPolicyDefinition destinationPolicy() {
        destinationPolicyDefinition = new DestinationPolicyDefinition(this);
        return destinationPolicyDefinition;
    }

    DestinationPolicyDefinition getDestinationPolicyDefinition() {
        return destinationPolicyDefinition;
    }
}

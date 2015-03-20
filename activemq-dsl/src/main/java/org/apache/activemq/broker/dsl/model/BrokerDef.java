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

import org.apache.activemq.broker.TransportConnector;

import java.util.List;

/**
 * @author jkorab
 */
public class BrokerDef {

    private String brokerName;
    private Boolean useJmx = false;
    private Boolean persistent = true;

    private DestinationPolicyDef destinationPolicyDef;
    private ManagementContextDef managementContextDef;
    private List<NetworkConnectorDef> networkConnectorDefs;
    private PluginsDef pluginsDef;
    private List<TransportConnectorDef> transportConnectorDefs;

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public List<TransportConnectorDef> getTransportConnectorDefs() {
        return transportConnectorDefs;
    }

    public void setTransportConnectorDefs(List<TransportConnectorDef> transportConnectorDefs) {
        this.transportConnectorDefs = transportConnectorDefs;
    }

    public Boolean getUseJmx() {
        return useJmx;
    }

    public void setUseJmx(Boolean useJmx) {
        this.useJmx = useJmx;
    }

    public Boolean getPersistent() {
        return persistent;
    }

    public void setPersistent(Boolean persistent) {
        this.persistent = persistent;
    }

    public DestinationPolicyDef getDestinationPolicyDef() {
        return destinationPolicyDef;
    }

    public void setDestinationPolicyDef(DestinationPolicyDef destinationPolicyDef) {
        this.destinationPolicyDef = destinationPolicyDef;
    }

    public ManagementContextDef getManagementContextDef() {
        return managementContextDef;
    }

    public void setManagementContextDef(ManagementContextDef managementContextDef) {
        this.managementContextDef = managementContextDef;
    }

    public List<NetworkConnectorDef> getNetworkConnectorDefs() {
        return networkConnectorDefs;
    }

    public void setNetworkConnectorDefs(List<NetworkConnectorDef> networkConnectorDefs) {
        this.networkConnectorDefs = networkConnectorDefs;
    }

    public PluginsDef getPluginsDef() {
        return pluginsDef;
    }

    public void setPluginsDef(PluginsDef pluginsDef) {
        this.pluginsDef = pluginsDef;
    }
}

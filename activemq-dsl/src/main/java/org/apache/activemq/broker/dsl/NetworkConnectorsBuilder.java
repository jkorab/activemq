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

import org.apache.commons.lang.Validate;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jkorab
 */
public class NetworkConnectorsBuilder {

    private final BrokerBuilder brokerBuilder;
    private Map<String, NetworkConnectorBuilder> networkConnectorDefinitionMap = new TreeMap<>();

    NetworkConnectorsBuilder(BrokerBuilder brokerBuilder) {
        assert (brokerBuilder != null);
        this.brokerBuilder = brokerBuilder;
    }

    public NetworkConnectorBuilder networkConnector(String name, String uri) {
        Validate.notEmpty(name, "name is empty");
        Validate.notEmpty(uri, "uri is empty");

        if (networkConnectorDefinitionMap.containsKey(name)) {
            throw new IllegalArgumentException("Network connector named " + name + "already defined");
        }
        NetworkConnectorBuilder transportConnectorDefinition = new NetworkConnectorBuilder(this, name, uri);
        networkConnectorDefinitionMap.put(name, transportConnectorDefinition);
        return transportConnectorDefinition;
    }

    public BrokerBuilder end() {
        return brokerBuilder;
    }

    public Collection<NetworkConnectorBuilder> getNetworkConnectorDefinitions() {
        return networkConnectorDefinitionMap.values();
    }
}

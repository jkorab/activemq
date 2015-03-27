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
import org.apache.commons.lang.Validate;

import java.util.*;

/**
 * @author jkorab
 */
public class TransportConnectorsBuilder {

    private final BrokerBuilder brokerBuilder;
    private Map<String, TransportConnectorBuilder> transportConnectorBuilderMap = new TreeMap<>();

    TransportConnectorsBuilder(BrokerBuilder brokerBuilder) {
        assert (brokerBuilder != null);
        this.brokerBuilder = brokerBuilder;
    }

    public TransportConnectorBuilder transportConnector(String name, String uri) {
        Validate.notEmpty(name, "name is empty");
        Validate.notEmpty(uri, "uri is empty");

        if (transportConnectorBuilderMap.containsKey(name)) {
            throw new IllegalArgumentException("Transport connector named " + name + "already defined");
        }
        TransportConnectorBuilder transportConnectorBuilder = new TransportConnectorBuilder(this, name, uri);
        transportConnectorBuilderMap.put(name, transportConnectorBuilder);
        return transportConnectorBuilder;
    }

    /**
     * Closes off this block. Can only be called from a transportConnector, meaning that at least one
     * transportConnector must be defined.
     */
    BrokerBuilder end() {
        return brokerBuilder;
    }

    public Collection<TransportConnectorBuilder> getTransportConnectorDefinitions() {
        return transportConnectorBuilderMap.values();
    }

    public List<TransportConnectorDef> build() {
        List<TransportConnectorDef> transportConnectorDefs = new ArrayList<>();
        for (TransportConnectorBuilder transportConnectorBuilder : transportConnectorBuilderMap.values()) {
            transportConnectorDefs.add(transportConnectorBuilder.build());
        }
        return transportConnectorDefs;
    }
}

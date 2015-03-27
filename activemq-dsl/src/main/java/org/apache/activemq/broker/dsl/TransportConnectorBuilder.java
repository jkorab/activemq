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

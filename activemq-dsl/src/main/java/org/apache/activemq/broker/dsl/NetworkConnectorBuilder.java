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

import org.apache.activemq.broker.dsl.model.NetworkConnectorDef;

/**
 * @author jkorab
 */
public class NetworkConnectorBuilder extends BaseNetworkConnectorBuilder<NetworkConnectorDef, NetworkConnectorBuilder> {

    NetworkConnectorBuilder(NetworkConnectorsBuilder networkConnectorsBuilder, String name, String uri) {
        super(new NetworkConnectorDef(), networkConnectorsBuilder);
        assert (name != null);
        assert (uri != null);

        networkConnectorDef.setUri(uri);
        networkConnectorDef.setName(name);
    }


    public NetworkConnectorBuilder discoveryURI(String discoveryURI) {
        networkConnectorDef.setDiscoveryURI(discoveryURI);
        return this;
    }

    public NetworkConnectorBuilder uri(String uri) {
        networkConnectorDef.setUri(uri);
        return this;
    }

    /**
     * TODO
     */
    public DestinationsDefinition staticallyIncludedDestinations() {
        DestinationsDefinition destinationsDefinition = new DestinationsDefinition(this);
        return destinationsDefinition;
    }

}

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
public class NetworkConnectorDefinition {

    private final NetworkConnectorsDefinition networkConnectorsDefinition;
    private final String name;
    private final String uri;
    private Integer networkTTL;

    NetworkConnectorDefinition(NetworkConnectorsDefinition networkConnectorsDefinition, String name, String uri) {
        assert (networkConnectorsDefinition != null);
        assert (name != null);
        assert (uri != null);

        this.uri = uri;
        this.name = name;
        this.networkConnectorsDefinition = networkConnectorsDefinition;
    }

    public NetworkConnectorDefinition networkTTL(int networkTTL) {
        this.networkTTL = networkTTL;
        return this;
    }


    public DestinationsDefinition staticallyIncludedDestinations() {
        DestinationsDefinition destinationsDefinition = new DestinationsDefinition(this);
        return destinationsDefinition;
    }

    public NetworkConnectorsDefinition end() {
        return networkConnectorsDefinition;
    }

    public String getName() {
        return name;
    }

    String getUri() {
        return uri;
    }
}

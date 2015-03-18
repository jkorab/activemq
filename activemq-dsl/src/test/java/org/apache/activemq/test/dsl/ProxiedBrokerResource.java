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

package org.apache.activemq.test.dsl;


import org.apache.activemq.broker.dsl.TransportConnectorDefinition;
import org.apache.activemq.broker.dsl.TransportConnectorsDefinition;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jkorab
 */
public class ProxiedBrokerResource extends BrokerResource {

    private Logger log = LoggerFactory.getLogger(ProxiedBrokerResource.class);

    private final ProxyDefinition proxyDefinition;

    ProxiedBrokerResource(ProxyDefinition proxyDefinition) {
        super(proxyDefinition.getBrokerResource().getBrokerDefinition());
        this.proxyDefinition = proxyDefinition;
    }

    private Map<String, SocketProxy> cachedSocketProxies = new HashMap<>();

    public SocketProxy getProxy(String transportConnectorName) {
        Validate.notEmpty(transportConnectorName, "transportConnectorName is empty");

        // instantiating a proxy binds it to a port; cache it so subsequent gets refetch one in default state
        SocketProxy socketProxy = cachedSocketProxies.get(transportConnectorName);
        if (socketProxy == null) {
            socketProxy = getSocketProxy(transportConnectorName);
            cachedSocketProxies.put(transportConnectorName, socketProxy);
        } else {
            socketProxy.close();
        }
        return socketProxy;
    }

    SocketProxy getSocketProxy(String transportConnectorName) {
        if (transportConnectorName.equals(proxyDefinition.getTransportConnectorName())) {
            TransportConnectorsDefinition transportConnectorsDefinition = brokerDefinition.getTransportConnectorsDefinition();
            Validate.notNull(transportConnectorsDefinition, "No transportConnectors defined, so cannot proxy");
            Collection<TransportConnectorDefinition> transportConnectorDefinitions =
                    transportConnectorsDefinition.getTransportConnectorDefinitions();

            TransportConnectorDefinition transportConnectorDefinition = null;
            for (TransportConnectorDefinition tcDefinition : transportConnectorDefinitions) {
                if (tcDefinition.getName().equals(transportConnectorName)) {
                    transportConnectorDefinition = tcDefinition;
                }
            }
            Validate.notNull(transportConnectorDefinition, "No transportConnector defined with name " + transportConnectorName);

            URI tcUri = URI.create(transportConnectorDefinition.getUri());
            URI brokerUri = URI.create("tcp://localhost:" + tcUri.getPort());

            try {
                int proxyPort = proxyDefinition.getProxyPort();
                return new SocketProxy(proxyPort, brokerUri);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            BrokerResource wrappedResource = proxyDefinition.getBrokerResource();
            if (wrappedResource instanceof ProxiedBrokerResource) {
                // use it recursively
                ProxiedBrokerResource wrappedProxiedResource = (ProxiedBrokerResource) wrappedResource;
                return wrappedProxiedResource.getSocketProxy(transportConnectorName);
            } else {
                log.info("No proxy defined for name " + transportConnectorName);
                return null;
            }
        }
    }

    /**
     * Gets the <code>tcp://</code> connection URI to the named transportConnector. The URI will point to the proxy
     * port if that transportConnector has been proxied.
     * @param transportConnectorName The name of the transportConnector.
     * @return The connection URI.
     * @throws IllegalStateException if no transportConnector is defined with the given name, or if the scheme
     * on that transportConnector is anything other than <code>tcp</code> or <code>nio</code>.
     */
    @Override
    public String getTcpConnectionUri(String transportConnectorName) {
        Validate.notEmpty(transportConnectorName, "transportConnectorName is empty");

        SocketProxy socketProxy = getProxy(transportConnectorName);
        if (socketProxy == null) {
            // transportConnector is not proxied - use the regular lookup mechanism
            return super.getTcpConnectionUri(transportConnectorName);
        } else {
            URI proxiedUri = socketProxy.getUrl();
            assertSchemeIn(proxiedUri.getScheme(), "tcp", "nio");
            return "tcp://localhost:" + proxiedUri.getPort();
        }
    }
}

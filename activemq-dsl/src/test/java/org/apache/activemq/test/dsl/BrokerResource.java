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


import org.apache.activemq.broker.dsl.BrokerContext;
import org.apache.activemq.broker.dsl.BrokerDefinition;
import org.apache.activemq.broker.dsl.TransportConnectorDefinition;
import org.apache.activemq.broker.dsl.TransportConnectorsDefinition;
import org.apache.commons.lang.Validate;
import org.junit.rules.ExternalResource;

import javax.jms.Connection;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jkorab
 */
public class BrokerResource extends ExternalResource {
    protected final BrokerDefinition brokerDefinition;

    private final BrokerContext brokerContext;
    private final Map<String, ConnectionHolder> connectionHolderMap = new HashMap<>();

    public BrokerResource(BrokerDefinition brokerDefinition) {
        Validate.notNull(brokerDefinition, "brokerDefinition is null");
        this.brokerDefinition = brokerDefinition;
        this.brokerContext = new BrokerContext(brokerDefinition);
    }

    @Override
    protected void before() throws Throwable {
        brokerContext.start();
    }

    @Override
    protected void after() {
        for (ConnectionHolder connectionHolder : connectionHolderMap.values()) {
            connectionHolder.close();
        }
        brokerContext.stop();
    }


    public ProxyDefinition withProxied(String transportConnectorName) {
        Validate.notEmpty(transportConnectorName, "transportConnectorName is empty");
        ProxyDefinition proxyDefinition = new ProxyDefinition(this, transportConnectorName);
        return proxyDefinition;
    }

    BrokerDefinition getBrokerDefinition() {
        return brokerDefinition;
    }

    /**
     * Gets the <code>tcp://</code> connection URI to the named transportConnector.
     * Intended for use as input into an {@link org.apache.activemq.ActiveMQConnectionFactory}.
     * @param transportConnectorName The name of the transportConnector.
     * @return The connection URI.
     * @throws IllegalStateException if no transportConnector is defined with the given name, or if the scheme
     * on that transportConnector is anything other than <code>tcp</code> or <code>nio</code>.
     */
    public String getTcpConnectionUri(String transportConnectorName) {
        Validate.notEmpty(transportConnectorName, "transportConnectorName is empty");

        TransportConnectorsDefinition transportConnectorsDefinition = brokerDefinition.getTransportConnectorsDefinition();
        if (transportConnectorsDefinition == null) {
            throw new IllegalStateException("No transportConnectors defined");
        }

        Collection<TransportConnectorDefinition> tcDefinitions = transportConnectorsDefinition.getTransportConnectorDefinitions();
        String retval = null;
        for (TransportConnectorDefinition tcDefinition: tcDefinitions) {
            if (tcDefinition.getName().equals(transportConnectorName)) {
                URI tcUri = URI.create(tcDefinition.getUri());
                assertSchemeIn(tcUri.getScheme(), "tcp", "nio");
                retval = "tcp://localhost:" + tcUri.getPort();
                break;
            }
        }
        if (retval == null) {
            throw new IllegalStateException("No transportConnector found named " + transportConnectorName);
        }
        return retval;
    }

    protected void assertSchemeIn(String scheme, String ... expectedSchemes) {
        boolean found = false;
        for (String expectedScheme : expectedSchemes) {
            if (scheme.equals(expectedScheme)) {
                found = true;
                break;
            }
        }
        if (!found) {
            StringBuilder sb = new StringBuilder("Unexpected scheme " + scheme + ". Expected ");

            for (int i = 0; i < expectedSchemes.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(expectedSchemes[i]);
            }
            throw new IllegalArgumentException(sb.toString());
        }

    }

    /**
     * Sets up a ConnectionFactory to the named transport connector, and retrieves a started Connection from it.
     * The Connection will be closed as part of the lifecycle of this resource.
     * @param transportConnectorName The name of the transportConnector.
     * @return A connection to the named transport connector.
     * @throws IllegalStateException if no transportConnector is defined with the given name, or if the scheme
     * on that transportConnector is anything other than <code>tcp</code> or <code>nio</code>.
     */
    public Connection getConnection(String transportConnectorName) {
        Validate.notEmpty(transportConnectorName, "transportConnectorName is empty");

        ConnectionHolder connectionHolder = connectionHolderMap.get(transportConnectorName);
        if (connectionHolder == null) {
            connectionHolder = new ConnectionHolder(getTcpConnectionUri(transportConnectorName));
            connectionHolderMap.put(transportConnectorName, connectionHolder);
        }
        return connectionHolder.getConnection();
    }

    /**
     * Convenience method - sets up a ConnectionFactory to the the Openwire (tcp/nio) transport connector if one
     * is defined, and retrieves a started Connection from it.
     * The Connection will be closed as part of the lifecycle of this resource.
     * @return A connection.
     * @throws IllegalStateException if no openwire connector is defined.
     */
    public Connection getConnection() {
        String transportConnectorName = brokerContext.getOpenwireConnectorName();
        if (transportConnectorName == null) {
            throw new IllegalStateException("No OpenWire connector defined on this broker");
        }
        return getConnection(transportConnectorName);
    }
}

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

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.dsl.model.BrokerDef;
import org.apache.activemq.broker.dsl.model.TransportConnectorDef;
import org.apache.activemq.broker.dsl.translator.BrokerServiceTranslator;
import org.apache.commons.lang.Validate;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * FIXME this class name clashes with {@link org.apache.activemq.broker.BrokerContext}
 *
 * @author jkorab
 */
public class BrokerContext {

    private final BrokerBuilder brokerBuilder;
    private BrokerService brokerService;
    private BrokerDef brokerDef;

    public BrokerContext(BrokerBuilder brokerBuilder) {
        Validate.notNull(brokerBuilder, "brokerBuilder is null");
        this.brokerBuilder = brokerBuilder;
    }

    public void start() {
        brokerDef = brokerBuilder.build();
        brokerService = new BrokerServiceTranslator().translate(brokerDef);
        try {
            brokerService.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // wait for startup
        final int maxWaitTime = 10000;
        final CountDownLatch startLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                long waitStartTime = new Date().getTime();

                while(!brokerService.isStarted()) {
                    try {
                        Thread.sleep(100);
                        long now = new Date().getTime();
                        if ((now - waitStartTime) > maxWaitTime) {
                            return; // expired
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                startLatch.countDown();
            }
        }).start();
        try {
            if (!startLatch.await(maxWaitTime, TimeUnit.MILLISECONDS)) {
                // timeout
                throw new RuntimeException("unable to start broker within " + maxWaitTime + " ms");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public void stop() {
        try {
            brokerService.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the name of the openwire connector defined on this broker. The first connector whose scheme starts with
     * tcp or nio is returned.
     * @return A transport connector name, or null.
     */
    public String getOpenwireConnectorName() {
        if (brokerDef == null) {
            throw new IllegalStateException("BrokerContext is not started");
        }
        String connectorName = null;
        for (TransportConnectorDef transportConnectorDef : brokerDef.getTransportConnectorDefs()) {
            String uri = transportConnectorDef.getUri();
            if (uri.startsWith("tcp") || (uri.startsWith("nio"))) {
                connectorName = transportConnectorDef.getName();
                break;
            }
        }
        return connectorName;
    }
}

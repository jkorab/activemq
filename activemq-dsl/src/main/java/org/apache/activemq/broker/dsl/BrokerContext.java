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
import org.apache.commons.lang.Validate;

/**
 * FIXME this class name clashes with {@link org.apache.activemq.broker.BrokerContext}
 *
 * @author jkorab
 */
public class BrokerContext {

    private final BrokerDefinition brokerDefinition;
    private BrokerService brokerService;

    public BrokerContext(BrokerDefinition brokerDefinition) {
        Validate.notNull(brokerDefinition, "brokerDefinition is null");
        this.brokerDefinition = brokerDefinition;
    }

    public void start() {
        brokerService = new BrokerServiceBuilder().build(brokerDefinition);
        try {
            brokerService.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        try {
            brokerService.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

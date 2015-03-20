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

import org.apache.activemq.broker.region.policy.PendingMessageLimitStrategy;

/**
 * Base class for common attributes of queue and topic policyEntry elements.
 * @author jkorab
 */
public abstract class PolicyEntryBuilder<T extends PolicyEntryBuilder> {

    private Boolean advisoryForFastProducers;
    private Boolean advisoryForConsumed;
    private Boolean advisoryForDelivery;
    private Boolean advisoryForDiscardingMessages;
    private Boolean advisoryForSlowConsumers;
    private Boolean advisoryWhenFull;
    private Boolean producerFlowControl;
    private PendingMessageLimitStrategy pendingMessageLimitStrategy;

    public T advisoryForFastProducers(Boolean advisoryForFastProducers) {
        this.advisoryForFastProducers = advisoryForFastProducers;
        return (T) this;
    }

    public T advisoryForConsumed(Boolean advisoryForConsumed) {
        this.advisoryForConsumed = advisoryForConsumed;
        return (T) this;
    }

    public T advisoryForDelivery(Boolean advisoryForDelivery) {
        this.advisoryForDelivery = advisoryForDelivery;
        return (T) this;
    }

    public T advisoryForDiscardingMessages(Boolean advisoryForDiscardingMessages) {
        this.advisoryForDiscardingMessages = advisoryForDiscardingMessages;
        return (T) this;
    }

    public T advisoryForSlowConsumers(Boolean advisoryForSlowConsumers) {
        this.advisoryForSlowConsumers = advisoryForSlowConsumers;
        return (T) this;
    }

    public T advisoryWhenFull(Boolean advisoryWhenFull) {
        this.advisoryWhenFull = advisoryWhenFull;
        return (T) this;
    }

    public T producerFlowControl(Boolean producerFlowControl) {
        this.producerFlowControl = producerFlowControl;
        return (T) this;
    }

    public T pendingMessageLimitStrategy(PendingMessageLimitStrategy pendingMessageLimitStrategy) {
        this.pendingMessageLimitStrategy = pendingMessageLimitStrategy;
        return (T) this;
    }

    public Boolean getAdvisoryForFastProducers() {
        return advisoryForFastProducers;
    }

    public Boolean getAdvisoryForConsumed() {
        return advisoryForConsumed;
    }

    public Boolean getAdvisoryForDelivery() {
        return advisoryForDelivery;
    }

    public Boolean getAdvisoryForDiscardingMessages() {
        return advisoryForDiscardingMessages;
    }

    public Boolean getAdvisoryForSlowConsumers() {
        return advisoryForSlowConsumers;
    }

    public Boolean getAdvisoryWhenFull() {
        return advisoryWhenFull;
    }

    public Boolean getProducerFlowControl() {
        return producerFlowControl;
    }

    public PendingMessageLimitStrategy getPendingMessageLimitStrategy() {
        return pendingMessageLimitStrategy;
    }



}

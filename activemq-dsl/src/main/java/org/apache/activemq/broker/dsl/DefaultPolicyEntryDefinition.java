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

package org.apache.activemq.broker.dsl;

import org.apache.activemq.broker.region.policy.PendingMessageLimitStrategy;

/**
 * @author jkorab
 */
public class DefaultPolicyEntryDefinition extends PolicyEntryDefinition {

    private final PolicyMapDefinition policyMapDefinition;

    public DefaultPolicyEntryDefinition(PolicyMapDefinition policyMapDefinition) {
        assert (policyMapDefinition != null);
        this.policyMapDefinition = policyMapDefinition;
    }

    private Boolean advisoryForFastProducers;
    private Boolean advisoryForConsumed;
    private Boolean advisoryForDelivery;
    private Boolean advisoryForDiscardingMessages;
    private Boolean advisoryForSlowConsumers;
    private Boolean advisoryWhenFull;
    private Boolean producerFlowControl;
    private PendingMessageLimitStrategy pendingMessageLimitStrategy;

    public DefaultPolicyEntryDefinition advisoryForFastProducers(Boolean advisoryForFastProducers) {
        this.advisoryForFastProducers = advisoryForFastProducers;
        return this;
    }

    public DefaultPolicyEntryDefinition advisoryForConsumed(Boolean advisoryForConsumed) {
        this.advisoryForConsumed = advisoryForConsumed;
        return this;
    }

    public DefaultPolicyEntryDefinition advisoryForDelivery(Boolean advisoryForDelivery) {
        this.advisoryForDelivery = advisoryForDelivery;
        return this;
    }

    public DefaultPolicyEntryDefinition advisoryForDiscardingMessages(Boolean advisoryForDiscardingMessages) {
        this.advisoryForDiscardingMessages = advisoryForDiscardingMessages;
        return this;
    }

    public DefaultPolicyEntryDefinition advisoryForSlowConsumers(Boolean advisoryForSlowConsumers) {
        this.advisoryForSlowConsumers = advisoryForSlowConsumers;
        return this;
    }

    public DefaultPolicyEntryDefinition advisoryWhenFull(Boolean advisoryWhenFull) {
        this.advisoryWhenFull = advisoryWhenFull;
        return this;
    }

    public DefaultPolicyEntryDefinition producerFlowControl(Boolean producerFlowControl) {
        this.producerFlowControl = producerFlowControl;
        return this;
    }

    public DefaultPolicyEntryDefinition pendingMessageLimitStrategy(PendingMessageLimitStrategy pendingMessageLimitStrategy) {
        this.pendingMessageLimitStrategy = pendingMessageLimitStrategy;
        return this;
    }

    public PolicyMapDefinition end() {
        return policyMapDefinition;
    }

    Boolean getAdvisoryForFastProducers() {
        return advisoryForFastProducers;
    }

    Boolean getAdvisoryForConsumed() {
        return advisoryForConsumed;
    }

    Boolean getAdvisoryForDelivery() {
        return advisoryForDelivery;
    }

    Boolean getAdvisoryForDiscardingMessages() {
        return advisoryForDiscardingMessages;
    }

    Boolean getAdvisoryForSlowConsumers() {
        return advisoryForSlowConsumers;
    }

    Boolean getAdvisoryWhenFull() {
        return advisoryWhenFull;
    }

    Boolean getProducerFlowControl() {
        return producerFlowControl;
    }

    PendingMessageLimitStrategy getPendingMessageLimitStrategy() {
        return pendingMessageLimitStrategy;
    }
}

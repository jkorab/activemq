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

import org.apache.activemq.broker.dsl.model.DefaultPolicyEntryDef;
import org.apache.activemq.broker.dsl.model.PolicyEntryDef;
import org.apache.activemq.broker.region.policy.PendingMessageLimitStrategy;

/**
 * Base class for common attributes of queue and topic policyEntry elements.
 * @author jkorab
 */
public abstract class PolicyEntryBuilder<D extends PolicyEntryDef, T extends PolicyEntryBuilder> {

    protected D policyEntryDef;

    public PolicyEntryBuilder(D policyEntryDef) {
        assert (policyEntryDef != null);
        this.policyEntryDef = policyEntryDef;
    }

    public T advisoryForFastProducers(Boolean advisoryForFastProducers) {
        policyEntryDef.setAdvisoryForFastProducers(advisoryForFastProducers);
        return (T) this;
    }

    public T advisoryForConsumed(Boolean advisoryForConsumed) {
        policyEntryDef.setAdvisoryForConsumed(advisoryForConsumed);
        return (T) this;
    }

    public T advisoryForDelivery(Boolean advisoryForDelivery) {
        policyEntryDef.setAdvisoryForDelivery(advisoryForDelivery);
        return (T) this;
    }

    public T advisoryForDiscardingMessages(Boolean advisoryForDiscardingMessages) {
        policyEntryDef.setAdvisoryForDiscardingMessages(advisoryForDiscardingMessages);
        return (T) this;
    }

    public T advisoryForSlowConsumers(Boolean advisoryForSlowConsumers) {
        policyEntryDef.setAdvisoryForSlowConsumers(advisoryForSlowConsumers);
        return (T) this;
    }

    public T advisoryWhenFull(Boolean advisoryWhenFull) {
        policyEntryDef.setAdvisoryWhenFull(advisoryWhenFull);
        return (T) this;
    }

    public T producerFlowControl(Boolean producerFlowControl) {
        policyEntryDef.setProducerFlowControl(producerFlowControl);
        return (T) this;
    }

    public T pendingMessageLimitStrategy(PendingMessageLimitStrategy pendingMessageLimitStrategy) {
        policyEntryDef.setPendingMessageLimitStrategy(pendingMessageLimitStrategy);
        return (T) this;
    }

    public D build() {
        return policyEntryDef;
    }
}

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

import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.commons.lang.Validate;

/**
 * @author jkorab
 */
class PolicyEntryBuilder {

    PolicyEntry build(PolicyEntryDefinition definition) {
        Validate.notNull(definition, "definition is null");

        PolicyEntry policyEntry = new PolicyEntry();
        policyEntry.setAdvisoryForFastProducers(safe(definition.getAdvisoryForFastProducers()));
        policyEntry.setAdvisoryForConsumed(safe(definition.getAdvisoryForConsumed()));
        policyEntry.setAdvisoryForDelivery(safe(definition.getAdvisoryForDelivery()));
        policyEntry.setAdvisoryForDiscardingMessages(safe(definition.getAdvisoryForDiscardingMessages()));
        policyEntry.setAdvisoryForSlowConsumers(safe(definition.getAdvisoryForSlowConsumers()));
        policyEntry.setAdvisoryWhenFull(safe(definition.getAdvisoryWhenFull()));
        policyEntry.setProducerFlowControl(safe(definition.getProducerFlowControl()));

        policyEntry.setPendingMessageLimitStrategy(definition.getPendingMessageLimitStrategy());

        if (definition instanceof DestinationPolicyEntryDefinition) {
                applyDestinationFields(policyEntry, (DestinationPolicyEntryDefinition) definition);
        }
        return policyEntry;
    }

    private void applyDestinationFields(PolicyEntry policyEntry, DestinationPolicyEntryDefinition definition) {
        assert (policyEntry != null);
        assert (definition != null);

        if (definition instanceof QueuePolicyEntryDefinition) {
            applyQueueFields(policyEntry, (QueuePolicyEntryDefinition) definition);
        } else {
            if (definition.getTemporary()) {
                policyEntry.setTempTopic(true);
            }
        }
    }

    private void applyQueueFields(PolicyEntry policyEntry, QueuePolicyEntryDefinition definition) {
        assert (policyEntry != null);
        assert (definition != null);

        if (definition.getTemporary()) {
            policyEntry.setTempQueue(true);
        } else {
            policyEntry.setQueue(definition.getName());
        }
        policyEntry.setExpireMessagesPeriod(definition.getExpireMessagesPeriod());
    }

    boolean safe(Boolean b) {
        return (b == null) ? false : b;
    }

}

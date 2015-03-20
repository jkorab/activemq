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

package org.apache.activemq.broker.dsl.translator;

import org.apache.activemq.broker.dsl.model.DestinationPolicyEntryDef;
import org.apache.activemq.broker.dsl.model.PolicyEntryDef;
import org.apache.activemq.broker.dsl.model.QueuePolicyEntryDef;
import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.commons.lang.Validate;

/**
 * @author jkorab
 */
class PolicyEntryTranslator {

    PolicyEntry translate(PolicyEntryDef policyEntryDef) {
        Validate.notNull(policyEntryDef, "definition is null");

        PolicyEntry policyEntry = new PolicyEntry();
        policyEntry.setAdvisoryForFastProducers(safe(policyEntryDef.getAdvisoryForFastProducers()));
        policyEntry.setAdvisoryForConsumed(safe(policyEntryDef.getAdvisoryForConsumed()));
        policyEntry.setAdvisoryForDelivery(safe(policyEntryDef.getAdvisoryForDelivery()));
        policyEntry.setAdvisoryForDiscardingMessages(safe(policyEntryDef.getAdvisoryForDiscardingMessages()));
        policyEntry.setAdvisoryForSlowConsumers(safe(policyEntryDef.getAdvisoryForSlowConsumers()));
        policyEntry.setAdvisoryWhenFull(safe(policyEntryDef.getAdvisoryWhenFull()));
        policyEntry.setProducerFlowControl(safe(policyEntryDef.getProducerFlowControl()));

        policyEntry.setPendingMessageLimitStrategy(policyEntryDef.getPendingMessageLimitStrategy());

        if (policyEntryDef instanceof DestinationPolicyEntryDef) {
                applyDestinationFields(policyEntry, (DestinationPolicyEntryDef) policyEntryDef);
        }
        return policyEntry;
    }

    private void applyDestinationFields(PolicyEntry policyEntry, DestinationPolicyEntryDef definition) {
        assert (policyEntry != null);
        assert (definition != null);

        if (definition instanceof QueuePolicyEntryDef) {
            applyQueueFields(policyEntry, (QueuePolicyEntryDef) definition);
        } else {
            if (definition.getTemporary()) {
                policyEntry.setTempTopic(true);
            }
        }
    }

    private void applyQueueFields(PolicyEntry policyEntry, QueuePolicyEntryDef definition) {
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

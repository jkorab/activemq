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

import org.apache.commons.lang.Validate;

/**
 * @author jkorab
 */
public class IndirectPolicyEntryBuilder {

    private final PolicyEntriesBuilder policyEntriesBuilder;
    private PolicyEntryBuilder policyEntryBuilder;

    IndirectPolicyEntryBuilder(PolicyEntriesBuilder policyEntriesBuilder) {
        assert(policyEntriesBuilder != null);
        this.policyEntriesBuilder = policyEntriesBuilder;
    }

    public QueuePolicyEntryBuilder queue(String name) {
        Validate.notEmpty(name, "queue name is empty");

        QueuePolicyEntryBuilder queuePolicyEntryDefinition = new QueuePolicyEntryBuilder(policyEntriesBuilder, name);
        policyEntryBuilder = queuePolicyEntryDefinition;
        return queuePolicyEntryDefinition;
    }

    public PolicyEntryBuilder getPolicyEntryBuilder() {
        return policyEntryBuilder;
    }

    public QueuePolicyEntryBuilder tempQueue() {
        QueuePolicyEntryBuilder queuePolicyEntryDefinition = new QueuePolicyEntryBuilder(policyEntriesBuilder);
        policyEntryBuilder = queuePolicyEntryDefinition;
        return queuePolicyEntryDefinition;
    }

    public TopicPolicyEntryBuilder tempTopic() {
        TopicPolicyEntryBuilder topicPolicyEntryDefinition = new TopicPolicyEntryBuilder(policyEntriesBuilder);
        policyEntryBuilder = topicPolicyEntryDefinition;
        return topicPolicyEntryDefinition;
    }
}

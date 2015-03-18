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

/**
 * Base class for common attributes of queue and topic policyEntry elements.
 * @author jkorab
 */
public abstract class PolicyEntryDefinition {

    private final PolicyEntriesDefinition policyEntriesDefinition;
    private final String name;

    PolicyEntryDefinition(PolicyEntriesDefinition policyEntriesDefinition, String name) {
        assert (policyEntriesDefinition != null);
        assert (name != null);
        this.policyEntriesDefinition = policyEntriesDefinition;
        this.name = name;
    }

    public PolicyEntriesDefinition end() {
        return policyEntriesDefinition;
    }

    String getName() {
        return name;
    }
}

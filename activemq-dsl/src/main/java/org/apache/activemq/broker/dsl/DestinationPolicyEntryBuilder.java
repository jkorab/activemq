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

/**
 * @author jkorab
 */
public abstract class DestinationPolicyEntryBuilder<T extends PolicyEntryBuilder> extends PolicyEntryBuilder<T> {

    private final boolean temporary;
    private final String name;
    private final PolicyEntriesBuilder policyEntriesBuilder;

    DestinationPolicyEntryBuilder(PolicyEntriesBuilder policyEntriesBuilder) {
        assert (policyEntriesBuilder != null);
        this.temporary = true;
        this.name = null;
        this.policyEntriesBuilder = policyEntriesBuilder;
    }

    DestinationPolicyEntryBuilder(PolicyEntriesBuilder policyEntriesBuilder, String name) {
        assert (name != null);
        assert (policyEntriesBuilder != null);
        this.temporary = false;
        this.name = name;
        this.policyEntriesBuilder = policyEntriesBuilder;
    }

    public PolicyEntriesBuilder end() {
        return policyEntriesBuilder;
    }

    public String getName() {
        return name;
    }

    public boolean getTemporary() {
        return temporary;
    }
}

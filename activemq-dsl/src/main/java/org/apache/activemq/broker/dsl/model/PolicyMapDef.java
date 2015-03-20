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

package org.apache.activemq.broker.dsl.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jkorab
 */
public class PolicyMapDef {

    private DefaultPolicyEntryDef defaultPolicyEntryDef;
    private List<PolicyEntryDef> policyEntryDefs = new ArrayList<>();

    public DefaultPolicyEntryDef getDefaultPolicyEntryDef() {
        return defaultPolicyEntryDef;
    }

    public void setDefaultPolicyEntryDef(DefaultPolicyEntryDef defaultPolicyEntryDef) {
        this.defaultPolicyEntryDef = defaultPolicyEntryDef;
    }

    public List<PolicyEntryDef> getPolicyEntryDefs() {
        return policyEntryDefs;
    }

    public void setPolicyEntryDefs(List<PolicyEntryDef> policyEntryDefs) {
        this.policyEntryDefs = policyEntryDefs;
    }
}

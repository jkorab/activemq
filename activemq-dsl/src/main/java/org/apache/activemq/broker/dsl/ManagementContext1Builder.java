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

import org.apache.activemq.broker.dsl.model.ManagementContext1Def;

/**
 * @author jkorab
 */
public class ManagementContext1Builder {

    private final ManagementContextBuilder managementContextBuilder;
    private final ManagementContext1Def managementContext1Def;

    ManagementContext1Builder(ManagementContextBuilder managementContextBuilder) {
        assert (managementContextBuilder != null);
        this.managementContextBuilder = managementContextBuilder;
        this.managementContext1Def = new ManagementContext1Def();
    }

    public ManagementContext1Builder createConnector(boolean createConnector) {
        managementContext1Def.setCreateConnector(createConnector);
        return this;
    }

    public ManagementContextBuilder end() {
        return managementContextBuilder;
    }

    public ManagementContext1Def build() {
        return managementContext1Def;
    }
}

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

import org.apache.activemq.broker.dsl.model.ManagementContextDef;

/**
 * @author jkorab
 */
public class ManagementContextBuilder {

    private BrokerBuilder brokerBuilder;
    private ManagementContext1Builder managementContext1Builder;

    ManagementContextBuilder(BrokerBuilder brokerBuilder) {
        assert (brokerBuilder != null);
        this.brokerBuilder = brokerBuilder;
    }

    public ManagementContext1Builder managementContext() {
        managementContext1Builder = new ManagementContext1Builder(this);
        return managementContext1Builder;
    }

    public BrokerBuilder end() {
        return brokerBuilder;
    }

    public ManagementContext1Builder getManagementContext1Builder() {
        return managementContext1Builder;
    }

    public ManagementContextDef build() {
        return null; // TODO
    }
}

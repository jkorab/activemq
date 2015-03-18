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
 * @author jkorab
 */
public class ManagementContext1Definition {

    private final ManagementContextDefinition managementContextDefinition;
    private boolean createConnector = true;

    ManagementContext1Definition(ManagementContextDefinition managementContextDefinition) {
        assert (managementContextDefinition != null);
        this.managementContextDefinition = managementContextDefinition;
    }

    public ManagementContext1Definition createConnector(boolean createConnector) {
        this.createConnector = createConnector;
        return this;
    }

    public ManagementContextDefinition end() {
        return managementContextDefinition;
    }

    public boolean isCreateConnector() {
        return createConnector;
    }
}

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

import org.apache.activemq.broker.dsl.model.SimpleAuthenticationPluginDef;

/**
 * @author jkorab
 */
public class SimpleAuthenticationPluginBuilder {

    private final PluginsBuilder pluginsBuilder;
    private UsersBuilder usersBuilder;

    SimpleAuthenticationPluginBuilder(PluginsBuilder pluginsBuilder) {
        assert (pluginsBuilder != null);
        this.pluginsBuilder = pluginsBuilder;
    }


    public UsersBuilder users() {
        usersBuilder = new UsersBuilder(this);
        return usersBuilder;
    }

    public PluginsBuilder end() {
        return pluginsBuilder;
    }

    public SimpleAuthenticationPluginDef build() {
        SimpleAuthenticationPluginDef simpleAuthenticationPluginDef = new SimpleAuthenticationPluginDef();
        if (usersBuilder != null) {
            simpleAuthenticationPluginDef.setAuthenticationUserDefs(usersBuilder.build());
        }
        return simpleAuthenticationPluginDef;
    }
}

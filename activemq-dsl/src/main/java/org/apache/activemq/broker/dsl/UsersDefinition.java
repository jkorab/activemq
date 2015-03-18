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

import java.util.ArrayList;
import java.util.List;

/**
 * @author jkorab
 */
public class UsersDefinition {

    private final SimpleAuthenticationPluginDefinition simpleAuthenticationPluginDefinition;
    private final List<AuthenticationUserDefinition> authenticationUserDefinitions = new ArrayList<>();

    UsersDefinition(SimpleAuthenticationPluginDefinition simpleAuthenticationPluginDefinition) {
        assert (simpleAuthenticationPluginDefinition != null);
        this.simpleAuthenticationPluginDefinition = simpleAuthenticationPluginDefinition;
    }

    public AuthenticationUserDefinition authenticationUser(String username) {
        Validate.notEmpty(username, "username is empty");

        AuthenticationUserDefinition authenticationUserDefinition = new AuthenticationUserDefinition(this, username);
        authenticationUserDefinitions.add(authenticationUserDefinition);
        return authenticationUserDefinition;
    }

    public SimpleAuthenticationPluginDefinition end() {
        Validate.notEmpty(authenticationUserDefinitions, "No authenticationUsers defined");
        return simpleAuthenticationPluginDefinition;
    }

    List<AuthenticationUserDefinition> getAuthenticationUserDefinitions() {
        return authenticationUserDefinitions;
    }
}

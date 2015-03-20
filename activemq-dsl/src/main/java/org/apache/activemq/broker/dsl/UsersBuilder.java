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

import org.apache.activemq.broker.dsl.model.AuthenticationUserDef;
import org.apache.commons.lang.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jkorab
 */
public class UsersBuilder {

    private final SimpleAuthenticationPluginBuilder simpleAuthenticationPluginBuilder;
    private final List<AuthenticationUserBuilder> authenticationUserBuilders = new ArrayList<>();

    UsersBuilder(SimpleAuthenticationPluginBuilder simpleAuthenticationPluginBuilder) {
        assert (simpleAuthenticationPluginBuilder != null);
        this.simpleAuthenticationPluginBuilder = simpleAuthenticationPluginBuilder;
    }

    public AuthenticationUserBuilder authenticationUser(String username) {
        Validate.notEmpty(username, "username is empty");

        AuthenticationUserBuilder authenticationUserBuilder = new AuthenticationUserBuilder(this, username);
        authenticationUserBuilders.add(authenticationUserBuilder);
        return authenticationUserBuilder;
    }

    public SimpleAuthenticationPluginBuilder end() {
        Validate.notEmpty(authenticationUserBuilders, "No authenticationUsers defined");
        return simpleAuthenticationPluginBuilder;
    }

    public List<AuthenticationUserBuilder> getAuthenticationUserBuilders() {
        return authenticationUserBuilders;
    }

    public List<AuthenticationUserDef> build() {
        ArrayList<AuthenticationUserDef> authenticationUserDefs = new ArrayList<>();
        for (AuthenticationUserBuilder authenticationUserBuilder : authenticationUserBuilders) {
            authenticationUserDefs.add(authenticationUserBuilder.build());
        }
        return authenticationUserDefs;
    }
}

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
public class AuthenticationUserDefinition {

    private final UsersDefinition usersDefinition;
    private final String username;
    private String password;
    private String groups;

    AuthenticationUserDefinition(UsersDefinition usersDefinition, String username) {
        assert (usersDefinition != null);
        assert (username != null);
        this.usersDefinition = usersDefinition;
        this.username = username;
    }

    public AuthenticationUserDefinition password(String password) {
        Validate.notEmpty(password, "password is empty");
        this.password = password;
        return this;
    }

    public AuthenticationUserDefinition groups(String groups) {
        Validate.notEmpty(groups, "groups is empty");
        this.groups = groups;
        return this;
    }

    public UsersDefinition end() {
        Validate.notNull(password, "password is null");
        Validate.notNull(groups, "groups is null");
        return usersDefinition;
    }

    public String getGroups() {
        return groups;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}

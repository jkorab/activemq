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

/**
 * @author jkorab
 */
public class AuthenticationUserBuilder {

    private final UsersBuilder usersBuilder;
    private final AuthenticationUserDef authenticationUserDef;

    AuthenticationUserBuilder(UsersBuilder usersBuilder, String username) {
        assert (usersBuilder != null);
        assert (username != null);
        this.usersBuilder = usersBuilder;
        authenticationUserDef = new AuthenticationUserDef();
        authenticationUserDef.setUsername(username);
    }

    public AuthenticationUserBuilder password(String password) {
        Validate.notEmpty(password, "password is empty");
        authenticationUserDef.setPassword(password);
        return this;
    }

    public AuthenticationUserBuilder groups(String groups) {
        Validate.notEmpty(groups, "groups is empty");
        // TODO there's probably a better way to do this than pass in a csv
        authenticationUserDef.setGroups(groups);
        return this;
    }

    public UsersBuilder end() {
        Validate.notNull(authenticationUserDef.getPassword(), "password is null");
        Validate.notNull(authenticationUserDef.getGroups(), "groups is null");
        return usersBuilder;
    }

    public AuthenticationUserDef build() {
        return authenticationUserDef;
    }
}

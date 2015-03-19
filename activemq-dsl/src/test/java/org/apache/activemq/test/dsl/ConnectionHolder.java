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

package org.apache.activemq.test.dsl;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang.Validate;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

/**
 * @author jkorab
 */
class ConnectionHolder {

    private final ConnectionFactory connectionFactory;
    private Connection connection;

    ConnectionHolder(String connectionUri) {
        Validate.notEmpty(connectionUri, "connectionUri is empty");
        this.connectionFactory = new ActiveMQConnectionFactory(connectionUri);
    }

    Connection getConnection() {
        try {
            connection = connectionFactory.createConnection();
            connection.start();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    void close() {
        try {
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

}

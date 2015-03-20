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
public class DestinationsDefinition {

    private final NetworkConnectorBuilder networkConnectorBuilder;
    private final List<String> topics = new ArrayList<>();
    private final List<String> queues = new ArrayList<>();

    DestinationsDefinition(NetworkConnectorBuilder networkConnectorBuilder) {
        assert (networkConnectorBuilder != null);
        this.networkConnectorBuilder = networkConnectorBuilder;
    }

    public DestinationsDefinition topic(String topicName) {
        Validate.notEmpty(topicName, "topicName is empty");

        if (topics.contains(topicName)) {
            throw new IllegalArgumentException("Topic " + topicName + "already added to networkConnector " + networkConnectorBuilder.getName());
        }
        topics.add(topicName);
        return this;
    }

    public DestinationsDefinition queue(String queueName) {
        Validate.notEmpty(queueName, "queueName is empty");

        if (queues.contains(queueName)) {
            throw new IllegalArgumentException("Queue " + queueName + "already added to networkConnector " + networkConnectorBuilder.getName());
        }
        queues.add(queueName);
        return this;
    }

    public NetworkConnectorBuilder end() {
        return networkConnectorBuilder;
    }

}

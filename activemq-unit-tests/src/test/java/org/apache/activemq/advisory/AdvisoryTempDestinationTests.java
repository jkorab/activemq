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
package org.apache.activemq.advisory;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.Topic;

import org.apache.activemq.broker.dsl.ActiveMQBrokers;
import org.apache.activemq.broker.region.policy.ConstantPendingMessageLimitStrategy;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.test.dsl.BrokerResource;
import org.apache.mina.util.AvailablePortFinder;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdvisoryTempDestinationTests {

    protected static final int MESSAGE_COUNT = 2000;

    @Rule
    public BrokerResource broker = new BrokerResource(
            ActiveMQBrokers.broker("advisory").useJmx(false).persistent(false)
                .destinationPolicy()
                    .policyMap()
                        .policyEntries()
                            .policyEntry().tempQueue()
                                .advisoryForFastProducers(true)
                                .advisoryForConsumed(true)
                                .advisoryForDelivery(true)
                                .advisoryForDiscardingMessages(true)
                                .advisoryForSlowConsumers(true)
                                .advisoryWhenFull(true)
                                .producerFlowControl(false)
                                .pendingMessageLimitStrategy(getPendingMessageLimitStrategy())
                            .end()
                            .policyEntry().tempTopic()
                                .advisoryForFastProducers(true)
                                .advisoryForConsumed(true)
                                .advisoryForDelivery(true)
                                .advisoryForDiscardingMessages(true)
                                .advisoryForSlowConsumers(true)
                                .advisoryWhenFull(true)
                                .producerFlowControl(false)
                                .pendingMessageLimitStrategy(getPendingMessageLimitStrategy())
                            .end()
                        .end()
                    .end()
                .end()
                .transportConnectors()
                    .transportConnector("openwire", "tcp://localhost:" + AvailablePortFinder.getNextAvailable())
                .end());

    private ConstantPendingMessageLimitStrategy getPendingMessageLimitStrategy() {
        ConstantPendingMessageLimitStrategy strategy = new ConstantPendingMessageLimitStrategy();
        strategy.setLimit(10);
        return strategy;
    }

    @Test
    public void testNoSlowConsumerAdvisory() throws Exception {
        Connection connection = broker.getConnection();

        Session s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        TemporaryQueue queue = s.createTemporaryQueue();
        MessageConsumer consumer = s.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
            }
        });
        Topic advisoryTopic = AdvisorySupport
                .getSlowConsumerAdvisoryTopic((ActiveMQDestination) queue);
        s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer advisoryConsumer = s.createConsumer(advisoryTopic);
        // start throwing messages at the consumer
        MessageProducer producer = s.createProducer(queue);
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            BytesMessage m = s.createBytesMessage();
            m.writeBytes(new byte[1024]);
            producer.send(m);
        }
        Message msg = advisoryConsumer.receive(1000);
        assertNull(msg);
    }

    @Test
    public void testSlowConsumerAdvisory() throws Exception {
        Connection connection = broker.getConnection();

        Session s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        TemporaryQueue queue = s.createTemporaryQueue();
        MessageConsumer consumer = s.createConsumer(queue);
        assertNotNull(consumer);

        Topic advisoryTopic = AdvisorySupport
                .getSlowConsumerAdvisoryTopic((ActiveMQDestination) queue);
        s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer advisoryConsumer = s.createConsumer(advisoryTopic);
        // start throwing messages at the consumer
        MessageProducer producer = s.createProducer(queue);
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            BytesMessage m = s.createBytesMessage();
            m.writeBytes(new byte[1024]);
            producer.send(m);
        }
        Message msg = advisoryConsumer.receive(1000);
        assertNotNull(msg);
    }

    @Test
    public void testMessageDeliveryAdvisory() throws Exception {
        Connection connection = broker.getConnection();

        Session s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        TemporaryQueue queue = s.createTemporaryQueue();
        MessageConsumer consumer = s.createConsumer(queue);
        assertNotNull(consumer);

        Topic advisoryTopic = AdvisorySupport.getMessageDeliveredAdvisoryTopic((ActiveMQDestination) queue);
        MessageConsumer advisoryConsumer = s.createConsumer(advisoryTopic);
        //start throwing messages at the consumer
        MessageProducer producer = s.createProducer(queue);

        BytesMessage m = s.createBytesMessage();
        m.writeBytes(new byte[1024]);
        producer.send(m);

        Message msg = advisoryConsumer.receive(1000);
        assertNotNull(msg);
    }

    @Test
    public void testTempMessageConsumedAdvisory() throws Exception {
        Connection connection = broker.getConnection();

        Session s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        TemporaryQueue queue = s.createTemporaryQueue();
        MessageConsumer consumer = s.createConsumer(queue);

        Topic advisoryTopic = AdvisorySupport.getMessageConsumedAdvisoryTopic((ActiveMQDestination) queue);
        MessageConsumer advisoryConsumer = s.createConsumer(advisoryTopic);
        //start throwing messages at the consumer
        MessageProducer producer = s.createProducer(queue);

        BytesMessage m = s.createBytesMessage();
        m.writeBytes(new byte[1024]);
        producer.send(m);
        String id = m.getJMSMessageID();
        Message msg = consumer.receive(1000);
        assertNotNull(msg);

        msg = advisoryConsumer.receive(1000);
        assertNotNull(msg);

        ActiveMQMessage message = (ActiveMQMessage) msg;
        ActiveMQMessage payload = (ActiveMQMessage) message.getDataStructure();
        String originalId = payload.getJMSMessageID();
        assertEquals(originalId, id);
    }

    @Test
    public void testMessageExpiredAdvisory() throws Exception {
        Connection connection = broker.getConnection();

        Session s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = s.createQueue(getClass().getName());
        MessageConsumer consumer = s.createConsumer(queue);
        assertNotNull(consumer);

        Topic advisoryTopic = AdvisorySupport.getExpiredMessageTopic((ActiveMQDestination) queue);
        MessageConsumer advisoryConsumer = s.createConsumer(advisoryTopic);
        //start throwing messages at the consumer
        MessageProducer producer = s.createProducer(queue);
        producer.setTimeToLive(1);
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            BytesMessage m = s.createBytesMessage();
            m.writeBytes(new byte[1024]);
            producer.send(m);
        }

        Message msg = advisoryConsumer.receive(5000);
        assertNotNull(msg);
    }

}

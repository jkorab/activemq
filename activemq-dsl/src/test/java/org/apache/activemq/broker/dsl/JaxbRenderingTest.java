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

package org.apache.activemq.broker.dsl;

import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;

/**
 * @author jkorab
 */
public class JaxbRenderingTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Test
    public void testXmlRendering() throws JAXBException {
        BrokerContext context = new BrokerContext(ActiveMQBrokers.broker("embedded").useJmx(false).persistent(false)
                .transportConnectors()
                    .transportConnector("openwire", "tcp://0.0.0.0:61616").end()
                .end());

        context.start();
        try {
            String xml = context.getConfigAsXml();
            log.info(xml);
            assertNotNull(xml);
        } finally {
            context.stop();
        }
    }
}

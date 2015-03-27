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

package org.apache.activemq.broker.dsl.model;

import org.apache.activemq.broker.region.policy.PendingMessageLimitStrategy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * @author jkorab
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class PolicyEntryDef {

    private Boolean advisoryForFastProducers;
    private Boolean advisoryForConsumed;
    private Boolean advisoryForDelivery;
    private Boolean advisoryForDiscardingMessages;
    private Boolean advisoryForSlowConsumers;
    private Boolean advisoryWhenFull;
    private Boolean producerFlowControl;

    @XmlTransient
    private PendingMessageLimitStrategy pendingMessageLimitStrategy;

    public Boolean getAdvisoryForFastProducers() {
        return advisoryForFastProducers;
    }

    public void setAdvisoryForFastProducers(Boolean advisoryForFastProducers) {
        this.advisoryForFastProducers = advisoryForFastProducers;
    }

    public Boolean getAdvisoryForConsumed() {
        return advisoryForConsumed;
    }

    public void setAdvisoryForConsumed(Boolean advisoryForConsumed) {
        this.advisoryForConsumed = advisoryForConsumed;
    }

    public Boolean getAdvisoryForDelivery() {
        return advisoryForDelivery;
    }

    public void setAdvisoryForDelivery(Boolean advisoryForDelivery) {
        this.advisoryForDelivery = advisoryForDelivery;
    }

    public Boolean getAdvisoryForDiscardingMessages() {
        return advisoryForDiscardingMessages;
    }

    public void setAdvisoryForDiscardingMessages(Boolean advisoryForDiscardingMessages) {
        this.advisoryForDiscardingMessages = advisoryForDiscardingMessages;
    }

    public Boolean getAdvisoryForSlowConsumers() {
        return advisoryForSlowConsumers;
    }

    public void setAdvisoryForSlowConsumers(Boolean advisoryForSlowConsumers) {
        this.advisoryForSlowConsumers = advisoryForSlowConsumers;
    }

    public Boolean getAdvisoryWhenFull() {
        return advisoryWhenFull;
    }

    public void setAdvisoryWhenFull(Boolean advisoryWhenFull) {
        this.advisoryWhenFull = advisoryWhenFull;
    }

    public Boolean getProducerFlowControl() {
        return producerFlowControl;
    }

    public void setProducerFlowControl(Boolean producerFlowControl) {
        this.producerFlowControl = producerFlowControl;
    }

    public PendingMessageLimitStrategy getPendingMessageLimitStrategy() {
        return pendingMessageLimitStrategy;
    }

    public void setPendingMessageLimitStrategy(PendingMessageLimitStrategy pendingMessageLimitStrategy) {
        this.pendingMessageLimitStrategy = pendingMessageLimitStrategy;
    }
}

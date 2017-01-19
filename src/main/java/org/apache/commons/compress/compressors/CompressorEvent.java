/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.compress.compressors;

import java.util.EventObject;

/**
 * Notification of (de)compression progress.
 * @Immutable
 */
public class CompressorEvent extends EventObject {

    public enum EventType { NEW_BLOCK, NEW_STREAM, NEW_MEMBER };
    private static final long serialVersionUID = 1L;
    private final EventType eventType;
    private final int eventCounter;
    private final long bitsProcessed;

    /**
     * Creates a new event.
     *
     * @param source the stream creating the event
     * @param blockNumber number of the block that is getting processed now
     * @param streamNumer number of the stream that is getting
     *        processed now
     * @param bitsProcessed number of bits read or written when the event is triggered
     */
    public CompressorEvent(Object source, EventType eventType, int eventCounter,
                                    long bitsProcessed) {
        super(source);
        this.eventType = eventType;
        this.eventCounter = eventCounter;
        this.bitsProcessed = bitsProcessed;
    }

    /**
     * The current event type
     * @return the current event type
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * The current counter value of this event.
     *
     * @return number of the block that is getting processed now
     */
    public int getEventCounter() {
        return eventCounter;
    }

    /**
     * The number of bits processed so far.
     * @return number of bits read or written on the underlying input respectively output stream when the event is triggered
     */
    public long getBitsProcessed() {
        return bitsProcessed;
    }
}

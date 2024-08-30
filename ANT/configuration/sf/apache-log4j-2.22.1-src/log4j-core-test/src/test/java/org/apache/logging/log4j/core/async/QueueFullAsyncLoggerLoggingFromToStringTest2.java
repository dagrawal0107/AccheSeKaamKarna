/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
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
package org.apache.logging.log4j.core.async;

import static org.junit.Assert.*;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.test.junit.SetTestProperty;
import org.junit.jupiter.api.Disabled;

/**
 * Tests queue full scenarios with pure AsyncLoggers (all loggers async).
 */
@SetTestProperty(key = "log4j2.formatMsgAsync", value = "true")
public class QueueFullAsyncLoggerLoggingFromToStringTest2 extends QueueFullAsyncLoggerLoggingFromToStringTest {

    @Override
    @Disabled("Causes deadlocks")
    public void testLoggingFromToStringCausesOutOfOrderMessages(LoggerContext ctx, BlockingAppender blockingAppender)
            throws Exception {
        super.testLoggingFromToStringCausesOutOfOrderMessages(ctx, blockingAppender);
    }

    @Override
    protected void checkConfig(final LoggerContext ctx) {
        super.checkConfig(ctx);
        assertFormatMessagesInBackground();
    }
}

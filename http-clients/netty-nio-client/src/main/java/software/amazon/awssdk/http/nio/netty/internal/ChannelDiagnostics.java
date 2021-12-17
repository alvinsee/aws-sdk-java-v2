/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.http.nio.netty.internal;

import java.time.Instant;
import software.amazon.awssdk.annotations.SdkInternalApi;
import software.amazon.awssdk.utils.ToString;

/**
 * Diagnostic information that may be useful to help with debugging during error scenarios.
 */
@SdkInternalApi
public class ChannelDiagnostics {
    private Instant channelCreationTime;
    private int requestCount = 0;

    public void setChannelCreationTime(Instant channelCreationTime) {
        this.channelCreationTime = channelCreationTime;
    }

    public void incrementRequestCount() {
        ++this.requestCount;
    }

    @Override
    public String toString() {
        return ToString.builder("ChannelDiagnostics")
                       .add("creationTime", channelCreationTime)
                       .add("requestCount", requestCount)
                       .build();
    }
}

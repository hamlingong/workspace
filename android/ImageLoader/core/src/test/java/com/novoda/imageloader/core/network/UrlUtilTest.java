/**
 * Copyright 2012 Novoda Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.novoda.imageloader.core.network;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlUtilTest {

    private UrlUtil urlUtil = new UrlUtil();

    @Test
    public void SHOULD_removeQueryFromUrlReturnNul_WHEN_urlIsNull() {
        assertEquals(null, urlUtil.removeQuery(null));
    }

    @Test
    public void SHOULD_removeQueryFromUrlReturnUnmodifiedUrl_WHEN_qeryNotPresent() {
        assertEquals("http://www.google.com", urlUtil.removeQuery("http://www.google.com"));
    }

    @Test
    public void SHOULD_removeQueryFromUrl() {
        assertEquals("http://www.google.com", urlUtil.removeQuery("http://www.google.com?q=test"));
    }

}

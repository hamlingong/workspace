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
package com.novoda.imageloader.core.file;

import com.novoda.imageloader.core.LoaderSettings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasicFileManagerTest extends FileTestCase {

    private BasicFileManager basicFileManager;
    private LoaderSettings settings;

    @Before
    public void beforeEachTest() {
        settings = mock(LoaderSettings.class);
        createCacheDir();
    }

    @After
    public void afterEachTest() {
        deleteCacheDir();
    }

    @Test
    public void shouldDistinguishBetweenUrlWithQueryIfIsQueryIncludedInHashIsTrue() {
        when(settings.isCleanOnSetup()).thenReturn(false);
        when(settings.getCacheDir()).thenReturn(cacheDir);
        when(settings.isQueryIncludedInHash()).thenReturn(true);

        basicFileManager = new BasicFileManager(settings);
        String filePath1 = basicFileManager.getFile("http://googl.com?param=1").getAbsolutePath();
        String filePath2 = basicFileManager.getFile("http://googl.com?param=2").getAbsolutePath();

        assertFalse(filePath2.equalsIgnoreCase(filePath1));
    }

    @Test
    public void shouldNotDistinguishBetweenUrlWithQueryIfIsQueryIncludedInHashIsFalse() {
        when(settings.isCleanOnSetup()).thenReturn(false);
        when(settings.getCacheDir()).thenReturn(cacheDir);
        when(settings.isQueryIncludedInHash()).thenReturn(false);

        basicFileManager = new BasicFileManager(settings);
        String filePath1 = basicFileManager.getFile("http://googl.com?param=1").getAbsolutePath();
        String filePath2 = basicFileManager.getFile("http://googl.com?param=2").getAbsolutePath();

        assertTrue(filePath2.equalsIgnoreCase(filePath1));
    }

}

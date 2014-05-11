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

import com.novoda.imageloader.core.util.WhatOS;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class FileTestCase {

    private static final String FOLDER_FOR_TEST_TMP_FILES = "target/unit-test/tmp";

    protected File cacheDir;

    protected void createCacheDir() {
        cacheDir = new File(FOLDER_FOR_TEST_TMP_FILES);
        cacheDir.mkdirs();
    }

    protected void deleteCacheDir() {
        try {
            FileUtils.deleteDirectory(cacheDir);
        } catch (Exception e) {
            if (WhatOS.isWindows()) {
                System.err.println("Problem deleting the cachedir : " + e.getMessage());
            } else {
                Assert.fail("Problem deleting the cachedir : " + e.getMessage());
            }
        }
    }

}

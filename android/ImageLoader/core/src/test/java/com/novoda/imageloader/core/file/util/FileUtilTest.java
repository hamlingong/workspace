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
package com.novoda.imageloader.core.file.util;

import com.novoda.imageloader.core.exception.ImageCopyException;
import com.novoda.imageloader.core.file.FileTestCase;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junitx.framework.FileAssert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FileUtilTest extends FileTestCase {

    private final FileUtil fileUtil = new FileUtil();

    @Before
    public void beforeEachTest() {
        createCacheDir();
    }

    @After
    public void afterEachTest() {
        deleteCacheDir();
    }

    @Test
    public void shouldDeleteAllFiles() {
        File f1 = createFile("1");
        File f2 = createFile("2");

        assertTrue(fileUtil.deleteFileCache(cacheDir.getAbsolutePath()));

        assertFalse(f1.exists());
        assertFalse(f2.exists());
    }

    @Test
    public void shouldReduceFiles() {
        File f1 = createFile("1", 10000);
        File f2 = createFile("2");
        File f3 = createFile("3", 105000);
        File f4 = createFile("4", System.currentTimeMillis());

        assertTrue(fileUtil.reduceFileCache(cacheDir.getAbsolutePath(), 24 * 3600 * 1000));

        assertFalse(f1.exists());
        assertTrue(f2.exists());
        assertFalse(f3.exists());
        assertTrue(f4.exists());
    }

    @Test
    public void shouldCloseNonNullCloseable() throws IOException {
        Closeable closeable = mock(Closeable.class);

        fileUtil.closeSilently(closeable);

        verify(closeable, atLeastOnce()).close();
    }

    @Test
    public void shouldCloseAvoidNullPointers() {
        fileUtil.closeSilently(null);
    }

    @Test
    public void shouldCloseFailSilently() throws IOException {
        Closeable closeable = mock(Closeable.class);
        doThrow(new IOException()).when(closeable).close();
        fileUtil.closeSilently(closeable);
    }

    @Test
    public void shouldCopyStream() throws ImageCopyException, URISyntaxException {
        URL testFile = ClassLoader.getSystemResource("testFile1");
        File from = new File(testFile.toURI());
        assertTrue(from.exists());
        File to = new File(cacheDir.getAbsolutePath() + "testFile1");

        fileUtil.copy(from, to);

        FileAssert.assertBinaryEquals(from, to);
    }

    @Test(expected = ImageCopyException.class)
    public void shouldCopyStreamFailWithImageCopyException() throws ImageCopyException {
        File from = new File("src/test/resources/testFileThatDoesNotExists");
        File to = new File(cacheDir.getAbsolutePath() + "testFile2");

        fileUtil.copy(from, to);
    }

    @Test
    public void shouldCopyStreams() throws FileNotFoundException, URISyntaxException {
        URL testFile = ClassLoader.getSystemResource("testFile1");
        File from = new File(testFile.toURI());
        assertTrue(from.exists());
        File to = new File(cacheDir.getAbsolutePath() + "testFile3");
        InputStream in = new FileInputStream(from);
        OutputStream out = new FileOutputStream(to);

        fileUtil.copyStream(in, out);

        FileAssert.assertBinaryEquals(from, to);
    }

    @Test
    public void shouldCopyStreamsFailSilently() throws IOException {
        InputStream from = mock(InputStream.class);
        when(from.read(any(byte[].class))).thenThrow(new IOException());
        File to = new File(cacheDir.getAbsolutePath() + "testFile3");
        OutputStream out = new FileOutputStream(to);

        fileUtil.copyStream(from, out);
    }

    @Test
    public void shouldPrepareCacheDirectoryOnFileSystemIfIsMounted() {
        AndroidFileContext fileContext = mock(AndroidFileContext.class);
        when(fileContext.isMounted()).thenReturn(true);
        when(fileContext.getPackageName()).thenReturn("com.something");
        when(fileContext.getExternalStorageDirectory()).thenReturn(cacheDir);

        fileUtil.prepareCacheDirectory(fileContext);

        File expected = new File(cacheDir.getAbsoluteFile() + "/Android/data/com.something/cache/images");
        assertTrue(expected.exists());
        assertTrue(expected.isDirectory());
    }

    private File createFile(String name) {
        return createFile(name, -1);
    }

    private File createFile(String name, long lastModified) {
        try {
            File f1 = new File(cacheDir, name + ".tmp");
            FileUtils.write(f1, name);
            if (lastModified != -1) {
                f1.setLastModified(lastModified);
            }
            return f1;
        } catch (Exception e) {
            Assert.fail("Can't crete file for the test" + e.getMessage());
            throw new RuntimeException("Can't crete file for the test " + e.getMessage());
        }
    }

}

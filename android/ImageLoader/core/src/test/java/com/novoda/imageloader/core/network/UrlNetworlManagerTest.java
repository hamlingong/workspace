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

import com.novoda.imageloader.core.LoaderSettings;
import com.novoda.imageloader.core.exception.ImageNotFoundException;
import com.novoda.imageloader.core.file.FileTestCase;
import com.novoda.imageloader.core.file.util.FileUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class UrlNetworlManagerTest extends FileTestCase {

    private UrlNetworkManager urlNetworkManager;
    private LoaderSettings loaderSettings;
    private HttpURLConnection httpURLConnection;
    private FileUtil fileUtil;
    private File imageFile;
    protected String lastUrl;

    @Before
    public void beforeEachTest() throws IOException {
        loaderSettings = mock(LoaderSettings.class);
        fileUtil = mock(FileUtil.class);
        when(loaderSettings.getSdkVersion()).thenReturn(8);
        httpURLConnection = mock(HttpURLConnection.class);
        urlNetworkManager = new UrlNetworkManager(loaderSettings, fileUtil) {
            @Override
            protected HttpURLConnection openConnection(String url) throws IOException, MalformedURLException {
                lastUrl = url;
                return httpURLConnection;
            }
        };
        createCacheDir();
        imageFile = new File(cacheDir.getAbsolutePath() + "/test.jpg");
        imageFile.createNewFile();
    }

    @After
    public void afterEachTest() {
        deleteCacheDir();
    }

    @Test(expected = ImageNotFoundException.class)
    public void shouldThrowFileNotFoundExecptionIfFileDoesNotExists() throws IOException {
        File imageFile = new File(cacheDir.getAbsolutePath() + "/");
        imageFile.createNewFile();
        urlNetworkManager.retrieveImage("http://king.com", imageFile);
    }

    @Test
    public void shouldExecuteCopyStream() {
        urlNetworkManager.retrieveImage("http://king.com", imageFile);
        verify(fileUtil).copyStream(any(InputStream.class), any(FileOutputStream.class));
    }

    @Test
    public void shouldAlwaysCallStreams() {
        urlNetworkManager.retrieveImage("http://king.com", imageFile);
        verify(fileUtil, atLeast(2)).closeSilently(any(Closeable.class));
    }

    @Test
    public void shouldCallDisconnectIfDefinedInSettings() {
        when(loaderSettings.getDisconnectOnEveryCall()).thenReturn(true);
        urlNetworkManager.retrieveImage("http://king.com", imageFile);
        verify(httpURLConnection).disconnect();
    }

    @Test
    public void shouldAvoidToDisconnectIfNotDefinedInSettings() {
        urlNetworkManager.retrieveImage("http://king.com", imageFile);
        verify(httpURLConnection, never()).disconnect();
    }

    @Test
    public void shouldFailGracefullyForUnknownExceptions() throws IOException {
        when(httpURLConnection.getInputStream()).thenThrow(new IOException());
        urlNetworkManager.retrieveImage("http://king.com", imageFile);
        verify(httpURLConnection, never()).disconnect();
    }

    @Test
    public void shouldSetKeepAliveSystemPropertyForApiLevelOlderThan8() {
        System.setProperty("http.keepAlive", "true");
        assertEquals("true", System.getProperty("http.keepAlive"));
        when(loaderSettings.getSdkVersion()).thenReturn(4);

        urlNetworkManager.retrieveImage("http://king.com", imageFile);
        assertEquals("false", System.getProperty("http.keepAlive"));
    }

    @Test
    public void shouldResolveRedirectAtMostThreeTimes() throws IOException {
        when(httpURLConnection.getResponseCode()).thenReturn(307);
        urlNetworkManager.retrieveImage("http://king.com", imageFile);
        verify(httpURLConnection, times(3)).getHeaderField("Location");
        verify(httpURLConnection, never()).getInputStream();
    }

    @Test
    public void shouldResolveRedirect() throws IOException {
        when(httpURLConnection.getResponseCode()).thenAnswer(new Answer<Integer>() {
            private boolean redirect = true;

            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                if (redirect) {
                    redirect = false;
                    return 307;
                }
                return 200;
            }
        });
        InputStream expected = mock(InputStream.class);
        when(httpURLConnection.getInputStream()).thenReturn(expected);
        when(httpURLConnection.getHeaderField("Location")).thenReturn("http://king2.com");

        urlNetworkManager.retrieveImage("http://king.com", imageFile);
        verify(httpURLConnection, times(1)).getHeaderField("Location");
        verify(httpURLConnection).getInputStream();
        assertEquals("http://king2.com", lastUrl);
    }

    @Test
    public void shouldRetrieveInputStream() throws IOException {
        InputStream expected = mock(InputStream.class);
        when(httpURLConnection.getInputStream()).thenReturn(expected);
        InputStream actual = urlNetworkManager.retrieveInputStream("http://king.com");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRetrieveNullInputStreamForUnknownExceptions() throws IOException {
        when(httpURLConnection.getInputStream()).thenThrow(new IOException());
        InputStream actual = urlNetworkManager.retrieveInputStream("http://king.com");
        assertNull(actual);
    }

    @Test(expected = ImageNotFoundException.class)
    public void shouldThrowImageNotFoundExceptionForFileNotFoundException() throws IOException {
        when(httpURLConnection.getInputStream()).thenThrow(new FileNotFoundException());
        urlNetworkManager.retrieveInputStream("http://king.com");
    }

}

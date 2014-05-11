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
package com.novoda.imageloader.core.util;

import android.graphics.Bitmap;

import com.novoda.imageloader.core.bitmap.BitmapUtil;
import com.novoda.imageloader.core.network.NetworkManager;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Bitmap.class})
public class DirectLoaderTest {

    private DirectLoader directLoader;
    private NetworkManager networkManager;
    private BitmapUtil bitmapUtil;
    private String url = "http://www.google.com";

    @Before
    public void beforeEachTest() {
        networkManager = Mockito.mock(NetworkManager.class);
        bitmapUtil = Mockito.mock(BitmapUtil.class);
        directLoader = new DirectLoader(networkManager, bitmapUtil);
    }

    @Test
    public void shouldReturnNullIfUrlIsNull() {
        assertNull(directLoader.download(null));
    }

    @Test
    public void shouldReturnNullIfUrlIsEmpty() {
        assertNull(directLoader.download(""));
    }

    @Test
    public void shouldReturnNullIfIsNotPossibleToGetAnInputStreamFromNetwrokResource() {
        Mockito.when(networkManager.retrieveInputStream(url)).thenReturn(null);
        assertNull(directLoader.download(url));
    }

    @Test
    public void shouldReturnBitmapFromHttpResource() {
        InputStream is = Mockito.mock(InputStream.class);
        Mockito.when(networkManager.retrieveInputStream(url)).thenReturn(is);
        Bitmap expectedBitmap = PowerMockito.mock(Bitmap.class);
        PowerMockito.when(bitmapUtil.decodeInputStream(is)).thenReturn(expectedBitmap);
        Bitmap actualBitmap = directLoader.download(url);
        assertEquals(expectedBitmap, actualBitmap);
    }

}

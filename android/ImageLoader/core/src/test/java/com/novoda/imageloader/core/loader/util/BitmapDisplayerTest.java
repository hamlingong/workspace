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
package com.novoda.imageloader.core.loader.util;

import android.graphics.Bitmap;

import com.novoda.imageloader.core.model.ImageWrapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Bitmap.class})
public class BitmapDisplayerTest {

    private BitmapDisplayer bitmapDisplayer;
    private Bitmap bitmap;
    private ImageWrapper imageWrapper;

    @Before
    public void beforeEachTest() {
        bitmap = PowerMockito.mock(Bitmap.class);
        imageWrapper = mock(ImageWrapper.class);
    }

    @Test
    public void shouldNotSetNullBitmap() {
        bitmapDisplayer = new BitmapDisplayer(null, imageWrapper);
        bitmapDisplayer.run();

        verify(imageWrapper, never()).setBitmap(null, false);
    }

    @Test
    public void shouldNotSetBitmapIfTheUrlHasChanged() {
        when(imageWrapper.isUrlChanged()).thenReturn(true);
        bitmapDisplayer = new BitmapDisplayer(bitmap, imageWrapper);
        bitmapDisplayer.run();

        verify(imageWrapper, never()).setBitmap(null, false);
    }

    @Test
    public void shouldSetBitmap() {
        when(imageWrapper.isUrlChanged()).thenReturn(false);
        bitmapDisplayer = new BitmapDisplayer(bitmap, imageWrapper);
        bitmapDisplayer.run();

        verify(imageWrapper).setBitmap(bitmap, false);
    }

}

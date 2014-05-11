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
package com.novoda.imageloader.core.model;

import android.widget.ImageView;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImageWrapperTest {

    private ImageWrapper imageWrapper;
    private ImageView imageView;
    private ImageTag imageTag;

    @Before
    public void beforeEachTest() {
        imageView = mock(ImageView.class);
        imageTag = mock(ImageTag.class);

    }

    @Test
    public void shouldNotFailIfImageTagIsNull() {
        imageWrapper = new ImageWrapper(imageView);
    }

    @Test
    public void shouldSetLoadingResourceId() {
        when(imageTag.getLoadingResourceId()).thenReturn(1);
        when(imageView.getTag()).thenReturn(imageTag);

        imageWrapper = new ImageWrapper(imageView);
        assertEquals(1, imageWrapper.getLoadingResourceId());
    }

    @Test
    public void shouldSetNotFoundResourceIdIfDefined() {
        when(imageTag.getNotFoundResourceId()).thenReturn(2);
        when(imageView.getTag()).thenReturn(imageTag);

        imageWrapper = new ImageWrapper(imageView);
        assertEquals(2, imageWrapper.getNotFoundResourceId());
    }

    @Test
    public void shouldReturnTrueIfCurrentUrlHasChanged() {
        when(imageTag.getUrl()).thenReturn("url1");
        when(imageView.getTag()).thenReturn(imageTag);

        imageWrapper = new ImageWrapper(imageView);
        when(imageTag.getUrl()).thenReturn("url2");

        assertTrue(imageWrapper.isUrlChanged());
    }

    @Test
    public void shouldReturnFalseIfCurrentUrlHasNotChanged() {
        when(imageTag.getUrl()).thenReturn("url1");
        when(imageView.getTag()).thenReturn(imageTag);

        imageWrapper = new ImageWrapper(imageView);
        when(imageTag.getUrl()).thenReturn("url1");

        assertFalse(imageWrapper.isUrlChanged());
    }

    @Test
    public void shouldHandleNullPointerException() {
        imageTag = new ImageTag(null, 0, 0, 0, 0);
        when(imageView.getTag()).thenReturn(imageTag);
        imageWrapper = new ImageWrapper(imageView);

        assertNotNull(imageWrapper.getCurrentUrl());
    }

}

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

import android.view.Display;

import com.novoda.imageloader.core.util.AnimationHelper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImageTagFactoryTest {

    private ImageTagFactory imageTagFactory;
    private int height = 12;
    private int width = 9;
    private int defaultResourceId = 1;
    private String url = "google.com";

    private final AnimationHelper animationHelper = mock(AnimationHelper.class);

    @Before
    public void beforeEachTest() {
        imageTagFactory = ImageTagFactory.getInstance(9, 12, 1);
    }

    @Test
    public void shouldSetNormalPropertiesOnTheImageTag() {
        ImageTag imageTag = buildTag();

        assertEquals(defaultResourceId, imageTag.getLoadingResourceId());
        assertEquals(defaultResourceId, imageTag.getNotFoundResourceId());
        assertEquals(height, imageTag.getHeight());
        assertEquals(width, imageTag.getWidth());
        assertEquals(url, imageTag.getUrl());
    }

    @Test
    public void shouldSetPreviewProperties() {
        int previewHeight = 1;
        int previewWidth = 2;
        imageTagFactory.usePreviewImage(previewWidth, previewHeight, true);
        ImageTag imageTag = buildTag();

        assertEquals(previewHeight, imageTag.getPreviewHeight());
        assertEquals(previewWidth, imageTag.getPreviewWidth());
    }

    @Test
    public void shouldUseTheSameUrlForPreview() {
        imageTagFactory.usePreviewImage(1, 1, true);
        ImageTag imageTag = buildTag();

        assertEquals(url, imageTag.getPreviewUrl());
    }

    @Test
    public void shouldNotUseTheSameUrlForPreview() {
        imageTagFactory.usePreviewImage(1, 1, false);
        ImageTag imageTag = buildTag();

        assertNull(imageTag.getPreviewUrl());
    }

    @Test
    public void shouldUseDisplaySizes() {
        //TODO: Test failing when targeting API 17 because of the final Display class
        final Display display = mock(Display.class);
        when(display.getHeight()).thenReturn(21);
        when(display.getWidth()).thenReturn(12);
        imageTagFactory = ImageTagFactory.getInstance(display.getWidth(), display.getHeight(), 1);
        ImageTag imageTag = buildTag();

        assertEquals(21, imageTag.getHeight());
        assertEquals(12, imageTag.getWidth());
    }

    @Test(expected = RuntimeException.class)
    public void shouldComplainAboutUnsetParameters() {
        imageTagFactory = ImageTagFactory.getInstance();
        buildTag();
    }

    private ImageTag buildTag() {
        return imageTagFactory.build(url, animationHelper);
    }

}

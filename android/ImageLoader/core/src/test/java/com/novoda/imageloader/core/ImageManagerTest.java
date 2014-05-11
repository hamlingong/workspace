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
package com.novoda.imageloader.core;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import com.novoda.imageloader.core.bitmap.BitmapUtil;
import com.novoda.imageloader.core.cache.CacheManager;
import com.novoda.imageloader.core.file.FileManager;
import com.novoda.imageloader.core.loader.ConcurrentLoader;
import com.novoda.imageloader.core.network.NetworkManager;

import java.io.File;
import java.lang.ref.WeakReference;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

public class ImageManagerTest {
    private LoaderSettings loaderSettings;
    private Context context;
    private ImageManager imageManager;

    @Before
    public void beforeEveryTest() {
        loaderSettings = mock(LoaderSettings.class);
        when(loaderSettings.isCleanOnSetup()).thenReturn(false);
        when(loaderSettings.getLoader()).thenReturn(new ConcurrentLoader(loaderSettings));
        context = mock(Context.class);
    }

    @Test(expected = RuntimeException.class)
    public void shouldComplainIfInternetPermissionIsNotSet() {
        disableManifestPermission(Manifest.permission.INTERNET);

        new ImageManager(context, loaderSettings);
    }

    @Test(expected = RuntimeException.class)
    public void shouldComplainIfWriteExternalStoragePermissionIsNotSet() {
        disableManifestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        new ImageManager(context, loaderSettings);
    }

    @Test
    public void shouldRegisterOnImageLoadedListener() {
        OnImageLoadedListener listener = mock(OnImageLoadedListener.class);
        imageManager = new ImageManager(loaderSettings);
        imageManager.setOnImageLoadedListener(listener);

        WeakReference listenerReference = new WeakReference<OnImageLoadedListener>(listener);

        System.gc();
        assertNotNull(listenerReference.get());
    }

    @Test
    public void shouldUnregisterOnImageLoadedListener() {
        setUpImageManager();
        OnImageLoadedListener listener = mock(OnImageLoadedListener.class);
        imageManager.setOnImageLoadedListener(listener);

        WeakReference listenerReference = new WeakReference<OnImageLoadedListener>(listener);
        listener = null;

        assertNotNull(listenerReference.get());
        System.gc();
        assertNull(listenerReference.get());
    }

    private void setUpImageManager() {
        setValidImageManagerPermissions();
        imageManager = new ImageManager(context, loaderSettings);
    }

    private void setValidImageManagerPermissions() {
        PackageManager pm = mock(PackageManager.class);
        when(pm.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, null)).thenReturn(PackageManager.PERMISSION_GRANTED);
        when(pm.checkPermission(Manifest.permission.INTERNET, null)).thenReturn(PackageManager.PERMISSION_GRANTED);
        when(context.getPackageManager()).thenReturn(pm);
    }

    private void disableManifestPermission(String permission) {
        PackageManager pm = mock(PackageManager.class);
        when(pm.checkPermission(permission, null)).thenReturn(
                PackageManager.PERMISSION_DENIED);
        when(context.getPackageManager()).thenReturn(pm);
    }
}

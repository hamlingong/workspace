package com.novoda.imageloader.core.loader.util;

import android.content.Context;
import android.widget.ImageView;

import com.novoda.imageloader.core.LoaderSettings;
import com.novoda.imageloader.core.bitmap.BitmapUtil;
import com.novoda.imageloader.core.cache.CacheManager;
import com.novoda.imageloader.core.file.FileManager;
import com.novoda.imageloader.core.model.ImageTag;
import com.novoda.imageloader.core.network.NetworkManager;

import java.io.File;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BitmapRetrieverTest {
    static final String IMAGE_URL = "http://blog.novoda.com/blog/_themes/master/assets/images/logo-desktop.png";
    static final int WIDTH = 100;
    static final int HEIGHT = 100;

    final File fileCachedImage = mock(File.class);
    final CacheManager cacheManager = mock(CacheManager.class);

    @Test
    public void testWhenBitmapRetrievalFails_ReferenceToCachedImageIsRemoved() {
        BitmapRetriever retriever = getRetrieverForCachedImageFileThatFailsRetrieval();

        retriever.getBitmap();

        verify(cacheManager, atLeastOnce()).remove(IMAGE_URL);
    }

    @Test
    public void testWhenBitmapRetrievalFails_ImageFileContainerIsDeleted() {
        BitmapRetriever retriever = getRetrieverForCachedImageFileThatFailsRetrieval();

        retriever.getBitmap();

        verify(fileCachedImage, atLeastOnce()).delete();
    }

    private BitmapRetriever getRetrieverForCachedImageFileThatFailsRetrieval() {
        final FileManager fileManager = mock(FileManager.class);
        final BitmapUtil bitmapUtil = mock(BitmapUtil.class);
        final NetworkManager networkManager = mock(NetworkManager.class);

        when(fileCachedImage.exists()).thenReturn(true);
        when(fileManager.getFile(IMAGE_URL, WIDTH, HEIGHT)).thenReturn(fileCachedImage);
        when(bitmapUtil.decodeFile(fileCachedImage, WIDTH, HEIGHT)).thenReturn(null);

        LoaderSettings loaderSettings = new LoaderSettings() {
            public BitmapUtil getBitmapUtil() {
                return bitmapUtil;
            }
        };
        loaderSettings.setNetworkManager(networkManager);
        loaderSettings.setFileManager(fileManager);
        loaderSettings.setCacheManager(cacheManager);

        ImageTag imageTag = new ImageTag(IMAGE_URL, 0, 0, WIDTH, HEIGHT);
        ImageView imageView = createImageView(imageTag);

        return new BitmapRetriever(IMAGE_URL, fileCachedImage, WIDTH, HEIGHT, 0, false, true, imageView, loaderSettings, mock(Context.class));
    }

    private ImageView createImageView(ImageTag tag) {
        ImageView imageView = mock(ImageView.class);
        when(imageView.getTag()).thenReturn(tag);
        return imageView;
    }
}

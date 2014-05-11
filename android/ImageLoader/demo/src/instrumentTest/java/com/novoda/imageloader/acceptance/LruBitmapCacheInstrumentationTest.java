package com.novoda.imageloader.acceptance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.test.InstrumentationTestCase;

import com.novoda.imageloader.core.cache.LruBitmapCache;

public class LruBitmapCacheInstrumentationTest extends InstrumentationTestCase {

    private static final String KEY = "key";

    private LruBitmapCache cache;

    public LruBitmapCacheInstrumentationTest(String name) {
        super();
        setName(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        cache = new LruBitmapCache(getInstrumentation().getContext());
    }

    public void testPutValue() {
        Bitmap bitmap = createBitmap();
        cache.put(KEY, bitmap);
        assertEquals(bitmap, cache.get(KEY, bitmap.getWidth(), bitmap.getHeight()));
    }

    public void testRemoveValue() {
        cache.put(KEY, createBitmap());
        cache.remove(KEY);
        assertNull(cache.get(KEY, 100, 100));
    }

    private Bitmap createBitmap() {
        return BitmapFactory.decodeResource(getInstrumentation().getContext().getResources(), android.R.drawable.ic_delete);
    }

}

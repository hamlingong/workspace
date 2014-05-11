package com.novoda.imageloader.core.cache;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LruBitmapCacheTest {

    @Test
    public void verifyCalculateCacheSizeDoesNotIntOverflow() {
        LruBitmapCache cache = new LruBitmapCacheTestOverride();

        long undividedResult = 200L * 25L * 1024L * 1024L;
        assertTrue(undividedResult > Integer.MAX_VALUE);

        long dividedResult = undividedResult / 100L;
        assertTrue(dividedResult < Integer.MAX_VALUE);

        long calculatedResult = cache.calculateCacheSize(200, 25);
        assertEquals(dividedResult, calculatedResult);
    }

    private class LruBitmapCacheTestOverride extends LruBitmapCache {

    }
}

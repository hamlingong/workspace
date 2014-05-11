package com.novoda.imageloader.acceptance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.test.InstrumentationTestCase;

import com.novoda.imageloader.core.bitmap.BitmapUtil;

public class BitmapUtilsInstrumentationTest extends InstrumentationTestCase {

    private final int scaledBitmapSize = 200;
    private final boolean allowUpSampling = true;

    public BitmapUtilsInstrumentationTest(String name) {
        super();
        setName(name);
    }

    public void test_bitmaputil_scales_bitmaps_to_specified_size() {
        Bitmap bmOriginal = BitmapFactory.decodeResource(getInstrumentation().getContext().getResources(), R.drawable.icon);
        assertFalse(bmOriginal.getHeight() == scaledBitmapSize);
        assertFalse(bmOriginal.getWidth() == scaledBitmapSize);

        Bitmap bm = new BitmapUtil().scaleBitmap(bmOriginal, scaledBitmapSize, scaledBitmapSize, allowUpSampling);

        assertEquals(scaledBitmapSize, bm.getHeight());
        assertEquals(scaledBitmapSize, bm.getWidth());
    }

    public void test_bitmaputil_creates_bitmaps__of_a_specified_size() {
        Bitmap bm = new BitmapUtil().decodeResourceBitmapAndScale(getInstrumentation().getContext(),
                scaledBitmapSize, scaledBitmapSize, R.drawable.icon, allowUpSampling);

        assertTrue(bm.getHeight() == scaledBitmapSize);
        assertTrue(bm.getWidth() == scaledBitmapSize);
    }

}

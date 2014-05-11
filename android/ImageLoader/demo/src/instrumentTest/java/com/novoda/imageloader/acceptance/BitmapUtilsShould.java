package com.novoda.imageloader.acceptance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.test.InstrumentationTestCase;

import com.novoda.imageloader.core.bitmap.BitmapUtil;

public class BitmapUtilsShould extends InstrumentationTestCase {

    private static final boolean UPSAMPLING_ENABLED = true;
    private static final boolean UPSAMPLING_DISABLED = false;

    private final int biggerScaledBitmapSize = 400;
    private final int smallerScaledBitmapSize = 10;

    public BitmapUtilsShould(String name) {
        super();
        setName(name);
    }

    public void test_scale_existing_bitmaps_to_specified_size() {
        Bitmap bmOriginal = BitmapFactory.decodeResource(getInstrumentation().getContext().getResources(), R.drawable.icon);
        assertFalse(bmOriginal.getHeight() == biggerScaledBitmapSize);
        assertFalse(bmOriginal.getWidth() == biggerScaledBitmapSize);

        Bitmap bm = new BitmapUtil().scaleBitmap(bmOriginal, biggerScaledBitmapSize, biggerScaledBitmapSize, UPSAMPLING_ENABLED);

        assertEquals(biggerScaledBitmapSize, bm.getHeight());
        assertEquals(biggerScaledBitmapSize, bm.getWidth());
    }

    public void test_create_bitmaps_of_a_specified_size() {
        Bitmap bm = new BitmapUtil().decodeResourceBitmapAndScale(getInstrumentation().getContext(),
                biggerScaledBitmapSize, biggerScaledBitmapSize, R.drawable.icon, UPSAMPLING_ENABLED);

        assertTrue(bm.getHeight() == biggerScaledBitmapSize);
        assertTrue(bm.getWidth() == biggerScaledBitmapSize);
    }

    public void test_keep_original_bitmap_when_scaling_to_a_bigger_size_when_upscaling_is_set_to_false() {
        Bitmap bm = new BitmapUtil().decodeResourceBitmapAndScale(getInstrumentation().getContext(),
                biggerScaledBitmapSize, biggerScaledBitmapSize, R.drawable.icon, UPSAMPLING_DISABLED);

        assertFalse(bm.getHeight() == biggerScaledBitmapSize);
        assertFalse(bm.getWidth() == biggerScaledBitmapSize);
    }

    public void test_scale_bitmap_when_scaling_to_a_smaller_size_when_upscaling_is_set_to_false() {
        Bitmap bm = new BitmapUtil().decodeResourceBitmapAndScale(getInstrumentation().getContext(),
                smallerScaledBitmapSize, smallerScaledBitmapSize, R.drawable.icon, UPSAMPLING_DISABLED);

        assertTrue(bm.getHeight() == smallerScaledBitmapSize);
        assertTrue(bm.getWidth() == smallerScaledBitmapSize);
    }

}


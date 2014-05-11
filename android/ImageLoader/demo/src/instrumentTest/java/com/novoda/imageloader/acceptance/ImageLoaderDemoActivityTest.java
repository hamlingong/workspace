package com.novoda.imageloader.acceptance;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.AbsListView;

import com.jayway.android.robotium.solo.Solo;
import com.novoda.imageloader.demo.R;
import com.novoda.imageloader.demo.activity.ImageLongList;

public class ImageLoaderDemoActivityTest extends ActivityInstrumentationTestCase2<ImageLongList> {
    private Solo solo;

    public ImageLoaderDemoActivityTest() {
        super("com.novoda.imageloader.demo", ImageLongList.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testOpenTheActivity() {
        assertNotNull(solo);
    }

    public void testScrollingDownTheEntireList() {
        AbsListView list = (AbsListView) solo.getView(R.id.list_view);
        solo.scrollListToTop(list);

        boolean scrollMore = true;
        while (scrollMore) {
            scrollMore = solo.scrollDownList(list);
        }

        assertEquals(list.getLastVisiblePosition(), list.getAdapter().getCount() - 1);
    }
}


package com.kzl.lib.http.sample;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

/**
 * Project:LuLuModuleLibs<br/>
 * Module:<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/23<br/>
 * Time: 11:27<br/>
 * To change this template use File | Settings | File Templates.
 */
public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {
    MyActivity activity;
    Instrumentation instrumentation;
    View view;
    public MyActivityTest() {
        super(MyActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        System.out.println("setUp");
        instrumentation = getInstrumentation();
        activity = getActivity();
        view = activity.findViewById(R.id.container);
    }

    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    public void testOnCreate() throws Exception {
        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                view.performClick();
            }
        });
    }
}

package com.hamlin.myandroid.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.hamlin.myandroid.R;
public class FragmentActivity extends Activity {
    private final String TAG = "MyAndroid_FragmentActivity";

    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        setContentView(R.layout.fragment_activity);

        /*
         * 动态加载Fragment
         */
//        Display display = getWindowManager().getDefaultDisplay();
//        if (display.getWidth() > display.getHeight()) {
//            LeftFragment leftFragment = new LeftFragment();
//            getFragmentManager().beginTransaction().replace(R.id.main_layout, leftFragment).commit();
//        } else {
//            RightFragment rightFragment = new RightFragment();
//            getFragmentManager().beginTransaction().replace(R.id.main_layout, rightFragment).commit();
//        }
    }
}

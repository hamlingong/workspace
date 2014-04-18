package com.hamlin.myandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
    private final String TAG = "MyAndroid_MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

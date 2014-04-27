package com.kzl.lib.http.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.kzl.lib.http.sample.http.impl.LoginTaskGet;
import com.kzl.lib.http.sample.http.impl.LoginTaskPost;
import com.kzl.lib.http.sample.http.impl.SyncRequestTask;
import com.kzl.lib.utils.MD5Util;
import com.kzl.lib.utils.ThreadPoolUtil;

/**
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginTaskGet(MyActivity.this).send("may123", MD5Util.getMD5Str("may123"));
                new LoginTaskPost(MyActivity.this).send("may123", MD5Util.getMD5Str("may123"));
                ThreadPoolUtil.getThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        SyncRequestTask.loginGetTask("may123", MD5Util.getMD5Str("may123"));
                        SyncRequestTask.loginPostTask("may123", MD5Util.getMD5Str("may123"));
                    }
                });
            }
        });
    }
}

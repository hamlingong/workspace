package com.kzl.lib.http.sample;

import android.app.Application;
import com.kzl.lib.utils.CrashHandler;
import com.kzl.lib.utils.ToastUtil;

/**
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class APP extends Application {
    private static APP APP;

    public static APP getInstance() {
        return APP;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        APP = (com.kzl.lib.http.sample.APP) getApplicationContext();
        ToastUtil.init(APP);

        // 异常捕获处理
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }

}


package com.kzl.lib.utils;

import android.util.Log;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class LogUtil {
    private static final String TAG = "myLog";
    public static final boolean isDebug = true;
    public static final String NULL = "NULL";

    public static void trace(Exception e) {
        if (!isDebug)
            return;
        final String msg = e.getMessage();
        Log.e(TAG, msg == null ? NULL : msg);
    }

    public static void trace(String msg) {
        if (!isDebug)
            return;
        Log.d(TAG, msg == null ? NULL : msg);
    }


    public static void trace(String tag, String msg) {
        if (!isDebug)
            return;
        Log.d(TAG + tag, msg);
    }

    public static void trace(String tag, Exception e) {
        if (!isDebug)
            return;
        final String msg = e.getMessage();
        Log.e(TAG + tag, msg == null ? NULL : msg);
    }
}

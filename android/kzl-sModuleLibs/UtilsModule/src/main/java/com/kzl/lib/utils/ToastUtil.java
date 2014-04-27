package com.kzl.lib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ToastUtil {
    private final static Handler HANDLER = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            synchronized (synObj) {
                toast.setText((String) msg.obj);
                toast.setDuration(msg.arg1);
                toast.show();
            }
        }
    };
    private static Toast toast;
    private static Context context;
    private static Object synObj = new Object();

    @SuppressLint("ShowToast")
    public static void init(Context context) {
        ToastUtil.context = context;
        toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    public static void showMessage(final String msg) {
        showMessage(msg, Toast.LENGTH_SHORT);
    }

    public static void showMessage(final int resId) {
        showMessage(resId, Toast.LENGTH_SHORT);
    }

    public static void showMessage(final String msg, final int len) {
        if (StringUtils.isEmpty(msg))
            return;
        final Message message = HANDLER.obtainMessage();
        message.arg1 = len;
        message.obj = msg;
        HANDLER.sendMessage(message);
    }

    public static void showMessage(final int resId, final int len) {
        final Message message = HANDLER.obtainMessage();
        message.arg1 = len;
        message.obj = context.getString(resId);
        HANDLER.sendMessage(message);
    }

}

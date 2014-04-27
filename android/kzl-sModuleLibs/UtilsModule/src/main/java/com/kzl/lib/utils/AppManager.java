package com.kzl.lib.utils;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * 应用程序Activity管理类:用于Activity管理和应用程序退出<br/>
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AppManager {
    private static final ArrayList<WeakReference<Activity>> ACTIVITY_STACK = new ArrayList<WeakReference<Activity>>();

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(Activity activity) {
        ACTIVITY_STACK.add(new WeakReference<Activity>(activity));
    }

    /**
     * 结束所有Activity
     */
    private static void finishAllActivity() {
        for (int i = 0, size = ACTIVITY_STACK.size(); i < size; i++) {
            if (null != ACTIVITY_STACK.get(i)) {
                final WeakReference<Activity> weakReference = ACTIVITY_STACK.get(i);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().finish();
                }
            }
        }
        ACTIVITY_STACK.clear();
    }

    /**
     * 退出应用程序
     */
    public static void appExit() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

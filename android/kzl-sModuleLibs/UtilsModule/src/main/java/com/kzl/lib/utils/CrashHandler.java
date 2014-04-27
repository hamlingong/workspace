package com.kzl.lib.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";
    public String path = "/CrashHandler";
    public String fileName = "my_exception.txt";
    private static CrashHandler INSTANCE = new CrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context ctx) {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        }
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return true;
        }
        File fileDir = new File(Environment.getExternalStorageDirectory() + path);
        LogUtil.trace("===============================" + fileDir.getAbsolutePath());
        if (!fileDir.exists())
            fileDir.mkdirs();
        File exceptionFile = new File(fileDir, fileName);
        if (!exceptionFile.exists()) {
            try {
                exceptionFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream foos = new FileOutputStream(exceptionFile, true);
            StringBuffer sb = new StringBuffer();
            sb.append("\r\n报错日期:");
            sb.append(new Date(System.currentTimeMillis()).toLocaleString()
                    + "\r\n");
            printStackTrace(sb, ex);// or sb.append(ex.getMessage());
            foos.write(sb.toString().getBytes());
            foos.flush();
            foos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void printStackTrace(StringBuffer sb, Throwable ex) {
        if (sb == null)
            sb = new StringBuffer();
        StackTraceElement[] trace = ex.getStackTrace();
        synchronized (sb) {
            sb.append(ex.toString() + "\r\n");
            for (int i = 0; i < trace.length; i++) {
                sb.append(" at " + trace[i] + "\r\n");
            }
            Throwable ourCause = ex.getCause();
            if (ourCause != null)
                printStackTraceAsCause(sb, ourCause, trace);
        }
    }

    private void printStackTraceAsCause(StringBuffer sb, Throwable ex,
                                        StackTraceElement[] causedTrace) {
        // assert Thread.holdsLock(s);
        // Compute number of frames in common between this and caused
        if (sb == null)
            sb = new StringBuffer();
        StackTraceElement[] trace = ex.getStackTrace();
        int m = trace.length - 1, n = causedTrace.length - 1;
        while (m >= 0 && n >= 0 && trace[m].equals(causedTrace[n])) {
            m--;
            n--;
        }
        int framesInCommon = trace.length - 1 - m;
        sb.append("Caused by: ");
        sb.append(ex + "\r\n");
        for (int i = 0; i <= m; i++) {
            sb.append(" at " + trace[i] + "\r\n");
        }
        if (framesInCommon != 0) {
            sb.append(" ..." + framesInCommon + " more \r\n");
        }

        // Recurse if we have a cause
        Throwable ourCause = ex.getCause();
        if (ourCause != null)
            printStackTraceAsCause(sb, ourCause, trace);
    }
}

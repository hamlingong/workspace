package com.kzl.lib.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPoolUtil {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static Executor threadPool;

    public static Executor getThreadPool() {
        if (threadPool == null) {
//            threadPool = Executors.newCachedThreadPool();
            threadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        }
        return threadPool;
    }
}

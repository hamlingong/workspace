package com.kzl.lib.http.task.interfaces.sync;

import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.task.interfaces.GPConstantValues;
import com.kzl.lib.utils.LogUtil;

/**
 * http同步请求的执行器抽象类<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleProjectInterfaces<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public abstract class SyncHttpExecutor {
    private final static String LOG_TAG = GPConstantValues.LOG_TAG;

    /**
     * http同步请求执行入口
     * @param <T>
     * @return
     */
    public abstract <T extends EmptyHttpResponse> T execute();

    /**
     * http同步请求执行前的准备
     * @param url
     * @param request
     * @param <T>
     * @return
     */
    public <T extends EmptyHttpResponse> T filter(String url, EmptyHttpRequest request) {
        LogUtil.trace(LOG_TAG, "json-request sync:" + url);
        LogUtil.trace(LOG_TAG, "request-actionCode:" + request.getActionCode());

        final long start = System.currentTimeMillis();

        T response = execute();

        LogUtil.trace(LOG_TAG + "  start-end ==" + (System.currentTimeMillis() - start));
        return response;
    }
}

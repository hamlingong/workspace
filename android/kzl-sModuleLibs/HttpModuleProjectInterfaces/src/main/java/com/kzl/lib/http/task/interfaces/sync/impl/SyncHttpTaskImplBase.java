package com.kzl.lib.http.task.interfaces.sync.impl;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.SyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.kzl.lib.http.task.interfaces.sync.SyncHttpTask;
import com.kzl.lib.http.task.interfaces.sync.SyncHttpExecutor;
import com.kzl.lib.utils.LogUtil;
/**
 * 同步请求实现的基类，子类可以直接继承传递实现，也可以很方便的以组合方式使用<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleProjectInterfaces<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class SyncHttpTaskImplBase<T extends EmptyHttpResponse> implements SyncHttpTask<T> {
    private SyncHttpClient syncHttpClient;
    private Context context;

    public SyncHttpTaskImplBase(Context context, SyncHttpClient syncHttpClient) {
        this.syncHttpClient = syncHttpClient;
        this.context = context;
    }

    @Override
    public T execute(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final HttpResponseFilter filter) {
        LogUtil.trace(LOG_TAG, "SyncHttpTaskImplBase");
        return new SyncHttpExecutor() {
            @Override
            public T execute() {
                return (T) syncHttpClient.execute(context, url, request, HttpCommonUtil.getResponseClassType(mapper, request.getActionCode()), filter);
            }
        }.filter(url, request);
    }
}

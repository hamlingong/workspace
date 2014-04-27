package com.kzl.lib.http.task.interfaces.async.impl;

import android.content.Context;
import com.kzl.lib.http.client.interfaces.AsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.AsyncHttpFlowHandler;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.kzl.lib.http.task.interfaces.GPConstantValues;
import com.kzl.lib.http.task.interfaces.async.AsyncHttpExecutor;
import com.kzl.lib.http.task.interfaces.async.AsyncHttpTaskExcutor;
import com.kzl.lib.utils.LogUtil;
import com.kzl.lib.utils.Utils;

/**
 * 异步请求实现的基类
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleProjectInterfaces<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AsyncHttpTaskExcutorImpl<T extends EmptyHttpResponse> implements AsyncHttpTaskExcutor {
    private final static String LOG_TAG = GPConstantValues.LOG_TAG;
    protected Context context;
    private AsyncHttpClient asyncHttpClient;
    private AsyncHttpFlowHandler<T> asyncHttpFlowHandler;
    private long start;

    public AsyncHttpTaskExcutorImpl(Context context, AsyncHttpClient asyncHttpClient, AsyncHttpFlowHandler<T> asyncHttpFlowHandler) {
        this.context = context;
        this.asyncHttpClient = asyncHttpClient;
        this.asyncHttpFlowHandler = asyncHttpFlowHandler;
    }

    /**
     * 响应的handler，处理http请求响应的结果
     */
    public final HttpResponseHandler<T> handler = new HttpResponseHandler<T>() {

        @Override
        public void onFinish(T response) {
            long end = System.currentTimeMillis();
            LogUtil.trace(LOG_TAG + "  start-end ==" + (end - start));
            if (response == null) {
                asyncHttpFlowHandler.onNoData();
            } else {
                asyncHttpFlowHandler.onSuccess(response);
            }
            asyncHttpFlowHandler.onFinish();
        }
    };

    /**
     * http异步请求执行前的准备
     *
     * @param url
     * @param request
     * @param executor
     */
    private void filter(final String url, final EmptyHttpRequest request, final AsyncHttpExecutor executor) {
        LogUtil.trace(LOG_TAG, "json-request async:" + url);
        LogUtil.trace(LOG_TAG, "request-actionCode:" + request.getActionCode());
        if (!Utils.isNetWorkAvailable(context)) {
            asyncHttpFlowHandler.onNoNet();
            return;
        }
        asyncHttpFlowHandler.onStart();
        start = System.currentTimeMillis();
        executor.execute();
    }

    @Override
    public void execute(final Context context, final String url, final EmptyHttpRequest request, final HttpResponseMapper mapper, final HttpResponseFilter filter) {
        filter(url, request, new AsyncHttpExecutor() {
            @Override
            public void execute() {
                asyncHttpClient.execute(context, url, request, HttpCommonUtil.getResponseClassType(mapper, request.getActionCode()), handler, filter);
            }
        });
    }
}

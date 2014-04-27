package com.kzl.lib.http.sample.http.base.async.impl;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.AsyncHttpClient;
import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.sample.http.base.HttpCommonUtils;
import com.kzl.lib.http.sample.http.base.AsyncHttpFlowResponseSuccessHandler;
import com.kzl.lib.http.sample.http.base.HttpResponseFilterImpl;
import com.kzl.lib.http.sample.http.base.async.AsyncHttpTask;
import com.kzl.lib.http.sample.http.base.async.AsyncHttpFlowFlowHandlerImpl;
import com.kzl.lib.http.task.interfaces.BaseHttpRequest;
import com.kzl.lib.http.task.interfaces.BaseHttpResponse;
import com.kzl.lib.http.task.interfaces.async.AsyncHttpTaskExcutor;
import com.kzl.lib.http.task.interfaces.async.impl.AsyncHttpTaskExcutorImpl;

/**
 * http 异步访问的基类,get、post等具体实现，都可以继承本类<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AsyncHttpTaskImplBase<T extends BaseHttpResponse> extends AsyncHttpFlowFlowHandlerImpl<T> implements AsyncHttpTask, AsyncHttpFlowResponseSuccessHandler<T> {
    private Context context;
    private AsyncHttpTaskExcutor asyncHttpTaskExcutor;

    public AsyncHttpTaskImplBase(Context context, AsyncHttpClient asyncHttpClient) {
        this.context = context;
        asyncHttpTaskExcutor = new AsyncHttpTaskExcutorImpl<T>(context, asyncHttpClient, this);
    }

    @Override
    public void execute(final BaseHttpRequest request) {
        asyncHttpTaskExcutor.execute(context, HttpCommonUtils.getRequestUrl(request), request, GpConstantsActionCode.getInstance(), HttpResponseFilterImpl.getInstance());
    }
}

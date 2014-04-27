package com.kzl.lib.http.client.impl.async;

import android.content.Context;

import com.kzl.lib.http.client.callback.HttpExecute;
import com.kzl.lib.http.client.interfaces.AsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.AsyncHttpUtil;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * 通过AsyncTask实现的get异步请求
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplTrinea<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AsyncHttpClientImplGet<T extends EmptyHttpResponse> implements AsyncHttpClient<T> {
    @Override
    public void execute(Context context, final String requestUrl, EmptyHttpRequest request, Class<T> classOfT, HttpResponseHandler<T> handler, HttpResponseFilter filter) {
        AsyncHttpUtil.execute(classOfT, handler, new HttpExecute() {
            @Override
            public HttpResponse execute() {
                return HttpUtils.httpGet(requestUrl);
            }
        }, filter);
    }

}

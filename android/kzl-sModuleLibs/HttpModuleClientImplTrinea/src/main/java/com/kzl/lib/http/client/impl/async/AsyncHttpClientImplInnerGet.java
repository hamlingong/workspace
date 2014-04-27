package com.kzl.lib.http.client.impl.async;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.AsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * 使用第三方实现get方式异步请求
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplTrinea<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AsyncHttpClientImplInnerGet<T extends EmptyHttpResponse> implements AsyncHttpClient<T> {

    @Override
    public void execute(Context context, String requestUrl, EmptyHttpRequest request, final Class<T> classOfT, final HttpResponseHandler<T> handler, final HttpResponseFilter filter) {
        HttpUtils.httpGet(requestUrl, new HttpUtils.HttpListener() {
            @Override
            protected void onPreGet() {
                super.onPreGet();
            }

            @Override
            protected void onPostGet(HttpResponse response) {
                super.onPostGet(response);
                HttpCommonUtil.onFinish(response, classOfT, handler, filter);
            }
        });
    }
}

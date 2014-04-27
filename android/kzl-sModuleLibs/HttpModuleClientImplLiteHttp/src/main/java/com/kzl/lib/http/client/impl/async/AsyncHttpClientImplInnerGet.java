package com.kzl.lib.http.client.impl.async;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.AsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.async.HttpAsyncExcutor;
import com.litesuits.http.data.HttpStatus;
import com.litesuits.http.data.NameValuePair;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.request.Request;
import com.litesuits.http.response.Response;

/**
 * 使用第三方实现get方式异步请求
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplLiteHttp<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AsyncHttpClientImplInnerGet<T extends EmptyHttpResponse> implements AsyncHttpClient<T> {

    @Override
    public void execute(Context context, String requestUrl, EmptyHttpRequest request, final Class<T> classOfT, final HttpResponseHandler<T> handler, final HttpResponseFilter filter) {
        HttpAsyncExcutor asyncExcutor = new HttpAsyncExcutor();

        asyncExcutor.execute(LiteHttpClient.getInstance(context), new Request(requestUrl), new com.litesuits.http.response.handler.HttpResponseHandler() {
            @Override
            protected void onSuccess(Response res, HttpStatus status, NameValuePair[] headers) {
                HttpCommonUtil.onFinish(HttpCommonUtil.getResponseString(res), classOfT, handler, filter);
            }

            @Override
            protected void onFailure(Response res, HttpException e) {
            }
        });
    }
}

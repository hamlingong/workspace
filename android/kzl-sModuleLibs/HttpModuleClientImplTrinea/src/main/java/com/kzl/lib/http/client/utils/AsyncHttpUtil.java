package com.kzl.lib.http.client.utils;

import android.os.AsyncTask;

import com.kzl.lib.http.client.callback.HttpExecute;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

import cn.trinea.android.common.entity.HttpResponse;

/**
 * http 异步请求执行工具
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplTrinea<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AsyncHttpUtil {
    /**
     * 通过同步的http 请求，自己实现异步，具体请求子类实现
     *
     * @param classOfT
     * @param handler
     * @param httpExecute
     * @param <T>
     */
    public static <T extends EmptyHttpResponse> void execute(final Class<T> classOfT,
                                                             final HttpResponseHandler<T> handler, final HttpExecute httpExecute, final HttpResponseFilter filter) {
        new AsyncTask<Void, Void, HttpResponse>() {
            @Override
            protected HttpResponse doInBackground(Void... params) {
                return httpExecute.execute();
            }

            @Override
            protected void onPostExecute(HttpResponse response) {
                super.onPostExecute(response);
                HttpCommonUtil.onFinish(response, classOfT, handler, filter);
            }
        }.execute();
    }
}

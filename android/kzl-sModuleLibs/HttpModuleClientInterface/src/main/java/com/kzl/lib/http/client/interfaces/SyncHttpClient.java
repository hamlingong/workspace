package com.kzl.lib.http.client.interfaces;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * http同步请求实现接口
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientInterface<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface SyncHttpClient<T extends EmptyHttpResponse> {
    /**
     *
     * @param context
     * @param requestUrl
     * @param request
     * @param classOfT
     * @param filter
     * @return
     */
    public T execute(Context context,
                     final String requestUrl, final EmptyHttpRequest request,
                     final Class<T> classOfT, final HttpResponseFilter filter);

}

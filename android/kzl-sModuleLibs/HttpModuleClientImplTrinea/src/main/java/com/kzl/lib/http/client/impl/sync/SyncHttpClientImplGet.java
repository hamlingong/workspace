package com.kzl.lib.http.client.impl.sync;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.SyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * http get同步请求实现
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplTrinea<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class SyncHttpClientImplGet<T extends EmptyHttpResponse> implements SyncHttpClient<T> {
    @Override
    public T execute(Context context,String requestUrl, EmptyHttpRequest request, Class<T> classOfT, HttpResponseFilter filter) {
        HttpResponse response = HttpUtils.httpGet(requestUrl);
        return HttpCommonUtil.onFinish(response, classOfT, null, filter);
    }
}

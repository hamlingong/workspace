package com.kzl.lib.http.task.interfaces.async;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;

/**
 * http异步请求执行接口<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleProjectInterfaces<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface AsyncHttpTaskExcutor {
    /**
     * http async execute
     * @param context
     * @param url
     * @param request
     * @param mapper
     * @param filter
     */
    void execute(final Context context , final String url, final EmptyHttpRequest request, final HttpResponseMapper mapper, final HttpResponseFilter filter);
}

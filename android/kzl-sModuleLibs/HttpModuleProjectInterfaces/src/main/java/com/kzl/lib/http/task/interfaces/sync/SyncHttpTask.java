package com.kzl.lib.http.task.interfaces.sync;


import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.http.task.interfaces.GPConstantValues;

/**
 * http同步请求执行接口<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleProjectInterfaces<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface SyncHttpTask<T extends EmptyHttpResponse> {
    final static String LOG_TAG = GPConstantValues.LOG_TAG;

    /**
     *  http sync execute
     * @param request
     * @param url
     * @param mapper
     * @param filter
     * @return
     */
    public T execute(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final HttpResponseFilter filter);

}

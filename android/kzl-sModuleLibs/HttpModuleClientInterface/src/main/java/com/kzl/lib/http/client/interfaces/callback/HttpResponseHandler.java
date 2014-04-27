package com.kzl.lib.http.client.interfaces.callback;


import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * http响应结果派发器<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientInterface<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface HttpResponseHandler<T extends EmptyHttpResponse>  {
    /**
     * do when you get the http response
     *
     * @param response
     */
    public void onFinish(T response);
}

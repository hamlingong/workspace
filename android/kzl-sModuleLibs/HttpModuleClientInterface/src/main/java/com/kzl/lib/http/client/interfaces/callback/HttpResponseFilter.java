package com.kzl.lib.http.client.interfaces.callback;

/**
 * http响应过滤器<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientInterface<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface HttpResponseFilter {
    /**
     * filter the response json and return as you like
     *
     * @param responseJson
     * @return
     */
    String dealWithRet(String responseJson);
}

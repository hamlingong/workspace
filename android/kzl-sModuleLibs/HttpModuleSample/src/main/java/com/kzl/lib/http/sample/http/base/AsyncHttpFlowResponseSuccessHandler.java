package com.kzl.lib.http.sample.http.base;

import com.kzl.lib.http.task.interfaces.BaseHttpResponse;

/**
 * http请求成功后调用的接口<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface AsyncHttpFlowResponseSuccessHandler<T extends BaseHttpResponse> {
    /**
     * http访问正常，业务逻辑正常
     */
    public void onNormal(T rest);

    /**
     * http访问正常，业务逻辑错误
     */
    public void onError(String retCode, String errorInfo);
}

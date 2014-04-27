package com.kzl.lib.http.task.interfaces;


import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;

/**
 * 业务的http请求基类，继承了http的空请求基类<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleProjectInterfaces<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class BaseHttpRequest extends EmptyHttpRequest {

    public BaseHttpRequest(String actionCode) {
        super(actionCode);
    }
}

package com.kzl.lib.http.client.interfaces.model;

/**
 * http的基类请求类
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientInterface<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class EmptyHttpRequest {
    private transient String actionCode;

    public EmptyHttpRequest() {
    }

    public EmptyHttpRequest(String actionCode) {

        this.actionCode = actionCode;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
}

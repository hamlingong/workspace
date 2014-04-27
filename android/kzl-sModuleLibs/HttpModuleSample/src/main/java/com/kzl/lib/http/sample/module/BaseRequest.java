package com.kzl.lib.http.sample.module;

import com.kzl.lib.http.task.interfaces.BaseHttpRequest;

/**
 * 业务请求基类，可以在这里写点项目的请求用到的公用属性<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 14-3-30<br/>
 * Time: 下午10:31<br/>
 * To change this template use File | Settings | File Templates.
 */
public class BaseRequest extends BaseHttpRequest {

    private String auth = "";//校验码
    private String userId = "";

    public BaseRequest(String actionCode) {
        super(actionCode);
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("?auth=%s&userId=%s", auth, userId);
    }
}

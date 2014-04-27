package com.kzl.lib.http.sample.module.request;

import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.sample.module.BaseRequest;

/**
 * 登录请求类<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 14-3-30<br/>
 * Time: 下午7:37<br/>
 * To change this template use File | Settings | File Templates.
 */
public class LoginRequest extends BaseRequest {
    private String userName;
    private String password;

    public LoginRequest() {
        super(GpConstantsActionCode.LOGIN_ACTION);
    }
    public LoginRequest(String userName, String password) {
        this();
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString() +
                "&userName=" + userName +
                "&password=" + password;
    }
}

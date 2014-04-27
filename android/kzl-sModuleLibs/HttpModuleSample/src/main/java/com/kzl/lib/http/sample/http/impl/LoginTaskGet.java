package com.kzl.lib.http.sample.http.impl;


import android.content.Context;
import com.kzl.lib.http.sample.http.base.async.impl.AsyncHttpTaskImplGet;
import com.kzl.lib.http.sample.module.request.LoginRequest;
import com.kzl.lib.http.sample.module.response.LoginResponse;
import com.kzl.lib.utils.LogUtil;

/**
 * 登录请求，异步get方式<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class LoginTaskGet<T extends LoginResponse> extends AsyncHttpTaskImplGet<T> {

    public LoginTaskGet(Context context) {
        super(context);
    }

    //登录
    public void send(final String account, final String md5Password) {
        super.execute(new LoginRequest(account, md5Password));
    }

    @Override
    public void onError(String retCode, String errorInfo) {
        super.onError(retCode, errorInfo);
    }

    @Override
    public void onNormal(T response) {
        super.onNormal(response);
        LogUtil.trace("response==" + response.toString());
    }
}
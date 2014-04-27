package com.kzl.lib.http.sample.http.impl;


import com.kzl.lib.http.sample.http.base.sync.BaseSyncHttpTask;
import com.kzl.lib.http.sample.module.request.LoginRequest;
import com.kzl.lib.http.sample.module.response.LoginResponse;

/**
 * 登录请求，同步请求方式r/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class SyncRequestTask {
    public static LoginResponse loginGetTask(final String account, final String md5Password) {
        return (LoginResponse) BaseSyncHttpTask.getInstance().get(new LoginRequest(account, md5Password));
    }

    public static LoginResponse loginPostTask(final String account, final String md5Password) {
        return (LoginResponse)BaseSyncHttpTask.getInstance().post(new LoginRequest(account, md5Password));
    }
}

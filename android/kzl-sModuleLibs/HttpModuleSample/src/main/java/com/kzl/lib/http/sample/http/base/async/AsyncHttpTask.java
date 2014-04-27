package com.kzl.lib.http.sample.http.base.async;

import com.kzl.lib.http.task.interfaces.BaseHttpRequest;

/**
 * http异步访问类的执行接口<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/17<br/>
 * Time: 22:11<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface AsyncHttpTask {
    /**
     * 异步 http 访问执行入口
     * @param request
     */
    public void execute(final BaseHttpRequest request);
}

package com.kzl.lib.http.client.interfaces.callback;


import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * http任务的流程接口
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientInterface<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface AsyncHttpFlowHandler<T extends EmptyHttpResponse> {
    /**
     * 访问网络开始时回调，与onFinish成对
     */
    public void onStart();

    /**
     * 访问网络结束时回调，与onStart成对
     */
    public void onFinish();

    /**
     * 访问网络时，无可用网络回调
     */
    public void onNoNet();

    /**
     * 无法解析结果时回调
     */
    public void onNoData();

    /**
     * 访问正常,数据不为空时回调
     */
    public void onSuccess(final T response);

}

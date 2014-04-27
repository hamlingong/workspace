package com.kzl.lib.http.sample.http.base.sync;


import android.content.Context;

import com.kzl.lib.http.sample.APP;
import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.sample.http.base.HttpCommonUtils;
import com.kzl.lib.http.sample.http.base.HttpResponseFilterImpl;
import com.kzl.lib.http.sample.module.BaseRequest;
import com.kzl.lib.http.sample.module.BaseResponse;
import com.kzl.lib.http.task.interfaces.sync.SyncHttpTask;
import com.kzl.lib.http.task.interfaces.sync.impl.SyncHttpTaskImplGet;
import com.kzl.lib.http.task.interfaces.sync.impl.SyncHttpTaskImplPost;

/**
 * 应用 http 同步访问的基类，建议以组合的方式使用，不要继承<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/17<br/>
 * Time: 21:25<br/>
 * To change this template use File | Settings | File Templates.
 */
public class BaseSyncHttpTask<T extends BaseResponse> {
    private static BaseSyncHttpTask instance;
    private SyncHttpTask<T> getSyncHttpTask;
    private SyncHttpTask<T> postSyncHttpTask;

    private BaseSyncHttpTask(Context context) {
        getSyncHttpTask = new SyncHttpTaskImplGet<T>(context);
        postSyncHttpTask = new SyncHttpTaskImplPost<T>(context);
    }

    public static BaseSyncHttpTask getInstance() {
        if (instance == null) {
            instance = new BaseSyncHttpTask(APP.getInstance().getApplicationContext());
        }
        return instance;
    }

    /**
     * sync http get
     * @param request
     * @return
     */
    public T get(BaseRequest request) {
        return getSyncHttpTask.execute(request, HttpCommonUtils.getRequestUrl(request), GpConstantsActionCode.getInstance(), HttpResponseFilterImpl.getInstance());
    }

    /**
     * sync http post
     * @param request
     * @return
     */
    public T post(BaseRequest request) {
        return postSyncHttpTask.execute(request, HttpCommonUtils.getRequestUrl(request), GpConstantsActionCode.getInstance(), HttpResponseFilterImpl.getInstance());
    }
}

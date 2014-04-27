package com.kzl.lib.http.client.interfaces.utils;

import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * ActionCode Response 映射类抽象类<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientInterface<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public abstract class HttpResponseMapper {
    /**
     * to find the class type which extends EmptyHttpResponse by the actionCode
     *
     * @param actionCode
     * @param <T>
     * @return
     */
    public abstract <T extends EmptyHttpResponse> Class<T> findClass(String actionCode);
}

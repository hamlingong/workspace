package com.kzl.lib.http.sample.http;

import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.http.sample.module.response.LoginResponse;
import com.kzl.lib.http.task.interfaces.BaseHttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * ActionCode Response 映射类<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class GpConstantsActionCode extends HttpResponseMapper {
    private final static Map<String, Class<? extends BaseHttpResponse>> CLASS_MAP = new HashMap<String, Class<? extends BaseHttpResponse>>();
    public final static String HOST = "";//TODO 添加主机url
    public final static String RES_OK = "0";
    public static final String LOGIN_ACTION = "login.action";
    private static final GpConstantsActionCode instance = new GpConstantsActionCode();

    public static GpConstantsActionCode getInstance() {
        return instance;
    }

    public GpConstantsActionCode() {
        CLASS_MAP.put(LOGIN_ACTION, LoginResponse.class);
    }

    public <T extends EmptyHttpResponse> Class<T> findClass(String actionCode) {
        Class c = CLASS_MAP.get(actionCode);
//        if (c == null)
//            c = BaseHttpResponse.class;
        return c;
    }

//    public static void main(String[] args) {
//        System.out.println();
//        System.out.println("class findClass FF a == " + HttpResponseMapper.findClass("a"));
//        System.out.println("class findClass FF g == " + HttpResponseMapper.findClass("g"));
//        System.out.println();
//        System.out.println("class findClass DD a == " + GpConstantsActionCode.findClass("a"));
//        System.out.println("class findClass DD g == " + GpConstantsActionCode.findClass("g"));
//
//    }
}

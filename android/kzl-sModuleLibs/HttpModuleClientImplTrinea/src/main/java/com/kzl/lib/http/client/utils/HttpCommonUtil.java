package com.kzl.lib.http.client.utils;

import cn.trinea.android.common.entity.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.utils.LogUtil;

/**
 * http工具类
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplTrinea<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class HttpCommonUtil {
    private final static String LOG_TAG = "HTTPUtil";
    private final static Gson GSON = new Gson();

    /**
     * execute after baseGet the response
     *
     * @param response
     * @param classOfT
     * @param handler
     * @param <T>
     */
    public static <T extends EmptyHttpResponse> T onFinish(HttpResponse response, final Class<T> classOfT, final HttpResponseHandler<T> handler, final HttpResponseFilter filter) {
        LogUtil.trace(LOG_TAG, "json-response:" + response.getResponseBody());
        T responseEntity = null;
        try {
            String retJson = filter.dealWithRet(response.getResponseBody());
            responseEntity = GSON.fromJson(retJson, classOfT);
        } catch (JsonSyntaxException e) {
            LogUtil.trace(e);
        } catch (JsonParseException e) {
            LogUtil.trace(e);
        } catch (NullPointerException e){
            LogUtil.trace(e);
        }catch (Exception e){
            LogUtil.trace(e);
        } finally {
            if (handler != null) {
                handler.onFinish(responseEntity);
            }
        }
        return responseEntity;
    }


}

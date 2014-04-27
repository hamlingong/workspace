package com.kzl.lib.http.client.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.HttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.utils.LogUtil;
import com.litesuits.http.response.Response;

/**
 * http工具类
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplLiteHttp<br/>
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
     * get the response class type  by the action  code from mapper
     * @param mapper
     * @param actionCode
     * @param <T>
     * @return
     */
    public static <T extends EmptyHttpResponse> Class<T> getResponseClassType(HttpResponseMapper mapper, String actionCode) {
        return mapper.findClass(actionCode);
    }

    /**
     * get the response's json string
     * @param response
     * @return
     */
    public static String getResponseString(Response response){
        if (response == null)
            return null;
        return response.getString();
    }
    /**
     * execute after baseGet the response
     * @param responseString
     * @param classOfT
     * @param handler
     * @param filter
     * @param <T>
     * @return
     */
    public static <T extends EmptyHttpResponse> T onFinish(String  responseString, final Class<T> classOfT, final HttpResponseHandler<T> handler, final HttpResponseFilter filter) {
        LogUtil.trace(LOG_TAG, "json-response:" + responseString);
        T responseEntity = null;
        try {
            String retJson = filter.dealWithRet(responseString);
            responseEntity = GSON.fromJson(retJson, classOfT);
        } catch (JsonSyntaxException e) {
            LogUtil.trace(e);
        } catch (JsonParseException e) {
            LogUtil.trace(e);
        } catch (NullPointerException e){
            LogUtil.trace(e);
        }catch (Exception e){
            LogUtil.trace(e);
        }finally {
            if (handler != null) {
                handler.onFinish(responseEntity);
            }
        }
        return responseEntity;
    }
}

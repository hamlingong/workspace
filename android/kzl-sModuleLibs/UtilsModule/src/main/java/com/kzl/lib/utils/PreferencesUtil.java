package com.kzl.lib.utils;

import android.annotation.TargetApi;
import android.content.Context;
import com.kzl.lib.utils.base.BasePreferencesUtil;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 一个preferences 工具类，实现了preference的所有读写方法 <br/>
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class PreferencesUtil {
    private static PreferencesUtil preferencesUtil;
    private BasePreferencesUtil basePreferencesUtil;

    private PreferencesUtil(Context context) {
        this.basePreferencesUtil = new BasePreferencesUtil(context);
    }

    private PreferencesUtil(Context context, String preferencesName) {
        this.basePreferencesUtil = new BasePreferencesUtil(context, preferencesName);
    }

    public static PreferencesUtil getInstance(Context context) {
        if (preferencesUtil == null)
            preferencesUtil = new PreferencesUtil(context);
        return preferencesUtil;
    }

    public String getStringByKey(String key) {
        return basePreferencesUtil.preference.getString(key, "");
    }

    public void setStringByKey(String key, String value) {
        basePreferencesUtil.editor.putString(key, value);

    }

    public boolean getBooleanByKey(String key) {
        return basePreferencesUtil.preference.getBoolean(key, false);
    }

    public void setBooleanByKey(String key, boolean value) {
        basePreferencesUtil.editor.putBoolean(key, value);

    }

    public float getFloatByKey(String key) {
        return basePreferencesUtil.preference.getFloat(key, 0);
    }

    public void setFloatByKey(String key, float value) {
        basePreferencesUtil.editor.putFloat(key, value);
    }

    public int getIntByKey(String key) {
        return basePreferencesUtil.preference.getInt(key, 0);
    }

    public void setIntByKey(String key, int value) {
        basePreferencesUtil.editor.putInt(key, value);

    }

    public long getLongByKey(String key) {
        return basePreferencesUtil.preference.getLong(key, 0);
    }

    public void setLongByKey(String key, long value) {
        basePreferencesUtil.editor.putLong(key, value);

    }

    @TargetApi(11)
    public Set<String> getStringSetByKey(String key) {
        return basePreferencesUtil.preference.getStringSet(key,
                new HashSet<String>());
    }

    @TargetApi(11)
    public void setStringSetByKey(String key, Set<String> value) {
        basePreferencesUtil.editor.putStringSet(key, value);

    }

    public Map<String, ?> getAll() {
        return basePreferencesUtil.preference.getAll();
    }

    public void commit() {
        basePreferencesUtil.commit();
    }
}

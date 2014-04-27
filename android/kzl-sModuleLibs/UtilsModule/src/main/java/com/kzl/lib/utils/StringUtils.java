package com.kzl.lib.utils;

import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class StringUtils {
    public static final String MONEY_DECIMAL_FORMAT = "#,###";

    /**
     * is null or its length is 0
     * <p/>
     * <pre>
     * isEmpty(null) = true;
     * isEmpty(&quot;&quot;) = true;
     * isEmpty(&quot;  &quot;) = false;
     * </pre>
     *
     * @param str
     * @return if string is null or its size is 0, return true, else return false.
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * overload isEmpty for charSequence
     *
     * @param charSequence
     * @return
     */
    public static boolean isEmpty(CharSequence charSequence) {
        return (charSequence == null || isEmpty(charSequence.toString()));
    }

    /**
     * overload isEmpty for TextView;
     *
     * @param textView
     * @return
     */
    public static boolean isEmpty(TextView textView) {
        return (textView == null || isEmpty(textView.getText()));
    }

    /**
     * get the charSequence as string
     *
     * @param charSequence
     * @return
     */
    public static String getString(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    /**
     * overload for TextView
     *
     * @param textView
     * @return
     */
    public static String getString(TextView textView) {
        return textView == null ? null : getString(textView.getText());
    }

    /**
     * 根据格式，将制定数据格式化
     *
     * @param data
     * @param pattern
     * @return
     */
    public static String getDecimalFormat(double data, String pattern) {
        String res = String.valueOf(data);
        DecimalFormat df = new DecimalFormat();
        try {
            df.applyPattern(pattern);
            res = df.format(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public static String getDecimalFormat(String data, String pattern) {
        if (isEmpty(data)||"null".equals(data)) {
            return data;
        }
        return  getDecimalFormat(Double.valueOf(data),pattern);
    }

//    public static void main(String[] args) {
//        double s = 33334.5;
//        System.out.println("=============StringUtils.getDecimalFormat(s,StringUtils.MONEY_DECIMAL_FORMAT)=============" + StringUtils.getDecimalFormat(s, StringUtils.MONEY_DECIMAL_FORMAT));
//        System.out.println("=============StringUtils.getDecimalFormat(s,StringUtils.MONEY_DECIMAL_FORMAT)=============" + StringUtils.getDecimalFormat(String.valueOf(s), StringUtils.MONEY_DECIMAL_FORMAT));
//    }

}

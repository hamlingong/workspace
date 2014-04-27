package com.kzl.lib.utils.model;

/**
 * Project:UtilsModule
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 14-3-28<br/>
 * Time: 下午9:07<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ScreenBean {
    private int widthPixels;
    private int heightPixels;

    public ScreenBean() {
    }

    public ScreenBean(int widthPixels, int heightPixels) {

        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
    }

    public int getWidthPixels() {
        return widthPixels;
    }

    public void setWidthPixels(int widthPixels) {
        this.widthPixels = widthPixels;
    }

    public int getHeightPixels() {
        return heightPixels;
    }

    public void setHeightPixels(int heightPixels) {
        this.heightPixels = heightPixels;
    }
}

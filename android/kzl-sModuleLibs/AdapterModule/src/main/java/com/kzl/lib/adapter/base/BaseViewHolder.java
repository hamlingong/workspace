package com.kzl.lib.adapter.base;

/**
 * 数据绑定类 包含绑定的控件成员 绑定方法。
 * a bindable interface with a setData method
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface BaseViewHolder<D> extends UnMixable {
    /**
     * bind the data message
     *
     * @param data     the data params
     * @param position the position of data in the datasArray
     */
    public abstract<T extends D> void setData(T data, int position);

}

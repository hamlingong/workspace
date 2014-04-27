package com.kzl.lib.adapter.base;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
/**
 * a abstract class do some job to reduce code about bind view to holder and easy on use baseAdapter
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractAdapter<D> extends BaseAdapter {

    protected Context context;
    protected String TAG;
    protected LayoutInflater inflater;
    private List<D> list;

    public AbstractAdapter(Context context) {
        this(context, null);
    }

    /**
     * constructor
     *
     * @param context
     * @param list
     */
    public AbstractAdapter(Context context, List<D> list) {

        this.context = context;
        TAG = this.getClass().getName();
        if (list == null) {
            this.list = new ArrayList<D>();
        } else {
            this.list = list;
        }
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    /**
     * set the list Arrays and notify update
     *
     * @param list
     */
    public void refreshData(List<D> list) {
        this.list.clear();
        if (list != null) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }


    @SuppressWarnings("unchecked")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);

        BaseViewHolder<D> holder;
        if (convertView == null) {
            convertView = View.inflate(context, getItemViewLayout(type), null);
            holder = getItemViewHolder(type);
            convertView.setTag(holder);
        } else {
            holder = (BaseViewHolder<D>) convertView.getTag();
        }
        ViewInjectorByReflect.injectView(holder, convertView);
        D bean = getItem(position);

        holder.setData(bean, position);
        return convertView;

    }

    protected Context getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public D getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * get the itemlayout base on viewType;
     * 获取对应itemType 的布局文件
     *
     * @param itemViewType
     * @return
     */
    protected abstract int getItemViewLayout(int itemViewType);

    /**
     * get the binder base on viewType;
     * 获取对应itemType的控件集合绑定工具
     *
     * @param itemViewType
     * @return
     */
    protected abstract BaseViewHolder<D> getItemViewHolder(int itemViewType);
}

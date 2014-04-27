package com.kzl.lib.adapter.base;

import android.view.View;

import java.lang.reflect.Field;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 14-4-2<br/>
 * Time: 下午8:32<br/>
 * a helper class
 * <p/>
 * use java reflect to inject view to the obj whose member has the same name to
 * the subViewId(R.id.name)
 * 利用java反射功能 执行控件注射
 */


public class ViewInjectorByReflect {

    /**
     * 执行View 与 控件索引对象 关联
     * <p/>
     * 执行注入的对象 成员名称 必须与 View 的子控件的 id 一致
     *
     * @param obj 所传递的对象 必须实现UnMixable接口 以避免代码混搅过程中 影响java 反射功能使用。
     * @param v
     */
    public static final void injectView(UnMixable obj, View v) {

        Class<?> aClass = obj.getClass();

        while (aClass != null) {// 循环往上查询成员变量

            Field[] fields = aClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                int id = v.getResources().getIdentifier(field.getName(), "id",
                        v.getContext().getPackageName());
                if (id > 0) {
                    View fieldView = v.findViewById(id);
                    if (fieldView == null) {
                    } else
                        try {
                            field.set(obj, fieldView);
                        } catch (IllegalArgumentException e) {

                            e.printStackTrace();
                        } catch (IllegalAccessException e) {

                            e.printStackTrace();
                        }
                }
                field.setAccessible(false);

            }
            aClass = aClass.getSuperclass();
        }

    }

}

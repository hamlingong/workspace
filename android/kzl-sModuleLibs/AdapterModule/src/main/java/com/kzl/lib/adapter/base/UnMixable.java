package com.kzl.lib.adapter.base;

/**
 * empty interface   for not to do code mix .
 * 空接口 仅仅表明
 * 任何实现该接口的类 其成员变量不参与 代码混肴
 * -keep interface com.kzl.lib.adapter.base.UnMixable
 * -keepclassmembernames class * implements com.kzl.lib.adapter.base.UnMixable
 * {
 * *;
 * }
 * <p/>
 * <p/>
 * 实现该接口的任何类， 其成员名称（变量名称 TextView tv_name） 必须和android 界面元素标识(R.id.tv_name)一致
 * 方可使用
 *
 * @see ViewInjectorByReflect 配合使用
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface UnMixable {

}

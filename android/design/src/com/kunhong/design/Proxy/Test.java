package com.kunhong.design.Proxy;

/**
 * 代理模式 代理模式:给某一对象提供代理对象,并由代理对象控制具体对象的引用.
 * 
 * 代理,指的就是一个角色代表另一个角色采取行动,就象生活中,一个红酒厂商,是不会直接把红酒零售客户的,都是通过代理来完成他的销售业务的.而客户,
 * 也不用为了喝红酒而到处找工厂,他只要找到厂商在当地的代理就行了,具体红酒工厂在那里,客户不用关心,代理会帮他处理.
 * 
 * @author lyq
 * 
 */
public class Test {
	public static void main(String agr[]) {
		SellInterface sell = new RedWineProxy();
		sell.sell();
	}
}

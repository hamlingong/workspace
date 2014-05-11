package com.kunhong.design.Facade;

/**
 * 门面模式 
 * Facade类其实相当于A、B、C模块的外观界面，有了这个Facade类，那么客户端就不需要亲自调用子系统中的A、B、C模块了，
 * 也不需要知道系统内部的实现细节
 * ，甚至都不需要知道A、B、C模块的存在，客户端只需要跟Facade类交互就好了，从而更好地实现了客户端和子系统中A、B、C模块的解耦
 * ，让客户端更容易地使用系统。
 * 
 * @author lyq
 * 
 */
public class Test {

	public static void main(String[] args) {

		Facade facade = new Facade();
		facade.test();
	}

}

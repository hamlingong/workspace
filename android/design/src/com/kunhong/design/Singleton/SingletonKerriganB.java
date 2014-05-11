package com.kunhong.design.Singleton;

/**
 * 实现单例访问Kerrigan的第二次尝试
 * 比起第一段代码仅仅在方法中多了一个synchronized修饰符，现在可以保证不会出线程问题了。但是这里有个很大（
 * 至少耗时比例上很大）的性能问题。除了第一次调用时是执行了SingletonKerriganB的构造函数之外
 * ，以后的每一次调用都是直接返回instance对象
 * 。返回对象这个操作耗时是很小的，绝大部分的耗时都用在synchronized修饰符的同步准备上，因此从性能上说很不划算。
 */
public class SingletonKerriganB {

	/**
	 * 单例对象实例
	 */
	private static SingletonKerriganB instance = null;

	public synchronized static SingletonKerriganB getInstance() {
		if (instance == null) {
			instance = new SingletonKerriganB();
		}
		return instance;
	}
}

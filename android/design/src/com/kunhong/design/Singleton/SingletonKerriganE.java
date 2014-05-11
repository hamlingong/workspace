package com.kunhong.design.Singleton;

/**
 * 实现单例访问Kerrigan的第五次尝试 代码倒越来越复杂了，现在先来个返璞归真，根据JLS（Java Language
 * Specification）中的规定
 * ，一个类在一个ClassLoader中只会被初始化一次，这点是JVM本身保证的，那就把初始化实例的事情扔给JVM好了，代码被改成这样：
 * 也就是标准的饿汉式写法
 */
public class SingletonKerriganE {

	/**
	 * 单例对象实例
	 */
	private static SingletonKerriganE instance = new SingletonKerriganE();

	public static SingletonKerriganE getInstance() {
		return instance;
	}
}

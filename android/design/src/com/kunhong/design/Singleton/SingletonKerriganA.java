package com.kunhong.design.Singleton;

/**
 * 实现单例访问Kerrigan的第一次尝试 标准懒汉式方法 这个写法我们把四点需求从上往下检测，
 * 发现第二点的时候就出了问题，假设这样的场景：两个线程并发调用SingletonKerriganA
 * .getInstance()，假设线程一先判断完instance是否为null，既代码中的line A进入到line
 * B的位置。刚刚判断完毕后，JVM将CPU资源切换给线程二，由于线程一还没执行line B，所以instance仍然是空的，因此线程二执行了new
 * SignletonKerriganA()操作。片刻之后，线程一被重新唤醒，它执行的仍然是new
 * SignletonKerriganA()操作，好了，问题来了，两个Kerrigan谁是李逵谁是李鬼？
 */
public class SingletonKerriganA {

	/**
	 * 单例对象实例
	 */
	private static SingletonKerriganA instance = null;

	public static SingletonKerriganA getInstance() {
		if (instance == null) { // line A
			instance = new SingletonKerriganA(); // line B
		}
		return instance;
	}
}

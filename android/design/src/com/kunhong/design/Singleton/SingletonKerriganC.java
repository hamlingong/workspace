package com.kunhong.design.Singleton;

/**
 * 实现单例访问Kerrigan的第三次尝试
 * 基本上，把synchronized移动到代码内部是没有什么意义的，每次调用getInstance()还是要进行同步
 * 。同步本身没有问题，但是我们只希望在第一次创建Kerrigan实例的时候进行同步，因此我们有了下面的写法——双重锁定检查（DCL）。
 */
public class SingletonKerriganC {

	/**
	 * 单例对象实例
	 */
	private static SingletonKerriganC instance = null;

	public static SingletonKerriganC getInstance() {
		synchronized (SingletonKerriganC.class) {
			if (instance == null) {
				instance = new SingletonKerriganC();
			}
		}
		return instance;
	}
}

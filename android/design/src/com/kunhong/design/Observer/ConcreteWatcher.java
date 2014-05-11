package com.kunhong.design.Observer;

/**
 * 具体观察者角色(Watcher) 
 * @author lyq
 *
 */
public class ConcreteWatcher implements AbstractWatcher {

	/**
	 * 观察到被观察者发生变化时，执行的方法
	 */
	public void update() {
		System.out.println("update.....");
		
	}
	
}

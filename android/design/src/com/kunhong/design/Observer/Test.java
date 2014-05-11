package com.kunhong.design.Observer;

/**
 * 观察者模式 观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态上发生变化时，会通知所有观察者对象，
 * 让他们能够自动更新自己
 * 
 * 观察者模式的组成
 * 
 * 1.抽象主题角色:把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。
 * 一般用一个抽象类或接口来实现 2.抽象观察者角色:为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。
 * 3.具体主题角色(Watched):把所有对观察者对象的引用保存在一个集合中
 * ，每个抽象主题角色都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类或接口来实现。
 * 4.具体观察者角色(Watcher):为所有具体的观察者定义一个接口，在得到主题的通知时更新自己
 * 
 * @author lyq
 * 
 */
public class Test {

	public static void main(String[] args) {
		// 定义一个被观察者对象
		AbstractWatched watched = new ConcreteWatched();

		// 定义三个观察者对象
		AbstractWatcher watcher1 = new ConcreteWatcher();
		AbstractWatcher watcher2 = new ConcreteWatcher();
		AbstractWatcher watcher3 = new ConcreteWatcher();

		// 被观察者添加观察者. 被观察者和观察者之间关系是一对多关系
		watched.addAbstactWatcher(watcher1);
		watched.addAbstactWatcher(watcher2);
		watched.addAbstactWatcher(watcher3);

		System.out.println("第1次...");
		// 被观察者发生改变时，通知观察者执行相应方法
		watched.notifyWatchers();

		// 移除一个观察者
		watched.removeAbstactWatcher(watcher2);

		System.out.println("第2次...");
		// 被观察者发生改变时，通知观察者执行相应方法
		watched.notifyWatchers();

		// 移除一个所有观察者
		watched.removeAll();

		System.out.println("第3次...");
		// 被观察者发生改变时，通知观察者执行相应方法
		watched.notifyWatchers();

		// 结果
		/*
		 * 执行结果为： 第1次... update..... update..... update..... 第2次... update.....
		 * update..... 第3次...
		 */

	}
}

package com.kunhong.design.Observer;

/**
 * 抽象主题角色类
 * @author lyq
 *
 */
public interface AbstractWatched {
	
	//增加一个观察者
	public void addAbstactWatcher(AbstractWatcher watcher);
	
	//移除一个观察者
	public void removeAbstactWatcher(AbstractWatcher watcher);
	
	//移除所有的观察着
	public void removeAll();
	
	//通知所有的观察者
	public void notifyWatchers();

}

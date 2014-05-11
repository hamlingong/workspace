package com.kunhong.design.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题角色
 * @author lyq
 *
 */
public class ConcreteWatched implements AbstractWatched {

	/**
	 * list:存放观察者的一个集合对象
	 */
	List<AbstractWatcher> list = new ArrayList<AbstractWatcher>();
	
	/**
	 * 增加一个观察者
	 */
	public void addAbstactWatcher(AbstractWatcher watcher) {
		list.add(watcher);

	}

	/**
	 * 移除一个观察者
	 */
	public void removeAbstactWatcher(AbstractWatcher watcher) {
		list.remove(watcher);

	}

	/**
	 * 移除所有的观察着
	 */
	public void removeAll() {
		list.clear();

	}
	
	/**
	 * 通知所有的观察者
	 */
	public void notifyWatchers() {
		for(AbstractWatcher watcher : list){
			watcher.update();
		}

	}

}

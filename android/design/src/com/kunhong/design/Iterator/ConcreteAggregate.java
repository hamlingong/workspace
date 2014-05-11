package com.kunhong.design.Iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate implements Aggregate {
	private List list = new ArrayList();

	public void add(Object obj) {
		list.add(obj);
	}

	public Iterator iterator() {
		return new ConcreteIterator(list);
	}

	public void remove(Object obj) {
		list.remove(obj);
	}
}

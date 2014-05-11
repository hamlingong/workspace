package com.kunhong.design.Iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator{
	private List list = new ArrayList();
	private int cursor =0;
	public ConcreteIterator(List list){
		this.list = list;
	}
	public boolean hasNext() {
		if(cursor==list.size()){
			return false;
		}
		return true;
	}
	public Object next() {
		Object obj = null;
		if(this.hasNext()){
			obj = this.list.get(cursor++);
		}
		return obj;
	}
}
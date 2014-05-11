package com.kunhong.design.Memento;

public class User {
	private Memento memento;

	public Memento retrieveMemento() { // 恢复系统
		return this.memento;
	}

	public void saveMemento(Memento memento) { // 保存系统
		this.memento = memento;
	}
}

package com.kunhong.design.Memento;

public class WindowsSystem {
	private String state;

	/**
	 * 创建系统备份
	 * @return
	 */
	public Memento createMemento() { 
		return new Memento(state);
	}

	/**
	 * 恢复系统
	 * @param m
	 */
	public void restoreMemento(Memento m) {  
		this.state = m.getState();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("当前系统处于" + this.state);
	}
}

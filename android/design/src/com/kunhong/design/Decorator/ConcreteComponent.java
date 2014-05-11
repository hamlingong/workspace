package com.kunhong.design.Decorator;

/**
 * 具体构件角色
 * 
 * @author lyq
 * 
 */
public class ConcreteComponent implements Component {
	@Override
	public void doSomething() {
		System.out.println("功能A");
	}
}

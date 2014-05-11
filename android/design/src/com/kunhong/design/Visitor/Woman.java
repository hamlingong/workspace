package com.kunhong.design.Visitor;

public class Woman implements Person {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

package com.kunhong.design.State;

public class Angry implements MoodState {
	Person p;

	public Angry(Person p) {
		this.p = p;
	}

	public void doSomething() {
		System.out.println("I'm angry!");
	}

	public void changeState() {
		p.setState(new Happy(p));
	}
}

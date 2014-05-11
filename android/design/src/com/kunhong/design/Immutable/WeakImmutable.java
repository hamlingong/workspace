package com.kunhong.design.Immutable;

/**
 * 弱不变模式
 * 一个类的实例的状态是不可变化的，但是这个类的引用的实例具有可能会变化的状态。这样的类符合弱不变模式的定义。要实现弱不变模式，一个类必须满足如下条件：
 * 
 * 第一，对象没有任何方法会修改对象的状态，当对象的构造函数对对象的状态初始化之后，对象的状态便不再改变。
 * 
 * 第二，所有的属性都应当是私有的，以防客户端对象直接修改任何的内部状态。
 * 
 * 第三，这个对象所引用的对象如果是可变对象的话，必须设法限制外界对这个对象的访问，以防止对这些对象的修改。如果可能应该尽量在不变对象的内部来初始化。
 * 
 * 弱不变模式的缺点是：
 * 一个弱不变对象引用的实例变量可以是可变对象，可能会通过外界修改父对象的状态，这是一个显著的缺点。可以在初始化可变对象时，先进行clone。
 */
public class WeakImmutable {

	/**
	 * 属性私有，满足条件2
	 */
	private int state;

	/**
	 * 属性私有，满足条件2
	 */
	private User user;

	private Integer age;

	public WeakImmutable(int state, User user, Integer age) {
		this.state = state;
		this.user = user;
		this.age = age;
	}

	public int getState() {
		return this.state;
	}

	public User getUser() {
		return this.user;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setState() {
		// 对象没有任何方法修改对象的状态,满足条件1
		// do nothing.
	}
}

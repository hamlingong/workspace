package com.kunhong.design.Immutable;

/**
 * 不变模式 不变模式有两种形式：一种是弱不变模式，另一种是强不变模式。
 * 
 * 弱不变模式：
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
 * 
 * 不变模式 强不变模式： 一个类的实例的状态不会改变，同时它的子类的实例也具有不可变化的状态。这样的类符合强不变模式。要实现强不变模式，
 * 一个类必须首先满足弱不变模式所要求的所有条件 ，并且还要满足下面条件之一：
 * 第一，所考虑的类所有的方法都应当是final，这样这个类的子类不能够置换掉此类的方法。
 * 第二，这个类本身就是final的，那么这个类就不可能会有子类，从而也就不可能有被子类修改的问题。
 * 
 * @author lyq
 * 
 */
public class Test {
	public static void main(String[] args) {
		int state = 0;
		User u = new User();
		Integer age = 100;
		u.setName("yes");
		WeakImmutable weak = new WeakImmutable(state, u, age);
		System.out.println("原始值：" + weak.getState() + ","
				+ weak.getUser().getName() + "," + weak.getAge());
		// 修改引用后
		state = 5;
		// User由于是可变对象引用，所以有影响
		u.setName("no");
		age = 200;
		System.out.println("修改引用后：" + weak.getState() + ","
				+ weak.getUser().getName() + "," + weak.getAge());
	}
}

package com.kunhong.design.State;

/**
 * 状态模式 状态模式属于对象创建型模式，其意图是允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了他的类。
 * 比较常见的例子是在一个表示网络连接的类TCPConnection
 * ，一个TCPConnection对象的状态处于若干不同的状态之一:连接已经建立(Established
 * ),正在监听，连接已经关闭(closed)。当一个TCPConnection对象收到其他对象的请求时
 * ，他根据自身的状态作出不同的反应。例如：一个Open请求的结果依赖于该连接已关闭还是连接已建立状态
 * 。State模式描述了TCPConnection如何在每一种状态下表现出不同的行为
 * 。这一种模式的关键思想是引入了一个称为TCPState的抽象类表示网络的连接状态
 * ，TCPState类为各种表示不同的操作状态的字类声明了一个公共接口。TCPState的子类实现与特定的状态相关的行为
 * 。例如，TCPEstablished和TCPClosed类分别实现了特定于TCPConnection的连接已建立状态和连接已关闭状态的行为。
 * 举例来说：一个人具有生气
 * ，高兴和抓狂等状态，在这些状态下做同一个事情可能会有不同的结果，一个人的心情可能在这三种状态中循环转变。使用一个moodState类表示一个人的心情
 * ，使用mad,Happy,Angry类代表不同的心情
 * 
 * @author lyq
 * 
 */
public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		for (int i = 0; i < 10; i++)
			p.doSomething();
	}
}

package com.kunhong.design.FlyWeight;

/**
 * 享元模式 
 * 我们先考虑一种比较简单的解决方案：对于不能共享的状态，不要在Charactor类中设置，而是由客户程序在自己的代码中进行设置
 * 
 * @author lyq
 * 
 */
public class Test {
	public static void main(String[] args) {
		Charactor a = new CharactorA();
		Charactor b = new CharactorB();
		
		// 显示字符A
		display(a, 12);
		// 显示字符B
		display(b, 14);
	}

	// 设置字符的大小
	public static void display(Charactor objChar, int nSize) {
		try {
			System.out.println("字符：" + objChar.letter + "，大小：" + nSize);
		} catch (Exception err) {
		}
	}
}

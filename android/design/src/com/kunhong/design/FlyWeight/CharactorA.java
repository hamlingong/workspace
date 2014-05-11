package com.kunhong.design.FlyWeight;

/**
 * 具体的字符类A
 * 
 * @author lyq
 * 
 */
public class CharactorA extends Charactor {
	/**
	 * 构造函数
	 */
	public CharactorA() {
		this.letter = 'A';
	}

	/**
	 * 显示方法
	 */
	public void display() {
		try {
			System.out.println(this.letter);
		} catch (Exception err) {
		}
	}
}

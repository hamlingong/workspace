package com.kunhong.design.FlyWeight;

/**
 * 具体的字符类B
 * 
 * @author lyq
 * 
 */
public class CharactorB extends Charactor {
	/**
	 * 构造函数
	 */
	public CharactorB() {
		this.letter = 'B';
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

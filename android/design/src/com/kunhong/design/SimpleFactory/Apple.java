package com.kunhong.design.SimpleFactory;

/**
 * 通过implements实现接口Fruit
 * 
 */
public class Apple implements Fruit {
	private int treeAge;

	public void grow() {
		log(" Apple is growing ");
	}

	public void harvest() {
		log(" Apple has been harvested ");
	}

	public void plant() {
		log(" Apple ha been planted ");
	}

	public static void log(String msg) {
		System.out.println(msg);
	}

	public int getTreeAge() {
		return treeAge;
	}

	public void setTreeAge(int treeAge) {
		this.treeAge = treeAge;
	}
}

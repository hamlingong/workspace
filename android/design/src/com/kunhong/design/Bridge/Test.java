package com.kunhong.design.Bridge;

/**
 * 桥接模式 最后将两个变化联系起来 在问题域中是图形使用画图方法 所有应该在Shape中使用Drawing
 * 我们可以通过在具体的图形类中通过构造函数传入具体的画图方法来实现
 * 
 * @author lyq
 * 
 */
public class Test {
	public static void main(String[] args) {
		Shape circle = new Circle(new Drawing2());
		circle.doDraw();
	}
}

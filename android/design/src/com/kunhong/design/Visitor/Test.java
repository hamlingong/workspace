package com.kunhong.design.Visitor;

/**
 * 访问者模式 访问者模式仅应当用于数据结构非常稳定的情况下使用，它把数据结构和作用于数据结构上的操作之间的耦合脱开，使得操作集合可以相对自由地演化。
 * 
 * 数据结构的每一个节点都可以接受一个访问者的调用，此节点向访问者对象传入节点对象，而访问者对象则反过来执行节点对象的操作。这样的过程叫做“双重分派”。
 * 
 * @author lyq
 * 
 */
public class Test {
	public static void main(String[] args) {
		ObjectStructure o = new ObjectStructure(); // 依赖于ObjectStructure
		// 实例化具体元素
		o.attach(new Man());
		o.attach(new Woman());

		// 当成功时不同元素的不同反映
		Visitor success = new Success(); // 依赖于抽象的Visitor接口
		o.display(success);

		// 当恋爱时的不同反映
		Visitor amativeness = new Love(); // 依赖于抽象的Visitor接口
		o.display(amativeness);

	}
}

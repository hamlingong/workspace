package com.kunhong.design.AbstractFactory;

/**
 * 产品等级1的实现类
 * 
 * @author lyq
 * 
 */
public class Creator1 extends AbstractCreator {

	/**
	 * 只产生产品等级为1的A产品
	 */
	public AbstractProductA createProductA() {
		return new ProductA1();
	}

	/**
	 * 只产生产品等级为1的B产品
	 */
	public AbstractProductB createProductB() {
		return new ProductB1();
	}

}

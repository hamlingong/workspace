package com.kunhong.design.AbstractFactory;

/**
 * 产品等级2的实现类
 * 
 * @author lyq
 * 
 */
public class Creator2 extends AbstractCreator {

	/**
	 * 只产生产品等级为2的A产品
	 */
	public AbstractProductA createProductA() {
		return new ProductA2();
	}

	/**
	 * 只产生产品等级为2的B产品
	 */
	public AbstractProductB createProductB() {
		return new ProductB2();
	}

}

package com.kunhong.design.SimpleFactory;

/**
 * 简单工厂模式
 * @author 林意群
 */
public class Test {
	public static void main(String[] args) throws Exception {
        FruitGardener fg=new FruitGardener();
        Fruit ap=fg.factory("Apple");
        ap.grow();
        Fruit gp=fg.factory("Grape");
        gp.plant();
        
        Fruit dd=fg.factory("ddd");//抛出Bad fruit request异常
    }
}

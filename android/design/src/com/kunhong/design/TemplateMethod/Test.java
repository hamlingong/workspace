package com.kunhong.design.TemplateMethod;

/**
 * 模板方法模式 模板方法模式是类的行为模式。准备一个抽象类，将部分逻辑以具体方法以及具体构造函数的形式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑。
 * 不同的子类可以以不同的方式实现这些抽象方法，从而对剩余的逻辑有不同的实现。这就是模板方法模式的用意
 * 
 * @author lyq
 * 
 */
public class Test {
	public static void main(String[] args) {
		Account account = new MoneyMarketAccount();
		System.out.println("货币市场账号的利息数额为：" + account.calculateInterest());
		account = new CDAccount();
		System.out.println("定期账号的利息数额为：" + account.calculateInterest());
	}
}

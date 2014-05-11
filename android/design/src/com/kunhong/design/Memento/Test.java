package com.kunhong.design.Memento;

/**
 * 备忘录模式
 * 备忘录模式 在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样就可以将该对象恢复到原先保存前的状态。 二、 模式解说
 * 在程序运行过程中，某些对象的状态处在转换过程中，可能由于某种原因需要保存此时对象的状态，以便程序运行到某个特定阶段，需要恢复到对象之前处于某个点时的状态。
 * 如果使用一些公有接口让其它对象来得到对象的状态，便会暴露对象的实现细节。
 * 
 * @author lyq
 * 
 */
public class Test {
	public static void main(String[] args) {

		WindowsSystem Winxp = new WindowsSystem(); // Winxp系统
		User user = new User(); // 某一用户
		Winxp.setState("好的状态"); // Winxp处于好的运行状态
		user.saveMemento(Winxp.createMemento()); // 用户对系统进行备份，Winxp系统要产生备份文件
		Winxp.setState("坏的状态"); // Winxp处于不好的运行状态
		Winxp.restoreMemento(user.retrieveMemento()); // 用户发恢复命令，系统进行恢复
		System.out.println("当前系统处于" + Winxp.getState());
	}
}

package com.kunhong.design.ChainOfResponsibility;

/**
 * 责任链模式 责任链模式优点，上面已经体现出来了。无非就是降低了耦合、提高了灵活性。但是责任链模式可能会带来一些额外的性能损耗，因为它要从链子开头开始遍历。
 * 因为无法预知来自外界（客户端）的请求是属于哪种类型，每个类如果碰到它不能处理的请求只要放弃就可以。
 * 缺点是效率低，因为一个请求的完成可能要遍历到最后才可能完成，当然也可以用树的概念优化。
 * 
 * @author lyq
 * 
 */
public class Test {

	public static void main(String[] args) {
		Handler banzhang = new BanZhang("班长");
		Handler laoshi = new BanZhang("老师");
		Handler daoyuan = new DaoYuan("导员");
		Handler xiaozhang = new XiaoZhang("校长");
		banzhang.setNextHandler(laoshi); // 设置班长的下一个处理者是老师
		laoshi.setNextHandler(daoyuan);// 设置老师的下一个处理者是导员
		daoyuan.setNextHandler(xiaozhang);// 设置导员的下一个处理者是校长
		String requests = "退学";

		// 把请求交给班长即可，如果班长处理不了会一层层往上交
		banzhang.handleRequest(requests);
	}
}

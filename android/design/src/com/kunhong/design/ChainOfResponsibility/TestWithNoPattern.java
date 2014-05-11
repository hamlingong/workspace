package com.kunhong.design.ChainOfResponsibility;

/**
 * 传统模式的关系模式处理
 * @author lyq
 *
 */
public class TestWithNoPattern {

	public static void main(String[] args) {
		HandlerWithoutPattern banzhang = new HandlerWithoutPattern("班长");
		HandlerWithoutPattern daoyuan = new HandlerWithoutPattern("导员");
		HandlerWithoutPattern xiaozhang = new HandlerWithoutPattern("校长");
		//将请求给不同的人以便能够得到处理，因为客户程序不知道这些请求具体哪个 
		//人能够处理，于是它便把请求一一的交给处理者 
		banzhang.handleRequest("不去开班会");
		daoyuan.handleRequest("不去开班会");
		xiaozhang.handleRequest("不去开班会");

	}
}

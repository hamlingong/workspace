package com.kunhong.design.ChainOfResponsibility;

/**
 * 传统模式的方法，没使用责任链模式
 * @author lyq
 *
 */
public class HandlerWithoutPattern {
	
	private String name; //处理者的名字 
	public HandlerWithoutPattern(String name) {
		this.name = name;
	}
	public void handleRequest(String request) {
		if ("班长".equals(name)) {
			if ("不去开班会".equals(request)) {
				System.out.println(name + "可以处理" + request + ",给于批准");
			} else {
				System.out.println(name + "不处理" + request + "这种请求");
			}
		} else if ("导员".equals(name)) {
			if ("离校".equals(request)) {
				System.out.println(name + "可以处理" + request + ",给于批准");
			} else {
				System.out.println(name + "不处理" + request + "这种请求");
			}
		} else if ("校长".equals(name)) {
			if ("退学".equals(request)) {
				System.out.println(name + "可以处理" + request + ",给于批准");
			} else {
				System.out.println(name + "不处理" + request + "这种请求");
			}
		} else {
			System.out.println("没有专人可以处理这个请求");
		}
} 

}

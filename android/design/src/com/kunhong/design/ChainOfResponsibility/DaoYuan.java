package com.kunhong.design.ChainOfResponsibility;

public class DaoYuan extends Handler {
	public DaoYuan(String name) {
		this.name = name;
	}

	public void handleRequest(String request) {
		if ("离校".equals(request)) {
			System.out.println(name + "可以处理" + request + "给于批准！");
		} else {
			System.out.println(name + "不可以处理" + request + "转交给"
					+ successor.getName());
			successor.handleRequest(request);
		}
	}
}


package com.kunhong.design.ChainOfResponsibility;

public class XiaoZhang extends Handler {
	public XiaoZhang(String name) {
		this.name = name;
	}

	public void handleRequest(String request) {
		if ("退学".equals(request)) {
			System.out.println(name + "可以处理" + request + "给于批准！");
		} else {
			System.out.println(name + "觉的" + request + "是无理请求，不给于批准");
		}
	}
}
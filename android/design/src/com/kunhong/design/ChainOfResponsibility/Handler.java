package com.kunhong.design.ChainOfResponsibility;

public abstract class Handler {
	protected Handler successor;
	protected String name;

	public String getName() {
		return name;
	}

	//处理请求，由子类完成 
	public abstract void handleRequest(String request);

	//设置下一个处理请求的人 
	public void setNextHandler(Handler successor) {
		this.successor = successor;
	}
}







	



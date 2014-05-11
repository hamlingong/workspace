package com.kunhong.design.Adapter;

/**
 * 适配器模式
 * 测试类 client PS2Port(PS2接口)。 USBPort(USB接口)。 PS2ToUSB(对象适配器)，将PS2接口装换成USB接口。
 * TestAdapter(测试类)，客户端。
 * 适配器模式：将一个接口转换成另外一个接口。
 * 
 * @author lyq
 * 
 */
public class Test {

	public static void main(String[] args) {
		// 1.我现在有一个PS2接口
		PS2Port ps2Port = new PS2Port() {
			@Override
			public void workWithPS2() {
				System.out.println("PS2工作中");
			}
		};

		// 2.但是我需要的是一个USB接口啊,对我(client)来说，我只认识USB接口
		// 3.经过PS2ToUSB的转换，PS2接口变成了USB接口
		USBPort ps2ToUsbPort = new PS2ToUSB(ps2Port);

		ps2ToUsbPort.workWithUSB();

	}

}

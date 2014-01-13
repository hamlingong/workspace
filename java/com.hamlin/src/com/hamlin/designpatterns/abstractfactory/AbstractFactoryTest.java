package com.hamlin.designpatterns.abstractfactory;

public class AbstractFactoryTest {
    public static void test() {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();

        provider = new SendSmsFactory();
        sender = provider.produce();
        sender.send();
    }
}

package com.hamlin.designpatterns.factorymethod;

public class FactoryMethodTest {
    public static void test() {
        Sender sender = SendFactory.produceMail();
        sender.send();
        sender = SendFactory.produceSms();
        sender.send();
    }
}

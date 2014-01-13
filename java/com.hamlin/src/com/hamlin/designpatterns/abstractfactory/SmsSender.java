package com.hamlin.designpatterns.abstractfactory;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("SmsSender.send()!!!");
    }
}

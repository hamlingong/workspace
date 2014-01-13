package com.hamlin.designpatterns.abstractfactory;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("MailSender.send()!!!");
    }
}

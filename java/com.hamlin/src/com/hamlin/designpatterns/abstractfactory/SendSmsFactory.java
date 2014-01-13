package com.hamlin.designpatterns.abstractfactory;

public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

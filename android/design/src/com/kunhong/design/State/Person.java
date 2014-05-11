package com.kunhong.design.State;

public class Person{
    private MoodState state;
    public Person(){
       state = new Mad(this);
    }
    public void setState(MoodState state){
       this.state = state;
    }
    public void doSomething(){
        state.doSomething();
       state.changeState();
    }
}
package com.kunhong.design.State;

public class Happy implements MoodState{
    Person p;
    public Happy(Person p){
       this.p = p;
    }
    public void doSomething(){
       System.out.println("I'm happy!");
    }
    public void changeState(){
       p.setState(new Mad(p));
    }
}
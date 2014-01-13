package com.hamlin.designpatterns.observer;

public class ObserverTest {
    public static void test() {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}

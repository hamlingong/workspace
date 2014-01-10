package com.hamlin.designpatterns.test;

import com.hamlin.designpatterns.observer.MySubject;
import com.hamlin.designpatterns.observer.Observer1;
import com.hamlin.designpatterns.observer.Observer2;
import com.hamlin.designpatterns.observer.Subject;

public class DesignPatternTest {
    public static void observerTest() {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}

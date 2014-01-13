package com.hamlin.tests;

import com.hamlin.designpatterns.abstractfactory.AbstractFactoryTest;
import com.hamlin.designpatterns.factorymethod.FactoryMethodTest;
import com.hamlin.designpatterns.iterator.IteratorTest;
import com.hamlin.designpatterns.observer.ObserverTest;
import com.hamlin.synchronize.SynchronizeTest;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SynchronizeTest.myThreadTest();
        SynchronizeTest.myThread2Test();
        SynchronizeTest.myThread3Test();

        ObserverTest.test();
        IteratorTest.test();
        FactoryMethodTest.test();
        AbstractFactoryTest.test();

    }

}

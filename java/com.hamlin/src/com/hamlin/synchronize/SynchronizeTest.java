package com.hamlin.synchronize;

public class SynchronizeTest {
    public static void myThreadTest() {
        System.out.println("-----------------[myThreadTest: begain]-----------------");
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }

        System.out.println("-----------------[myThreadTest: end]-----------------");
    }

    public static void myThread2Test() {
        System.out.println("-----------------[myThread2Test: begain]-----------------");
        Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread2(sync);
            thread.start();
        }
        System.out.println("-----------------[myThread2Test: end]-----------------");
    }

    public static void myThread3Test() {
        System.out.println("-----------------[myThread3Test: begain]-----------------");
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread3();
            thread.start();
        }
        System.out.println("-----------------[myThread3Test: end]-----------------");
    }
}

package com.hamlin.synchronize;

public class Sync {
    public synchronized void test() {
        System.out.println("test begin...");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test end...");
    }

    public void test2() {
        synchronized (Sync.class) {
            System.out.println("test2 begin...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test2 end...");
        }
    }
}

package com.hamlin.synchronize;

public class MyThread3 extends Thread {
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test2();
    }
}

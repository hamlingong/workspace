package com.hamlin.synchronize;

public class MyThread extends Thread {
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}

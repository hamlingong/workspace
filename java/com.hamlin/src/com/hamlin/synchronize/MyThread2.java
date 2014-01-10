package com.hamlin.synchronize;

public class MyThread2 extends Thread {
    private final Sync sync;
    
    public MyThread2(Sync sync) {
        this.sync = sync;
    }
    
    @Override
    public void run() {
        sync.test();
    }
}

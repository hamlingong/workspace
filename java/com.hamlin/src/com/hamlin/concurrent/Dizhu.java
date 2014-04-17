package com.hamlin.concurrent;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Dizhu {
    public static void test() {
        Changgong worker = new Changgong();
        FutureTask<Integer> jiangong = new FutureTask<Integer>(worker);
        new Thread(jiangong).start();
        while(!jiangong.isDone()){
            try {
                System.out.println("看长工做完了没...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        int amount;
        try {
            amount = jiangong.get();
            System.out.println("工作做完了,上交了"+amount);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

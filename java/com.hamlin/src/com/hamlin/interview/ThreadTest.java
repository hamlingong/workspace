package com.hamlin.interview;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @题目: 开启三个线程, 顺序打印ABC十次。
 *
 */

public class ThreadTest {
    public static void test() {
        new BaseThread().test();
//        new SemaphoreThread().test();
//        new ReentrantLockThread().test();
    }
}

/**
 *
 * @思路: 解题思路大概是这样的，开启三个线程，每个线程一次打印一个字母，并且按照一定的顺序打印，当打印A的时候，其他线程处于阻塞状态，打印完A以后，将线程解锁，让打印B的那个线程开启，
 *       其他线程处于阻塞状态，同理打印C的时候，阻塞其他线程，这三个线程顺序循环，就达到顺序多次打印ABC的目的了。
 *
 * @小结: 在JAVA中，是没有类似于PV操作、进程互斥等相关的方法的。JAVA的进程同步是通过synchronized()来实现的，
 *      需要说明的是，JAVA的synchronized()方法类似于操作系统概念中的互斥内存块，在JAVA中的Object类型中，都是带有一个内存锁的，在有线程获取该内存锁后，其它线程无法访问该内存，
 *      从而实现JAVA中简单的同步、互斥操作。明白这个原理，就能理解为什么synchronized(this)与synchronized(static XXX)的区别了，synchronized就是针对内存区块申请内存锁，
 *      this关键字代表类的一个对象，所以其内存锁是针对相同对象的互斥操作，而static成员属于类专有，其内存空间为该类所有成员共有，这就导致synchronized()对static成员加锁，
 *      相当于对类加锁，也就是在该类的所有成员间实现互斥，在同一时间只有一个线程可访问该类的实例。如果只是简单的想要实现在JAVA中的线程互斥，明白这些基本就已经够了。
 *      但如果需要在线程间相互唤醒的话就需要借助Object.wait(), Object.nofity()了。Obj.wait()，与Obj.notify()必须要与synchronized(Obj)一起使用，也就是wait,与notify是针对已经获取了Obj锁进行操作，
 *      从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内。从功能上来说wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()唤醒该线程，
 *      才能继续获取对象锁，并继续执行。相应的notify()就是对对象锁的唤醒操作。但有一点需要注意的是notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，
 *      自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。这样就提供了在线程间同步、唤醒的操作。Thread.sleep()与Object.wait()二者都可以暂停当前线程，
 *      释放CPU控制权，主要的区别在于Object.wait()在释放CPU同时，释放了对象锁的控制。理解了这些解决这道面试题应该就不成问题了.
 *
 * @参考: http://blog.csdn.net/shinehuaking2011/article/details/8112432
 *       http://blog.csdn.net/liu251/article/details/6227763
 *       http://www.cnblogs.com/icejoywoo/archive/2012/10/15/2724674.html
 *
 *
 * @author hailong
 */
class BaseThread {
    private final Object obj = new Object();
    private static boolean isThreadA = true;
    private static boolean isThreadB = false;
    private static boolean isThreadC = false;

    public void test() {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (obj) {
                    while (!isThreadA) {  // 使用while让进程一直等待
                        try {
                            System.out.println("A::ThreadA.wait()");
                            obj.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A::A");
                    isThreadA = false;
                    isThreadB = true;
                    isThreadC = false;
                    System.out.println("A::ThreadA.notifyAll()");
                    obj.notifyAll();
                }
            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (obj) {
                    while (!isThreadB) {  // 使用while让进程一直等待
                        try {
                            System.out.println("B::ThreadB.wait()");
                            obj.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B::B");
                    isThreadA = false;
                    isThreadB = false;
                    isThreadC = true;
                    System.out.println("B::ThreadB.notifyAll()");
                    obj.notifyAll();
                }
            }
        }
    }

    class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (obj) {
                    while (!isThreadC) {  // 使用while让进程一直等待
                        try {
                            System.out.println("C::ThreadC.wait()");
                            obj.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C::C");
                    isThreadA = true;
                    isThreadB = false;
                    isThreadC = false;
                    System.out.println("C::ThreadC.notifyAll()");
                    obj.notifyAll();
                }
            }
        }
    }
}

class ReentrantLockThread {
    //通过JDK5中的锁来保证线程的访问的互斥
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static boolean isThreadA = true;
    private static boolean isThreadB = false;
    private static boolean isThreadC = false;

    public void test() {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    class ThreadA extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if(!isThreadA) {
                        A.await();
                    }
                    System.out.println("ReentrantLockThread -- A");
                    isThreadA = false;
                    isThreadB = true;
                    isThreadC = false;
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if(!isThreadB) {
                        B.await();
                    }
                    System.out.println("ReentrantLockThread -- B");
                    isThreadA = false;
                    isThreadB = false;
                    isThreadC = true;
                    C.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadC extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if(!isThreadC) {
                        C.await();
                    }
                    System.out.println("ReentrantLockThread -- C");
                    isThreadA = true;
                    isThreadB = false;
                    isThreadC = false;
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class SemaphoreThread {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(1);
    private static Semaphore C = new Semaphore(1);

    public void test() {
        // 开始只有A可以获取, BC都不可以获取, 保证了A最先执行
        try {
            B.acquire();
            C.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    A.acquire();
                    System.out.println("A");
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.println("B");
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    C.acquire();
                    System.out.println("C");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

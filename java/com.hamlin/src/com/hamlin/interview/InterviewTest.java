package com.hamlin.interview;

public class InterviewTest {
    public static void test()  {
        /*
         * 输出: Base method_1
         * 原因: 父类的方法不知道子类的实现
         *
         */
        new Sub().method_2();
    }
}

class Base {
    private void method_1() {
        System.out.print("Base method_1");
    }

    void method_2() {
        method_1();
    }
}

class Sub extends Base {
    void mehtod_1() {
        System.out.print("Sub method_1");
    }
}

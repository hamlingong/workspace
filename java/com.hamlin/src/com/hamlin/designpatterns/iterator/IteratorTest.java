package com.hamlin.designpatterns.iterator;

public class IteratorTest {
    public static void test() {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

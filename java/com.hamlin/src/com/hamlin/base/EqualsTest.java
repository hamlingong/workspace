package com.hamlin.base;

import java.util.HashSet;

/**
 * @desc hashcode 与 equals
 *
 * Java对equals()的要求:
 * 1. 对称性：如果x.equals(y)返回是"true"，那么y.equals(x)也应该返回是"true"。
 * 2. 反射性：x.equals(x)必须返回是"true"。
 * 3. 类推性：如果x.equals(y)返回是"true"，而且y.equals(z)返回是"true"，那么z.equals(x)也应该返回是"true"。
 * 4. 一致性：如果x.equals(y)返回是"true"，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是"true"。
 * 5. 非空性，x.equals(null)，永远返回是"false"；x.equals(和x不同类型的对象)永远返回是"false"。
 *
 * == : 它的作用是判断两个对象的地址是不是相等。即，判断两个对象是不试同一个对象。
 * equals() : 它的作用也是判断两个对象是否相等。但它一般有两种使用情况(前面第1部分已详细介绍过)：
 *  情况1，类没有覆盖equals()方法。则通过equals()比较该类的两个对象时，等价于通过“==”比较这两个对象。
 *  情况2，类覆盖了equals()方法。一般，我们都覆盖equals()方法来两个对象的内容相等；若它们的内容相等，则返回true(即，认为这两个对象相等)。
 *
 * hashCode()的作用
 * hashCode()在散列表中才有用，在其它情况下没用。在散列表中hashCode() 的作用是获取对象的散列码，进而确定该对象在散列表中的位置。
 *
 * @author hamlin
 *
 */

public class EqualsTest {

    public static void test() {
        // 新建2个相同内容的Person对象，
        // 再用equals比较它们是否相等
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        Person p3 = new Person("aaa", 200);
        Person p4 = new Person("EEE", 100);


        // 新建HashSet对象
        HashSet<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        // 比较p1 和 p2， 并打印它们的hashCode()
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        // 打印set
        System.out.printf("set:%s\n", set);

        /**
         * 运行结果:
         * p1.equals(p2) : true; p1(6851700) p2(6851700)
         * set:[(EEE, 100), (eee, 100), (aaa, 200)]
         *
         * 结果分析：
         * 同时覆写equals 与 hashCode方法, HashSet中没有重复元素。
         * 比较p1和p2，我们发现：它们的hashCode()相等，通过equals()比较它们也返回true。所以，p1和p2被视为相等。
         * 比较p1和p4，我们发现：虽然它们的hashCode()相等；但是，通过equals()比较它们返回false。所以，p1和p4被视为不相等。
         *
         * @author hailong
         *
         */
    }
}

/**
 * @desc Person类。
 */
class Person {
    int age;
    String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "("+name + ", " +age+")";
    }

    /**
     * @desc 覆盖equals方法
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person)obj;
        return name.equals(person.name)
                && age == person.age;
    }

    @Override
    public int hashCode() {
        int nameHash = name.toUpperCase().hashCode();
        return nameHash * age;
    }
}

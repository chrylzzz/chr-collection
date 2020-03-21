package com.chryl;

import com.chryl.po.User;

/**
 * hashCode（）与equals（）的相关规定：
 * 如果两个对象相等，则hashcode一定也是相同的
 * 两个对象相等,对两个equals方法返回true
 * 两个对象有相同的hashcode值，它们也不一定是相等的
 * 综上，equals方法被覆盖过，则hashCode方法也必须被覆盖
 * hashCode()的默认行为是对堆上的对象产生独特值。如果没有重写hashCode()，则该class的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）。
 * <p>
 * ==与equals的区别
 * ==是判断两个变量或实例是不是指向同一个内存空间 equals是判断两个变量或实例所指向的内存空间的值是不是相同
 * ==是指对内存地址进行比较 equals()是对字符串的内容进行比较
 * ==指引用是否相同 equals()指的是值是否相同
 * <p>
 * Created by Chryl on 2020/3/20.
 */
public class TestOne {
    public static void main(String[] args) {

        User user = new User();
        User user2 = new User();
        User u3 = user;

        System.out.println(user.equals(user2));
        System.out.println(user.equals(u3));
        System.out.println(u3.hashCode());
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());

    }
}

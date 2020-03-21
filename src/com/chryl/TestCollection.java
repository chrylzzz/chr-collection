package com.chryl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Chryl on 2020/3/20.
 */
public class TestCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(3, "0");
        for (String s : list) {
            System.out.println(s);

        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String join = String.join(",", list);
        System.out.println(join);

    }
}

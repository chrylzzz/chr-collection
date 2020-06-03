package com.chryl.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chr.yl on 2020/6/3.
 *
 * @author Chr.yl
 */
public class SubList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
        System.out.println(list);
//        List<String> subList = (ArrayList) list.subList(3, 6);//注意不可强转为ArrayList ,因为返回的是ArrayList的内部类SubList并不是ArrayList,而是一个ArrayList的视图,对于subList的列表所有操作都会反映到原列表上
        List<String> subList = list.subList(3, 6);
        System.out.println(subList.getClass() + "  " + subList);
        System.out.println(list.getClass() + "  " + list);
    }
}

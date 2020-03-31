package com.chryl.collection;

import java.math.BigDecimal;
import java.util.*;

/**
 * 根据value的值的大小,来获得对应的key
 * Created by Chr.yl on 2020/3/31.
 *
 * @author Chr.yl
 */
public class SortMap {
    public static void main(String[] args) {
        Map<String, BigDecimal> sorMap = new HashMap<>();

        sorMap.put("123", new BigDecimal("184"));
        sorMap.put("129", new BigDecimal("184"));
        sorMap.put("125", new BigDecimal("4"));
        sorMap.put("121", new BigDecimal("164"));
        sorMap.put("126", new BigDecimal("144"));
        sorMap.put("127", new BigDecimal("144"));
        sorMap.put("122", new BigDecimal("154"));
        sorMap.put("122", new BigDecimal("194"));
        sorMap.put("162", new BigDecimal("124"));
        sorMap.put("124", new BigDecimal("114"));
        sorMap.put("122", new BigDecimal("134"));
        sorMap.put("112", new BigDecimal("154"));

        Set<Map.Entry<String, BigDecimal>> entrySet = sorMap.entrySet();
        ArrayList<Map.Entry<String, BigDecimal>> entryArrayList = new ArrayList<>(entrySet);
        //lambda 表达式
//        Collections.sort(entryArrayList, (o1, o2) -> {
//            if (o1.getValue().doubleValue() - o2.getValue().doubleValue() > 0) {
//                return 1;
//            } else if (o1.getValue().doubleValue() - o2.getValue().doubleValue() == 0) {
//                return 0;
//            } else {
//                return 0;
//            }
//        });
        //正序排列
        Collections.sort(entryArrayList, new Comparator<Map.Entry<String, BigDecimal>>() {
            @Override
            public int compare(Map.Entry<String, BigDecimal> o1, Map.Entry<String, BigDecimal> o2) {

                if (o1.getValue().doubleValue() - o2.getValue().doubleValue() > 0) {
                    return 1;
                } else if (o1.getValue().doubleValue() - o2.getValue().doubleValue() == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(entryArrayList);


    }
}

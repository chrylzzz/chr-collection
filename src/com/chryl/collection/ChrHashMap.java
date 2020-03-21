package com.chryl.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chr.yl on 2020/3/21.
 *
 * @author Chr.yl
 */
public class ChrHashMap {
    public static void main(String[] args) {
        Map<String, String> strMap = new HashMap<>(10);
        /**
         * 1.hashMap初始化size算法:|:有1为1,都为0才是0
         * Returns a power of two size for the given target capacity.
         * tableSizeFor(int cap)
         static final int tableSizeFor(int cap) {
         int n = cap - 1;//减1:为了防止cap为16的时候,扩容到32,不必要扩容
         n |= n >>> 1;
         n |= n >>> 2;
         n |= n >>> 4;
         n |= n >>> 8;
         n |= n >>> 16;//右移的目的是把cap-1的值右侧都变成1,值就是最合适2次幂-1,那么n+1不管怎么样都是最近的2次幂,而又是最合适的大小
         return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
         }
         *
         */
        //int 4*8=32
        //00000000 00000000 00000000 00001010  ->10         int n = cap - 1;

        //00000000 00000000 00000000 00001001  ->9          cap - 1;
        //00000000 00000000 00000000 00000100  ->9>>>1      n >>> 1;
        //-------------------------------------
        //00000000 00000000 00000000 00001101  ->9|9>>>1    n|=n >>> 1;
        //00000000 00000000 00000000 00000011  ->           n >>> 2;
        //-------------------------------------
        //00000000 00000000 00000000 00001111  ->           n |= n >>> 2;
        //00000000 00000000 00000000 00000000  ->           n >>> 4
        //-------------------------------------
        //00000000 00000000 00000000 00001111  ->           n |= n >>> 4;
        //直到右侧都为1,那么n+1就是最合适的2次幂值

    }
}

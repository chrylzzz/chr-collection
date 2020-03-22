package com.chryl.collection;

import java.util.*;

import static sun.jvm.hotspot.oops.CellTypeState.value;

/**
 * Created by Chr.yl on 2020/3/21.
 *
 * @author Chr.yl
 */
public class ChrHashMap {

    public static void main(String[] args) {
        /**
         * hashMap详解:
         * 1.
         *  jdk8之前,hashap构造方法创建一个一个长度16的Entry[] table,来存放键值对数据,
         *  之后,不是在hashMap的构造方法底层创建数组了,是在第一次调用put方法是创建(putVal方法详见),Node[] table,依然来存储键值对数据,
         * 2.put:
         *  根据key的string类中重写hashCode()方法计算出值,然后结合数组长度采用某种算法(hash()方法,再取余)算出Node[]数组中存储数据的索引,
         *  put流程
         *  (1)key->hash(key)->(n-1)&hash:如果该位置数据通没有该数据,直接存储,
         *      (2)如果该桶有数据,比较hash值,不一致在此桶下划出一个节点,存储该数据,(该方式为拉链法)
         *      (3)如果hash值一样(发生hash冲突),调用String的equal方法比较内容是否一致
         *          (4)一致:直接覆盖
         *          (5)不一致:继续向该桶中下面的的链表的key进行比较,如果都不相等,划出一个节点存储
         *          如果阈值(0.75)
         */
        HashMap<String, String> strMap = new HashMap<>(10);
        strMap.put("Zzz", "msc");
        strMap.put("Ccc", "cmaa");
        strMap.put("Ppp", "iios");
        /**
         * 1.hashMap初始化resize算法:|:有1为1,都为0才是0
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

        /**
         * 2.hash方法:hashMap的hash算法如何算出hash值得
         static final int hash(Object key) {
         int h;
         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
         }

         底层采用key的hashCode()值方法集合数组长度无符号右移(>>>),按位异或(^),按位与(&)计算出索引
         还可以取余法
         */


        /**
         * 扩容方法:
         * resize()
         * 何时扩容:0.75  链表节点>8 长度
         * 当hashMap,中的一个链表对象个数达到了8个,此时如果素组长度没有达到64,
         * 那么,hashmap会先选择扩容解决,如果已经达到了64,那么链表就会变成红黑树,
         * 节点类型Node变成treeNode,如果下次执行resize方法,判断映射树的节点个数低于6,也会把树转换为链表.
         * 扩容之后:原来的位置被分配到的新位置,要么是'原来的位置',要么是'原位置+旧容量'
         *
         */

        /**
         * get()
         * 1.查看桶中第一个节点:first = tab[(n - 1) & hash]) ,如果hash相等,那么直接返回,
         * 否则,区分是一个红黑树还是一个链表
         * 2.链表使用do-while循环
         * 3.红黑树使用find()方法,红黑树节点大小插入时已经被大小排序了,使用递归方式调用(慢查找).
         */


        /**
         * 遍历方式,4种
         */

//        show(strMap);
//        show2(strMap);
//        show3(strMap);
//        show4(strMap);

        /**
         * 如果hashMap的容量我们已知,那么如何初始化HashMap的构造方法最合适呢:
         * initCap=(需要存储的元素个数/负载因子)+1 ,负载因子默认0.75
         * 小例:比如,我们设置的值为7,经过处理之后,会被设置成8,但是8*0.75=6的时候就会被扩容,
         * 也就是说,7个数据存到第6个的时候就会被扩容,显然不是我们想要看到的
         */

    }


    /**
     * 1.
     * 分别遍历key,value
     */
    public static void show(HashMap<String, String> hm) {
        //获取所有的key
        Set<String> strings = hm.keySet();
        for (String string : strings) {
            System.out.println(string);
        }

        //获得所有的val
        Collection<String> values = hm.values();
        for (String value : values) {
            System.out.println(value);
        }
    }

    /**
     * 2.
     * 迭代器遍历
     */
    public static void show2(HashMap<String, String> hm) {
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Iterator<Map.Entry<String, String>> it = entries.iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }


    /**
     * get方式:不建议使用,效率低
     */
    private static void show3(HashMap<String, String> hm) {

        Set<String> keys = hm.keySet();//第一次迭代器
        for (String key : keys) {
            String val = hm.get(key);//第二次迭代器
            System.out.println(key + "--" + val);
        }
    }

    /**
     * jdk8的Map接口默认方法:
     * default void	forEach(BiConsumer<? super K,? super V> action)
     * 在该映射中的每个条目执行给定的操作，直到所有的条目被处理或操作抛出异常。
     * BiConsumer  void	accept(T t, U u)
     * T:key
     * U:val
     */
    public static void show4(HashMap<String, String> hm) {
        hm.forEach((key, val) -> {
            System.out.println(key + "--" + val);
        });
    }
}

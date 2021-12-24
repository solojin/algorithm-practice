package jinyj.course.linkedList;

import java.util.TreeMap;

// 有序表的使用
public class OrderedTableTest {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        // 1）void put(K key, V value): 将一个（key，value）记录加入到表中，或者根据key将记录更新成value。
        treeMap.put(2, "我是2");
        treeMap.put(5, "我是5");
        treeMap.put(1, "我是1");
        treeMap.put(4, "我是4");

        // 2）V get(K key):根据给定的key，查询value并返回。
        System.out.println(treeMap.get(1)); // 我是1

        // 3）void remove(K key):移除key的记录。
        treeMap.remove(1);
        System.out.println(treeMap.get(1)); // null

        // 4）boolean containsKey(K key):判断是否有关于key的记录。
        System.out.println(treeMap.containsKey(2)); // true

        // 5）K firstKey():返回所有键值的排序结果中，最左（最小）的那个。
        System.out.println("最小：" + treeMap.firstKey()); // 2

        // 6）K lastKey():返回所有键值的排序结果中，最右（最大）的那个。
        System.out.println("最大：" + treeMap.lastKey()); // 5

        // 7）K floorKey(K key):如果表中存入过key，返回key；否则返回所有键值的排序结果中，key的前一个。
        System.out.println(treeMap.floorKey(3)); // 在表中所有<=3的数中，离3最近的数：2
        System.out.println(treeMap.floorKey(4)); // 在表中所有<=4的数中，离4最近的数：4

        // 8）K ceilingKey(K key):如果表中存入过key，返回key；否则返回所有键值的排序结果中，key的后一个。
        System.out.println("" + treeMap.ceilingKey(3)); // 在表中所有>=3的数中，离3最近的数：4
        System.out.println("" + treeMap.ceilingKey(4)); // 在表中所有>=4的数中，离4最近的数：4
    }
}

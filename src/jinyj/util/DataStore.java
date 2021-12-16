package jinyj.util;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    // 随机获取10个整数
    public static Integer[] getData() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            double d = Math.random();
            list.add((int)(d*10));
        }
        Integer[] arrays = new Integer[list.size()];
        list.toArray(arrays);
        return arrays;
    }

    // 数组中两数交换
    public static void swap(Integer[] array, int i, int j) {
        if(array != null && i < array.length && j< array.length) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

//    public static void swap(Integer[] array, int i, int j) {
//        if(array != null && i < array.length && j< array.length && i != j) {
//            array[i] = array[i] ^ array[j];
//            array[j] = array[i] ^ array[j];
//            array[i] = array[i] ^ array[j];
//        }
//    }

    public static Integer[] getBigData() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++) {
            double d = Math.random();
            list.add((int)(d*100));
        }
        Integer[] arrays = new Integer[list.size()];
        list.toArray(arrays);
        return arrays;
    }

}

package jinyj.util;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public static Integer[] getLittleData() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            double d = Math.random();
            list.add((int)(d*10));
        }
        Integer[] arrays = new Integer[list.size()];
        list.toArray(arrays);
        return arrays;
    }

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

    public static void swap(Integer[] array, int i, int j) {
        if(array != null && i < array.length && j< array.length && i != j) {
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
    }
}

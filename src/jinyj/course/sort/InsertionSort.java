package jinyj.course.sort;

import jinyj.util.DataStore;

// 插入排序
public class InsertionSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getData();
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        InsertionSort.sort(arr);
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i] + " ";
        }
        System.out.println("排序后：" + res);
    }

    // 插入排序
    public static void sort(Integer[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[j+1]) {
                    DataStore.swap(arr, j, j+1);
                }
            }
        }
    }
}

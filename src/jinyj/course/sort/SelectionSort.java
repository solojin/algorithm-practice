package jinyj.course.sort;

import jinyj.util.DataStore;

// 选择排序
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getData();
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        SelectionSort.sort(arr);
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i] + " ";
        }
        System.out.println("排序后：" + res);
    }

    // 选择排序
    public static void sort(Integer[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    DataStore.swap(arr, i, j);
                }
            }
        }
    }
}

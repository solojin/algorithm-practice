package jinyj.course.sort;

import jinyj.util.DataStore;

// 冒泡
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] arr = DataStore.getData();
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        BubbleSort.sort(arr);
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i] + " ";
        }
        System.out.println("排序后：" + res);
    }

    // 冒泡排序
    public static void sort(Integer[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    DataStore.swap(arr, j, j+1);
                }
            }
        }
    }
}

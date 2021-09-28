package jinyj.course.sort;

import jinyj.util.DataStore;

public class SelectionSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getSmallData();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("sort");
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i+1; j <= arr.length - 1; j++) {
                if(arr[i] > arr[j]) {
                    DataStore.swap(arr, i, j);
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

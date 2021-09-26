package jinyj.course.sort;

import jinyj.util.DataStore;

public class insertionSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getLittleData();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("sort");
        for(int i = 1; i < arr.length - 1; i++) {
            for(int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--) {
                DataStore.swap(arr, j, j+1);
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

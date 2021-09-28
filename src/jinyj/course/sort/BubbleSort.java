package jinyj.course.sort;

import jinyj.util.DataStore;

public class BubbleSort {
    public static void main(String[] args) {
        Integer[] arr = DataStore.getSmallData();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("sort");
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    DataStore.swap(arr, j, j+1);
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

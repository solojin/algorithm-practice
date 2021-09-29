package jinyj.course.sort;

import jinyj.util.DataStore;

public class HeapSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getSmallData();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("sort");
        for(int i = 0; i < arr.length; i++) {
            HeapSort.headInsert(arr, i);
        }
        int headSize = arr.length - 1;
        while(headSize > 0) {
            DataStore.swap(arr, 0, headSize);
            HeapSort.headIfy(arr, 0, headSize--);
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void headInsert(Integer[] arr, int i) {
        if(i >= 0) {
            while(arr[i] > arr[(i - 1) / 2]) {
                DataStore.swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    public static void headIfy(Integer[] arr, int i, int headSize) {
        if(i >= 0) {
            while((2 * i + 1) <= headSize) {
                int l = 2 * i + 1;
                int r = 2 * i + 2;
                int large = r <= headSize && arr[r] > arr[l] ? r : l;
                large = arr[large] > arr[i] ? large : i;
                if(large == i) {
                   return;
                }
                DataStore.swap(arr, i, large);
                i = large;
            }
        }
    }
}

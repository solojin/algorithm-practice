package jinyj.course.sort;

import jinyj.util.DataStore;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getSmallData();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("sort");
        MergeSort.process(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void process(Integer[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(Integer[] arr, int L, int M, int R) {
        Integer[] help = new Integer[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        while(p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= M) {
            help[i++] = arr[p1++];
        }
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}

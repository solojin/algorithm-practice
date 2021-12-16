package jinyj.course.sort;

import jinyj.util.DataStore;

// 快排
public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getData();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("sort");
        QuickSort.quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(Integer[] arr, int L, int R) {
        if(L < R) {
            DataStore.swap(arr, L + (int)Math.random()*(R - L + 1), R);
            Integer[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static Integer[] partition(Integer[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        int i = L;
        while(i < more) {
            if(arr[i] < arr[R]) {
                DataStore.swap(arr, ++less, i++);
            }
            else if(arr[i] > arr[R]) {
                DataStore.swap(arr, i, --more);
            } else {
                i++;
            }
        }
        DataStore.swap(arr, more, R);
        Integer[] res = {less + 1, more};
        return res;
    }
}

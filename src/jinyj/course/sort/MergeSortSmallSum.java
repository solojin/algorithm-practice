package jinyj.course.sort;

import jinyj.util.DataStore;
//TODO 对照视频，未得到预期的小和值
public class MergeSortSmallSum {

    public static void main(String[] args) {
//        Integer[] arr = DataStore.getSmallData();
//        Integer[] arr = {1,3,4,2,5};
        Integer[] arr = {1,3,4,2};
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("sort");
        Integer res = MergeSortSmallSum.process(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("smallSum");
        System.out.println(res);
    }

    public static Integer process(Integer[] arr, int L, int R) {
        if(L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
        return process(arr, L, mid)
                + process(arr, mid + 1, R)
                + merge(arr, L, mid, R);
    }

    public static Integer merge(Integer[] arr, int L, int M, int R) {
        Integer[] help = new Integer[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        int res = 0;
        while(p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return res;
    }
}

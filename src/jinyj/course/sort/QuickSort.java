package jinyj.course.sort;

import jinyj.util.DataStore;

// 快速排序
public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getData();
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        QuickSort.quickSort(arr, 0, arr.length - 1);
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i] + " ";
        }
        System.out.println("排序后：" + res);
    }

    // 快速排序
    public static void quickSort(Integer[] arr, int L, int R) {
        if(L < R) {
            // 随机选取一个基准值，将区间最后一个值与基准值交换位置
            DataStore.swap(arr, L + (int)Math.random()*(R - L + 1), R);
            Integer[] p = partition(arr, L, R);
            // 小于区域
            quickSort(arr, L, p[0] - 1);
            // 大于区域
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static Integer[] partition(Integer[] arr, int L, int R) {
        // "小于区域"的边界
        int lessBorder = L - 1;
        // "大于区域"的边界（本来"大于区域"的边界应该是R+1,但R位上已被基准值占据，所以"大于区域"边界是R)
        int moreBorder = R;
        // 当前位置
        int i = L;
        // 如果当前位置等于"大于区域"的边界，则说明整个区间的数已被遍历完
        while(i < moreBorder) {
            // arr[R]表示基准值
            // 如果当前位置的值小于基准值，则"小于区域"的下一个值与当前位置值交换，并且"小于区域"边界向右移一位，当前位置i自增一位
            if(arr[i] < arr[R]) {
                DataStore.swap(arr, ++lessBorder, i++);
            }
            // 如果当前位置的值大于基准值，则"大于区域"的前一个值与当前位置值交换，并且"大于区域"边界向左移一位，当前位置i不变
            else if(arr[i] > arr[R]) {
                DataStore.swap(arr, --moreBorder, i);
            }
            // 如果当前位置的值等于基准值，什么都不做，当前位置i自增一位
            else {
                i++;
            }
        }
        // 当前基准值在区间最后一个位，将基准值与"大于区域"首位交换，区间变得整体有序
        DataStore.swap(arr, moreBorder, R);
        // 返回"等于区域"的左右边界索引
        Integer[] res = {lessBorder + 1, moreBorder};
        return res;
    }

}

package jinyj.course.sort;

import jinyj.util.DataStore;

// 计数排序
public class CountSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getData();
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        int[] sortArr = CountSort.sort(arr);
        String res = "";
        for(int i = 0; i < sortArr.length; i++) {
            res += sortArr[i] + " ";
        }
        System.out.println("排序后：" + res);
    }

    // 计数排序
    public static int[] sort(Integer[] arr) {
        int max = CountSort.getMaxAndMin(arr);
        return CountSort.count(arr, max);
    }

    // 获取数组中最大值
    public static int getMaxAndMin(Integer[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
               max = arr[i];
            }
        }
        return max;
    }

    // 计数出现频次，并累加计数得到排序索引
    public static int[] count(Integer[] arr, int max) {
        // 计数数组，容量大小为原数组的最大值+1，每个位置上的值已被默认初始化为0
        int[] countArr = new int[max + 1];
        // 辅助数组，存放排序后的数组值
        int[] helpArr = new int[arr.length];
        // 遍历原数组，给计数数组对应位置数值+1，得到每个数出现的次数
        for(int i = 0; i < arr.length; i++) {
            countArr[arr[i]] += 1;
        }
        // 对计数数组做累加和，累加和的结果，其实就是排序后的位置索引
        for(int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        // 遍历原数组，将累加和的结果作为新数组的位置索引，依次将值赋值到新数组
        // 每取出一个值，就在计数数组对应位置-1
        for(int i =  0; i < arr.length; i++) {
            helpArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }
        return helpArr;
    }
}

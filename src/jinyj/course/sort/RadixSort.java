package jinyj.course.sort;

// 基数排序
public class RadixSort {

    public static void main(String[] args) {
        Integer[] arr = {97, 45, 124, 61};
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        int[] sortArr = RadixSort.sort(arr);
        String res = "";
        for(int i = 0; i < sortArr.length; i++) {
            res += sortArr[i] + " ";
        }
        System.out.println("排序后：" + res);
    }

    // 基数排序
    public static int[] sort(Integer[] arr) {
        // 最大值位数
        int maxDigit = RadixSort.getMaxDigit(arr);
        // 辅助数组，存放排序后的数组
        int[] helpArr = new int[arr.length];
        for(int i = 0; i < maxDigit; i++) {
            // 计数数组，范围0-9位
            int[] bucket = new int[10];
            // 遍历原数组的当前位数值，给计数数组对应位置上数值+1
            for(int j = 0; j < arr.length; j++) {
                int val = RadixSort.getDigitVal(arr[j], i);
                bucket[val] += 1;
            }
            // 计数数组前缀和，前缀和就是排序后的位置索引
            for(int j = 1; j < bucket.length; j++) {
                bucket[j] += bucket[j - 1];
            }
            // 遍历原数组，将前缀和的结果作为辅助数组的位置索引，依次将值赋值到辅助数组，并且，每取出一个值，就在计数数组对应位置-1
            for(int j = 0; j < arr.length; j++) {
                int val = RadixSort.getDigitVal(arr[j], i);
                helpArr[bucket[val] - 1] = arr[j];
                bucket[val]--;
            }
            for(int j = 0; j < arr.length; j++) {
                arr[arr.length - j - 1] = helpArr[j];
            }
        }
        return helpArr;
    }

    // 获取数组中最大值位数
    public static int getMaxDigit(Integer[] arr) {
        int max = 0;
        int maxDigit = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        while(max / 10 != 0) {
            ++maxDigit;
            max /= 10;
        }
        return maxDigit;
    }

    // 获取指定位数上的值
    public static int getDigitVal(int num, int digit) {
        return (int)(num / Math.pow(10, digit)) % 10;
    }
}

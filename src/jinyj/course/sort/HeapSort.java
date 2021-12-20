package jinyj.course.sort;

import jinyj.util.DataStore;

// 堆排
public class HeapSort {

    public static void main(String[] args) {
        Integer[] arr = DataStore.getData();
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        HeapSort.sort(arr);
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i] + " ";
        }
        System.out.println("排序后：" + res);
    }

    // 堆排
    public static void sort(Integer[] arr) {
        // 将数组转化为大根堆
        for(int i = 0; i < arr.length; i++) {
            HeapSort.headInsert(arr, i);
        }
        // 堆容量
        int headSize = arr.length - 1;
        while(headSize > 0) {
            // 取出最大值，即将堆的根节点与最后一个堆值交换，并让堆容量-1
            DataStore.swap(arr, 0, headSize);
            headSize = headSize - 1;
            // 调整堆顺序为大根堆
            HeapSort.headIfy(arr, 0, headSize);
        }
    }

    // 向堆中插入新值
    public static void headInsert(Integer[] arr, int i) {
        if(i >= 0) {
            // 堆结构固定，arr[(i - 1) / 2]得到的是父节点
            // 如果当前位置比父节点大，则与父节点交换值，并把当前位置i指向父节点
            // 循环这一过程，直到当前位置的值不比父节点大，或者当前位置已到堆顶
            while(arr[i] > arr[(i - 1) / 2]) {
                DataStore.swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    // 调整堆顺序为大根堆
    public static void headIfy(Integer[] arr, int i, int headSize) {
        if(i >= 0) {
            // 堆结构固定，(2 * i + 1) 得到的是左子节点
            // 左子节点小于等于堆容量时，即当前位置仍然有子节点时，继续循环
            while((2 * i + 1) <= headSize) {
                // 左子节点
                int l = 2 * i + 1;
                // 堆结构固定，(2 * i + 2) 得到的是右子节点
                int r = 2 * i + 2;
                // 获取左右节点中的最大值
                int large = r <= headSize && arr[r] > arr[l] ? r : l;
                // 获取当前节点与左右子节点间的最大值
                large = arr[large] > arr[i] ? large : i;
                // 当最大值就是当前位置，说明已经是大根堆，跳出循环
                if(large == i) {
                   return;
                }
                // 当前位置的值与最大值交换
                DataStore.swap(arr, i, large);
                // 当前位置指向最大值节点
                i = large;
            }
        }
    }
}

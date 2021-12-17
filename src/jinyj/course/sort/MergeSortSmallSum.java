package jinyj.course.sort;

// 归并法求小和
public class MergeSortSmallSum {

    public static void main(String[] args) {
        // 小和值：2 + 1 + 2 + 1 = 6
        Integer[] arr = {2,1,4,3};
        String source = "";
        for(int i = 0; i < arr.length; i++) {
            source += arr[i] + " ";
        }
        System.out.println("原数组：" + source);
        Integer smallSum = MergeSortSmallSum.process(arr, 0, arr.length - 1);
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i] + " ";
        }
        System.out.println("排序后：" + res);
        System.out.println("小和：" + smallSum);
    }

    // 二分后归并
    public static Integer process(Integer[] arr, int L, int R) {
        if(L == R) {
            return 0;
        }
        // 等价于L +（R - L）/ 2
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid)
                + process(arr, mid + 1, R)
                + merge(arr, L, mid, R);
    }

    // 归并，并计算小和
    public static Integer merge(Integer[] arr, int L, int M, int R) {
        // 辅助数组，用于存放R - L区间排序后的值
        Integer[] help = new Integer[R - L + 1];
        // 辅助数组当前位置
        int i = 0;
        // 左区间当前位置
        int p1 = L;
        // 右区间当前位置
        int p2 = M+1;
        int res = 0;
        while(p1 <= M && p2 <= R) {
            // 求小和等效于，把数组中每一个数自身累加，累加的次数为右边比它大的数的个数
            // 右区间已排好序，所以当arr[p1]比arr[p2]小时，右区间的数比arr[p1]大的个数是（R-p2+1）
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            // arr[p1]和arr[p2]对比大小，小值放入辅助数组，并自身索引加1
            // 与经典merge过程不一样的地方，这里arr[p1] == arr[p2]时，先拷贝arr[p2]进辅助数组，
            // 因为这样才能保证arr[p1]比arr[p2]小时，（R-p2+1）一定是右区间的数比arr[p1]大的个数
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 补充，考虑p2已放完，p1未放完的情况
        while(p1 <= M) {
            help[i++] = arr[p1++];
        }
        // 补充，考虑p1已放完，p2未放完的情况
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
}

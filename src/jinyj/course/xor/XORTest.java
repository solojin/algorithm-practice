package jinyj.course.xor;

import jinyj.util.DataStore;

import java.sql.Array;

public class XORTest {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 6, 5, 7, 1, 3};
        XORTest.test(arr);
    }

    public static void test(int[] arr) {
        // 全部数依次异或
        int eor = 0;
        for(int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // 提取最右的1，常用操作
        int rightone = eor & (~eor + 1);
        int onlyone = 0;
        // 全部数依次和rightone做与运算
        for(int i = 0; i < arr.length; i++) {
            // 将数分为两类，与rightone与运算后等于0的为一类
            if((rightone & arr[i]) == 0) {
                onlyone ^= arr[i];
            }
        }
        System.out.println("其中一个数：" + onlyone);
        System.out.println("另外一个数：" + (onlyone ^ eor));
    }
}


package jinyj.course.xor;

import jinyj.util.DataStore;

public class XORTest {

    public static void main(String[] args) {
        XORTest.test();

    }

    public static void test() {
        int a = 10;
        // 提取最后的1
        int rightone = a & (~a + 1);
        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(~a));
//        System.out.println(Integer.toBinaryString(~a + 1));
        System.out.println(Integer.toBinaryString(rightone));

        int cur = 8;
        int onlyone = rightone & cur;
        System.out.println(Integer.toBinaryString(cur));
        System.out.println(Integer.toBinaryString(onlyone));
    }
}


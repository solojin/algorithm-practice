package jinyj;

import jinyj.util.DataStore;

public class Main {

    public static void main(String[] args) {
        Integer[] res = DataStore.getBigData();
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

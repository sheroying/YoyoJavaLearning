package com.yoyo.test.algorithm.basic;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        int [] array = {1,2,4,0,5,6,0,1,8, 1,2};
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : array) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) +1);
                System.out.println("found out key i, value +1");;
            } else{
                map.put(i, 1);
            }
        }
        int number = 2; //定义number 前n个；
        Object[] valueList = (Object[]) map.values().toArray();
        for(int i = 0; i< valueList.length; i++) {
            for(int j = 0; j < valueList.length -i -1; j++) {
                int aa = (int) valueList[j];
                int bb = (int) valueList[j + 1];
                if (aa < bb) {
                    int temp = (int) valueList[j];
                    valueList[j] = valueList[j + 1];
                    valueList[j + 1] = temp;
                }
            }
        }
        Object[] num = Arrays.copyOf(valueList, number);

        map.forEach((k, v) -> {     // lamda 表达式 遍历所有的k v

            System.out.println("k is " + k + " v is " + v + " number is " + (int) num[num.length - 1]);
            if (v >= (int) num[num.length - 1]) {

//                System.out.println ("num[num.length-1]" + num[num.length-1]);
                System.out.println("most duplicated word " + k + " duplicated number is " + v);
            }
        });
    }
}

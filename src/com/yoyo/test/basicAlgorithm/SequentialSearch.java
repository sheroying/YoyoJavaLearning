package com.yoyo.test.basicAlgorithm;

import java.util.ArrayList;
import java.util.List;

//顺序查找,又称线性查找 https://zhuanlan.zhihu.com/p/319165422
public class SequentialSearch {
    public static void main(String[] args) {
        int[] aa = {1,3,5,2,7,0,6,6,8,9};
//        System.out.println(findMin(aa));

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(0);
        arrayList.add(6);
        arrayList.add(6);
        arrayList.add(8);
        arrayList.add(9);

//        int[] result = findSmallestValues(arrayList, 5);
        for( int i : findSmallestValues(arrayList, 5)) {
            System.out.println(i);
        }

    }

    //一次循环找到数组里面最大/小值，不用排序
    public static int findMin(int[] array) {
        int minValue = array[0];
        for(int i=0; i< array.length-1; i++) {
            minValue = minValue <= array[i] ? minValue : array[i];
        }
        return minValue;
    }

    //一次循环找到数组里面前N个最大/小值，不用排序
    public static int[] findSmallestValues(List<Integer> arrayList, int number) {
        int[] result = new int[number];
        for (int i =0; i< number; i++) {
            int[] aa = arrayList.stream().mapToInt(Integer::valueOf).toArray();
//            System.out.println("aa length" + aa.length);
            result[i] = findMin(aa);
//            System.out.println("result[i] " + result[i]);

//            System.out.println(arrayList.size());
            arrayList.remove(Integer.valueOf(result[i]));
//            System.out.println(arrayList.size());
        }
        return  result;
    }

//    public static int findMin(int[] array) {
//        Object aa = array[0];
//        int minValue  = (Integer) aa;
//        for(int i=0; i< array.size()-1; i++) {
//            int currentValue = (int)array.get(i);
//            minValue = minValue <= currentValue ? minValue : currentValue;
//        }
//        return minValue;
//    }
}

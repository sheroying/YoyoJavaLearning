package com.yoyo.test.algorithmProblem;

import java.util.ArrayList;
import java.util.List;

public class ArrayFindMissingNum {

    /**
     * 小红书面试 1. 排除数组中不存在的数字，比如1-100个数，随机放到int [99] 这样的数组中，找到哪个数字没有出现在数组中
     * @param args
     */
    public static void main(String[] args) {
        // 丢失一个数 57
        int[] aa = new int[99];
        for(int i =0; i<56; i++) {
            aa[i] = i+1;
        }
        for(int i = 56; i<99; i++) {
            aa[i] = i+2;
        }
        System.out.println(findMissingNum(aa));

        //丢失多个数 51, 52
        List<Integer> cc = new ArrayList<>();
        for(int i =0; i<98; i++) {
            if(i == 50) {
                cc.add(i+2);
            } else if(i == 51) {
                cc.add(i+2);
            } else{
                cc.add(i+1);
            }
        }

        int[] dd = cc.stream().mapToInt(Integer::valueOf).toArray();
        for(int i : findMissingNums(dd)) {
            System.out.println(i);
        }

    }

    public static int[] sort(int[] array) {
//        Arrays.stream(array).sorted();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length -1-i; j++) {
                if(array[j] > array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }
    /**
     * 1到100 相加，
     * @param array
     * @return
     */
    public static int findMissingNum(int[] array) {
        int sum1 =0;
        for(int i: array){
            sum1 = sum1 + i;
        }

        int sum2 = 0;
        for(int i = 1; i<101;i++) {
            sum2 = sum2 + i;
        }

        return sum2 - sum1;
    }

    public static int[] findMissingNums(int[] array) {
        int[] result = new int[100-array.length];
        int k =0;
        for(int i = 1; i<array.length; i++) {
            if(array[i] - array[i-1] != 1) {
                result[k] = array[i-1] + array[i] - array[i-1]-1;
                k++;
            }
        }
        return result;
    }
}

package com.yoyo.test.algorithm.basic.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//选择排序，给一个乱序数组，依次找出最大值 和第一位交换，倒数第二大（未排序数组中的最大的数）跟第二位交换，依次交换到末尾即刻，即可排序好， 基于顺序查找实现的
public class SelectSort {

    public static void main(String[] args) {

        int[] aa = {1, 4, 6, 3, 9, 0, 2, 7, 8, 9, 4};
        int[] result = sort(aa);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            /**
             int[] temp = findMaxNumberAndIndex(array, i);
             int maxNumber = temp[0];
             int maxNumberIndex = temp[1];
             System.out.println("max number is " + maxNumber + " max number index is " + maxNumberIndex);
             */

            int startIndex = i;

            //Find max value and value index
            int maxNumber = array[startIndex];
            int maxNumIndex = startIndex;
            for (int j = startIndex; j < array.length; j++) {
                if (maxNumber < array[j]) {
                    maxNumber = array[j];
                    maxNumIndex = j;
                }
            }
            System.out.println("The " + i + " loop, max number is " + maxNumber + " max number index is " + maxNumIndex);
            swap(array, i, maxNumIndex);
        }

        return array;
    }

    public static int[] findMaxNumberAndIndex(int[] array, int startIndex) {
        int[] maxValueAndIndex = new int[2];
        int max = array[startIndex];
        int maxVIndex = startIndex;
        for (int i = startIndex; i < array.length; i++) {
            if (max < array[i]) {
                {
                    max = array[i];
                    maxVIndex = i;
                }
            }
        }

        maxValueAndIndex[0] = max;
        maxValueAndIndex[1] = maxVIndex;
        return maxValueAndIndex;
    }

    public static int[] swap(int[] array, int indexI, int indexJ) {
        int temp = array[indexI];
        array[indexI] = array[indexJ];
        array[indexJ] = temp;
        return array;
    }

}
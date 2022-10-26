package com.yoyo.test.algorithm.basic.sort;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {1, 4, 6, 2, 90, 45, 12, 8};

        QuickSort.quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + ",");
        }

    }

    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (rightIndex <= leftIndex) {
            return;
        }
        System.out.println("leftIndex = " + leftIndex + " rightIndex = " + rightIndex);

        int partitionIndex = partitionAndGetIndex(array, leftIndex, rightIndex); //创建分隔板，并返回分隔板的index
        System.out.println("partitionIndex = " + partitionIndex);

        quickSort(array, leftIndex, partitionIndex - 1); //对左边part 进行递归排序
        quickSort(array, partitionIndex + 1, rightIndex); //对右边part 进行递归排序
    }

    public static int partitionAndGetIndex(int[] array, int leftIndex, int rightIndex) {
//        int pIndex = rightIndex;
        int pIndex = leftIndex + new Random().nextInt(rightIndex - leftIndex); //随机生成一个你分隔板index值

        System.out.println("pIndex = " + pIndex);

        swap(array, pIndex, rightIndex); //将分隔板与最右边的值交换

        int i = leftIndex;
        for (int j = leftIndex; j < rightIndex; j++) {
            if (array[j] <= array[rightIndex]) { // 若左边第一位小于分隔板的值，则交换，将小的排在前面，大的排在后面
                //System.out.println("leftValue is " + i + "  value " + array[i] + "; rightValue is " + j + " value is " + array[j]);
                swap(array, i, j);
                //System.out.println("leftValue is " + i + "  value " + array[i] + "; rightValue is " + j + " value is " + array[j]);
                i++;
            }
        }

        System.out.println("i = " + i);
        swap(array, i, rightIndex);  //将分隔板与最右边的值交换回来

        System.out.print("array = ");
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + ",");
        }
        System.out.println();

        return i;
    }

    public static void swap(int[] array, int leftValue, int rightValue) {
        int temp = array[leftValue];
        array[leftValue] = array[rightValue];
        array[rightValue] = temp;
    }
}

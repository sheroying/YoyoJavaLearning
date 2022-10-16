package com.yoyo.test.basicAlgorithm;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = { 1,4,6,2,90,45,12,8};

        QuickSort.quickSort(array, 0, array.length - 1 );

        for( int i = 0; i< array.length ; i++) {
            System.out.println( array[i] + ",");
        }

    }
    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (rightIndex <= leftIndex) {
            return;
        }

        System.out.println("leftIndex = " + leftIndex + " rightIndex = " + rightIndex);
        int partitionIndex = partitionAndGetIndex(array, leftIndex, rightIndex);
        System.out.println("partitionIndex = " + partitionIndex);
        quickSort(array, leftIndex, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, rightIndex);
    }
    public static int partitionAndGetIndex(int[] array, int leftIndex, int rightIndex) {
//        int pIndex = rightIndex;
        int pIndex = leftIndex + new Random().nextInt(rightIndex - leftIndex);

        System.out.println("pIndex = " + pIndex);

        swap(array, pIndex, rightIndex);
        int i = leftIndex;
        for (int j = leftIndex; j < rightIndex; j++) {
            if (array[j] <= array[rightIndex]) {
                //System.out.println("leftValue is " + i + "  value " + array[i] + "; rightValue is " + j + " value is " + array[j]);
                swap(array, i, j);
                //System.out.println("leftValue is " + i + "  value " + array[i] + "; rightValue is " + j + " value is " + array[j]);
                i++;
            }
        }

        System.out.println("i = " + i);
        swap(array, i, rightIndex);

        System.out.print("array = ");
        for (int k = 0;k < array.length;k++){
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

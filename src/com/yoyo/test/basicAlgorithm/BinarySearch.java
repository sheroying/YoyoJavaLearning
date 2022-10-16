package com.yoyo.test.basicAlgorithm;

//二分查找，已排好序的数组，取一半进行查找，使用递归查找

/**
 * 给一个int数组, 查找一个数是否存在，若存在，返回true 并返回位置信息，若不存在返回false
 */
public class BinarySearch {
    public static void main(String[] args) {

        int[] aa = {1, 4, 6, 3, 9, 0, 2, 7, 8, 10, 5};

        int[] bb = {0,1,2,4,5,6,7,8,10};
        sort(bb, 12);
    }

    public static void sort(int[] array, int targetNumber) {
        //先从小到大排序
        bubbleSort(array);
        //施行二分查找
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int resultIndex = binarySearch(array, leftIndex, rightIndex, targetNumber);
        System.out.println("Find out the target number, and index is " + resultIndex);
    }

    public static int binarySearch(int[] array, int leftIndex, int rightIndex, int targetNumber) {
//        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        int middleIndex = (rightIndex + leftIndex) / 2;

        if (leftIndex > rightIndex) {
            return -1;
        }

        if (array[middleIndex] == targetNumber) {
            return middleIndex;
        } else if (array[middleIndex] > targetNumber) {
            return binarySearch(array, leftIndex, middleIndex-1, targetNumber);
        } else {
            return binarySearch(array, middleIndex + 1, rightIndex, targetNumber);
        }


    }

    //从小到大排序
    public static void bubbleSort(int[] originalList) {

        for (int i = 0; i < originalList.length - 1; i++) {
            for (int j = 0; j < originalList.length - i - 1; j++) {
                if (originalList[j] > originalList[j + 1]) {
                    int temp = originalList[j];
                    originalList[j] = originalList[j + 1];
                    originalList[j + 1] = temp;
//                    System.out.println("after: originalList[j] = " + originalList[j] + " originalList[i] = " + originalList[i]);

                }
            }
        }
    }
}

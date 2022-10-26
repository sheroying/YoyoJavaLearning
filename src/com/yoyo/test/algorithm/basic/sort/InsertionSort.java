package com.yoyo.test.algorithm.basic.sort;

/**
 * https://www.runoob.com/data-structures/insertion-sort.html
 *
 *
 * <p>
 * 对于少量元素的排序，它是一个有效的算法。插入排序是一种最简单的排序方法，它的基本思想是将一个记录插入到已经排好序的有序表中，从而一个新的、记录数增 1 的有序表
 * 。在其实现过程使用双层循环，外层循环对除了第一个元素之外的所有元素，内层循环对当前元素前面有序表进行待插入位置查找，并进行移动。
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] aa = {7, 6, 9, 3, 1, 5, 2, 4, 0, 19, 23};
        insertionSort(aa);
        for (int i : aa) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 2; j > 0; j--) {
                if (array[j] > array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

package com.yoyo.test.algorithm.basic.search;

//二分查找，已排好序的数组，取一半进行查找，使用递归查找

/**
 * 七大查找之二分查找 https://blog.csdn.net/fuyuyf/article/details/126183988
 * 七大查找   https://blog.csdn.net/weixin_39241397/article/details/79344179?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-79344179-blog-126183988.pc_relevant_aa_2&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-79344179-blog-126183988.pc_relevant_aa_2&utm_relevant_index=1
 * 给一个有序的int数组, 查找一个数是否存在，若存在，返回true 并返回位置信息，若不存在返回false
 */
public class BinarySearch {
    public static void main(String[] args) {
//        二分查找必须是查找有序的数组， 若不是，需先进行排序，但是原始数组的元素index会丢失
//        int[] aa = {1, 4, 6, 3, 9, 0, 2, 7, 8, 10, 5};

        int[] bb = {0, 1, 2, 4, 5, 6, 7, 8, 10};

        //递归施行 二分查找
        int leftIndex = 0;
        int rightIndex = bb.length - 1;
        int resultIndex = binarySearchViaRecursion(bb, leftIndex, rightIndex, 8);
        System.out.println("Find out the target number via recursion, and index is " + resultIndex);

        //循环施行二分查找
        int result = binarySearchViaCycle(bb, 8);
        System.out.println("Find out the target number via cycle, and index is " + result);
    }


    public static int binarySearchViaRecursion(int[] array, int leftIndex, int rightIndex, int targetNumber) {

        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
//        int middleIndex = (rightIndex + leftIndex) / 2;

        if (leftIndex > rightIndex) {
            return -1; // mark -1 means didn't find the result, 退出循环的条件
        }

        if (array[middleIndex] == targetNumber) {
            return middleIndex;
        } else if (array[middleIndex] > targetNumber) {
            return binarySearchViaRecursion(array, leftIndex, middleIndex - 1, targetNumber);
        } else {
            return binarySearchViaRecursion(array, middleIndex + 1, rightIndex, targetNumber);
        }

    }

    //从小到大排序
    public static int binarySearchViaCycle(int[] array, int targetNumber) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (array[middle] == targetNumber) {
                return middle;
            } else if (array[middle] > targetNumber) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return -1;
    }
}

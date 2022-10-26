package com.yoyo.test.algorithm.basic.sort;

/**
 * 冒泡排序
 */
//https://www.huoban.com/news/post/19428.html
//https://www.runoob.com/w3cnote/ten-sorting-algorithm.html
public class BubbleSort {

    public static void main(String[] args) throws InterruptedException {
        int[] list = {3, 1, 4, 2, 5, 8, 7, 9, 12, 1, 2, 3};
//        list = Arrays.stream(list).sorted().toArray();
//        bubbleSort(list);
//        for (int i : list) {
//            System.out.println(i);
//        }
//        bubbleSort2(list);
//        for (int i : list) {
//            System.out.println(i);
//        }

//        bubbleSort3(list);
//        for (int i : list) {
//            System.out.println(i);
//        }

        bubbleSort4(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] originalList) {
        int count = 0;
        for (int i = 0; i < originalList.length; i++) {
            for (int j = 0; j < originalList.length; j++) {
                count = count + 1;
                System.out.println("i = " + i + " j = " + j + " count = " + count);
                System.out.println("before:  originalList[i] = " + originalList[i] + " originalList[j] = " + originalList[j]);
                if (originalList[i] > originalList[j]) {
                    int temp = originalList[i];
                    originalList[i] = originalList[j];
                    originalList[j] = temp;
                    System.out.println("after: originalList[i] = " + originalList[i] + " originalList[j] = " + originalList[j]);
                }
            }
        }
    }

    public static void bubbleSort2(int[] originalList) {
        int count = 0;
        for (int i = 0; i < originalList.length; i++) {
            for (int j = i + 1; j < originalList.length; j++) {
                count = count + 1;
                System.out.println("i = " + i + " j = " + j + " count = " + count);
                if (originalList[i] > originalList[j]) {
                    int temp = originalList[i];
                    originalList[i] = originalList[j];
                    originalList[j] = temp;
                    System.out.println("after: originalList[i] = " + originalList[i] + " originalList[j] = " + originalList[j]);
                }
            }
        }
    }

    /**
     * 自己写的，根据第二个动图https://www.jianshu.com/p/648d87dc4cfc
     *
     * @param originalList
     */
    public static void bubbleSort3(int[] originalList) {
        int count = 0;
        for (int i = 0; i < originalList.length - 1; i++) {
            for (int j = 0; j < originalList.length - i - 1; j++) {
                count++;
                System.out.println("i = " + i + " count = " + count);
                System.out.println("before: originalList[j] = " + originalList[j] + " originalList[i] = " + originalList[i]);
                if (originalList[j] < originalList[j + 1]) {
                    int temp = originalList[j];
                    originalList[j] = originalList[j + 1];
                    originalList[j + 1] = temp;
                    System.out.println("after: originalList[j] = " + originalList[j] + " originalList[i] = " + originalList[i]);

                }
            }
        }
    }

    /**
     * 优化方案，
     * 1， 设置一个标志位，记录上一次排序是否有交换，没有这可以提前退出循环 set hasSwap
     * 2， 记录上一次最后交换的位置，作为下一次循环的结束边界，  最后一次比较说明之后的元素已经排好序，无需无意义的比较  set lastSwapIndex
     * 3， 双向冒泡排序，从左往右比较一次，然后从右往左比较一次，以此类推， CocktailSort
     *
     * @param originalList
     */
    public static void bubbleSort4(int[] originalList) {
        int left = 0;
        int right = originalList.length - 1;
        int lastSwapIndex = 0; //记录最后一次交换标记的位置
        boolean hasSwap = false;  // 记录标志位，是否未发生交换

        int count = 0;
        while (left < right) {

            for (int i = left; i < right; i++) { // 从左到右，由小到大进行交换排序，保证originalList[right] 是最大的
                if (originalList[i] > originalList[i + 1]) {
                    swap(originalList, i, i + 1);
                    hasSwap = true;
                    lastSwapIndex = i;
                    count++;
                }
            }
            right = lastSwapIndex;  //将最后一次的交换位置的index作为右边界
            if (!hasSwap) { // 上一轮若没有交换则提前结束
                break;
            }
            hasSwap = false; //重置是否交换的标签
            for (int i = right; i > left; i--) { // 从右到左，由大到小进行交换排序，保证originalList[left] 是最小的
                if (originalList[i] < originalList[i - 1]) {
                    swap(originalList, i, i - 1);
                    hasSwap = true;
                    lastSwapIndex = i;
                    count++;
                }
            }
            left = lastSwapIndex; //将最后一次交换的位置作为左边界
            if (!hasSwap) { //上一轮没有交换则提前结束
                break;
            }
            hasSwap = false; //重置是否交换的标签
        }
        System.out.println("count = " + count);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

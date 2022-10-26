package com.yoyo.test.algorithm.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayConvertToArrayList {
    /**
     * https://www.cnblogs.com/hwh000/p/16207321.html
     * 【List】java数组转ArrayList
     * 1、String[] 转 ArrayList
     *
     * String[] array= {"aa", "bb", "cc"};
     * ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
     * 注意：直接使用 Arrays.asList(array) 得到的 ArrayList 不能进行 add，remove操作，因为他们并不是我们熟悉的ArrayList，而是Arrays里面的内部类ArrayList，详解。
     *
     * 2、int[] 转 ArrayList
     *
     * 复制代码
     * List<Integer>
     * int[] array = {1, 2, 3};
     * // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
     * // 1.使用Arrays.stream将int[]转换成IntStream。
     * // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
     * // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>
     *
     * List<Integer> list1 = Arrays.stream(array).boxed().collect(Collectors.toList());
     *
     * 复制代码
     * 注意：直接使用 Arrays.asList(arr) 得到的是 List<int[]> list；
     */

    public static void main(String[] args) {

        // int[] 转化成ArrayList<Integer>
        int[] aa = {1, 3, 5, 2, 7, 0, 6, 6, 8, 9};

        List<Integer> arrayList = Arrays.stream(aa).boxed().collect(Collectors.toList());
        for(Integer integer:arrayList ){
            System.out.println(integer);
            System.out.println((int)integer);
        }

        // ArrayList<Integer> 转化成 int[] 数组
        int[] bb = arrayList.stream().mapToInt(Integer::valueOf).toArray();
        for(int i : bb) {
            System.out.println(i);
        }
    }
}

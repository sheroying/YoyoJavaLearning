package com.yoyo.test.algorithm.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicatedNumbers {

    //找到两个数组里面重复的元素, 单个数组没有重复的元素
    public static void main(String[] args) {

        int[] a = {1, 7, 2, 10};
        int[] b = {2, 6, 4, 7, 5};

        for (Object i : findDuplicatedNumbers(a, b)) {
            System.out.println((Integer) i);
        }
    }

    /**
     * 一次循环，循环次数取数组较长的那个length , 时间复杂度O(N)
     *
     * @param aa 第一个数组
     * @param bb 第二个数组
     * @return
     */
    public static List findDuplicatedNumbers(int[] aa, int[] bb) {
        int longerLength = aa.length >= bb.length ? aa.length : bb.length;

        List<Integer> result = new ArrayList<>();
        Map map = new HashMap();

        for (int i = 0; i < longerLength; i++) {
            if (i <= aa.length - 1 && map.containsKey(aa[i])) {
                result.add(aa[i]);
                map.put(aa[i], 1);
            } else if (i <= aa.length - 1 && !map.containsKey(aa[i])) {
                map.put(aa[i], 0);
            } else {
                continue;
            }

            if (i <= bb.length - 1 && map.containsKey(bb[i])) {
                result.add(bb[i]);
                map.put(bb[i], 1);
            } else if (i <= bb.length - 1 && !map.containsKey(bb[i])) {
                map.put(bb[i], 0);
            } else {
                continue;
            }
        }
        return result;
    }

    /**
     * 暴力破解，不推荐，时间复杂度是O(n的2次方)
     */
    public static void findDuplicatedNumbers2(int[] a, int[] b) {
        int[] result = new int[2];
        int k = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < b.length - 1; j++) {
                if (a[i] == b[j]) {
                    result[k] = a[i];
                    k++;
                    System.out.println("result " + i + " = " + a[i]);
                }
            }
        }
    }

}


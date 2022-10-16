package com.yoyo.test.algorithmProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 查找一个log中出现次数最多的前n个单词， 也可以使用顺序查找进行
 */
public class FindMostFrequentWord {
    public static void main(String args[]) {
        String log = "asjfg agjgk aaaa aegkrge aaaa faekg rthir greh aaaa uuuuu asjfg faekg ooooo aaaa asjfg";
        findDuplicatedWords(log, 3);
    }


    public static void findDuplicatedWords(String log, int number) {
        String[] words = log.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str: words) {
            if(!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) +1);
            }
        }
        Object[] valueList = (Object[]) map.values().toArray();
//        Arrays.stream(valueList).sorted();
        for( int i =0; i < valueList.length; i++) { // 排序从大到小
            for( int j = 0; j < valueList.length -i-1; j++) {
                int aa = (int)valueList[j];
                int bb = (int)valueList[j+1];
                if(aa < bb ){
                    int temp = (int)valueList[j];
                    valueList[j] = valueList[j+1];
                    valueList[j+1] = temp;
                }
            }
        }
        Object[] num = Arrays.copyOf(valueList, number); //  只要前N 个重复率最高的

        map.forEach((k,v) -> {     // lamda 表达式 遍历所有的k v

            System.out.println ("k is " + k + " v is " + v + " number is " + (int)num[num.length-1]);
            if (v >= (int)num[num.length-1]) {

//                System.out.println ("num[num.length-1]" + num[num.length-1]);
                System.out.println ("most duplicated word " + k + " duplicated number is " + v);
            }
        });

    }
}

package com.yoyo.test.algorithm.basic;

public class Testaaa {

    public static void main(String[] args) {
        String aa = "aaabccccffaaa" ; //’  => ‘a3b1c4f2a3’
        char[] list =  aa.toCharArray();
        int num = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< list.length-1; i++) {
            if(list[i] == list[i+1]) {
                num++;
            } else {
                num++;
                sb.append(list[i]);
                sb.append(num);
                num = 0;

            }
            if(list[i] == list[i+1] && i == list.length-2) {
                num++;
                sb.append(list[i]);
                sb.append(num);
            }
        }
//            null, '', 123111333, 'a', 'aaaa1233ssff11' '!@##$%%%^^', "qqqqqqq", "werefg     2343",   Integer, stringbuffer, 'weageaegegeggg.....', 'asdfg',
         System.out.println(sb);

    }
}

package com.yoyo.test.algorithmProblem;

public class Bottle {
    public static void main(String[] args) {
        int price = 10;
        System.out.println(getBottleNumber(10));
    }

    /**
     * 经典的2个瓶子兑换1瓶水，4个盖子兑换一瓶水，2元买一瓶水，给10元可以喝多少水
     * @param price
     * @return
     */
    public static int getBottleNumber(int price) {
        int bottle = price / 2; //2元一瓶水
        int body = price / 2;  //2个瓶身兑一瓶水
        int cover = price / 2;  //4个盖子兑一瓶水
        while (body >=2 || cover >= 4) {
            if(body/2 >= 1) {
                bottle += body / 2;
                cover += body /2;
                body = body / 2 + body%2;
            }
            if(cover/4 >= 1) {
                bottle += cover/4;
                body += cover/4;
                cover = cover/4 + cover%4;
            }
        }
        return bottle;
    }
}

package com.yoyo.test.threads.producer.comsumer.example;

public class ProductFactory {
    int a = 0;


    public void produce() {
        System.out.println("product ");
        if(a > 0) {
            System.out.println("produce a = " + a);
            a=0;
        }
    }

    public void consume() {
        System.out.println("consume ");
        if(a == 0) {
            System.out.println("consume a = " + a);
            a += 1;
        }
    }
}

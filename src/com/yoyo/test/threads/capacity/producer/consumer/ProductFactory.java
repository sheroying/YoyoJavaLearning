package com.yoyo.test.threads.capacity.producer.consumer;

public class ProductFactory {
    int a = 0;
    private Product product;


    public void produce() {
        System.out.println("product ");
        if(null!= product && product.count > 0) {
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

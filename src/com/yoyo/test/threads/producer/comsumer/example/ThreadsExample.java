package com.yoyo.test.threads.producer.comsumer.example;


//https://zhuanlan.zhihu.com/p/73442055
public class ThreadsExample {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        Producer producer = new Producer(productFactory);
        Consumer consumer = new Consumer(productFactory);
        producer.start();
        new Thread(consumer).start();
    }


}

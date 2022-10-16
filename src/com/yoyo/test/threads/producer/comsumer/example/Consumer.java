package com.yoyo.test.threads.producer.comsumer.example;


public class Consumer implements Runnable{
    private ProductFactory productFactory;
    public Consumer (ProductFactory productFactory) {
        this.productFactory = productFactory;
     }

    public void run() {
        while(true) {
            synchronized (productFactory) {
                productFactory.consume();
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

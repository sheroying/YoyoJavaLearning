package com.yoyo.test.threads.capacity.producer.consumer;

public class Producer extends Thread {
    private ProductFactory productFactory;
    public Producer(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public void run() {
        while (true) {
            synchronized (productFactory) {
                productFactory.produce();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

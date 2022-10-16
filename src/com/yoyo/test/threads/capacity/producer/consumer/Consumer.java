package com.yoyo.test.threads.capacity.producer.consumer;


public class Consumer implements Runnable{
    private ProductFactory productFactory;
    public Consumer (ProductFactory productFactory) {
        this.productFactory = productFactory;
     }
//    int a = 2;
//    @Override
    public void run() {
        while(true) {
            synchronized (productFactory) {
                productFactory.consume();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

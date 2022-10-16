package com.yoyo.test.threads.threads;

public class RunnableA implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("before -- RunnableA a = " + ThreadA.a);
        synchronized (ThreadA.a) {
            System.out.println("synchronized -> before if 111 -- RunnableA a = " + ThreadA.a);
            if(ThreadA.a > 0) {
                System.out.println("RunnableA a = " + ThreadA.a);
                ThreadA.a=0;
            }
        }
    }
}

package com.yoyo.test.threads.threads;

import java.util.concurrent.FutureTask;

//https://segmentfault.com/a/1190000022648047
public class ThreadsExample {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        RunnableA consumerB = new RunnableA();
        CallableA callableA = new CallableA();
        threadA.start();
        new Thread(consumerB).start();
        FutureTask<Integer> futureTask = new FutureTask<>(callableA);
        new Thread(futureTask, "test1").start();
    }


}

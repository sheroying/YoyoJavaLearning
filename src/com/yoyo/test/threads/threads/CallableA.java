package com.yoyo.test.threads.threads;

import java.util.concurrent.Callable;

public class CallableA implements Callable {
    @Override
    public Integer call() throws Exception {
         System.out.println("Implements the call method");
        return 1024;
    }
}

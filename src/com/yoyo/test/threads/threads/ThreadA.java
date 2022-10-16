package com.yoyo.test.threads.threads;

public class ThreadA extends Thread {
    static Integer a = 0;

    public void run() {
        System.out.println("before -- ThreadA a = " + ThreadA.a);
        synchronized (a) {
            if (a.equals(0)) {
                System.out.println("ThreadA a=" + a);
                a += 1;
            }

        }
    }

}

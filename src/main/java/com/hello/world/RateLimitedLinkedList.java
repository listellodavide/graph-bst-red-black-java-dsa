package com.hello.world;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class RateLimitedLinkedList implements RateLimiter<String> {
    volatile long time;

    volatile  int count = 0;

    private static final int MAX_REQUESTS = 10;


    public RateLimitedLinkedList() {

        this.time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Override
    synchronized public boolean tryAcquire() {
        if (System.currentTimeMillis() - this.time < 1000) {
            System.out.println("diff:  " + (System.currentTimeMillis() - this.time));
            if (count < MAX_REQUESTS) {
                increment();
                return true;
            }
            return false;
        } else {
            resetCounter();
            return true;
        }
    }

    @Override
    public String supplyElement(Supplier<String> iaka) throws Exception {

        if(tryAcquire()) {
            return iaka.get();
        }
        return null;
    }


    synchronized private void resetCounter() {
        count = 0;
        this.time = System.currentTimeMillis();
    }


    synchronized void increment() {
        count++;
        System.out.println("incremented "+ count);
    }

    public String getElement(Callable<String> iaka) throws Exception {
        if(tryAcquire()) {
            return iaka.call();
        }
        return null;
    }


}

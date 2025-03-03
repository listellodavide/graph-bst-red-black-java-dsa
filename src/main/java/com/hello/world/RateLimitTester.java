package com.hello.world;

public class RateLimitTester {

    public static void main(String[] args) throws Exception {

        RateLimitedLinkedList rlll = new RateLimitedLinkedList();

        for(int i = 0; i < 50; i++) {

            Thread.sleep(50); // 0.25 seconds, 4 each second, so 32 in 8 seconds

            int finalI = i;
            System.out.println(rlll.getElement(()-> "hello "+ finalI));
        }
    }
}

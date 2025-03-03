package com.hello.world.bst;

import java.util.Random;

public class RandomInteger {

    public static int generateRandomInteger(int min, int max) {
        Random r = new Random();
        return r.nextInt(max-min) + min;
    }
}

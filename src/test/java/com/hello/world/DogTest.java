package com.hello.world;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogTest {

    @BeforeAll
    public static void init() {
        System.out.println("Doing stuff");
    }
    @Test
    public void testBark() {
        String expectedString = "woof";
        assertEquals(expectedString, "woof");
        System.out.println("WOOF!");
    }
}

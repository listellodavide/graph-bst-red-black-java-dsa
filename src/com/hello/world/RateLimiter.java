package com.hello.world;

import java.util.function.Supplier;

public interface RateLimiter<T> {

    boolean tryAcquire();



//    String getElement(Callable<String> iaka) throws Exception;
    String supplyElement(Supplier<String> iaka) throws Exception;
}

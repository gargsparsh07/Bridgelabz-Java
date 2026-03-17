package ioprogramming.annotationsandreflection.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

class Calculator {

    @CacheResult
    public int square(int n) {
        System.out.println("Computing...");
        return n * n;
    }
}

public class CacheResultExample {

    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();
        Method method = Calculator.class.getMethod("square", int.class);

        int input = 5;

        if(method.isAnnotationPresent(CacheResult.class)) {

            if(cache.containsKey(input)) {
                System.out.println("From Cache: " + cache.get(input));
            } else {
                int result = (int) method.invoke(calc, input);
                cache.put(input, result);
                System.out.println("Computed: " + result);
            }
        }

        // second call (cached)
        System.out.println("Second Call:");
        if(cache.containsKey(input)) {
            System.out.println("From Cache: " + cache.get(input));
        }
    }
}
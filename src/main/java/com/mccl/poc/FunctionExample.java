package com.mccl.poc;

import java.util.function.Function;

public class FunctionExample {
    public static Integer calculateInteger(Integer value, Function<Integer, Integer> calculateFunction) {
        return calculateFunction.apply(value);
    }
}

package com.mccl.poc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FunctionalInterfacesTest {

    @Test
    public void functionExecution() {
        Integer result = FunctionExample.calculateInteger(1, i -> i * 2);
        Assert.assertTrue(result.compareTo(2) == 0);
    }

    @Test
    public void concatWithComma() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        String result = list.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(","));
        Assert.assertTrue(result.equals("1,2,3,4,5"));
    }

    @Test
    public void mapIterating() {
        Map<String, String> map = new HashMap<>();
        map.put("K1", "V1");
        map.put("K2", "V2");
        map.put("K3", "V3");
        map.forEach((key, value) -> System.out.println("key: " + key + " value:" + value));
    }
}

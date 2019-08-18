package com.mccl.poc;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void hashMapCreation() {
        Map<String, String> map = new HashMap<>();
        String putResult = map.put("key", "value");
        Assert.assertNull(putResult);
        Assert.assertNotNull(map);
    }
}

package com.mccl.poc;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class CollectionsTest {

    @Test
    public void linkedListTest() {
        Queue<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.stream().forEach(System.out::println);
    }
}

package com.mccl.poc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void streamGenerateAsSupplierUse() {
        Supplier<List<Integer>> supplier = () -> Arrays.asList(1, 2, 3, 4, 5);
        Stream<List<Integer>> stream = Stream.generate(supplier);
        Assert.assertNotNull(stream);
    }

    @Test
    public void streamFilterAsPredicateUse() {
        Predicate<String> predicate = s -> s.startsWith("T");
        Stream<String> stream = Stream.of("One", "Two", "Three");
        stream
                .filter(predicate)
                .forEach(System.out::println);
    }

    @Test
    public void streamMapAsFunctionUse() {
        Function<String, String> function = s -> s.concat(" - " + s.length());
        Stream<String> stream = Stream.of("One", "Two", "Three");
        stream
                .map(function)
                .forEach(System.out::println);
    }

    @Test
    public void streamForEachAsConsumerUse() {
        Consumer<String> consumer = s -> System.out.println(s.concat(s));
        Stream<String> stream = Stream.of("One", "Two", "Three");
        stream.forEach(consumer);
    }
}

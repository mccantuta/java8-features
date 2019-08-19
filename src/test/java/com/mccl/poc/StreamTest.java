package com.mccl.poc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void streamGenerateAsSupplierUse() {
        Supplier<Double> supplier = Math::random;
        Stream
                .generate(supplier)
                .limit(10)
                .forEach(System.out::println);
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

    @Test
    public void skipMethodForStream() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .skip(5)
                .forEach(System.out::println);
    }

    @Test
    public void limitMethodForStream() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void toMapMethodForStream() {
        Map<Integer, Integer> map = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(
                        Collectors
                                .toMap(Function.identity(), Function.identity()));
        Assert.assertNotNull(map);
    }
}

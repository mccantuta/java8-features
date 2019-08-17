package com.mccl.poc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferenceTest {

    @Test
    public void newPersonShouldExecuted() {
        Stream<String> stream = Stream.of("One", "Two", "Three");
        stream.map(Person::new).forEach(System.out::println);
    }

    @Test
    public void methodReferenceShouldFunction() {
        Stream<List<String>> stream = Stream.of(Arrays.asList("Peter", "Lima"), Arrays.asList("Charles", "New York"));
        stream
                .map(e -> new Person(e.get(0), e.get(1)))
                .forEach(System.out::println);
    }

    @Test
    public void methodReferenceWithManyArgumentsShouldFunction() {
        Stream<List<String>> stream = Stream.of(Arrays.asList("Peter", "Lima"), Arrays.asList("Charles", "New York"));
        stream
                .map(Person::new)
                .forEach(System.out::println);
    }

    @Test
    public void callNonStaticMethod() {
        Stream<List<String>> stream = Stream.of(Arrays.asList("Peter", "Lima"), Arrays.asList("Charles", "New York"));
        stream
                .map(Person::new)
                .map(Person::returnFullData)
                .forEach(System.out::println);
    }
}

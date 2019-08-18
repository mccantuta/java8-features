package com.mccl.poc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class OptionalTest {

    @Test
    public void createEmptyOptional() {
        Optional<String> optional = Optional.empty();
        Assert.assertFalse(optional.isPresent());
    }

    @Test
    public void createNonNullOptional() {
        Optional<String> optional = Optional.of("test");
        Assert.assertTrue(optional.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void createNonNullOptionalShouldError() {
        Optional<String> optional = Optional.of(null);
        optional.isPresent();
    }

    @Test
    public void createNullOptional() {
        Optional<String> optional = Optional.ofNullable(null);
        Assert.assertFalse(optional.isPresent());
    }

    @Test
    public void optionalShouldNotError() {
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        int result = intStream
                .min()
                .orElse(0);
        System.out.println(result);
    }

    @Test
    public void emptyListShouldError() {
        IntStream intStream = Arrays.stream(new int[]{});
        int result = intStream
                .min()
                .orElse(0);
        System.out.println(result);
    }

    @Test
    public void applyIntermediateOperationsToOptional() {
        String result = Optional.ofNullable("test")
                .map(String::toUpperCase)
                .filter(s -> s.length() > 1)
                .orElse("EMPTY");
        Assert.assertFalse(result.equals("EMPTY"));
    }

    @Test
    public void applyIntermediateOperationsToNonExistOptional() {
        String result = Optional.ofNullable("test")
                .filter(s -> s.length() > 100)
                .orElse("EMPTY");
        Assert.assertTrue(result.equals("EMPTY"));
    }

    @Test
    public void differenceApplyOrElseAndOrElseGetSlow() {
        //orElse execute the method provided although it is not needed
        String result = Optional.ofNullable("test")
                .orElse(Util.heavyResource());
    }

    @Test
    public void differenceApplyOrElseAndOrElseGetFast() {
        //orElseGet only execute the supplier if the optional value is not present.
        String result = Optional.ofNullable("test")
                .orElseGet(() -> Util.heavyResource());
    }

    @Test(expected = IllegalArgumentException.class)
    public void orElseThrowException() {
        String nullString = null;
        Optional.ofNullable(nullString).orElseThrow(IllegalArgumentException::new);
    }
}

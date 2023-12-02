package org.willowsenator.patternMatching;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PatternMatchingExampleTest {

    private final PatternMatchingExample patternMatchingExample = new PatternMatchingExample();


    @ParameterizedTest
    @MethodSource("input")
    void pattern(Object value, String expectedResult){
        var output = patternMatchingExample.pattern(value);
        Assertions.assertEquals(expectedResult, output);
    }

    @ParameterizedTest
    @MethodSource("input")
    void patternUsingInstanceOf(Object value, String expectedResult){
        var output = patternMatchingExample.patternUsingInstanceOf(value);
        Assertions.assertEquals(expectedResult, output);
    }

    @ParameterizedTest
    @MethodSource("input")
    void patternUsingSwitch(Object value, String expectedResult){
        var output = patternMatchingExample.patternUsingSwitch(value);
        Assertions.assertEquals(expectedResult, output);
    }

    private static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of("Omar", "String of length: 4"),
                Arguments.of(1, "Integer: 1"),
                Arguments.of(null, "Not a String or Integer")
        );
    }

}
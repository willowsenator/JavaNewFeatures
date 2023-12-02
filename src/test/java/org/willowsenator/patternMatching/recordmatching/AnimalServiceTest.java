package org.willowsenator.patternMatching.recordmatching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AnimalServiceTest {
    private final AnimalService animalService = new AnimalService();

    @ParameterizedTest
    @MethodSource("input")
    void retrieveName(Animal animal, String expectedResult){
        var output = animalService.retrieveName(animal);
        Assertions.assertEquals(expectedResult, output);
    }

    @ParameterizedTest
    @MethodSource("input")
    void retrieveNameV2(Animal animal, String expectedResult){
        var output = animalService.retrieveNameV2(animal);
        Assertions.assertEquals(expectedResult, output);
    }

    @Test
    void retrieveNameGuardedPattern(){
        var output = animalService.retrieveNameGuardedPattern(new Cat(null, "Black"));
        Assertions.assertEquals("", output);
    }


    private static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of(new Cat("Michi", "black"), "Michi"),
                Arguments.of(new Dog("Wolf", "brown"), "Wolf"),
                Arguments.of(null, "")
        );
    }

}
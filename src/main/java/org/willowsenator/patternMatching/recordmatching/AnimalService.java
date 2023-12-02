package org.willowsenator.patternMatching.recordmatching;

public class AnimalService {
    public String retrieveName(Animal animal){
        return switch(animal){
            case Cat cat -> cat.name();
            case Dog dog -> dog.name();
            case null -> "";
        };
    }

    public String retrieveNameV2(Animal animal){
        return switch(animal){
            case Cat(var name, var color) -> name;
            case Dog(var name, var color) -> name;
            case null -> "";
        };
    }

    public String retrieveNameGuardedPattern(Animal animal){
        return switch(animal){
            case Cat(var name, var color) when name == null-> "";
            case Cat(var name, var color) -> name;
            case Dog(var name, var color) -> name;
            case null -> "";
        };
    }
}

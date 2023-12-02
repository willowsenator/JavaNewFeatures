package org.willowsenator.patternMatching;

public class PatternMatchingExample {
    public String pattern(Object o){
        if(o instanceof Integer){
            var i = (Integer) o;
            return "Integer: " + i;
        }

        if(o instanceof String){
            var s = (String) o;
            return "String of length: " + s.length();
        }
        return "Not a String or Integer";
    }

    public String patternUsingInstanceOf(Object o){
        if(o instanceof Integer i){
            return "Integer: " + i;
        }

        if(o instanceof String s){
            return "String of length: " + s.length();
        }
        return "Not a String or Integer";
    }

    public String patternUsingSwitch(Object o){
       return switch(o){
           case String s -> "String of length: " + s.length();
           case Integer i -> "Integer: " + i;
           case null, default -> "Not a String or Integer";
       };
    }
}

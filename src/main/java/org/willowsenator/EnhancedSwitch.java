package org.willowsenator;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class EnhancedSwitch {
    public static void main(String[] args){
        var currentDate = LocalDate.now();

        System.out.printf("""
                Month: %s Year: %d Days: %d
                """, currentDate.getMonth(), currentDate.getYear(), daysFromMonth(currentDate.getMonth(),
                currentDate.getYear()));
    }

    public static int daysFromMonth(Month month, int year) {
        return switch (month) {
            case FEBRUARY -> {
                if(Year.isLeap(year)){
                    System.out.println("Year is leap");
                    yield 29;
                } else{
                    System.out.println("Year is not leap");
                    yield 28;
                }
            }
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
            default -> 30;
        };
    }
}

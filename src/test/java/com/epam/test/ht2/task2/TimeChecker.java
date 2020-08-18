package com.epam.test.ht2.task2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class TimeChecker {
    /* here it is possible to set pseudo current time
     for testing purposes (date will stay actual) */
    final static LocalTime pseudoNow = LocalTime.parse("15:00");

    public static long getDayDif(LocalDate start, LocalDate end){
        return DAYS.between(start, end) >= 0 ? DAYS.between(start, end) : -1;
    }

    public static long getTimeLeftToday(LocalTime time){

        LocalTime start = LocalTime.parse(time.toString());
        LocalTime stop = LocalTime.parse("18:00");

        if(time.isAfter(LocalTime.parse("18:00"))){
            return 0;
        }
        if(time.isBefore(LocalTime.parse("10:00"))){
            return 8;
        }

        return Duration.between(start, stop).toHours();
    }

    public static LocalDateTime getDateBetweenTodayAndDate(long days){
        return LocalDateTime.now().plusDays(days);
    }

    public static long getDaysBetweenNowAndDuration(long hoursDuration){
        long hoursToday = getTimeLeftToday(pseudoNow);
        if(hoursDuration < hoursToday){
            return 0;
        }

        long totalHours = hoursDuration - hoursToday;
        if(totalHours <= 8){
            return 1;
        }

        long result = totalHours / 8;
        if(totalHours % 8 != 0){
            result++;
        }
        return result;
    }

    public static long findHoursBetweenNowAndDate(long days){
        long hoursLeft = getTimeLeftToday(pseudoNow);
        hoursLeft += 8*days;
            return hoursLeft;
    }
}

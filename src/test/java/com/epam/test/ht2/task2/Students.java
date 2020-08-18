package com.epam.test.ht2.task2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public enum Students {
    ALEX(Specialties.DESIGN, "Alex", "Johnson", LocalDateTime.parse("2020-08-15T10:00")){
        @Override
        String getStudyStatus(){
            LocalDateTime EndDate = TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.DESIGN.duration.toHours()));

            return LocalDateTime.now().isBefore(EndDate)
                    ? "Studies are not finished. " + calcTimeDif(EndDate) + " left til the end."
                    : "Studies are completed. " + calcTimeDif(EndDate) + " passed since then.";
        }

        @Override
        LocalDateTime getEndDate() {
            return TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.DESIGN.duration.toHours()));
        }

        @Override
        long getTimeSpent(){
            long days = TimeChecker.getDayDif(LocalDate.now(), startDate.toLocalDate());
            if(days == -1) {
                return 0;
            }
            return TimeChecker.findHoursBetweenNowAndDate(days);
        }
    },
    MARTIN(Specialties.TESTING, "Martin", "Kerry", LocalDateTime.parse("2020-08-05T10:00:00")){
        @Override
        String getStudyStatus(){
            LocalDateTime EndDate = TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.TESTING.duration.toHours()));

            return LocalDateTime.now().isBefore(EndDate)
                    ? "Studies are not finished. " + calcTimeDif(EndDate) + " left til the end."
                    : "Studies are completed. " + calcTimeDif(EndDate) + " passed since then.";
        }

        @Override
        LocalDateTime getEndDate() {
            return TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.TESTING.duration.toHours()));
        }

        @Override
        long getTimeSpent(){
            long days = TimeChecker.getDayDif(LocalDate.now(), startDate.toLocalDate());
            if(days == -1) {
                return 0;
            }
            return TimeChecker.findHoursBetweenNowAndDate(days);
        }
    },
    JOHN(Specialties.TESTING, "John", "Michaels", LocalDateTime.parse("2020-08-14T10:00:00")){
        @Override
        String getStudyStatus(){
            LocalDateTime EndDate = TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.TESTING.duration.toHours()));

            return LocalDateTime.now().isBefore(EndDate)
                    ? "Studies are not finished. " + calcTimeDif(EndDate) + " left til the end."
                    : "Studies are completed. " + calcTimeDif(EndDate) + " passed since then.";
        }

        @Override
        LocalDateTime getEndDate() {
            return TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.TESTING.duration.toHours()));
        }

        @Override
        long getTimeSpent(){
            long days = TimeChecker.getDayDif(LocalDate.now(), startDate.toLocalDate());
            if(days == -1) {
                return 0;
            }
            return TimeChecker.findHoursBetweenNowAndDate(days);
        }
    },
    SARAH(Specialties.DEVOPS, "Sarah", "Richards", LocalDateTime.parse("2020-08-15T10:00:00")){
        @Override
        String getStudyStatus(){
            LocalDateTime EndDate = TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.DEVOPS.duration.toHours()));

            return LocalDateTime.now().isBefore(EndDate)
                    ? "Studies are not finished. " + calcTimeDif(EndDate) + " left til the end."
                    : "Studies are completed. " + calcTimeDif(EndDate) + " passed since then.";
        }

        @Override
        LocalDateTime getEndDate() {
            return TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.DEVOPS.duration.toHours()));
        }

        @Override
        long getTimeSpent(){
            long days = TimeChecker.getDayDif(LocalDate.now(), startDate.toLocalDate());
            if(days == -1) {
                return 0;
            }
            return TimeChecker.findHoursBetweenNowAndDate(days);
        }
    },
    TOM(Specialties.DEVOPS, "Tom", "Sawyer", LocalDateTime.parse("2020-08-16T10:00:00")){
        @Override
        String getStudyStatus(){
            LocalDateTime EndDate = TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.DEVOPS.duration.toHours()));

            return LocalDateTime.now().isBefore(EndDate)
                    ? "Studies are not finished. " + calcTimeDif(EndDate) + " left til the end."
                    : "Studies are completed. " + calcTimeDif(EndDate) + " passed since then.";
        }

        @Override
        LocalDateTime getEndDate() {
            return TimeChecker.getDateBetweenTodayAndDate(TimeChecker.
                    getDaysBetweenNowAndDuration(Specialties.DEVOPS.duration.toHours()));
        }

        @Override
        long getTimeSpent(){
            long days = TimeChecker.getDayDif(LocalDate.now(), startDate.toLocalDate());
            if(days == -1) {
                return 0;
            }
            return TimeChecker.findHoursBetweenNowAndDate(days);
        }
    };

    Specialties specialty;
    String firstName;
    String lastName;
    LocalDateTime startDate;

    Students(Specialties specialty, String firstName, String lastName, LocalDateTime startDate){
        this.specialty = specialty;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
    }

    abstract String getStudyStatus();
    abstract long getTimeSpent();
    abstract LocalDateTime getEndDate();


    String calcTimeDif(LocalDateTime date){
        if(LocalDateTime.now().toLocalTime().isAfter(LocalTime.parse("18:00"))){
            Duration timeUntilWork = Duration.between(LocalTime.parse("10:00"), LocalDateTime.now());
        }
        Duration timeDif = Duration.between(date, LocalDateTime.now());

        long days = timeDif.toDays();
        timeDif = timeDif.minusDays(days);
        long hours = timeDif.toHours();

        return (days == 0 ? "" : Math.abs(days) + "d,") + (hours == 0 ? "" : Math.abs(hours) + "h");
    }
}

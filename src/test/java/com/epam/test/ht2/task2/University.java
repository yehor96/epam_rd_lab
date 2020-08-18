package com.epam.test.ht2.task2;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class University {

    public University() {
        System.out.println("Welcome to our University!\n");
    }

    public void showReport(){
        if (getReportType() == 0){
            showShortReport();
        }
        else{
            showFullReport();
        }
    }

    public void showStudentsInfo(){
        for (Students student : Students.values()){
            System.out.println("STUDENT: " + Students.valueOf(student.toString()).firstName + " " + Students.valueOf(student.toString()).lastName);
            System.out.println("CURRICULUM: " + Students.valueOf(student.toString()).specialty);
            System.out.println("START_DATE: " + Students.valueOf(student.toString()).startDate);
            System.out.println("COURSE\t\t\tDURATION(hrs)");
            System.out.println("-------------------------");
            System.out.printf("1. %s %15s \n", Students.valueOf(student.toString()).specialty.subject1 , Students.valueOf(student.toString()).specialty.subject1.duration.toHours());
            System.out.printf("2. %s %15s \n", Students.valueOf(student.toString()).specialty.subject2 , Students.valueOf(student.toString()).specialty.subject2.duration.toHours());
            System.out.println("\n");
        }
    }

    private void showShortReport(){
        for (Students student : Students.values()) {
            System.out.print(Students.valueOf(student.toString()).firstName + " " + Students.valueOf(student.toString()).lastName);
            System.out.print(" (" + Students.valueOf(student.toString()).specialty + " student)");
            System.out.println(" - " + Students.valueOf(student.toString()).getStudyStatus());
        }
    }

    private void showFullReport(){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(("dd.MM.yyyy"));

        for (Students student : Students.values()) {
            System.out.println("FIO: " + Students.valueOf(student.toString()).firstName + " " + Students.valueOf(student.toString()).lastName);
            System.out.println("Time spent: " + Math.abs(Students.valueOf(student.toString()).getTimeSpent()) + "h");
            System.out.println("CURRICULUM: " + Students.valueOf(student.toString()).specialty);
            System.out.println("Course duration: " + Students.valueOf(student.toString()).specialty.duration.toHours() + "h");
            System.out.println("START_DATE: " + Students.valueOf(student.toString()).startDate.format(pattern));
            System.out.println("END_DATE: " + Students.valueOf(student.toString()).getEndDate().toLocalDate().format(pattern));
            System.out.println(Students.valueOf(student.toString()).getStudyStatus());
            System.out.println();
        }
    }

    private int getReportType(){
        int reportType = -1;
        System.out.print("Please specify if you would like to receive short or full report (s/f): ");

        Scanner in = new Scanner(System.in);
        while(reportType == -1) {
            switch (in.nextLine()) {
                case "s":
                    reportType = 0;
                    break;
                case "f":
                    reportType = 1;
                    break;
                default:
                    System.out.print("Unknown entry. Please enter \"s\" for short report or \"f\" for full one: ");
            }
        }
        return reportType;
    }
}

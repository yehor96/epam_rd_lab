package com.epam.test.ht10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        allNumbers = getInput();

        Thread thread1 = new Thread(new NumberCruncher(allNumbers));
        Thread thread2 = new Thread(new NumberCruncher(allNumbers));
        Thread thread3 = new Thread(new NumberCruncher(allNumbers));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        Collections.sort(listOfPrimes);
        displayInfo(listOfPrimes.toArray());
    }

    public static int[] allNumbers;
    public static volatile ArrayList<Integer> listOfPrimes = new ArrayList<>();

    public static int[] getInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a range of numbers within 1 - 10 000.");
        System.out.print("Start of range. ");
        int start = validateInput(scanner);
        System.out.print("End of range. ");
        int end = validateInput(scanner);

        if(end < start){
            int t = end;
            end = start;
            start = t;
        }

        int[] numbers = new int[end-start+1];
        int number = start;
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = number;
            number++;
        }

        return numbers;
    }

    public static int validateInput(Scanner scanner){
        boolean flag = true;
        int value = 1;

        while(flag) {
            System.out.print("Enter number: ");
            value = scanner.nextInt();
            if ((value <= 0) || (value > 10_000)) {
                System.out.println("Mistake! Please enter a number within range 1 - 10 000");
            } else {
                flag = false;
            }
        }

        return value;
    }

    public static void displayInfo(Object[] list){
        if(list == null){
            System.out.println("There are no prime numbers in specified range.");
        }

        System.out.println("Prime numbers in specified range: ");
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + "  ");
            if((i+1) % 10 == 0){
                System.out.println();
            }
        }
    }
}

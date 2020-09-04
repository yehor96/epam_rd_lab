package com.epam.test.ht10;

import java.util.ArrayList;
import java.util.Collections;

import static com.epam.test.ht10.ConsoleOperator.displayInfo;
import static com.epam.test.ht10.ConsoleOperator.getInput;

public class Main {
    public static int[] allNumbers;
    public static volatile ArrayList<Integer> listOfPrimes = new ArrayList<>();

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
}

package com.epam.test.ht10;

import java.util.ArrayList;
import java.util.Collections;

import static com.epam.test.ht10.Helper.*;

public class Main {
    public static int[] allNumbers;
    public static int threadNumber;
    public static int[][] dividedArrays;
    public static volatile ArrayList<Integer> listOfPrimes = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        allNumbers = getInput();
        threadNumber = getNumberOfThreads();

        dividedArrays = getArrayDividedByThreadNumber(threadNumber, allNumbers);

        Thread[] threads = new Thread[threadNumber];

        for(int i = 0; i < threadNumber; i++){
            threads[i] = new Thread(new NumberCruncher(dividedArrays[i]));
        }

        for(int i = 0; i < threadNumber; i++){
            threads[i].start();
        }

        for(int i = 0; i < threadNumber; i++){
            threads[i].join();
        }

        Collections.sort(listOfPrimes);
        displayInfo(listOfPrimes.toArray());
    }
}

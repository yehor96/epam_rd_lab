package com.epam.test.ht10;

public class NumberCruncher implements Runnable {
    public NumberCruncher(int[] nums) {
        this.rangeOfNums = nums;
    }

    private int[] rangeOfNums;

    public void run(){
        getPrimeNumbers();
    }

    public void getPrimeNumbers(){
        for(var number : rangeOfNums){
            if(number % 2 == 0 || number == 1){
                continue;
            }

            int n = number - (number / 2) - 1;
            while((number % n != 0)){
               n--;
               if(n==1){
                   synchronized(Main.listOfPrimes){
                       if(Main.listOfPrimes.contains(number)){
                           continue;
                       }
                       Main.listOfPrimes.add(number);
                   }
                   continue;
               }
            }
        }
    }
}

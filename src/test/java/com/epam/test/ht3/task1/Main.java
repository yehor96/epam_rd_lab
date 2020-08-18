package com.epam.test.ht3.task1;

public class Main {
    //Variant 5
    public static void main(String[] args) {
        int [] arrayNumbers = getRandomNumbers(LENGTH);

        System.out.println("All the numbers: ");
        for(var each : arrayNumbers){
            System.out.print(each + " ");
        }

        int avg = getAverageValue(arrayNumbers);
        int smallest = getSmallestValue(arrayNumbers);

        System.out.println("\nAverage value is " + avg
                + "\nSmallest value is " + smallest
                + "\nAverage - smallest = " + (avg - smallest)
        );
    }

    public static final int LENGTH = 20;

    public static int[] getRandomNumbers(int length){
        int[] numArray = new int[length];

        for(int i = 0; i < numArray.length; i++){
            int number = (int)(Math.random()*10);

            if(Math.random() <= 0.5){
                number *= -1;
            }

            numArray[i] = number;
        }

        return numArray;
    }

    public static int getAverageValue(int[] array){
        int sum = 0;
        for(var each : array){
            sum += each;
        }
        return sum / array.length;
    }

    public static int getSmallestValue(int[] array){
        int smallest = array[0];
        for(int i = 1; i < array.length; i++)
            if(smallest > array[i]){
            smallest = array[i];
        }
        return smallest;
    }
}

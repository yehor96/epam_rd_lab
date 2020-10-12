package com.epam.test.ht10;

import static com.epam.test.ht10.Validator.validateInput;

public class Helper {
    public static void print(String text){
        System.out.print(text);
    }

    public static int[][] getArrayDividedByThreadNumber(int threadNumber, int[] arrayOfNumbers){
        int newArrayLength = arrayOfNumbers.length / threadNumber;
        int newArray[][] = new int[threadNumber][newArrayLength];

        int index = 0;
        for(int i = 0; i < threadNumber; i++ ){
            for(int j = 0; j < newArrayLength; j++ ){
                newArray[i][j] = arrayOfNumbers[index];
                index++;
            }
        }

        return newArray;
    }

    public static int getNumberOfThreads(){
        print("Also, we need number of threads: ");
        return validateInput();
    }

    public static int[] getInput(){
        print("Enter a range of numbers within 1 - 10 000.\n");

        print("Start of range. ");
        int start = validateInput();
        print("End of range. \n");
        int end = validateInput();

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

    public static void displayInfo(Object[] list){
        if(list == null){
            print("There are no prime numbers in specified range.\n");
        }

        print("Prime numbers in specified range: \n");
        for(int i = 0; i < list.length; i++){
            print(list[i] + "  ");
            if((i+1) % 10 == 0){
                print("\n");
            }
        }
    }
}

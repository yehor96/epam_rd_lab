package com.epam.test.ht10;

import java.util.Scanner;

import static com.epam.test.ht10.Helper.print;

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int validateInput(){
        boolean flag = true;
        int value = 1;

        while(flag) {
            print("Enter number: ");
            value = scanner.nextInt();
            if ((value <= 0) || (value > 10_000)) {
                print("Mistake! Please enter a number within range 1 - 10 000");
            } else {
                flag = false;
            }
        }

        return value;
    }
}

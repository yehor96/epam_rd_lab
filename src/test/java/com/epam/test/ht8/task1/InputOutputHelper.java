package com.epam.test.ht8.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputOutputHelper {
    private static final Scanner scannerConsole = new Scanner(System.in);
    private static Scanner scannerFile;

    public static void print(String text){
        System.out.print(text);
    }

    public static String getInput(String text){
        print(text);
        return scannerConsole.nextLine();
    }

    public static boolean hasMoreElements(){
        return scannerFile.hasNext();
    }

    public static String getNextElement(){
        return scannerFile.useDelimiter(",").next();
    }

    public static void readFile(File file) throws FileNotFoundException {
        scannerFile = new Scanner(file);
    }
}

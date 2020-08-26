package com.epam.test.ht3.task3;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        getLogLevel();
        Calculator calculator = new Calculator(new Operation());
        double number1, number2;
        String operator;

        number1 = calculator.enterNumber();
        number2 = calculator.enterNumber();
        operator = calculator.enterOperator();

        calculator.setFirstNumber(number1);
        calculator.setSecondNumber(number2);
        calculator.setOperator(operator);

        calculator.makeOperation(number1, number2, operator);
        System.out.println(calculator.showDisplay());
    }

    public static void getLogLevel(){
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        String prompt = "Enter one of digits for setting log level: \n" +
                "0 - for 'OFF';\n" +
                "1 - for 'FATAL';\n" +
                "2 - for 'ERROR';\n" +
                "3 - for 'WARN';\n" +
                "4 - for 'INFO';\n" +
                "5 - for 'DEBUG';\n" +
                "6 - for 'TRACE';\n" +
                "7 - for 'ALL';\n" +
                "-1 - to skip this step;\n";

        do{
            System.out.println(prompt);
            String level = scanner.nextLine();

            switch(level) {
                case "-1":
                    flag = true;
                    break;
                case "0":
                    Configurator.setLevel("com.epam.test.ht3.task3.Calculator", Level.OFF);
                    flag = true;
                    break;
                case "1":
                    Configurator.setLevel("com.epam.test.ht3.task3.Calculator", Level.FATAL);
                    flag = true;
                    break;
                case "2":
                    Configurator.setLevel("com.epam.test.ht3.task3.Calculator", Level.ERROR);
                    flag = true;
                    break;
                case "3":
                    Configurator.setLevel("com.epam.test.ht3.task3.Calculator", Level.WARN);
                    flag = true;
                    break;
                case "4":
                    Configurator.setLevel("com.epam.test.ht3.task3.Calculator", Level.INFO);
                    flag = true;
                    break;
                case "5":
                    Configurator.setLevel("com.epam.test.ht3.task3.Calculator", Level.DEBUG);
                    flag = true;
                    break;
                case "6":
                    Configurator.setLevel("com.epam.test.ht3.task3.Calculator", Level.TRACE);
                    flag = true;
                    break;
                case "7":
                    Configurator.setLevel("com.epam.test.ht3.task3.Calculator", Level.ALL);
                    flag = true;
                    break;
                default:
                    System.out.println("Incorrect Entry! Make sure to enter value within 0 - 7.");
            }
        }while(!flag);
    }
}

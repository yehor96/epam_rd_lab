package com.epam.test.ht3.task3;

import java.util.Scanner;

import static java.lang.Double.NaN;

public class Calculator {
    private double firstNumber;
    private double secondNumber;
    private String operator;
    private double result;
    private Scanner scanner;
    private IOperation operation;

    public Calculator(IOperation operation){
        scanner = new Scanner(System.in);
        this.operation = operation;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double makeOperation(double firstNumber, double secondNumber, String operator){
        if(secondNumber==0 && operator.equals("/")){
            System.out.println("It is not possible to divide by zero! Please change operator.");
            while(operator.equals("/")){
                operator = enterOperator();
            }
            this.operator = operator;
        }

        switch(operator){
            case "+":
                result = operation.addition(firstNumber, secondNumber);
                return result;
            case "-":
                result = operation.subtraction(firstNumber, secondNumber);
                return result;
            case "*":
                result = operation.multiplication(firstNumber, secondNumber);
                return result;
            case "/":
                result = operation.division(firstNumber, secondNumber);
                return result;
            default:
                System.out.println("Illegal operation!");
                return NaN;
        }
    }

    public double enterNumber(){
        String stringValue;
        double doubleValue = 0;

        System.out.print("Enter a number: ");
        stringValue = scanner.nextLine();

        boolean flag;
        do {
            try {
                doubleValue = Double.parseDouble(stringValue);
                flag = false;
            } catch (Exception e){
                System.out.print("Mistake was made! You can only enter numbers! Now, enter a number: ");
                stringValue = scanner.nextLine();
                flag = true;
            }
        } while(flag);
        return doubleValue;
    }

    public String enterOperator(){
        String entry;
        String prompt = ("You can enter one of the following operators:" +
                "\n+ for addition" +
                "\n- for subtraction" +
                "\n* for multiplication" +
                "\n/ for division" +
                "\nEnter an operator: "
        );

        System.out.print(prompt);
        entry = scanner.nextLine();

        while((!entry.equals("+")) && (!entry.equals("-")) && (!entry.equals("*")) && (!entry.equals("/"))){
            System.out.println("Mistake was made! You can only enter one of specified symbols.");
            System.out.print(prompt);
            entry = scanner.nextLine();
        }

        return entry;
    }

    public String showDisplay(){
        return String.format("The result of operation %.2f %s %.2f = %.2f",
                firstNumber, operator, secondNumber, result);
    }
}

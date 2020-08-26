package com.epam.test.ht3.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static java.lang.Float.NaN;

public class Calculator {
    private double firstNumber;
    private double secondNumber;
    private String operator;
    private double result;
    private Scanner scanner;
    private IOperation operation;
    private static Logger logger;

    public Calculator(IOperation operation){
        scanner = new Scanner(System.in);
        this.operation = operation;
        logger = LogManager.getLogger(Calculator.class);
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
        logger.info("First number is set to: " + firstNumber);
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
        logger.info("Second number is set to: " + secondNumber);
    }

    public void setOperator(String operator) {
        this.operator = operator;
        logger.info("Operator is set to: " + operator);
    }

    public double makeOperation(double firstNumber, double secondNumber, String operator){
        if(secondNumber==0 && operator.equals("/")){
            logger.warn("Attempt to divide by zero. " +
                    "Operation: " + firstNumber + " " + operator + " " + secondNumber);
            System.out.println("It is not possible to divide by zero! Please change operator.");
            while(operator.equals("/")){
                operator = enterOperator();
                if(!operator.equals("/")){
                    logger.debug("Operator is reset to: " + operator +
                            ". Now operation is: " + firstNumber + " " + operator + " " + secondNumber);
                }
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
                result = NaN;
        }
        if(result == NaN){
            System.out.println("Illegal operation!");
            logger.error("Illegal operation is entered: " + operator);
        }
        else{
            logger.info("Result is set to: " + result);
        }

        return result;
    }

    public double enterNumber(){
        System.out.print("Enter a number: ");
        String stringValue = scanner.nextLine();

        double doubleValue = 0;
        boolean flag;
        do {
            try {
                doubleValue = Double.parseDouble(stringValue);
                flag = false;
            } catch (Exception e){
                logger.error("Incorrect string is entered: \"" + stringValue + "\"");
                System.out.print("Mistake was made! You can only enter numbers! Now, enter a number: ");
                stringValue = scanner.nextLine();
                logger.debug("Attempt to reenter number: \"" + stringValue + "\"");
                flag = true;
            }
        } while(flag);
        logger.info("Entered number is: " + doubleValue);
        return doubleValue;
    }

    public String enterOperator(){
        String operator;
        String prompt = ("You can enter one of the following operators:" +
                "\n+ for addition" +
                "\n- for subtraction" +
                "\n* for multiplication" +
                "\n/ for division" +
                "\nEnter an operator: "
        );

        System.out.print(prompt);
        operator = scanner.nextLine();

        while((!operator.equals("+")) && (!operator.equals("-")) && (!operator.equals("*")) && (!operator.equals("/"))){
            logger.error("Incorrect string is entered: \"" + operator + "\"");

            System.out.println("Mistake was made! You can only enter one of specified symbols.");
            System.out.print(prompt);
            operator = scanner.nextLine();

            logger.debug("Attempt to reenter operator: \"" + operator + "\"");
        }

        logger.info("Entered operator is: " + operator);
        return operator;
    }

    public String showDisplay(){
        String display = String.format("The result of operation %.2f %s %.2f = %.2f",
                firstNumber, operator, secondNumber, result);

        logger.info("Display text is: \"" + display + "\"");
        return display;
    }
}

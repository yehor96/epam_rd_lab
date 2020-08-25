package com.epam.test.ht3.task3;

public class Main {

    public static void main(String[] args) {
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
        calculator.showDisplay();
    }
}

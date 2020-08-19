package com.epam.test.ht3.task3;

public class Operation implements IOperator {

    @Override
    public double Addition(double number1, double number2) {
        return number1 + number2;
    }

    @Override
    public double Subtraction(double number1, double number2) {
        return number1 - number2;
    }

    @Override
    public double Multiplication(double number1, double number2) {
        return number1 * number2;
    }

    @Override
    public double Division(double number1, double number2) {
        return number1 / number2;
    }
}

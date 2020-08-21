package com.epam.test.ht6.task1.test;

import com.epam.test.ht6.task1.CalculatorString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTest {
    @Test
    void testAddMethodWithOneNumber() throws NegativesAreNotAllowedException {
        CalculatorString calculatorString = new CalculatorString();
        String value = "0";
        int expected = 0;

        int result = calculatorString.add(value);

        assertEquals(expected, result);
    }

    @Test
    void testAddMethodWithTwoNumbers() throws NegativesAreNotAllowedException {
        CalculatorString calculatorString = new CalculatorString();
        String value = "1,2";
        int expected = 3;

        int result = calculatorString.add(value);

        assertEquals(expected, result);
    }

    @Test
    void testAddMethodWithNoValues() throws NegativesAreNotAllowedException {
        CalculatorString calculatorString = new CalculatorString();
        String value = "";
        int expected = 0;

        int result = calculatorString.add(value);

        assertEquals(expected, result);
    }

    @Test
    void testAddMethodWithFiveValues() throws NegativesAreNotAllowedException {
        CalculatorString calculatorString = new CalculatorString();
        String value = "5,11,62,1,5";
        int expected = 84;

        int result = calculatorString.add(value);

        assertEquals(expected, result);
    }

    @Test
    void testAddMethodWithValuesSeparatedByNewLine() throws NegativesAreNotAllowedException {
        CalculatorString calculatorString = new CalculatorString();
        String value = "1\n2,3";
        int expected = 6;

        int result = calculatorString.add(value);

        assertEquals(expected, result);
    }

    @Test
    void testAddMethodWithValuesSeparatedByNewLineAndDelimiter() throws NegativesAreNotAllowedException {
        CalculatorString calculatorString = new CalculatorString();
        String value = "//;\n1\n2;3\n5";
        int expected = 11;

        int result = calculatorString.add(value);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ";", ":"})
    void testAddMethodWithValuesSeparatedByDelimiter(String delimiter) throws NegativesAreNotAllowedException {
        CalculatorString calculatorString = new CalculatorString();
        String value = "//" + delimiter + "\n1" + delimiter + "2";
        int expected = 3;

        int result = calculatorString.add(value);

        assertEquals(expected, result);
    }

    @Test
    void testAddMethodWithNegativeValue(){
        CalculatorString calculatorString = new CalculatorString();
        String value = "//;\n2;-2;-1";
        String expected = "[-2, -1]";

        Exception exception = assertThrows(NegativesAreNotAllowedException.class, () -> calculatorString.add(value));
        assertEquals(expected, exception.getMessage());
    }
}

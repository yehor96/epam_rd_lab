package com.epam.test.ht3.task3.test;

import com.epam.test.ht3.task3.Calculator;
import com.epam.test.ht3.task3.Operation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Float.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {

    @ParameterizedTest(name = "{index} => number1={0}, number2={1}, expectedResult={2}")
    @CsvSource({
            "1, 1, 2",
            "0, 3, 3",
            "-10, 3, -7",
            "-2, -3, -5",
            "-1, 0, -1"
    })
    void testAddition(double number1, double number2, double expectedResult){
        Calculator calculator = new Calculator(new Operation());
        String operator = "+";

        double actualResult = calculator.makeOperation(number1, number2, operator);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{index} => number1={0}, number2={1}, expectedResult={2}")
    @CsvSource({
            "5, 3, 2",
            "0, 3, -3",
            "-10, 3, -13",
            "-2, -3, 1",
            "9, 0, 9"
    })
    void testSubtraction(double number1, double number2, double expectedResult){
        Calculator calculator = new Calculator(new Operation());
        String operator = "-";

        double actualResult = calculator.makeOperation(number1, number2, operator);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{index} => number1={0}, number2={1}, expectedResult={2}")
    @CsvSource({
            "5, 3, 15",
            "0, 3, 0",
            "-10, 3, -30",
            "-2, -3, 6",
            "9, 1, 9"
    })
    void testMultiplication(double number1, double number2, double expectedResult){
        Calculator calculator = new Calculator(new Operation());
        String operator = "*";

        double actualResult = calculator.makeOperation(number1, number2, operator);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{index} => number1={0}, number2={1}, expectedResult={2}")
    @CsvSource({
            "6, 3, 2",
            "15, -3, -5",
            "15, 2, 7.5",
            "-20, 1, -20",
            "1, 4, 0.25"
    })
    void testDivision(double number1, double number2, double expectedResult){
        Calculator calculator = new Calculator(new Operation());
        String operator = "/";

        double actualResult = calculator.makeOperation(number1, number2, operator);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"&", "b", "2"})
    void testIllegalOperator(String operator){
        Calculator calculator = new Calculator(new Operation());
        double number1 = 1;
        double number2 = 2;
        double expectedResult = NaN;

        double actualResult = calculator.makeOperation(number1, number2, operator);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{index} => operator={0}, expectedResult ={1}")
    @CsvSource({
            "+, 'The result of operation 2.00 + 1.00 = 3.00'",
            "-, 'The result of operation 2.00 - 1.00 = 1.00'",
            "*, 'The result of operation 2.00 * 1.00 = 2.00'",
            "/, 'The result of operation 2.00 / 1.00 = 2.00'",
    })
    void testShowDisplay(String operator, String expectedResult){
        Calculator calculator = new Calculator(new Operation());

        double number1 = 2;
        double number2 = 1;

        calculator.setFirstNumber(number1);
        calculator.setSecondNumber(number2);
        calculator.setOperator(operator);
        calculator.makeOperation(number1, number2, operator);
        String actualResult = calculator.showDisplay();

        assertEquals(expectedResult, actualResult);
    }
}

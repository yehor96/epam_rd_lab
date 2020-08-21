package com.epam.test.ht3.task3.test;

import com.epam.test.ht3.task3.Calculator;
import com.epam.test.ht3.task3.Operation;
import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    void testAddition(){
        Calculator calculator = new Calculator(new Operation());

        calculator.makeOperation(5,6,"+");

    }
}

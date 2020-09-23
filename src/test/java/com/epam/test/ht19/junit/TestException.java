package com.epam.test.ht19.junit;

import com.epam.test.ht19.common.ExceptionMaker;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestException {
    /**
     * It is very easy to test exception with assertThrows method in JUnit.
     */
    @Test
    public void testThrowException() {
        assertThrows(ArithmeticException.class, ExceptionMaker::arithmetic);
    }

}

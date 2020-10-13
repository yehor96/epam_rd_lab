package com.epam.test.ht19.testng;

import com.epam.test.ht19.common.ExceptionMaker;
import org.testng.annotations.Test;


public class TestException {
    /**
     * In TestNG it is possible to only specify what kind of exception we are waiting for without assertions.
     */
    @Test(expectedExceptions = ArithmeticException.class)
    public void testThrowException() {
        ExceptionMaker.devideByZeroOperation();
    }
}

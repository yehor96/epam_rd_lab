package com.epam.test.ht19.testng;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestIgnore {
    /**
     * TestNG allows ignoring tests with additional parameter to @Test annotation
     */
    @Test(enabled = false)
    void testIgnore(){
        int a = 2;
        int b = 5;

        assertTrue(a < b);
    }
}

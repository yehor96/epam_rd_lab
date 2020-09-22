package com.epam.test.ht19.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIgnore {
    /**
     * JUnit allows ignoring tests with one simple annotation (@Ignore for JUnit4 and @Disabled for JUnit 5)
     * It is also possible to add a comment with reasons for ignoring a test.
     */
    @Disabled("Ignore this test.")
    @Test
    void testIgnore(){
        int a = 2;
        int b = 5;

        assertTrue(a < b);
    }
}

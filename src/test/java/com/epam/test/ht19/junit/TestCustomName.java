package com.epam.test.ht19.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCustomName {
    /**
     * Annotation @DisplayName allows specifying custom name for a test method.
     * This feature is available in JUnit5, but it is not possible to do so in TestNG.
     */
    @DisplayName("Custom Name")
    @Test
    void givenString_TestNullOrNot() {
        assertTrue(4 < 5);
    }
}

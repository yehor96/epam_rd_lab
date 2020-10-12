package com.epam.test.ht19.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestParameters {
    /**
     * JUnit allows simply specifying all the values that should be passed to the test.
     * It seems pretty easy and straightforward.
     * This can work when one argument should be parameterized using @ValueSource
     * Or it is possible to use @CsvSource for more than one parameterized argument.
     */
    @ParameterizedTest
    @ValueSource(strings = {"text", "word", "message"})
    void testValueSource(String value){
        assertFalse(value.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({ "1, 5", "2, 4", "6, 0" })
    void testCsvSource(int a, int b){
        assertEquals(6, a+b);
    }

    /**
     * It is also possible to create a method that will pass a stream of values into a test using @MethodSource.
     * This is basically the same approach as with @DataProvider in TestNG.
     */
    static Stream<Integer> valueProvider() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void givenMethodSource_TestInputStream(Integer digit) {
        assertTrue(0 < digit);
    }
}

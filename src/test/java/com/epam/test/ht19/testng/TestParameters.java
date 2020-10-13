package com.epam.test.ht19.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TestParameters {
    /**
     * TestNG allows giving a test an array of parameters using @DataProvider.
     * This approach is similar to @MethodSource in JUnit.
     */
    @DataProvider(name = "numbers")
    public static Object[][] numbersProvider() {
        return new Object[][]{{1, 5}, {2, 4}, {3, 3}};
    }

    @Test(dataProvider = "numbers")
    public void testDataProvider (int a, int b) {
        assertEquals(6, a+b);
    }

    /**
     * Another option is to pass parameters via XML file.
     */
    @Test
    @Parameters({"digit", "text"})
    public void testParameterViaXml(Integer digit, String txt){
        assertNotNull(digit);
        assertNotNull(txt);
    }
}

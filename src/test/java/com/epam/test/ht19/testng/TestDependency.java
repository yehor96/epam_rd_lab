package com.epam.test.ht19.testng;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class TestDependency {
    /**
     * TestNG allows creating tests that are dependent on other tests. So, if the first test fails,
     * the second (dependent test) will be skipped and will not fail.
     * In JUnit tests will fail in such situation (however, it is possible to use Assumptions for similar purposes).
     */
    @Test
    public void firstTest() {
        assertEquals(5, 3);
    }

    @Test(dependsOnMethods = {"firstTest"})
    public void dependentTest() {
        assertFalse("String".isEmpty());
    }
}

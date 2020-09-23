package com.epam.test.ht19.testng;

import org.testng.annotations.*;

public class BeforeAfter {

    /**
     * TestNG is way richer with Before/After annotations.
     * It is possible to not only run methods before each test and before class,
     * but also before the whole suite and before test group.
     */
    @BeforeGroups("testing")
    void setGroup(){
        System.out.println("Before Group");
    }

    @BeforeSuite
    void setSuite(){
        System.out.println("Before Suite");
    }

    @BeforeClass
    static void setUp(){
        System.out.println("BeforeAll");
    }

    @BeforeMethod
    void setUpEach(){
        System.out.println("BeforeEach");
    }

    @AfterMethod
    void tearDownEach(){
        System.out.println("AfterMethod");
    }

    @Test(groups = "testing")
    void test1(){
        System.out.println("== test1 ==");
    }

    @Test
    void test2(){
        System.out.println("== test2 ==");
    }

    @AfterClass
    static void tearDown(){
        System.out.println("AfterAll");
    }

    @AfterGroups("testing")
    void tearGroup(){
        System.out.println("Before Group");
    }

    @AfterSuite
    void tearSuite(){
        System.out.println("Before Suite");
    }
}
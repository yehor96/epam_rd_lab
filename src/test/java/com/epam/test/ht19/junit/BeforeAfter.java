package com.epam.test.ht19.junit;


import org.junit.jupiter.api.*;

public class BeforeAfter {
    /**
     * JUnit allows running method before whole test class and before each test method.
     */
    @BeforeAll
    static void setUp(){
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDownEach(){
        System.out.println("AfterEach");
    }

    @Test
    void test1(){
        System.out.println("== test ==");
    }

    @Test
    void test2(){
        System.out.println("== test ==");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("AfterAll");
    }
}

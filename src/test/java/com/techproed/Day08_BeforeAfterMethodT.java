package com.techproed;

import org.junit.*;

public class Day08_BeforeAfterMethodT {
    @BeforeClass
    public static void setUp(){
        System.out.println("Setup çalıştı.");

    }
    @Before
    public void methoddanOnce(){
        System.out.println("methoddanOnce çalıştı.");
    }
    @After
    public void methoddanSonra(){
        System.out.println("methoddanSonra çalıştı.");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 çalıştı.");
    }
    @Test
    public void test2(){
        System.out.println("Test 2 çalıştı.");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Terdown çalıştı.");
    }

}

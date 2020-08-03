package com.pacifico.test;

import org.testng.annotations.*;

public class testExploratory {

    @Test
    public void tcase1() {
        System.out.println("Test");
    }

    @BeforeMethod
    public void bmet() {
        System.out.println("Before Method");
    }

    @AfterClass
    public void amet() {
        System.out.println("After Method");
    }

    @BeforeSuite
    public void bsuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void asuite() {
        System.out.println("After Suite");
    }

    @BeforeClass
    public void bclass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void aclass() {
        System.out.println("After Class");
    }

}

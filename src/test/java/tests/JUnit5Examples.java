package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnit5Examples {

   @BeforeAll
    static void beforeAll(){
        System.out.println("==This before all tests");
    }

    @BeforeEach
    void beforeEach(){System.out.println("===This before each test");}

    @Test
    void firstTest() {
        System.out.println("=====Started firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("=====Started secondTest");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("==This after all tests");
    }
}

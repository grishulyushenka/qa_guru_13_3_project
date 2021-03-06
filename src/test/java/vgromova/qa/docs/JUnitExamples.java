package vgromova.qa.docs;

import org.junit.jupiter.api.*;

public class JUnitExamples {

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

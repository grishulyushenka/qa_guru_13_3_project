package vgromova.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import vgromova.qa.pages.StudentRegistrationFormPage;

public class TestBase {

    StudentRegistrationFormPage reg_form = new StudentRegistrationFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}

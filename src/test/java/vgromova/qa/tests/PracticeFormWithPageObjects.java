package vgromova.qa.tests;

import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjects extends TestBase {

    @Test
    void successfulTest() {

        reg_form.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setUserEmail("ivanov@ya.ru")
                .setGender("Male")
                .setUserNumber("9306705718")
                .setDateOfBirth("03", "March", "1990")
                .setSubject("Computer Science")
                .setHobby("Sports")
                .setPicture("kot_shrek.jpg")
                .setCurrentAddress("India")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submit();

        reg_form.checkSubmitTitle("Thanks for submitting the form")
                .checkResultsTable("Student Name", "Ivan Ivanov")
                .checkResultsTable("Student Email", "ivanov@ya.ru")
                .checkResultsTable("Gender", "Male")
                .checkResultsTable("Mobile", "9306705718")
                .checkResultsTable("Date of Birth", "03 March,1990")
                .checkResultsTable("Subjects", "Computer Science")
                .checkResultsTable("Hobbies", "Sports")
                .checkResultsTable("Picture", "kot_shrek.jpg")
                .checkResultsTable("Address", "India")
                .checkResultsTable("State and City", "Rajasthan Jaipur");

    }

}

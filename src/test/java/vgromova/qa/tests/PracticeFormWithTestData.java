package vgromova.qa.tests;

import org.junit.jupiter.api.Test;

public class PracticeFormWithTestData extends TestBase {

    @Test
    void successfulTest() {

        reg_form.openPage()
                .setFirstName(TestData.FIRST_NAME)
                .setLastName(TestData.LAST_NAME)
                .setUserEmail(TestData.USER_EMAIL)
                .setGender(TestData.GENDER)
                .setUserNumber(TestData.USER_NUMBER)
                .setDateOfBirth(TestData.DAY_OF_BIRTH, TestData.MONTH_OF_BIRTH, TestData.YEAR_OF_BIRTH)
                .setSubject(TestData.SUBJECT)
                .setHobby(TestData.HOBBY)
                .setPicture(TestData.PICTURE)
                .setCurrentAddress(TestData.CURRENT_ADDRESS)
                .setState(TestData.STATE)
                .setCity(TestData.CITY)
                .submit();

        reg_form.checkSubmitTitle("Thanks for submitting the form")
                .checkResultsTable("Student Name", TestData.FIRST_NAME + " " + TestData.LAST_NAME)
                .checkResultsTable("Student Email", TestData.USER_EMAIL)
                .checkResultsTable("Gender", TestData.GENDER)
                .checkResultsTable("Mobile", TestData.USER_NUMBER)
                .checkResultsTable("Date of Birth", TestData.DAY_OF_BIRTH + " " + TestData.MONTH_OF_BIRTH +
                        "," + TestData.YEAR_OF_BIRTH)
                .checkResultsTable("Subjects", TestData.SUBJECT)
                .checkResultsTable("Hobbies", TestData.HOBBY)
                .checkResultsTable("Picture", TestData.PICTURE)
                .checkResultsTable("Address", TestData.CURRENT_ADDRESS)
                .checkResultsTable("State and City", TestData.STATE + " " + TestData.CITY);

    }

}

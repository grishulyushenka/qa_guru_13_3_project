package vgromova.qa.tests;

import org.junit.jupiter.api.Test;

public class PracticeFormWithFaker extends TestBase {

    @Test
    void successfulTest() {

        TestData testData = new TestData();

        reg_form.openPage()
                .setFirstName(testData.randFirstName)
                .setLastName(testData.randLastName)
                .setUserEmail(testData.randUserEmail)
                .setGender(testData.randGender)
                .setUserNumber(testData.randUserNumber)
                .setDateOfBirth(testData.randDayOfBirth, testData.randMonthOfBirth, testData.randYearOfBirth)
                .setSubject(testData.randSubject)
                .setHobby(testData.randHobby)
                .setPicture(TestData.PICTURE)
                .setCurrentAddress(testData.randCurrentAddress)
                .setState(testData.randState)
                .setCity(testData.randCity)
                .submit();

        reg_form.checkSubmitTitle("Thanks for submitting the form")
                .checkResultsTable("Student Name", testData.randFirstName + " " + testData.randLastName)
                .checkResultsTable("Student Email", testData.randUserEmail)
                .checkResultsTable("Gender", testData.randGender)
                .checkResultsTable("Mobile", testData.randUserNumber)
                .checkResultsTable("Date of Birth", testData.randDayOfBirth + " " + testData.randMonthOfBirth  +
                        "," + testData.randYearOfBirth)
                .checkResultsTable("Subjects", testData.randSubject)
                .checkResultsTable("Hobbies", testData.randHobby)
                .checkResultsTable("Picture", TestData.PICTURE)
                .checkResultsTable("Address", testData.randCurrentAddress)
                .checkResultsTable("State and City", testData.randState + " " + testData.randCity);

    }

}

package vgromova.qa.pages;

import com.codeborne.selenide.SelenideElement;
import vgromova.qa.pages.components.CalenderComponent;
import vgromova.qa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationFormPage {

    public CalenderComponent calenderComponent = new CalenderComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            currentAddress = $("#currentAddress"),
            subject = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            state = $("#state"),
            stateValue =  $("#stateCity-wrapper"),
            city =  $("#city"),
            cityValue = $("#stateCity-wrapper"),
            submit = $("#submit"),
            successSubmitTitle = $("#example-modal-sizes-title-lg");
    public StudentRegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public StudentRegistrationFormPage setFirstName(String value){
        firstName.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setLastName(String value){
        lastName.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setUserEmail(String value){
        userEmail.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setGender(String value){
        gender.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage setUserNumber(String value){
        userNumber.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setDateOfBirth(String day, String month, String year){
        dateOfBirth.click();
        calenderComponent.setDate(day, month, year);

        return this;
    }

    public StudentRegistrationFormPage setDateOfBirthWithKeys(String day, String month, String year) {
        dateOfBirth.sendKeys(day + " " + month + " " + year);

        return this;
    }

    public StudentRegistrationFormPage setSubject(String value) {
        subject.sendKeys(value);
        subject.pressEnter();

        return this;
    }

    public StudentRegistrationFormPage setHobby(String value) {
        hobby.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage setPicture(String value) {
        picture.uploadFromClasspath(value);

        return this;
    }

    public StudentRegistrationFormPage setState(String value) {
        state.click();
        stateValue.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage setCity(String value) {
        city.click();
        cityValue.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage submit() {
        submit.click();

        return this;
    }

    public StudentRegistrationFormPage checkSubmitTitle(String value) {
        successSubmitTitle.shouldHave(text(value));

        return this;
    }

    public StudentRegistrationFormPage checkResultsTable(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}

package vgromova.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeForm extends TestBase {

    @Test
    void successfulTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //Заполнение полей формы
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");

        $("#userEmail").setValue("ivanov@ya.ru");

        $("#genterWrapper").$(byText("Male")).click();
        $("#gender-radio-1").shouldBe(selected);

        $("#userNumber").setValue("9306705718");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(2);
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").sendKeys("com");
        $("#subjectsInput").pressEnter();
        //$("#subjectsWrapper").$(byText("Computer Science")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        //$("#hobbies-checkbox-1").shouldBe(selected);
        $("#hobbiesWrapper").$(byText("Reading")).click();
        //$("#hobbies-checkbox-2").shouldBe(selected);
        $("#hobbiesWrapper").$(byText("Music")).click();
        //$("#hobbies-checkbox-3").shouldBe(selected);

        $("#uploadPicture").uploadFromClasspath("kot_shrek.jpg");

        $("#currentAddress").setValue("India");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(

                text("Ivan Ivanov"),
                text("ivanov@ya.ru"),
                text("Male"),
                text("9306705718"),
                text("03 March,1990"),
                text("Computer Science"),
                text("Sports, Reading, Music"),
                text("kot_shrek.jpg"),
                text("India"),
                text("Rajasthan Jaipur")

        );
    }

}

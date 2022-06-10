package vgromova.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        open("/automation-practice-form");
        //executeJavaScript("$('footer').remove()");
        //executeJavaScript("$('#fixedban').remove()");

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
        $(byText("3")).click();

        $("#subjectsInput").sendKeys("com");
        $(byText("Computer Science")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbies-checkbox-1").shouldBe(selected);
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbies-checkbox-2").shouldBe(selected);
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbies-checkbox-3").shouldBe(selected);

        $("#uploadPicture").uploadFromClasspath("kot_shrek.jpg");

        $("#currentAddress").setValue("India");

        $("#state").click();
        $(byText("Rajasthan")).click();

        $("#city").click();
        $(byText("Jaipur")).click();

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

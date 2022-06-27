package vgromova.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    @Test
    void successfulTest() {
        open("/text-box");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        String name = "Alex";
        String email = "Alex@example.com";
        String currentAddress = "Some address here 1";
        String permanentAddress = "Another address here 2";

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        $("[id=output]").find("[id=name]").shouldHave(text("Name:" + name));
        //$("[id=output] [id=name]").shouldHave(text("Name:" + name));
        //$("[id=output]").$("[id=name]").shouldHave(text("Name:" + name));
        $("[id=output]").find("[id=email]").shouldHave(text("Email:" + email));
        $("[id=output]").find("[id=currentAddress]").shouldHave(
                text("Current Address :" + currentAddress));
        $("[id=output]").find("[id=permanentAddress]").shouldHave(
                text("Permananet Address :" + permanentAddress));


    }
}

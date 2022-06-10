package vgromova.qa.docs;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void  cssXpathExamples() {

        $("[id=email]").setValue("123");
        $("#email").setValue("123");
        $(by("id", "email")).setValue("123");
        $x("//*[@id='email']").setValue("123");

        //<input type="email" class="inputtext login_form_input_box" name="email">
        $("[class=login_form_input_box]").setValue("123");
        $("[.login_form_input_box]").setValue("123");
        $("[.inputtext.login_form_input_box]").setValue("123");
        $("[input.inputtext.login_form_input_box]").setValue("123");
        $x("//input[@class='login_form_input_box']").setValue("123");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("123");

        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box" name="email">
        // </div>
        $("[.inputtext .login_form_input_box]").setValue("123");

        // <div> TEXT </div>
        $x("//div[text()=' TEXT ']");
        $x("//div[contains(text(), 'TEX')]");
        $x("//div[text()[contains(., 'TEX')]]");

        $(byText(" TEXT "));
        $(withText("TEXT"));

    }
}

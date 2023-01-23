package prog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import prog.TestBase;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrTests extends TestBase {
    @Test
    @DisplayName("Проверка страницы регистрации")

    void successfulRegistrationTest(){
        step("Открытие анкеты регистрации", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Заполнение анкеты", () -> {
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Fadeev");
        $("#userEmail").setValue("Alexs@mail.ru");
//
        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("8926012345");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2007");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("img/2.png");

        $("#currentAddress").setValue("Baker Street");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();
        });
        step("Проверка вводимых данных", () -> {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("Fadeev"), text("Alexs@mail.ru"), text("8926012345"));
        $("#closeLargeModal").click();
        });
    }
}

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrTests {


//    @BeforeAll
//    static void beforeAll(){
//        open("https://demoqa.com/automation-practice-form");
//        Configuration.browserSize = "1920x1080";
////        Configuration.holdBrowserOpen = true;
////
////
//    }
    @Test
    void successfulRegistrationTest(){
        String userName = "Alex";
        String lastName = "Fadeev";
        open("https://demoqa.com/automation-practice-form");


        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
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

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text(userName), text("Alexs@mail.ru"), text("8926012345"));
        $("#closeLargeModal").click();
    }
}

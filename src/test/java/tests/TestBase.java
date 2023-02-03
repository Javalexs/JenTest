package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

        @BeforeAll
        static void beforeAll(){
            ProjectConfig.setUp();
        }
        @BeforeEach
        void addListener(){
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        }
        @AfterEach
        void addAttachments(){
            Attach.screenshotAs("Скриншот страницы");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }

}

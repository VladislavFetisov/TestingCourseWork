package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.Props;
import core.User;
import core.ok.OkLoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public abstract class BaseTest {
    protected static User TEST_USER;
    protected OkLoginPage loginPage;


    @BeforeAll
    static void setup() throws IOException {
        Props.readJSON();
        Configuration.browser = Props.getBrowser();
        TEST_USER = Props.getRandomUser();
    }

    @BeforeEach
    void login() {
        loginPage = new OkLoginPage();
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWindow();
    }

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }
}

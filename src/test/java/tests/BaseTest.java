package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.Props;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public abstract class BaseTest {

    @BeforeAll
    static void setup() throws IOException {
        Props.readJSON();
        Configuration.browser = Props.getBrowser();
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

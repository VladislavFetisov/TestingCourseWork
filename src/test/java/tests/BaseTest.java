package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {
    @BeforeAll
    static void setup() {
        Configuration.browser = "firefox";
    }

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }
}

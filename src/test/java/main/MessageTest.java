package main;

import com.codeborne.selenide.Configuration;
import core.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class MessageTest {
    private static WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private MessagesPage messagesPage;

    @BeforeAll
    static void setup() {
//        System.setProperty("webdriver.gecko.driver", "/home/vladislav/wrk/geckoDriver/geckodriver");
//        driver = new FirefoxDriver(FirefoxDriver.);
        Props.readJSON();
        Configuration.browser = Props.getBrowser();
    }

    private void loginPageOkSetup() {
        loginPage = new OkLoginPage();
    }

    private void mainPageOkSetup() {
        mainPage = new OkMainPage();
    }

    private void messagesPageOkSetup() {
        messagesPage = new OkMessagesPage();
    }

    @Test
    void message() {
        loginPageOkSetup();
        mainPageOkSetup();
        messagesPageOkSetup();
        loginPage.login();
        mainPage.goToMessages();
        //waitUntilElementIsPresent("//msg-toolbar");

//        messagesPage.chooseDialog("Спутник");
//        messagesPage.sendText("Привет");
    }

    private void waitUntilElementIsPresent(String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeSelected(By.xpath(xpathExpression)));
    }

}


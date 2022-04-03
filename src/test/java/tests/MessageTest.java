package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.Props;
import core.ok.OkDialog;
import core.ok.OkLoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    private static OkLoginPage loginPage;

    @BeforeAll
    static void setup() {
        Props.readJSON();
        Configuration.browser = Props.getBrowser();
        loginPage = OkLoginPage.getInstance();
    }

    @Test
    void messageTest() {
        String dialogName = "Артур Галеев";
        String sendMessage = "Привет";
        OkDialog dialog = loginPage
                .login()
                .goToMessages()
                .chooseDialog(dialogName);
        dialog.sendText(sendMessage);
        try {
            String foundMessage = dialog.lastMessageText();
            assertEquals(sendMessage, foundMessage);
        } finally {
            dialog.deleteLastMessage();
        }
    }

    @AfterAll
    static void close(){
        Selenide.closeWebDriver();
    }

}

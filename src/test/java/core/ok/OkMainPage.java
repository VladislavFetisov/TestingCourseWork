package core.ok;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.time.Duration;

public class OkMainPage {
    public static final By MSG_BUTTON = By.xpath("//*[@id='msg_toolbar_button']");
    private static OkMainPage page;

    private OkMainPage() {
    }

    public static OkMainPage getInstance() {
        if (page == null) {
            page = new OkMainPage();
        }
        return page;
    }

    public OkMessagesPage goToMessages() {
        Selenide.$(MSG_BUTTON).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return OkMessagesPage.getInstance();
    }

}

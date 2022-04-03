package core.ok;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkMainPage extends BasePage {
    private static final By MAIN_LOGO = By.xpath("//*[@id='topPanelLeftCorner']");
    private static final By MSG_BUTTON = By.xpath("//*[@id='msg_toolbar_button']");
    private static final By PROFILE_BUTTON
            = By.xpath("//*[contains(@class,'user-main')]//*[contains(@hrefattrs,'userPage')]");

    public OkMessagesPage goToMessages() {
        $(MSG_BUTTON)
                .shouldBe(Condition.visible.because("Не отображается кнопка сообщений"), TIMEOUT)
                .click();
        return new OkMessagesPage();
    }

    public OkProfilePage goToProfile() {
        $(PROFILE_BUTTON)
                .shouldBe(Condition.visible.because("Не отображается кнопка профиля"), TIMEOUT)
                .click();
        return new OkProfilePage();

    }

    @Override
    void check() {
        $(MAIN_LOGO).shouldBe(Condition.visible.because("Главное лого должно отображаться"), TIMEOUT);
    }
}

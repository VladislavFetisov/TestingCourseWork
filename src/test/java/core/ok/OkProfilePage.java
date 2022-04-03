package core.ok;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkProfilePage extends BasePage {
    private static final By MAIN_PROFILE_WRAPPER = By.xpath("//*[@id='hook_Block_UserProfileCoverWrapper']");
    private static final By SETTINGS_BUTTON = By.xpath("//li[@class='u-menu_li  __custom']//*[@href='/settings']");

    @Override
    void check() {
        Utils.checkAndReturn(MAIN_PROFILE_WRAPPER, "Профиль должен появиться");
    }

    public OkSettingsPage goToSettings() {
        $(SETTINGS_BUTTON)
                .shouldBe(Condition.visible.because("Кнопка настроек должна быть"), TIMEOUT)
                .click();
        return new OkSettingsPage();
    }
}

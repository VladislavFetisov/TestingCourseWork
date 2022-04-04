package core.ok;

import org.openqa.selenium.By;

import static core.ok.Utils.waitUntilByShowUp;

public class OkSettingsPage extends BasePage {
    private static final By ANY_SETTINGS = By.xpath("//*[contains(@class,'user-settings')]");
    private static final By PROFILE_DATA
            = By.xpath("//*[contains(@class,'user-settings')]//*[contains(@hrefattrs,'EditProfile')]");
    private static final By LOGIN_HISTORY = By.xpath("//div[@id='hook_Block_UserSettingsMenu']//a[contains(@href, 'LocationHistory')]");


    public OkSettingsPopUP goToSettingsPopUp() {
        waitUntilByShowUp(PROFILE_DATA, "Должен появиться профиль").click();
        return new OkSettingsPopUP(this);
    }

    public OkLoginHistoryPage goToLoginHistoryPage() {
        waitUntilByShowUp(LOGIN_HISTORY, "Нет кнопки истории сообщений").click();
        return new OkLoginHistoryPage();
    }

    @Override
    void check() {
        waitUntilByShowUp(ANY_SETTINGS, "Настройки должны открыться");
    }

}

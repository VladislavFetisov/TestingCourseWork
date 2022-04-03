package core.ok;

import org.openqa.selenium.By;

public class OkSettingsPage extends BasePage {
    private static final By ANY_SETTINGS = By.xpath("//*[contains(@class,'user-settings')]");
    private static final By PROFILE_DATA
            = By.xpath("//*[contains(@class,'user-settings')]//*[contains(@hrefattrs,'EditProfile')]");

    @Override
    void check() {
        Utils.checkAndReturn(ANY_SETTINGS, "Настройки должны открыться");
    }

    public OkSettingsPopUP goToSettingsPopUp() {
        Utils.checkAndReturn(PROFILE_DATA, "Должен появиться профиль").click();
        return new OkSettingsPopUP(this);
    }

}

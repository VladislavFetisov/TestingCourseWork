package core.ok;

import org.openqa.selenium.By;

import static core.ok.Utils.waitUntilByShowUp;

public class OkSettingsPage extends BasePage {
    private static final By ANY_SETTINGS = By.xpath("//*[contains(@class,'user-settings')]");
    private static final By PROFILE_DATA
            = By.xpath("//*[contains(@class,'user-settings')]//*[contains(@hrefattrs,'EditProfile')]");
    private static final By LOGIN_HISTORY = By.xpath("//*[@id='hook_Block_UserSettingsMenu']//*[contains(@href, 'LocationHistory')]");
    private static final By TOP_PANEL = By.xpath("//*[@class='topPanel']");
    private static final By PERSON_INFO = By.xpath("//*[@class='portlet']");



    public OkSettingsPopUP goToSettingsPopUp() {
        waitUntilByShowUp(PROFILE_DATA, "Должен появиться профиль").click();
        return new OkSettingsPopUP(this);
    }

    public OkLoginHistoryPage goToLoginHistoryPage() {
        waitUntilByShowUp(LOGIN_HISTORY, "Нет кнопки истории сообщений").click();
        return new OkLoginHistoryPage();
    }

    @Override
    protected void isLoaded() throws Error {
        waitUntilByShowUp(ANY_SETTINGS, "Настройки должны открыться");
        waitUntilByShowUp(TOP_PANEL, "Верхняя панель должна отображаться");
        waitUntilByShowUp(PERSON_INFO, "Панель информации о человеке должна отображаться");
    }
}

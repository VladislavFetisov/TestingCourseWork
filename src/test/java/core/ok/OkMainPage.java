package core.ok;

import org.openqa.selenium.By;

import static core.ok.Utils.waitUntilByShowUp;

public class OkMainPage extends BasePage {
    private static final By MAIN_LOGO = By.xpath("//*[@id='topPanelLeftCorner']");
    private static final By MSG_BUTTON = By.xpath("//*[@id='msg_toolbar_button']");
    private static final By PROFILE_BUTTON
            = By.xpath("//*[contains(@class,'user-main')]//*[contains(@hrefattrs,'userPage')]");
    private static final By GROUPS_BUTTON = By.xpath("//*[contains(@class,'user-main')]//*[contains(@href,'/groups')]");
    private static final By INPUT_FIELD = By.xpath("//toolbar-search//label/input");

    public OkMessagesPage goToMessages() {
        waitUntilByShowUp(MSG_BUTTON, "Не отображается кнопка сообщений").click();
        return new OkMessagesPage();
    }

    public OkProfilePage goToProfile() {
        waitUntilByShowUp(PROFILE_BUTTON, "Не отображается кнопка профиля").click();
        return new OkProfilePage();

    }

    public OkGroupsPage goToGroups() {
        waitUntilByShowUp(GROUPS_BUTTON, "Не отображается кнопка групп").click();
        return new OkGroupsPage();
    }

    public OkSearchPage searchText(String text) {
        waitUntilByShowUp(INPUT_FIELD, "Нет поля ввода текста").val(text).pressEnter();
        return new OkSearchPage();
    }

    @Override
    protected void isLoaded() throws Error {
        waitUntilByShowUp(MAIN_LOGO, "Главное лого должно отображаться");
    }
}

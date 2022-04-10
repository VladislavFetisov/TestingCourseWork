package core.ok;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkSettingsPopUP extends BasePage {
    private static final By SETTING_MODAL_WINDOW = By.xpath("//*[@id='hook_Form_PopLayerEditUserProfileNewForm']");
    private static final By FIELD_NAME = By.xpath("//*[@id='field_name']");
    private static final By SUBMIT_BUTTON = By.xpath("//*[contains(@class,'form-actions_yes')]");
    private final OkSettingsPage settingsPage;

    public OkSettingsPopUP(OkSettingsPage settingsPage) {
        this.settingsPage = settingsPage;
    }

    public OkSettingsPage goToSettingsPage() {
        $(SUBMIT_BUTTON).click();
        settingsPage.isLoaded();
        return settingsPage;
    }

    public void changeName(String name) {
        $(FIELD_NAME).setValue(name);
    }

    public String getName() {
        return $(FIELD_NAME).getValue();
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        Utils.waitUntilByShowUp(SETTING_MODAL_WINDOW, "Должно появиться модальное окно");
    }
}

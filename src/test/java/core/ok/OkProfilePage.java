package core.ok;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static core.ok.Utils.waitUntilByShowUp;

public class OkProfilePage extends BasePage {
    private static final By MAIN_PROFILE_WRAPPER = By.xpath("//*[@id='hook_Block_UserProfileCoverWrapper']");
    private static final By SETTINGS_BUTTON = By.xpath("//li[@class='u-menu_li  __custom']//*[@href='/settings']");
    private static final By STATUS_FIELD = By.xpath("//div[@data-l='t,textField-text']/div[@tsid='TextFieldText']");
    private static final By STATUS_FIELD_INPUT = By.xpath("//div[@data-l='t,textField-text']/textarea");
    private static final By SAVE_STATUS_BTN = By.xpath("//div[@class='text-field_edit-controls']//button[@data-l='t,textField-save']");

    public OkProfilePage() {
        check();
    }

    public OkSettingsPage goToSettings() {
        waitUntilByShowUp(SETTINGS_BUTTON, "Кнопка настроек должна быть").click();
        return new OkSettingsPage();
    }

    public String getStatus() {
        return waitUntilByShowUp(STATUS_FIELD, "Нет поля статуса").getText();
    }

    public void setStatus(String newStatus) {
        waitUntilByShowUp(STATUS_FIELD, "Нет поля статуса").click();
        waitUntilByShowUp(STATUS_FIELD_INPUT, "Нет поля для вводя статуса").val(newStatus);
        waitUntilByShowUp(SAVE_STATUS_BTN, "Нет кнопки сохранить").click();
    }

    @Override
    void check() {
        Utils.waitUntilByShowUp(MAIN_PROFILE_WRAPPER, "Профиль должен появиться");
    }
}

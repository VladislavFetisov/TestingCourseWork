package core.ok;

import com.codeborne.selenide.Selenide;
import core.URL;
import core.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage extends BasePage {
    private static final By FIELD_EMAIL = By.xpath("//*[@id='field_email']");
    private static final By FIELD_PASSWORD = By.xpath("//*[@id='field_password']");

    public void openPage() {
        Selenide.open(URL.OK.getLink());
    }

    public void insertUser(User testUser) {
        $(FIELD_EMAIL).val(testUser.getLogin());
        $(FIELD_PASSWORD).val(testUser.getPass()).pressEnter();
    }

    public OkMainPage login(User testUser) {
        insertUser(testUser);
        return new OkMainPage();
    }

    @Override
    void check() {
        openPage();
        Utils.checkAndReturn(FIELD_EMAIL, "Текстовое поля для ввода логина должно отображаться");
    }

}

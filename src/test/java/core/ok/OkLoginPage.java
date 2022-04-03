package core.ok;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.URL;
import core.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage extends BasePage {
    private static final By FIELD_EMAIL = By.id("field_email");
    private static final By FIELD_PASSWORD = By.id("field_password");

    public void openPage() {
        Selenide.open(URL.OK.getLink());
    }

    public void insertUser() {
        User testUser = User.TEST_USER;
        $(FIELD_EMAIL).val(testUser.login());
        $(FIELD_PASSWORD).val(testUser.password()).pressEnter();
    }

    public OkMainPage login() {
        openPage();
        insertUser();
        return new OkMainPage();
    }

    @Override
    void check() {
        $(FIELD_EMAIL)
                .shouldBe(Condition.visible.because("Текстовое поля для ввода логина должно отображаться"), TIMEOUT);
    }

}

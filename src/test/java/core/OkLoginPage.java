package core;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage implements LoginPage {
    @Override
    public void openPage() {
        Selenide.open(URL.OK.getLink());
    }

    @Override
    public void insertUser() {
        User testUser = User.TEST_USER;
        $(By.id("field_email")).val(testUser.login());
        $(By.id("field_password")).val(testUser.password()).pressEnter();
    }

}

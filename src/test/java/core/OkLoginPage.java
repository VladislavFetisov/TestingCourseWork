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
        User testUser = Props.getRandomUser();
        $(By.id("field_email")).val(testUser.getLogin());
        $(By.id("field_password")).val(testUser.getPass()).pressEnter();
    }

}

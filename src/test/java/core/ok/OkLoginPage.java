package core.ok;

import com.codeborne.selenide.Selenide;
import core.Props;
import core.URL;
import core.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage  {
    public static final By FIELD_EMAIL = By.id("field_email");
    public static final By FIELD_PASSWORD = By.id("field_password");
    private static OkLoginPage page;

    private OkLoginPage() {

    }

    public static OkLoginPage getInstance() {
        if (page == null) {
            page = new OkLoginPage();
        }
        return page;
    }

    public void openPage() {
        Selenide.open(URL.OK.getLink());
    }

    public void insertUser() {
        User testUser = Props.getRandomUser();
        $(FIELD_EMAIL).val(testUser.getLogin());
        $(FIELD_PASSWORD).val(testUser.getPass()).pressEnter();
    }

    public OkMainPage login() {
        openPage();
        insertUser();
        return OkMainPage.getInstance();
    }
}

package core.ok;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkProfilePage extends BasePage {
    private static final By MAIN_PROFILE_WRAPPER = By.xpath("//*[@id='hook_Block_UserProfileCoverWrapper']");

    @Override
    void check() {
        $(MAIN_PROFILE_WRAPPER).shouldBe(Condition.visible.because("Профиль должен появиться"), TIMEOUT);
    }
}

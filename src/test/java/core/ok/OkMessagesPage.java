package core.ok;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkMessagesPage extends BasePage {

    private static final By MESSAGE_LAYER = By.xpath("//*[@id='msg_layer']");

    /**
     * @param fullName of user
     * @return first found dialog
     */
    public OkDialog chooseDialog(String fullName) {
        return OkDialog.getByName(fullName);
    }

    @Override
    void check() {
        Utils.checkAndReturn(MESSAGE_LAYER, "Сообщения должны появиться");
    }
}

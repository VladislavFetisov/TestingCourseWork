package core.ok;

import org.openqa.selenium.By;

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
    protected void isLoaded() throws Error {
        Utils.waitUntilByShowUp(MESSAGE_LAYER, "Сообщения должны появиться");
    }
}

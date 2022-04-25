package core.ok;

import org.openqa.selenium.By;

import static core.ok.Utils.waitUntilByShowUp;

public class OkMessagesPage extends BasePage {

    private static final By MESSAGE_LAYER = By.xpath("//*[@id='msg_layer']");
    private static final By SEARCH_FIELD = By.xpath("//msg-search-input");

    /**
     * @param fullName of user
     * @return first found dialog
     */
    public OkDialog chooseDialog(String fullName) {
        return OkDialog.getByName(fullName);
    }

    @Override
    protected void isLoaded() throws Error {
        waitUntilByShowUp(MESSAGE_LAYER, "Сообщения должны появиться");
        waitUntilByShowUp(SEARCH_FIELD, "Поиск по имени должен появиться");
    }
}

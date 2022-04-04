package core.ok;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static core.ok.Utils.waitUntilByShowUp;

public class OkDialog {
    private static final By MSG_INPUT_FIELD = By.xpath("//*[@class='input']//msg-input");
    private static final By LAST_SEND_MSG = By.xpath("//msg-message-list//*[last()-1]//msg-message[@mine][last()]");
    private static final By LAST_MSG_TEXT
            = By.xpath("//msg-message-list//*[last()-1]//msg-message[@mine][last()]//msg-parsed-text");
    private static final By LAST_SEND_MSG_CHECKBOX
            = By.xpath("//msg-message-controls//msg-button[@data-l='t,messageActionmore']");
    private static final By DELETE_MSG = By.xpath("//*[@id='msg_layer']//*[@data-tsid='remove_msg_button']");
    private static final By CONFIRM_DELETED = By.xpath("//msg-dialog//msg-button[@role='primary']");

    public static OkDialog getByName(String fullName) {
        waitUntilByShowUp(By.xpath(String.format("//*[text()='%s']", fullName.trim())),
                "Нельзя найти диалог по данному имени").click();
        return new OkDialog();
    }

    public void sendText(String text) {
        waitUntilByShowUp(MSG_INPUT_FIELD, "Нет поля для ввода текста").val(text).pressEnter();
    }

    public String lastMessageText() {
        return $(LAST_MSG_TEXT).text();
    }

    public void deleteLastMessage() {
        waitUntilByShowUp(LAST_SEND_MSG, "Нет последних отправленных сообщений").hover();
        waitUntilByShowUp(LAST_SEND_MSG_CHECKBOX, "Нет меню настроек у сообщения").click();
        waitUntilByShowUp(DELETE_MSG, "Нет кнопки удаления сообщения").click();
        waitUntilByShowUp(CONFIRM_DELETED, "Нет кнопки подтверждения удаления").click();
    }
}
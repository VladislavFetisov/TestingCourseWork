package core.ok;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkDialog {
    private static final By MSG_INPUT_FIELD = By.xpath("//*[@class='input']//msg-input");
    private static final By LAST_SEND_MSG = By.xpath("//msg-message[@mine][last()]");
    private static final By LAST_MSG_TEXT = By.xpath("//msg-message[@mine][last()]//msg-parsed-text");
    private static final By LAST_SEND_MSG_CHECKBOX = By.xpath("//msg-message[@mine][last()]//msg-checkbox");
    private static final By DELETE_MSG =
            By.xpath("//msg-chat-messages-controls//msg-button[@data-tsid='control-remove']");
    private static final By CONFIRM_DELETED = By.xpath("//msg-dialog//msg-button[@role='primary']");


    public static OkDialog getByName(String fullName) {
        $(By.xpath(String.format("//*[text()='%s']", fullName.trim())))
                .shouldBe(Condition.visible.because("Нельзя найти диалог по данному имени"), BasePage.TIMEOUT)
                .click();
        return new OkDialog();
    }

    public void sendText(String text) {
        $(MSG_INPUT_FIELD).val(text).pressEnter();
    }

    public String lastMessageText() {
        return $(LAST_MSG_TEXT).text();
    }

    public void deleteLastMessage() {
        $(LAST_SEND_MSG)
                .hover()
                .find(LAST_SEND_MSG_CHECKBOX)
                .click();
        $(DELETE_MSG).click();
        $(CONFIRM_DELETED).click();
    }
}
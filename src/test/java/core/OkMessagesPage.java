package core;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkMessagesPage implements MessagesPage {
    @Override
    public void chooseDialog(String name) {
        $(By.xpath(String.format("//*[text()='%s']", name.trim()))).click();
    }

    @Override
    public void sendText(String text) {
        $(By.xpath("//*[@class='input']//msg-input")).val(text).pressEnter();

    }

    @Override
    public void removeMessageByText(String text) {

    }
}

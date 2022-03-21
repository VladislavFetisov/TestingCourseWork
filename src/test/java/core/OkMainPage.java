package core;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class OkMainPage implements MainPage {

    @Override
    public void goToMessages() {
        Selenide.$(By.xpath("//*[@id='msg_toolbar_button']")).click();
    }
}

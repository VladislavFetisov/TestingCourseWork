package core.ok;

import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static core.ok.Utils.waitUntilByShowUp;

public class OkLoginHistoryPage extends BasePage{
    private static final By HISTORY_PAGE_TITLE = By.xpath("//div[@id='hook_Block_UserLocationHistory']/div[@class='user-settings __history']//span");
    private static final By LAST_TIME_LOGIN = By.xpath("//div[@id='hook_Block_UserLocationHistory']/div[@class='user-settings __history']/div[@class='user-settings_i'][1]//div[@class='user-settings_i_time']");

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public OkLoginHistoryPage() {
        check();
    }

    public LocalDateTime getLastLoginTime() {
        String s = waitUntilByShowUp(LAST_TIME_LOGIN, "Нет последних логинов").getText();
        return LocalDateTime.parse(s, dateTimeFormatter);
    }

    @Override
    void check() {
        waitUntilByShowUp(HISTORY_PAGE_TITLE, "Нет заголовка с текстом: Список подключений за последние 30 дней");
    }

    public static void main(String[] args) {
        LocalDateTime timeBeforeLogin = LocalDateTime.now();
        LocalDateTime lastLoginTime = LocalDateTime.parse("04.04.2022 14:35", OkLoginHistoryPage.dateTimeFormatter);
        System.out.println(lastLoginTime.isAfter(timeBeforeLogin));
    }
}

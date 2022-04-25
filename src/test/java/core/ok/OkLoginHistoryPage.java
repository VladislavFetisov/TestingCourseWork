package core.ok;

import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static core.ok.Utils.waitUntilByShowUp;

public class OkLoginHistoryPage extends BasePage {
    private static final By HISTORY_PAGE_TITLE
            = By.xpath("//*[@class='user-settings __history']//span");
    private static final By LAST_TIME_LOGIN
            = By.xpath("//*[@class='user-settings_i_time']");
    private static final By TOP_PANEL = By.xpath("//*[@class='topPanel']");


    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public LocalDateTime getLastLoginTime() {
        String s = waitUntilByShowUp(LAST_TIME_LOGIN, "Нет последних логинов").getText();
        return LocalDateTime.parse(s, dateTimeFormatter);
    }

    @Override
    protected void isLoaded() throws Error {
        waitUntilByShowUp(HISTORY_PAGE_TITLE, "Нет заголовка с текстом: Список подключений за последние 30 дней");
        waitUntilByShowUp(TOP_PANEL, "Верхняя панель должна отображаться");

    }
}

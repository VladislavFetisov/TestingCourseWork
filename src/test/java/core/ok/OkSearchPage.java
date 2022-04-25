package core.ok;

import org.openqa.selenium.By;

import static core.ok.Utils.waitUntilByShowUp;

public class OkSearchPage extends BasePage {
    private static final By MAIN_LOGO = By.xpath("//*[@id='topPanelLeftCorner']");
    private static final By SEARCH_FIELD = By.xpath("//div[contains(@class, 'wrap-input')]//input");
    private static final By TOP_PANEL = By.xpath("//*[@class='topPanel']");
    private static final By MAIN_PANEL = By.xpath("//*[contains(@class,'search-wrap')]");

    public String getSearchText() {
        return waitUntilByShowUp(SEARCH_FIELD, "Нет поискового поля").getValue();
    }

    @Override
    protected void isLoaded() throws Error {
        waitUntilByShowUp(MAIN_LOGO, "Главное лого должно отображаться");
        waitUntilByShowUp(TOP_PANEL, "Верхняя панель должна отображаться");
        waitUntilByShowUp(MAIN_PANEL, "Основная панель должна отображаться");
    }
}

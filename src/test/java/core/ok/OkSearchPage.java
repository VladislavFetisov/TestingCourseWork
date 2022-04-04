package core.ok;

import org.openqa.selenium.By;

import static core.ok.Utils.waitUntilByShowUp;

public class OkSearchPage extends BasePage {
    private static final By MAIN_LOGO = By.xpath("//*[@id='topPanelLeftCorner']");
    private static final By SEARCH_FIELD = By.xpath("//div[contains(@class, 'wrap-input')]//input");


    public String getSearchText() {
        return waitUntilByShowUp(SEARCH_FIELD, "Нет поискового поля").getValue();
    }

    @Override
    void check() {
        waitUntilByShowUp(MAIN_LOGO, "Главное лого должно отображаться");
    }
}

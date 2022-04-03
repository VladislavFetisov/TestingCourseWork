package core.ok;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OkGroupsPage extends BasePage {
    private static final By TOP_GROUPS_MODULE = By.xpath("//*[@id='hook_Block_MyGroupsTopBlock']");
    private static final By JOINED_GROUPS_NAMES
            = By.cssSelector("//*[@id='hook_Block_MyGroupsTopBlock']//li[@class='scroll-slider_item mr-x']//*[@alt]");
    private static final By FIRST_RECOMMENDED_GROUP
            = By.xpath("//*[contains(@class,'group-name-link')]");
    private static final By JOIN_FIRST_RECOMMENDED_GROUP = By.xpath("//*[contains(@class,'group-join')]");

    public OkGroupsPage() {
        check();
    }

    /**
     * @return group which we have joined
     */
    public Group joinFirstRecommendedGroup() {
        Group group = new Group($(FIRST_RECOMMENDED_GROUP).text());
        $(JOIN_FIRST_RECOMMENDED_GROUP).click();
        return group;
    }

    public List<Group> getAllJoinedGroups() {
        List<Group> groups = new ArrayList<>();
        for (SelenideElement selenideElement : $$(JOINED_GROUPS_NAMES)) {
            groups.add(new Group(selenideElement.getValue()));
        }
        return groups;
    }

    @Override
    void check() {
        Utils.waitUntilByShowUp(TOP_GROUPS_MODULE, "Модуль групп должен отображаться");
    }

    public record Group(String name) { //wrapper

    }
}

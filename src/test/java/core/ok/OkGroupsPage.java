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
            = By.xpath("//*[@id='listBlockPanelUserGroupsSectionBlock']//*[@class='group-vitrine-card_name']//span");
    private static final By FIRST_RECOMMENDED_GROUP = By.xpath("//*[contains(@class,'group-name-link')]");
    private static final By JOIN_FIRST_RECOMMENDED_GROUP
            = By.xpath("//*[@id='hook_Loader_PopularGroupsListBlockLoader']//*[contains(@class,'group-join')]//*");
    public static final By MY_GROUPS_BUTTON
            = By.xpath("//*[@id='hook_Block_UserGroupsPanelBlock']//*[contains(@hrefattrs,'User_MyGroupsNav_All')]");

    /**
     * @return group which we have joined
     */
    public Group joinFirstRecommendedGroup() {
        Group group = new Group($(FIRST_RECOMMENDED_GROUP).text());
        Utils.waitUntilByShowUp(JOIN_FIRST_RECOMMENDED_GROUP, "Кнопка вступить должна быть").click();
        return group;
    }

    public List<Group> getAllJoinedGroups() {
        List<Group> groups = new ArrayList<>();
        Utils.waitUntilByShowUp(JOINED_GROUPS_NAMES, "Группы должны появиться");
        for (SelenideElement selenideElement : $$(JOINED_GROUPS_NAMES)) {
            groups.add(new Group(selenideElement.text()));
        }
        return groups;
    }

    public OkGroupsPage goToUserGroups() {
        Utils.waitUntilByShowUp(MY_GROUPS_BUTTON, "Нет кнопки групп пользователя").click();
        return this;
    }

    @Override
    protected void isLoaded() throws Error {
        Utils.waitUntilByShowUp(TOP_GROUPS_MODULE, "Модуль групп должен отображаться");
    }

    public record Group(String name) { //wrapper

    }
}

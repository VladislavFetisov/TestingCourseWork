package tests.okTests;

import com.codeborne.selenide.Selenide;
import core.ok.OkGroupsPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import tests.BaseTest;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

class GroupTests extends BaseTest {

    /**
     * Логинимся в профиль->заходим в группы->вступаем в первую из рекомендованных групп->обновляем страницу
     * ->проверяем, что данная группа появилась в "Мои группы"
     */
    @Test
    @Timeout(60)
    void joinRandomGroup() {
        OkGroupsPage groupPage = loginPage
                .login(TEST_USER)
                .goToGroups()
                .goToUserGroups();
        List<OkGroupsPage.Group> oldGroups = groupPage.getAllJoinedGroups();
        OkGroupsPage.Group newGroup = groupPage.joinFirstRecommendedGroup();

        Selenide.refresh();
        List<OkGroupsPage.Group> upToDateGroups = groupPage.getAllJoinedGroups();
        assertThat(oldGroups).doesNotContain(newGroup); //matcher
        assertThat(upToDateGroups).contains(newGroup);
    }
}

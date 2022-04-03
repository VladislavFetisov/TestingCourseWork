package tests;

import com.codeborne.selenide.Selenide;
import com.google.common.truth.Truth;
import core.Props;
import core.User;
import core.ok.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OkTests extends BaseTest {
    private static final User TEST_USER = Props.getRandomUser();
    private OkLoginPage loginPage;

    @BeforeEach
    void login() {
        loginPage = new OkLoginPage();
    }

    /**
     * Логинимся в профиль -> открываем вкладку сообщения ->выбираем диалог
     * -> отправляем сообщение -> проверяем, что сообщение отправилось -> удаляем сообщение.
     *
     * @param dialogName название диалога
     * @param message    сообщения, которое отправляем
     */
    @ParameterizedTest
    @CsvSource(value = {
            "ВИКТОР ТОЛСТЫХ, ПРИВЕТ"
    })
    void messageTest(String dialogName, String message) {
        OkDialog dialog = loginPage
                .login(TEST_USER)
                .goToMessages()
                .chooseDialog(dialogName);
        dialog.sendText(message);
        String foundMessage = dialog.lastMessageText();
        dialog.deleteLastMessage();
        assertEquals(message, foundMessage, "Message is not found");
    }

    /**
     * Логинимся в профиль->открываем профиль->запоминаем имя->открываем настройки->меняем имя->открываем профиль
     * ->проверяем, что имя изменилось
     *
     * @param name имя, на которое будем менять
     */
    @ParameterizedTest
    @ValueSource(strings = {"Кирилл"})
    void changeProfileName(String name) {
        OkSettingsPopUP settingsPopUP = loginPage
                .login(TEST_USER)
                .goToProfile()
                .goToSettings()
                .goToSettingsPopUp();

        String oldName = settingsPopUP.getName();
        settingsPopUP.changeName(name);

        settingsPopUP.goToSettingsPage(); //back to old page
        Selenide.refresh();

        OkSettingsPopUP newPopUp = new OkSettingsPage().goToSettingsPopUp();
        String newName = newPopUp.getName();

        //settingOldName
        newPopUp.changeName(oldName);
        newPopUp.goToSettingsPage();

        Assertions.assertEquals(name, newName, "Ожидалось, что имя станет" + name);
    }

    /**
     * Логинимся в профиль->заходим в группы->вступаем в первую из рекомендованных групп->обновляем страницу
     * ->проверяем, что данная группа появилась в "Мои группы"
     */
    @Test
    void joinRandomGroup() {
        OkGroupsPage groupPage = loginPage
                .login(TEST_USER)
                .goToGroups();
        List<OkGroupsPage.Group> oldGroups = groupPage.getAllJoinedGroups();
        OkGroupsPage.Group newGroup = groupPage.joinFirstRecommendedGroup();

        Selenide.refresh();
        List<OkGroupsPage.Group> upToDateGroups = new OkGroupsPage().getAllJoinedGroups();

        Truth.assertThat(oldGroups).doesNotContain(newGroup); //matcher
        Truth.assertThat(upToDateGroups).contains(newGroup);

    }

    /**
     * Логинимся в профиль->пишем заметку-> публикуем заметку->проверяем, что заметка появилась->удаляем заметку.
     */
    @Test
    void createPost() {

    }
}

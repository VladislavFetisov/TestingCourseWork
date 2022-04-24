package tests.okTests;

import com.codeborne.selenide.Selenide;
import core.ok.OkProfilePage;
import core.ok.OkSettingsPage;
import core.ok.OkSettingsPopUP;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.BaseTest;

import static com.google.common.truth.Truth.assertWithMessage;

class ProfileTests extends BaseTest {

    /**
     * Логинимся в профиль->открываем профиль->запоминаем имя->открываем настройки->меняем имя->открываем профиль
     * ->проверяем, что имя изменилось
     *
     * @param name имя, на которое будем менять
     */
    @ParameterizedTest
    @ValueSource(strings = {"Кирилл"})
    @Timeout(60)
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

        assertWithMessage("Ожидалось, что имя станет" + name).that(name).isEqualTo(newName);
    }

    /**
     * Логинимся в профиль->открываем профиль->запоминаем статус->меняем статус->открываем профиль
     * ->проверяем, что статус изменился
     *
     * @param newStatus - статус, который будет вводиться
     */
    @ParameterizedTest
    @ValueSource(strings = {"Новый статус"})
    @Timeout(60)
    void changeProfileStatus(String newStatus) {
        OkProfilePage okProfilePage = loginPage
                .login(TEST_USER)
                .goToProfile();
        String oldStatus = okProfilePage.getStatus();

        okProfilePage.setStatus(newStatus);
        Selenide.refresh();
        String newReadStatus = okProfilePage.getStatus();

        okProfilePage.setStatus(oldStatus);

        assertWithMessage("Статусы не совпадают").that(newReadStatus).isEqualTo(newStatus);
    }
}

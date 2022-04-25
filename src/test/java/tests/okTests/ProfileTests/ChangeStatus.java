package tests.okTests.ProfileTests;

import com.codeborne.selenide.Selenide;
import core.ok.OkProfilePage;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.BaseTest;

import static com.google.common.truth.Truth.assertWithMessage;

public class ChangeStatus extends BaseTest {

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

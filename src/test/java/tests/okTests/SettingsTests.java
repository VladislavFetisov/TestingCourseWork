package tests.okTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import tests.BaseTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.google.common.truth.Truth.assertWithMessage;

class SettingsTests extends BaseTest {

    /**
     * Логинимся в профиль->открываем профиль->открываем настройки
     */
    @Test
    @DisplayName("Проверка времени логина")
    @Timeout(60)
    void checkHistoryLogin() {
        LocalDateTime timeBeforeLogin = LocalDateTime.now();
        LocalDateTime loginTime = loginPage
                .login(TEST_USER)
                .goToProfile()
                .goToSettings()
                .goToLoginHistoryPage()
                .getLastLoginTime();

        assertWithMessage("Время логина не совпадает")
                .that(loginTime).isAtLeast(timeBeforeLogin.truncatedTo(ChronoUnit.MINUTES));
    }
}

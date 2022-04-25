package tests.okTests.MessageTests;

import core.ok.OkDialog;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.BaseTest;

import static com.google.common.truth.Truth.assertWithMessage;

class SendTest extends BaseTest {

    /**
     * Логинимся в профиль -> открываем вкладку сообщения ->выбираем диалог
     * -> отправляем сообщение -> проверяем, что сообщение отправилось -> удаляем сообщение.
     *
     * @param dialogName название диалога
     * @param message    сообщения, которое отправляем
     */
    @ParameterizedTest
    @CsvSource(value = {
            "ВИКТОР ТОЛСТЫХ, ПРИВЕТ",
            "АЛЕКСАНДР ДОЛГОРУКИХ, САНЯ ВЕРНИ СОТКУ"
    })
    @Timeout(60)
    void messageTest(String dialogName, String message) {
        OkDialog dialog = loginPage
                .login(TEST_USER)
                .goToMessages()
                .chooseDialog(dialogName);
        dialog.sendText(message);
        String foundMessage = dialog.lastMessageText();
        dialog.deleteLastMessage();
        assertWithMessage("Отправленное сообщение не найдено")
                .that(message)
                .isEqualTo(foundMessage);
    }
}

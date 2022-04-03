package tests;

import core.ok.OkDialog;
import core.ok.OkLoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OkTests extends BaseTest {
    private static final String DIALOG_NAME = "Артур Галеев";
    private static final String MESSAGE = "Привет";
    private static final OkLoginPage loginPage = new OkLoginPage();


    /**
     * Логинимся в профиль -> открываем вкладку сообщения ->выбираем диалог с именем {@code DIALOG_NAME}
     * -> отправляем сообщение {@code MESSAGE} -> проверяем, что сообщение отправилось -> удаляем сообщение.
     */
    @Test
    void messageTest() {
        OkDialog dialog = loginPage
                .login()
                .goToMessages()
                .chooseDialog(DIALOG_NAME);
        dialog.sendText(MESSAGE);
        try {
            String foundMessage = dialog.lastMessageText();
            assertEquals(MESSAGE, foundMessage,"Message is not found");
        } finally {
            dialog.deleteLastMessage();
        }
    }

    /**
     * Логинимся в профиль->открываем профиль->запоминаем имя->открываем настройки->меняем имя->открываем профиль
     * ->проверяем, что имя изменилось
     */
    @Test
    void changeProfileName() {
        loginPage
                .login();


    }

    /**
     * Логинимся в профиль->заходим в группы->вступаем в первую из рекомендованных групп->обновляем страницу
     * ->проверяем, что данная группа появилась в "Мои группы"
     */
    @Test
    void joinRandomGroup() {

    }

    /**
     * Логинимся в профиль->пишем заметку-> публикуем заметку->проверяем, что заметка появилась->удаляем заметку.
     */
    @Test
    void createPost() {

    }
}

package tests.okTests.MainPageTests;

import core.ok.OkSearchPage;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.BaseTest;

import static com.google.common.truth.Truth.assertWithMessage;

class Search extends BaseTest {

    /**
     * Логинимся в профиль->в поле искать на сайте пишем текст->нажимаем на кнопку поиска
     * ->проверяем в поисковой строке текст
     *
     * @param initialText - текст, который будет вводиться
     */
    @ParameterizedTest
    @ValueSource(strings = {"Смысл жизни"})
    @Timeout(60)
    void search(String initialText) {
        OkSearchPage okSearchPage = loginPage
                .login(TEST_USER)
                .searchText(initialText);
        String foundText = okSearchPage.getSearchText();
        assertWithMessage("Поисковые запросы не совпадают").that(foundText).isEqualTo(initialText);
    }
}

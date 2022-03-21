package core;

public interface LoginPage extends Page {
    void insertUser();

    /**
     * Open mainPage
     */
    default void login() {
        openPage();
        insertUser();
    }
}

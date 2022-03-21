package core;

public record User(String login, String password) {
    private static final String TEST_LOGIN = "89189940901";
    private static final String TEST_PASSWORD = "ro3Faxqom";

    public static final User TEST_USER = new User(TEST_LOGIN, TEST_PASSWORD);

}

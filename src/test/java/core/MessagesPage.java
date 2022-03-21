package core;

public interface MessagesPage {
    void chooseDialog(String name);

    void sendText(String text);

    void removeMessageByText(String text);

}

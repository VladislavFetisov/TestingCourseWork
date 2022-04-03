package core;

import com.google.gson.JsonElement;
import core.ok.Utils;

public class User {

    private final String USER_LOGIN;
    private final String USER_PASSWORD;
    private final String USER_FIO;

    public User(JsonElement jsonElement) {
        this.USER_LOGIN = Utils.removeBrackets(jsonElement.getAsJsonObject().get("login").toString());
        this.USER_PASSWORD = Utils.removeBrackets(jsonElement.getAsJsonObject().get("password").toString());
        this.USER_FIO = Utils.removeBrackets(jsonElement.getAsJsonObject().get("fio").toString());
    }

    public String getLogin() {
        return USER_LOGIN;
    }

    public String getPass() {
        return USER_PASSWORD;
    }

    public String getFIO() {
        return USER_FIO;
    }
}

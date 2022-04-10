package core;

import com.google.gson.JsonElement;
import core.ok.Utils;

import java.util.Date;

public class User {

    private final String USER_LOGIN;
    private final String USER_PASSWORD;
    private final String USER_FIO;
    private String phoneNumber;
    private Date birthday;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public static class UserBuilder {
        private final User user;

        public UserBuilder(User user) {
            this.user = user;
        }

        public UserBuilder addPhoneNumber(String phoneNumber) {
            user.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder addBirthday(Date birthday) {
            user.birthday = birthday;
            return this;
        }

        public User build() {
            return user;
        }
    }
}

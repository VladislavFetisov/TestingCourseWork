package core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static com.google.gson.JsonParser.parseReader;

public class Props {
    private static final String FILE_NAME = "props.txt";
    private static List<User> userList;
    private static String BROWSER;

    // Reading from JSON file
    public static void readJSON() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            JsonElement jsonElement = parseReader(reader);
            JsonObject fileJsonObject = jsonElement.getAsJsonObject();

            userList = readUsers(fileJsonObject.getAsJsonArray("users"));
            BROWSER = readBrowser(fileJsonObject);
        } catch (IOException e) {
            System.out.println("Couldn't find props file \"" + FILE_NAME + "\"");
            userList = Collections.EMPTY_LIST;
            BROWSER = "";
            e.printStackTrace();
        }
    }

    public static String getBrowser() {
        return BROWSER;
    }

    public static String getFileName() {
        return FILE_NAME;
    }

    public static User getRandomUser() {
        if (userList.isEmpty()) {
            throw new NoSuchElementException("Так нет же пользователей лол");
        }
        return userList.get(0);
    }

    private static List<User> readUsers(JsonArray users) {
        if (users.isEmpty()) {
            System.out.println("No users in file \"" + FILE_NAME + "\"");
            return Collections.EMPTY_LIST;
        }

        ArrayList<User> objects = new ArrayList<>(users.size());
        for (JsonElement user : users) {
            objects.add(new User(user));
        }
        return objects;
    }

    private static String readBrowser(JsonObject fileJsonObject) {
        String browser = fileJsonObject.getAsJsonPrimitive("browser").toString();
        return browser.substring(1, browser.length() - 1);
    }
}

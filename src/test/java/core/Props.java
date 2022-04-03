package core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import core.ok.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static com.google.gson.JsonParser.parseReader;

public class Props {
    private static final String FILE_NAME = "props.json";
    private static List<User> userList;
    private static String BROWSER;

    // Reading from JSON file
    public static void readJSON() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (BufferedReader reader = openFile(classloader)) {
            JsonElement jsonElement = parseReader(reader);
            JsonObject fileJsonObject = jsonElement.getAsJsonObject();

            userList = readUsers(fileJsonObject.getAsJsonArray("users"));
            BROWSER = readBrowser(fileJsonObject);
        }
    }

    private static BufferedReader openFile(ClassLoader classloader) throws IOException {
        try {
            return new BufferedReader(new InputStreamReader(
                    Objects.requireNonNull(classloader.getResourceAsStream(FILE_NAME))));
        } catch (NullPointerException e) { //if file does not exist
            throw new IOException(String.format("File %s does not exist", FILE_NAME));
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
            return Collections.emptyList();
        }

        ArrayList<User> objects = new ArrayList<>(users.size());
        for (JsonElement user : users) {
            objects.add(new User(user));
        }
        return objects;
    }

    private static String readBrowser(JsonObject fileJsonObject) {
        String browser = fileJsonObject.getAsJsonPrimitive("browser").toString();
        return Utils.removeBrackets(browser);
    }
}

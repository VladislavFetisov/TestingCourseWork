package core.ok;

public final class Utils {
    private Utils() {

    }

    public static String removeBrackets(String value) {
        return value.substring(1, value.length() - 1);
    }
}

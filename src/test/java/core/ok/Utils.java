package core.ok;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public final class Utils {
    private static final Duration TIMEOUT = Duration.ofMillis(Configuration.timeout);

    private Utils() {

    }

    public static String removeBrackets(String value) {
        return value.substring(1, value.length() - 1);
    }

    public static SelenideElement waitUntilByShowUp(By selector, String message) {
        return $(selector).shouldBe(Condition.visible.because(message), TIMEOUT);
    }
}

package core.ok;

import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;

public abstract class BasePage extends LoadableComponent<BasePage> {
    public static Duration TIMEOUT = Duration.ofSeconds(10);

    /**
     * throws Error
     */
    protected BasePage() {
        isLoaded();
    }
}

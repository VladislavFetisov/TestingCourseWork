package core.ok;

import java.time.Duration;

public abstract class BasePage {
    public static Duration TIMEOUT = Duration.ofSeconds(10);

    abstract void check();

    protected BasePage() {
        check();
    }
}

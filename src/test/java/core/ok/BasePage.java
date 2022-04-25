package core.ok;

import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;

public abstract class BasePage extends LoadableComponent<BasePage> {
    /**
     * throws Error
     */
    protected BasePage() {
        isLoaded();
    }

    @Override
    protected void load() {
        //do nothing
    }
}

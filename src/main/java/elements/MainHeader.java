package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainHeader {

    private final By
        eventsTab = By.cssSelector("a.nav-link[href='/events']");

    public MainHeader clickOnEventsTab()
    {
        $(eventsTab).click();
        return this;
    }
}

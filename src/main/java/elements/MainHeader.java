package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainHeader {

    private final By
        eventsTab = By.cssSelector("a.nav-link[href='/events']"),
        videoTab = By.xpath("//a[text()='Video']");

    public MainHeader clickOnEventsTab()
    {
        $(eventsTab).click();
        return this;
    }

    public MainHeader clickOnVideoTab()
    {
        $(videoTab).click();
        return this;
    }

}

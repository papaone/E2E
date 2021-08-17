package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class EventsPage {

    private final By
        eventCard = By.xpath("//div[contains(@class,'event-card')]"),
        eventCounter = By.xpath("//span[contains(text(),'Upcoming')]/following-sibling::span[contains(@class,'counter')]");

    public Integer getEventCardCount()
    {
        Integer eventCardCount = Selenide.$$(eventCard).size();
        return eventCardCount;
    }

    public Integer getEventCounterValue()
    {
        Integer eventCounterValue = Integer.parseInt(Selenide.$(eventCounter).getText()) ;
        return eventCounterValue;
    }

}

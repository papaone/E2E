package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class EventsPage {

    private final By
            eventCard = By.xpath("//div[contains(@class,'event-card')]"),
            eventCounter = By.xpath("//span[contains(text(),'Upcoming')]/following-sibling::span[contains(@class,'counter')]"),
            pastEventsBtn = By.xpath("//span[contains(text(),'Past Events')]/parent::a"),
            pastEventCard = By.xpath("//div[@class='evnt-events-column cell-3']"),
            eventCardName = By.cssSelector("div.evnt-event-name span"),
            eventCardDate = By.cssSelector("div.evnt-event-dates-table span:first-child"),
            eventCardRegistrationInformation = By.cssSelector("div.evnt-event-dates-table span:nth-child(2)"),
            eventCardSpeakers = By.xpath("./div[@class='evnt-speaker']");

    public Integer getEventCardCount() {
        Integer eventCardCount = Selenide.$$(eventCard).size();
        return eventCardCount;
    }

    public Integer getEventCounterValue() {
        Integer eventCounterValue = Integer.parseInt(Selenide.$(eventCounter).getText());
        return eventCounterValue;
    }

    public EventsPage clickOnPastEventsBtn() {
        Selenide.$(pastEventsBtn).click();
        return this;
    }

    public ElementsCollection getPastEventCard() {
        return Selenide.$$(pastEventCard);
    }

    public SelenideElement getCardName()
    {
        return getPastEventCard().first().find(eventCardName);
    }

    public SelenideElement getCardDate()
    {
        return getPastEventCard().first().find(eventCardDate);
    }

    public SelenideElement getCardRegistrationInformation()
    {
        return getPastEventCard().first().find(eventCardRegistrationInformation);
    }

    public ElementsCollection getCardSpeakers() {
        return getPastEventCard().first().findAll(eventCardSpeakers);
    }
}

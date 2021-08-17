package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.EventsPage;

public class EventsPageSteps {
    EventsPage eventsPage = new EventsPage();

    @Step("Check that 'Events' counter have same value as events cards count")
    public EventsPageSteps checkEventCounterIsSameAsCardsCount()
    {
        Assertions.assertEquals(eventsPage.getEventCounterValue(),eventsPage.getEventCardCount());
        return this;
    }
}

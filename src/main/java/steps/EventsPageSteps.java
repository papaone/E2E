package steps;

import com.codeborne.selenide.junit.SoftAsserts;
import elements.PageLoader;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import pages.EventsPage;

public class EventsPageSteps {
    EventsPage eventsPage = new EventsPage();
    PageLoader pageLoader = new PageLoader();

    @Step("Check that 'Events' counter have same value as events cards count")
    public EventsPageSteps checkEventCounterIsSameAsCardsCount() {
        Assertions.assertEquals(eventsPage.getEventCounterValue(), eventsPage.getEventCardCount());
        return this;
    }

    @Step("Click on 'Past Events' button")
    public EventsPageSteps clickOnPastEventsButton() {

        eventsPage.clickOnPastEventsBtn();
        return this;
    }

    @Step("Assert that the 'Past Event' cards number is not null")
    public EventsPageSteps assertPastEventsCardsNumberIsNotNull() {
        pageLoader.waitLoaderDisappears();
        Assertions.assertNotNull(eventsPage.getPastEventCard());
        return this;
    }

    @Step("Assert that the 'Past Event' card contains information: location, name, date, etc.")
    public EventsPageSteps assertPastEventCardContent() {
        SoftAssertions.assertSoftly(softAssertions ->
        {
            softAssertions.assertThat(eventsPage.getCardName()).as("card name").isNotNull();
            softAssertions.assertThat(eventsPage.getCardDate()).as("card date").isNotNull();
            softAssertions.assertThat(eventsPage.getCardRegistrationInformation())
                    .as("card registration information").isNotNull();
            softAssertions.assertThat(eventsPage.getCardSpeakers().first()).as("card speakers").isNotNull();
        });

        return this;
    }
}

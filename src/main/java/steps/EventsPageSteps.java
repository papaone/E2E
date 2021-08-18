package steps;

import elements.Filter;
import elements.PageLoader;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import pages.EventsPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;

public class EventsPageSteps {

    EventsPage eventsPage = new EventsPage();
    PageLoader pageLoader = new PageLoader();
    Filter filter = new Filter();

    @Step("Check that 'Events' counter have same value as events cards count")
    public EventsPageSteps checkUpcomingEventCounterIsSameAsCardsCount() {
        pageLoader.waitLoaderDisappears();
        Assertions.assertEquals(eventsPage.getUpcomingEventCounterValue(), eventsPage.getEventCardCount());
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

    @Step("Assert that the event cards number is not null")
    public EventsPageSteps assertEventsCardsNumberIsNotNull() {
        pageLoader.waitLoaderDisappears();

        Assertions.assertNotNull(eventsPage.getPastEventCard());
        return this;
    }

    @Step("Assert that the 'Upcoming Event' cards date is >= now ")
    public EventsPageSteps assertUpcomingEventsCardsDate() throws ParseException {
        Date date = new SimpleDateFormat("dd MMM yyyy", Locale.US).parse(eventsPage.getCardDate().getText().substring(8));

        assertThat(true, Matchers.either(Matchers.is(date.after(Date.from(Instant.now()))))
                .or(Matchers.is(date.equals(Date.from(Instant.now())))));
        return this;
    }

    @Step("Select value in location dropdown")
    public EventsPageSteps selectValueInLocationDropDown(String location) {
        filter.selectLocation(location);
        return this;
    }

    @Step("Check that 'Past Events' counter have same value as events cards count")
    public EventsPageSteps checkPastEventCounterIsSameAsCardsCount() {
        Assertions.assertEquals(eventsPage.getPastEventCounterValue(), eventsPage.getEventCardCount());
        return this;
    }

    @Step("Assert that the 'Past Event' cards date is < now")
    public EventsPageSteps assertPastEventsCardsDate() throws ParseException {
        Date date = new SimpleDateFormat("dd MMM yyyy", Locale.US).parse(eventsPage.getCardDate().getText().substring(5));

        Assertions.assertTrue(date.before(Date.from(Instant.now())));
        return this;
    }
}

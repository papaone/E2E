import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import steps.EventsPageSteps;
import steps.MainPageSteps;
import steps.TalksLibraryPageSteps;
import steps.TalksPageSteps;

import java.text.ParseException;


@Execution(ExecutionMode.CONCURRENT)
public class FirstTest extends BaseTest {

    MainPageSteps mainPageSteps = new MainPageSteps();
    EventsPageSteps eventsPageSteps = new EventsPageSteps();
    TalksLibraryPageSteps talksLibraryPageSteps = new TalksLibraryPageSteps();
    TalksPageSteps talksPageSteps = new TalksPageSteps();

    @Test
    @AllureId("1")
    @Description("View upcoming events")
    public void viewUpcomingEvents() {
        mainPageSteps.navigateToEventsPage();
        eventsPageSteps.checkUpcomingEventCounterIsSameAsCardsCount();
    }

    @Test
    @AllureId("2")
    @Description("View Event Cards")
    public void viewEventCardsContent() {
        mainPageSteps.navigateToEventsPage();
        eventsPageSteps
                .clickOnPastEventsButton()
                .assertPastEventsCardsNumberIsNotNull()
                .assertPastEventCardContent();
    }

    @Test
    @AllureId("3")
    @Description("Validate date for upcoming event")
    public void validateDateForUpcomingEvent() throws ParseException {
        mainPageSteps.navigateToEventsPage();
        eventsPageSteps
                .assertEventsCardsNumberIsNotNull()
                .assertUpcomingEventsCardsDate();
    }

    @Test
    @AllureId("4")
    @Description("Check 'Past events' with location filter")
    public void checkPastEventsWithLocationFilter() throws ParseException {
        String location = "Canada";

        mainPageSteps.navigateToEventsPage();
        eventsPageSteps
                .clickOnPastEventsButton()
                .selectValueInLocationDropDown(location)
                .assertEventsCardsNumberIsNotNull()
                .checkPastEventCounterIsSameAsCardsCount()
                .assertPastEventsCardsDate();
    }

    @Test
    @AllureId("5")
    @Description("Check talks card filtering")
    public void checkTalksCardFiltering() {
        String location = "Belarus";
        String category = "Testing";
        String language = "ENGLISH";

        mainPageSteps.navigateToTalksLibraryPage();
        talksLibraryPageSteps.clickMoreFiltersIcon()
                .selectCategoryValue(category)
                .selectLocationValue(location)
                .selectLanguageValue(language)
                .openTalksCard();
        talksPageSteps
                .checkTalksPageDetails(location, category, language);
    }

    @Test
    @AllureId("6")
    @Description("Check talks card search by keyword")
    public void test6() {
        String searchValue = "QA";
        mainPageSteps.navigateToTalksLibraryPage();
        talksLibraryPageSteps.enterSearchValue(searchValue)
                .checkTalksCardNamesContains(searchValue);
    }
}

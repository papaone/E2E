import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import steps.EventsPageSteps;
import steps.MainPageSteps;

@Execution(ExecutionMode.CONCURRENT)
public class FirstTest extends BaseTest {

    MainPageSteps mainPageSteps = new MainPageSteps();
    EventsPageSteps eventsPageSteps = new EventsPageSteps();

    @Test
    @AllureId("1")
    @Description("View upcoming events")
    public void viewUpcomingEvents() {
        mainPageSteps.navigateToEventsPage();
        eventsPageSteps.checkEventCounterIsSameAsCardsCount();
    }

    @Test
    @AllureId("2")
    @Description("View Event Cards")
    public void testTwo() {
        mainPageSteps.navigateToEventsPage();
        eventsPageSteps
                .clickOnPastEventsButton()
                .assertPastEventsCardsNumberIsNotNull()
                .assertPastEventCardContent();
    }
}

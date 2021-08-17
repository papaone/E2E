import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import steps.EventsPageSteps;
import steps.MainPageSteps;

import static com.codeborne.selenide.Selenide.*;

@Execution(ExecutionMode.CONCURRENT)
public class FirstTest extends BaseTest{

    MainPageSteps mainPageSteps = new MainPageSteps();
    EventsPageSteps eventsPageSteps = new EventsPageSteps();

    @Test
    @AllureId("1")
    @Description("View upcoming events")
    public void viewUpcomingEvents()
    {
        mainPageSteps.navigateToMainPage()
                .clickOnEventsTab();
       eventsPageSteps.checkEventCounterIsSameAsCardsCount();
    }
}

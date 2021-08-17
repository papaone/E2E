package steps;

import elements.MainHeader;
import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {
    MainPage mainPage = new MainPage();
    MainHeader mainHeader = new MainHeader();

    @Step("Navigate to 'Main Page'")
    public MainPageSteps navigateToMainPage(){
        mainPage.goToMainPage();
        return this;
    }

    @Step("Click on 'Events' tab")
    public MainPageSteps clickOnEventsTab()
    {
        mainHeader.clickOnEventsTab();
        return this;
    }

}

package steps;

import elements.MainHeader;
import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {
    MainPage mainPage = new MainPage();
    MainHeader mainHeader = new MainHeader();

    @Step("Navigate to 'Events' page")
    public MainPageSteps navigateToEventsPage(){
        mainPage.goToMainPage();
        mainHeader.clickOnEventsTab();
        return this;
    }

    @Step("Navigate to 'Talks Library' page")
    public MainPageSteps navigateToTalksLibraryPage(){
        mainPage.goToMainPage();
        mainHeader.clickOnVideoTab();
        return this;
    }
}

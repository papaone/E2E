package steps;

import com.codeborne.selenide.SelenideElement;
import elements.Filter;
import elements.PageLoader;
import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import pages.TalksLibraryPage;

import java.util.Collections;

import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.MatcherAssert.assertThat;

public class TalksLibraryPageSteps {
    TalksLibraryPage talksLibraryPage = new TalksLibraryPage();
    Filter filter = new Filter();
    PageLoader pageLoader = new PageLoader();

    @Step("Click 'More Filters' icon")
    public TalksLibraryPageSteps clickMoreFiltersIcon(){
        pageLoader.waitLoaderDisappears();
        filter.clickMoreFiltersIcon();
        return this;
    }

    @Step("Select language value")
    public TalksLibraryPageSteps selectLanguageValue(String language){
        filter.selectLanguage(language);
        pageLoader.waitLoaderDisappears();
        return this;
    }

    @Step("Select location value")
    public TalksLibraryPageSteps selectLocationValue(String location){
        filter.selectLocation(location);
        pageLoader.waitLoaderDisappears();
        return this;
    }

    @Step("Select category value")
    public TalksLibraryPageSteps selectCategoryValue(String category){
        filter.selectCategory(category);
        pageLoader.waitLoaderDisappears();
        return this;
    }

    @Step("Open Talks card")
    public TalksLibraryPageSteps openTalksCard(){
        pageLoader.waitLoaderDisappears();
        talksLibraryPage.clickOnTalksCard();
        return this;
    }

    @Step("Enter search value")
    public TalksLibraryPageSteps enterSearchValue(String searchValue)
    {
        filter.enterValueInSearchField(searchValue);
        return this;
    }

    @Step("Check all Talks card names")
    public TalksLibraryPageSteps checkTalksCardNamesContains(String name){
        pageLoader.waitLoaderDisappears();
        sleep(500);
        for(SelenideElement element : talksLibraryPage.getAllTalksCardName())
        {
            Assertions.assertTrue(element.getText().contains(name));
            System.out.println(element.getText());
        }
        return this;
    }
}

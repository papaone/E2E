package elements;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class Filter {

    private final By
            locationDropDown = By.id("filter_location"),
            categoryDropDown = By.id("filter_category"),
            languageDropDown = By.id("filter_language"),
            moreFiltersIcon = By.cssSelector("div[href='#collapseMoreFilters']"),
            searchField = By.cssSelector("input[placeholder='Search by Talk Name']");

    public Filter selectLocation(String countryName) {
        Selenide.$(locationDropDown).click();
        Selenide.$(By.xpath("//label[@data-value='" + countryName + "']" )).click();
        return this;
    }

    public Filter selectCategory(String categoryName) {
        Selenide.$(categoryDropDown).click();
        Selenide.$(By.xpath("//label[@data-value='" + categoryName + "']" )).click();
        return this;
    }

    public Filter selectLanguage(String languageName) {
        Selenide.$(languageDropDown).click();
        Selenide.$(By.xpath("//label[@data-value='" + languageName + "']" )).click();
        return this;
    }

    public Filter clickMoreFiltersIcon() {
        Selenide.$(moreFiltersIcon).click();
        return this;
    }

    public Filter enterValueInSearchField(String searchValue) {
        Selenide.$(searchField).sendKeys(searchValue);
        return this;
    }
}

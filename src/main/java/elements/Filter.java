package elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Filter {

    private final By
            locationDropDown = By.id("filter_location"),
            categoryDropDown = By.id("filter_category"),
            languageDropDown = By.id("filter_language"),
            moreFiltersIcon = By.cssSelector("div[href='#collapseMoreFilters']"),
            searchField = By.cssSelector("input[placeholder='Search by Talk Name']");

    public Filter selectLocation(String countryName) {
        SelenideElement dropDown = Selenide.$(locationDropDown);
        dropDown.click();
        Selenide.$(By.xpath("//label[@data-value='" + countryName + "']" )).click();
        return this;
    }

    public Filter selectCategory(String categoryName) {
        SelenideElement dropDown = Selenide.$(categoryDropDown);
        dropDown.click();
        Selenide.$(By.xpath("//label[@data-value='" + categoryName + "']" )).click();
        return this;
    }

    public Filter selectLanguage(String languageName) {
        SelenideElement dropDown = Selenide.$(languageDropDown);
        dropDown.click();
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

package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;

public class TalksPage {

    private final By
        locationValue = By.xpath("//div[contains(@class,'evnt-talk-details location')]"),
        languageValue = By.xpath("//div[contains(@class,'evnt-talk-details language')]");

    public String getLocationValue()
    {
        return Selenide.$(locationValue).getText();
    }

    public String getLanguageValue()
    {
        return Selenide.$(languageValue).getText();
    }

    public String getCategoryValue(String categoryName)
    {
       return Selenide.$(By.xpath("//label[contains(text(),'"+ categoryName +"')]")).getText();
    }

}

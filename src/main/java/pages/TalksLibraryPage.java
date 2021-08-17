package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class TalksLibraryPage {
    private final By
            talksCard = By.xpath("//div[@class='evnt-talk-card']"),
            talksCardName = By.cssSelector("div.evnt-talk-name span");

    public TalksLibraryPage clickOnTalksCard() {
        Selenide.$$(talksCard).first().click();
        return this;
    }

    public ElementsCollection getAllTalksCardName() {
        return Selenide.$$(talksCardName);

    }

}



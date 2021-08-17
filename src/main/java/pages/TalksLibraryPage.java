package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

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



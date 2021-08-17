package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class PageLoader {

    private final By
            loader = By.xpath("//div[contains(@class,'evnt-loader')]");

    public void waitLoaderDisappears() {
        Selenide.$(loader).should(Condition.disappear);
    }
}

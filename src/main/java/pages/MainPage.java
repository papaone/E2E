package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class MainPage {

    private final String url = "https://events.epam.com/";

    private final By
        acceptCookieButton = By.id("onetrust-accept-btn-handler");

    public MainPage goToMainPage()
    {
        Selenide.open(url);
        return this;
    }

    public MainPage submitCookieIfDisplayed()
    {
        if(Selenide.$(acceptCookieButton).isDisplayed() == true)
        {
            Selenide.$(acceptCookieButton).click();
        }
        return this;
    }
}

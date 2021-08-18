package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class MainPage {
    private final By
            acceptCookieButton = By.id("onetrust-accept-btn-handler");


    public MainPage submitCookie() {
        Selenide.$(acceptCookieButton).click();
        return this;
    }
}

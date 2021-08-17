package pages;

import com.codeborne.selenide.Selenide;

public class MainPage {

    private final String url = "https://events.epam.com/";

    public MainPage goToMainPage()
    {
        Selenide.open(url);
        return this;
    }
}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    public static void openApp() {
        Configuration.browser = "chrome";
        //Configuration.baseUrl = "http://192.168.50.212:4444/wd/hub";
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "88";
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability("enableVNC", true);
        Configuration.pageLoadStrategy = PageLoadStrategy.NONE.toString();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        //open(Configuration.baseUrl);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}


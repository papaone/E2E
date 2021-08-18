import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.TestsConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class BaseTest {

    @BeforeEach
    public void openApp() {
        TestsConfig config = ConfigFactory.newInstance().create(TestsConfig.class, System.getProperties());
        //Configuration.remote = config.selenoidUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "91";
        Configuration.baseUrl = config.baseFrontendUrl();
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability("enableVNC", true);
        Configuration.pageLoadStrategy = PageLoadStrategy.NONE.toString();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open(Configuration.baseUrl);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}


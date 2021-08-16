import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Execution(ExecutionMode.CONCURRENT)
public class FirstTest extends BaseTest{

    @Test
    @AllureId("2")
    @Description("Check User logged in to otus.ru")
    public void goToGoogle()
    {
        open("https://google.com");
        sleep(500);
        $(By.xpath("test")).click();

    }

    @Test
    @AllureId("1")
    @Description("test2")
    public void goToOtus()
    {
        open("https://otus.ru");
        sleep(500);
    }
}

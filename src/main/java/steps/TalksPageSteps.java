package steps;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import pages.TalksPage;

public class TalksPageSteps {
    TalksPage talksPage = new TalksPage();

    @Step("Check talks page details")
    public TalksPageSteps checkTalksPageDetails(String location, String category, String language) {
        SoftAssertions.assertSoftly(softAssertions ->
        {
            softAssertions.assertThat(talksPage.getLocationValue()).as("location").contains(location);
            softAssertions.assertThat(talksPage.getCategoryValue(category)).as("category").isEqualTo(category);
            softAssertions.assertThat(talksPage.getLanguageValue()).as("language").isEqualTo(language);
        });

        return this;
    }
}

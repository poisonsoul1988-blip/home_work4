package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "poisonsoul1988-blip/java_base_jenkins_simple_tests";
    private static final String ISSUE = "New issue";

    @Test
    public void stepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open page", () -> {
            open("https://github.com");
        });

        step("Search repository" + REPOSITORY, () -> {
            $(".content__-QV4lC").click();
            $(".prc-components-Input-IwWrt").
                    setValue(REPOSITORY);
            $(".prc-components-Input-IwWrt").pressEnter();
        });

        step("Click repository link", () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Open Issue tab", () -> {
            $("a[href$='/issues']").click();
        });

        step("Check that the desired Issue exists", () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });

    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }

}

package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open mane page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search repository {repo}")
    public void searchForRepository(String repo) {
        $(".content__-QV4lC").click();
        $(".prc-components-Input-IwWrt").
                setValue(repo);
        $(".prc-components-Input-IwWrt").pressEnter();
    }

    @Step("Click repository link {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Open Issue tab")
    public void openIssuesTab() {
        $("a[href$='/issues']").click();
    }

    @Step("Check that the desired Issue exists")
    public void shouldSeeIssueWithNumber(String issue) {
        $(withText(issue)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

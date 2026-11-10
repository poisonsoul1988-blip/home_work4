package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class CleanSelenideTest {

    @Test
    public void cleanSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".content__-QV4lC").click();
        $(".prc-components-Input-IwWrt").
                setValue("poisonsoul1988-blip/java_base_jenkins_simple_tests");
        $(".prc-components-Input-IwWrt").pressEnter();

        $(linkText("poisonsoul1988-blip/java_base_jenkins_simple_tests")).click();
        $("a[href$='/issues']").click();
        $(withText("New issue")).should(Condition.exist);
    }
}

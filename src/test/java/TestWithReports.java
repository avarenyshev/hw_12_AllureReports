import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithReports {

    @Test
    void firstTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(byText("Search or jump to...")).click();
        $(byName("query-builder-test")).setValue("selenide").pressEnter();
        $(byXpath("//a[@href='/selenide/selenide']")).click();
        $("#issues-tab").click();
    }
}

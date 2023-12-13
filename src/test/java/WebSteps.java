import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    private void openMainPage() {
        open("https://github.com/");

    }
    @Step("Ищем репозиторий ")
    private void searchForRepository (String repo) {
        $(byText("Search or jump to...")).click();
        $(byName("query-builder-test")).setValue(StepsTest.REPOSITORY).pressEnter();

    }
    @Step("Кликаем по ссылке репозитория")
    private void clickOnRepositoryLink(String repo) {
        $(byXpath("//a[@href='/selenide/selenide']")).click();

    }
    @Step("Открываем таб Issues")
    private void openIssuesTab() {
        $("#issues-tab").click();

    }
    @Step("Проверяем наличие Issue с номером ")
    private void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + StepsTest.ISSUE)).should(Condition.exist);

    }

    @Test
    public void testAnnotationStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(StepsTest.REPOSITORY);
        steps.clickOnRepositoryLink(StepsTest.REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(StepsTest.ISSUE);

    }
}

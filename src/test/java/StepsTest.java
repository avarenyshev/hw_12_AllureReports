import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {
    public final static String REPOSITORY = "selenide/selenide";
    public final static int ISSUE = 2550;

    @Test
    void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {

            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(byText("Search or jump to...")).click();
            $(byName("query-builder-test")).setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(byXpath("//a[@href='/selenide/selenide']")).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
        $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }
}

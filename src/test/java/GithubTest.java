import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GithubTest extends TestBase{
    @Test
    void gitHubTest(){

        step("Открываем страницу GitHub", () ->{
            open("https://github.com/");});
        step("Ищем Selenide", () ->{
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("selenide");
            $(".header-search-input").submit();});
        step("Нажимаем на ссылку репозитория", () ->{
            $(linkText("selenide/selenide")).click();});
        step("Открываем раздел Wiki", () ->{
            $("#wiki-tab").shouldBe(Condition.visible).click();});
        step("Ищем SoftAssertions и кликаем на него", () ->{
            $(".js-wiki-more-pages-link.btn-link").click();
            $x("//div[@id='wiki-pages-box']//a[text()='SoftAssertions']").shouldBe(Condition.visible).click();});
        step("Проверяем наличие текста", () ->{
            $("#user-content-3-using-junit5-extend-test-class").shouldBe(Condition.visible);
        });

    }
}

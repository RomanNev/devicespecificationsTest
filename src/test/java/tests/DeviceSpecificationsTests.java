package tests;

import helpers.AllureAttachments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class DeviceSpecificationsTests extends TestBase {
    @Test
    @DisplayName("Открытие списка устройств бренда")
    void openBrandListTest() {
        step("Открыть 'https://www.devicespecifications.com'", () -> {
            open("");
        });

        step("Перейти в бренд Google", () -> {
            $(".brand-listing-container-frontpage").find(byText("Google")).click();
        });

        step("Проверить успешное открытие страницы со списком устройств бренда", () -> {
           $("nav:nth-child(1) > span:nth-child(1) > span:nth-child(2) > span:nth-child(1)").shouldHave(text("Google"));
        });
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.devicespecifications.com'", () ->
            open("https://www.devicespecifications.com"));

        step("Page title should have text 'DeviceSpecifications - Mobile device specifications, comparisons, news, user reviews and ratings'", () -> {
            String expectedTitle = "DeviceSpecifications - Mobile device specifications, comparisons, news, user reviews and ratings";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.devicespecifications.com'", () ->
            open("https://www.devicespecifications.com"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = AllureAttachments.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
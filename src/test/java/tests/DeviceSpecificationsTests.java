package tests;

import helpers.AllureAttachments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.*;
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


    @CsvSource(value = {
            ".en | DeviceSpecifications - Mobile device specifications, comparisons, news, user reviews and ratings",
            ".de | DeviceSpecifications - Spezifikationen der Mobilgeräte, Vergleiche, Nachrichten, Kundenrezensionen und Bewertungen",
            ".es | DeviceSpecifications - características y especificaciones de dispositivos móviles, comparaciones, novedades, opiniones de los usuarios y valoraciones",
            ".fr | DeviceSpecifications - Caractéristiques de dispositifs mobiles, comparaisons, actualités, avis d'utilisateurs",
            ".it | DeviceSpecifications - caratteristiche e specifiche di dispositivi mobili, confronti, notizie, valutazioni e opinioni degli utenti",
            ".ru | DeviceSpecifications - характеристики и спецификации мобильных устройств, сравнения, новости, оценки и отзывы потребителей",
            ".bg | DeviceSpecifications - Характеристики и спецификации на мобилни устройства, сравнения, новини, потребителски мнения и оценки",
            ".tr | DeviceSpecifications - Mobil cihaz özellikleri ve spesifikasyonları, karşılaştırmalar, haberler, kullanıcı yorumları ve değerlendirmeleri",

    },
            delimiter = '|'
    )

    @ParameterizedTest(name = "проверка смены языка ресурса \"{0}\" ")
    void changeLangTest(String lang, String titleLang) {
        step("Открыть 'https://www.devicespecifications.com'", () -> {
            open("");
        });

        step("Сменить язык на  \"{0}\"", () -> {
            $(lang).click();
        });

        step("Проверить успешную смену языка", () -> {
            String expectedTitle = titleLang;
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Поиск определенного девайса")
    void searchDeviceTest() {
        step("Открыть 'https://www.devicespecifications.com'", () -> {
            open("");
        });

        step("Ввести в строку поиска название устройства", () -> {
            $("#search").setValue("Google Pixel 6a").pressEnter();
        });

        step("Выбрать первое устройство в выдаче", () -> {
            $(".search-result-selected ").$(byText("Google Pixel 6a")).click();
        });

        step("Проверить открытие страницы с девайсом", () -> {
            $("header:nth-child(2) > h1").shouldHave(text("Google Pixel 6a - Specifications"));
        });
    }

    @Test
    @DisplayName("Добавление и удаление устройста из сравнения")
    void comparisonDeviceTest() {
        step("Открыть 'https://www.devicespecifications.com'", () -> {
            open("");
        });

        step("Ввести в строку поиска название  устройства", () -> {
            $("#search").setValue("Google Pixel 6a").pressEnter();
        });

        step("Выбрать устройство в выдаче", () -> {
            $(".search-result-selected ").$(byText("Google Pixel 6a")).click();
        });

        step("Добавить  устройство в сравнение", () -> {
            $("a.button span .image-arrows").click();
        });

        step("Удвлить устройство из сравнения", () -> {
            $("span.icon-button.icon-x").click();
        });

        step("Устройство удалено из сравнения", () -> {
            $(".comparison-container").shouldBe(hidden);
            $("span.icon-button.icon-x").shouldBe(hidden);
        });
    }


    @Test
    @DisplayName("Проверка suggest menu")
    void checkSuggestMenuTest() {
        step("Открыть 'https://www.devicespecifications.com'", () -> {
            open("");
        });

        step("Ввести в строку поиска название  устройства", () -> {
            $("#search").setValue("Google Pixel 6a").pressEnter();
        });

        step("Выбрать устройство в выдаче", () -> {
            $(".search-result-selected ").$(byText("Google Pixel 6a")).click();
        });

        step("Открыть suggest menu", () -> {
            $(".image-pencil").click();
        });


        step("Проверить содержимое suggest menu", () -> {
            $("#field_text[name=field_text]").shouldHave(
                    text("Provide information about," +
                            " which of the published data you want " +
                            "to be edited as well as a reliable source," +
                            " which confirms the accuracy " +
                            "of the information you suggest")
            );
            assertThat($("#submit-button").exists()).isEqualTo(true);

        });
    }


    @Test
    @DisplayName("В консоли страницы не должно быть ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть 'https://www.devicespecifications.com'", () ->
            open("https://www.devicespecifications.com"));

        step("Журналы консоли не должны содержать текст 'SEVERE'", () -> {
            String consoleLogs = AllureAttachments.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
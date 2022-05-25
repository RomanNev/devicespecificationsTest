# Проект по автоматизации тестирования для devicespecifications.com
## <a target="_blank" href="https://www.devicespecifications.com/">Веб сайт devicespecifications</a>

## Содержание:

- <a href="#технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#реализованные-проверки">Реализованные проверки</a>
- <a href="#запуск-из-терминала">Запуск из терминала</a>
- <a href="#отчет-в-telegram">Отчет в Telegram</a>


## Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

##  Реализованные проверки
- Открытие списка устройств бренда
- Смена языка ресурса (Параметризированные тесты)
- Поиск определенного девайса
- Сравнение двух устройств
- Проверка отсутсвия ошибок в консоли




##  Запуск из терминала

```bash
gradle clean test -Drun=remote
```

```bash
gradle clean test -Drun=local
```

## Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/screenshots/telegram-notification.png">
</p>



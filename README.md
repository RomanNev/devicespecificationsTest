# Проект по автоматизации тестирования для devicespecifications.com
## <a target="_blank" href="https://www.devicespecifications.com/">Веб сайт devicespecifications</a>

## Содержание:

- <a href="#технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#реализованные-проверки">Реализованные проверки</a>
- <a href="#запуск-из-терминала">Запуск из терминала</a>
- <a href="#сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#allure-отчет">Allure отчет</a>
- <a href="#отчет-в-telegram">Отчет в Telegram</a>
- <a href="#видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>


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

## Реализованные проверки
- Открытие списка устройств бренда
- Смена языка ресурса (Параметризированные тесты)
- Поиск определенного девайса
- Добавление и удаление устройста из сравнения
- Проверка suggest menu
- Проверка отсутсвия ошибок в консоли

## Запуск из терминала
### Локальный запуск 
```bash
gradle clean test -Drun=local
```

### Удаленный запуск

```bash
clean test  
-Dbrowser=${browser} 
-DbrowserVersion=${browserVersion} 
-DbrowserSize=${browserSize} 
-DremoteDriverUrl=${remoteDriverUrl}
```

## :Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/011-katana_sword_party-13-autotests/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins-dashboard.png">
</p>

## :Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure-main-page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure-test-page.png">
</p>

- ### График
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure-test-dashboard.png">
</p>

## Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/screenshots/telegram-notification.png">
</p>

## :Видео пример прохождения тестов
> Видео прилагается к каджому тесту
<p align="center">
  <img title="Selenoid Video" src="images/gif/test-run.gif">
</p>

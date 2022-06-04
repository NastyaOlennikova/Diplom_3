package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageObject {

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header/nav/a/p")
    public SelenideElement accountButton;//кнопка "Личный кабинет"

    @FindBy(how = How.XPATH, using = "//main/section[2]/div/button[text() = 'Войти в аккаунт']")
    public SelenideElement signInButtonMainPage;//кнопка "Войти в личный кабинет" на главной

    @FindBy(how = How.XPATH, using = "//section[2]/div/button[text() = 'Оформить заказ']")
    public SelenideElement makeOrderButton;//кнопка "Оформить заказ" на главной

    @FindBy(how = How.XPATH, using = "//header/nav/ul/li[1]/a/p[text() = 'Конструктор']")
    public SelenideElement constructorHeaderButton;//кнопка "Конструктор" в хэдере

    @FindBy(how = How.XPATH, using = "//div[starts-with(@class, 'AppHeader_header__logo')]")
    public SelenideElement stellarBurgersLogo;//логотип "Stella Burgers", хэдер

    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/div[1]/span[text() = 'Булки']")
    public SelenideElement bunsSectionButton;//кнопка выбора раздела "Булки", главная страница

    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/div[2]/span[text() = 'Соусы']")
    public SelenideElement saucesSectionButton;//кнопка выбора раздела "Соусы", главная страница

    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/div[3]/span[text() = 'Начинки']")
    public SelenideElement fillingsSectionButton;//кнопка выбора раздела "Начинки", главная страница

    public void goToPersonalAccount() {
        accountButton.click();
    }


}

package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StellarBurgersPageObject {

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header/nav/a/p")
    public SelenideElement accountButton;//кнопка "Личный кабинет"

    @FindBy(how = How.XPATH, using = "//div/div/p[1]/a[text() = 'Зарегистрироваться']")
    public SelenideElement signupButton;//кнопка "Зарегистрироваться"

    @FindBy(how = How.XPATH, using = "//main/section[2]/div/button[text() = 'Войти в аккаунт']")
    public SelenideElement signInButtonMainPage;//кнопка "Войти в личный кабинет" на главной

    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input[@name = 'name']")
    public SelenideElement nameInputRegistrationForm;//поле для ввода имени, регистрационная форма

    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input[@name = 'name']")
    public SelenideElement emailInputRegistrationForm;//поле для ввода email, регистрационная форма

    @FindBy(how = How.XPATH, using = "//fieldset[3]/div/div/input[@name = 'Пароль']")
    public SelenideElement passwordInputRegistrationForm;//поле для ввода пароля, регистрационная форма

    @FindBy(how = How.XPATH, using = "//div/form/button[text() = 'Зарегистрироваться']")
    public SelenideElement confirmSignUpButton;//кнопка "Зарегистрироваться"

    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input[@name = 'name']")
    public SelenideElement emailInputLoginForm; //поле для ввода email, форма авторизации

    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input[@name = 'Пароль']")
    public SelenideElement passwordInputLoginForm; //поле для ввода пароля, форма авторизации

    @FindBy(how = How.XPATH, using = "//main/div/form/button[text() = 'Войти']")
    public SelenideElement signInButtonLoginForm;//кнопка "Войти, форма авторизации

    @FindBy(how = How.XPATH, using = "//section[2]/div/button[text() = 'Оформить заказ']")
    public SelenideElement makeOrderButton;//кнопка "Оформить заказ" на главной

    @FindBy(how = How.XPATH, using = "//main/div/div/p[2]/a[text() = 'Восстановить пароль']")
    public SelenideElement restorePasswordButton;//кнопка "Восстановить пароль, форма авторизации

    @FindBy(how = How.XPATH, using = "//fieldset/div/div/input[@name = 'name']")
    public SelenideElement emailInputRestorePasswordForm;//поле ввода email, форма восстановления пароля

    @FindBy(how = How.XPATH, using = "//main/div/div/p/a[text() = 'Войти']")
    public SelenideElement signInButtonRestorePasswordForm;//кнопка "Войти", форма восстановления пароля

    @FindBy(how = How.XPATH, using = "//header/nav/ul/li[1]/a/p[text() = 'Конструктор']")
    public SelenideElement constructorHeaderButton;//кнопка "Конструктор" в хэдере

    @FindBy(how = How.XPATH, using = "//nav/ul/li[3]/button[text() = 'Выход']")
    public SelenideElement logOutButton;//кнопка "Выход", личный кабинет

    @FindBy(how = How.XPATH, using = "//div[starts-with(@class, 'AppHeader_header__logo')]")
    public SelenideElement stellarBurgersLogo;//логотип "Stella Burgers", хэдер

    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/div[1]/span[text() = 'Булки']")
    public SelenideElement bunsSectionButton;//кнопка выбора раздела "Булки", главная страница

    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/div[2]/span[text() = 'Соусы']")
    public SelenideElement saucesSectionButton;//кнопка выбора раздела "Соусы", главная страница

    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/div[3]/span[text() = 'Начинки']")
    public SelenideElement fillingsSectionButton;//кнопка выбора раздела "Начинки", главная страница
}

package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StellarBurgersPageObject {

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header/nav/a/p")
    public SelenideElement accountButton;//кнопка "Личный кабинет"

    @FindBy(how = How.CLASS_NAME, using = "text input__textfield text_type_main-default")
    public SelenideElement emailInput;//поле для ввода email

    @FindBy(how = How.CLASS_NAME, using = "input__placeholder text noselect text_type_main-default")
    public SelenideElement passwordInput;//поле для ввода пароля

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa")
    public SelenideElement signinButton;//кнопка "Войти"

    @FindBy(how = How.XPATH, using = "//div/p[1]/a[@class = 'Auth_link__1fOlj']")
    public SelenideElement signupButton;//кнопка "Зарегистрироваться"

    @FindBy(how = How.XPATH, using = "//div/main/div/div/p[2]/a[text()='Восстановить пароль']")
    public SelenideElement restorePasswordButton;//кнопка "Восстановить пароль"

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg")
    public SelenideElement signinButtonMainPage;//кнопка "Войти в личный кабинет" на главной

    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input[@name = 'name']")
    public SelenideElement nameInputRegistrationForm; //поле для ввода имени, регистрационная форма

    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input[@name = 'name']")
    public SelenideElement emailInputRegistrationForm;

    @FindBy(how = How.XPATH, using = "//fieldset[3]/div/div/input[@name = 'Пароль']")
    public SelenideElement passwordInputRegistrationForm;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/button[text()='Зарегистрироваться']")
    public SelenideElement confirmSignUpButton;





}

package org.example.pageobject;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPageObject {
    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input[@name = 'name']")
    public SelenideElement nameInputRegistrationForm;//поле для ввода имени, регистрационная форма

    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input[@name = 'name']")
    public SelenideElement emailInputRegistrationForm;//поле для ввода email, регистрационная форма

    @FindBy(how = How.XPATH, using = "//fieldset[3]/div/div/input[@name = 'Пароль']")
    public SelenideElement passwordInputRegistrationForm;//поле для ввода пароля, регистрационная форма

    @FindBy(how = How.XPATH, using = "//div/form/button[text() = 'Зарегистрироваться']")
    public SelenideElement confirmSignUpButton;//кнопка "Зарегистрироваться"

    @FindBy(how = How.XPATH, using = "//div/main/div/h2[text()='Регистрация']")
    public SelenideElement registerHeading;//заголовок формы - "Регистрация"

    @FindBy(how = How.XPATH, using = "//div/form/fieldset[3]/div/p[text() = 'Некорректный пароль']")
    public SelenideElement invalidPasswordErrorMessage;//ошибка "Некорректный пароль" при вводе невалидного значения

    public void registerHeadingIsVisible() {
        registerHeading.shouldBe(visible);
    }

    public void setName(String name) {
        nameInputRegistrationForm.setValue(name);
    }

    public void setEmail(String email) {
        emailInputRegistrationForm.setValue(email);
    }

    public void setPassword(String password) {
        passwordInputRegistrationForm.setValue(password);
    }
    public void confirmSignUp() {
        confirmSignUpButton.click();
    }

    public void invalidPasswordErrorMessageIsShown() {
        invalidPasswordErrorMessage.shouldBe(visible);
    }

    public void signUpUser(String name, String email, String password) {
        MainPageObject mainPage;
        LoginPageObject loginPage;
        RegisterPageObject registerPage;

        mainPage = open("https://stellarburgers.nomoreparties.site/",
                MainPageObject.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/",
                LoginPageObject.class);
        registerPage = open("https://stellarburgers.nomoreparties.site/",
                RegisterPageObject.class);

        mainPage.goToPersonalAccount();
        loginPage.signUpButtonIsVisible();
        loginPage.clickSignUpButton();
        registerPage.registerHeadingIsVisible();
        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(password);
        registerPage.confirmSignUp();
    }

}

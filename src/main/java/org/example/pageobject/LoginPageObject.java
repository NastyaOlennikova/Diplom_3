package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageObject {

    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input[@name = 'name']")
    public SelenideElement emailInputLoginForm; //поле для ввода email, форма авторизации

    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input[@name = 'Пароль']")
    public SelenideElement passwordInputLoginForm; //поле для ввода пароля, форма авторизации

    @FindBy(how = How.XPATH, using = "//main/div/form/button[text() = 'Войти']")
    public SelenideElement signInButtonLoginForm;//кнопка "Войти, форма авторизации

    @FindBy(how = How.XPATH, using = "//div/div/p[1]/a[text() = 'Зарегистрироваться']")
    public SelenideElement signUpButton;//кнопка "Зарегистрироваться"

    @FindBy(how = How.XPATH, using = "//main/div/div/p[2]/a[text() = 'Восстановить пароль']")
    public SelenideElement restorePasswordButton;//кнопка "Восстановить пароль, форма авторизации

    @FindBy(how = How.XPATH, using = "//div/main/div/h2[text()='Вход']")
    public SelenideElement signInHeading;//заголовок "Вход"

    public void signUpButtonIsVisible() {
        signUpButton.shouldBe(visible);
    }
    public void clickSignUpButton() {
        signUpButton.click();
    }
    public void signInHeadingIsVisible() {
        signInHeading.shouldBe(visible);
    }
    public void setEmail(String email) {
        emailInputLoginForm.setValue(email);
    }
    public void setPassword(String password) {
        passwordInputLoginForm.setValue(password);
    }
    public void clickSignInButton() {
        signInButtonLoginForm.click();
    }
    public void loginUser(String email, String password) {
        LoginPageObject loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPageObject.class);
        loginPage.signInHeadingIsVisible();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSignInButton();
    }

    public void clickRestorePasswordButton() {
        restorePasswordButton.click();
    }

}

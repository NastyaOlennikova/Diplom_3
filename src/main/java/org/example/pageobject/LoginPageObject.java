package org.example.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

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

    public void signUpButtonIsVisible() {
        signUpButton.shouldBe(visible);
    }
    public void clickSignUpButton() {
        signUpButton.click();
    }


}

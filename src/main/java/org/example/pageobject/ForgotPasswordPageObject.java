package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class ForgotPasswordPageObject {
    @FindBy(how = How.XPATH, using = "//fieldset/div/div/input[@name = 'name']")
    public SelenideElement emailInputRestorePasswordForm;//поле ввода email, форма восстановления пароля

    @FindBy(how = How.XPATH, using = "//main/div/div/p/a[text() = 'Войти']")
    public SelenideElement signInButtonRestorePasswordForm;//кнопка "Войти", форма восстановления пароля

    @FindBy(how = How.XPATH, using = "//main/div/h2[text() = 'Восстановление пароля']")
    public SelenideElement restorePasswordHeading;

    public void restorePasswordHeadingIsVisible() {
        restorePasswordHeading.shouldBe(visible);
    }
    public void clickSignInButton() {
        signInButtonRestorePasswordForm.click();
    }


}

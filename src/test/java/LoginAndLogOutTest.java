import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.StellarBurgersPageObject;
import org.example.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginAndLogOutTest {

    StellarBurgersPageObject mainPage;
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        Configuration.startMaximized = true;//опционально
        mainPage = open("https://stellarburgers.nomoreparties.site/",
                StellarBurgersPageObject.class);
        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(5) + ".ru";;
        password = RandomStringUtils.randomAlphabetic(6);
    }

    @Test
    public void loginMainPageButton() {
        mainPage.accountButton.click();
        mainPage.signupButton.shouldBe(visible);
        mainPage.signupButton.click();
        $(By.xpath("//div/main/div/h2[text()='Регистрация']")).shouldBe(visible);
        mainPage.nameInputRegistrationForm.setValue(name);
        mainPage.emailInputRegistrationForm.setValue(email);
        mainPage.passwordInputRegistrationForm.setValue(password);
        mainPage.confirmSignUpButton.click();
        $(By.xpath("/html/body/div/div/main/div/form/button[text() = 'Войти']")).shouldBe(visible);

        open("https://stellarburgers.nomoreparties.site/");
        mainPage.signInButtonMainPage.click();
        $(By.xpath("//div/main/div/h2[text()='Вход']")).shouldBe(visible);
        mainPage.emailInputLoginForm.setValue(email);
        mainPage.passwordInputLoginForm.setValue(password);
        mainPage.signInButtonLoginForm.click();
        mainPage.makeOrderButton.shouldBe(visible);
    }

    @Test
    public void loginHeaderAccountButton() {
        mainPage.accountButton.click();
        mainPage.signupButton.shouldBe(visible);
        mainPage.signupButton.click();
        $(By.xpath("//div/main/div/h2[text()='Регистрация']")).shouldBe(visible);
        mainPage.nameInputRegistrationForm.setValue(name);
        mainPage.emailInputRegistrationForm.setValue(email);
        mainPage.passwordInputRegistrationForm.setValue(password);
        mainPage.confirmSignUpButton.click();
        $(By.xpath("/html/body/div/div/main/div/form/button[text() = 'Войти']")).shouldBe(visible);

        refresh();
        mainPage.accountButton.click();
        $(By.xpath("//div/main/div/h2[text()='Вход']")).shouldBe(visible);
        mainPage.emailInputLoginForm.setValue(email);
        mainPage.passwordInputLoginForm.setValue(password);
        mainPage.signInButtonLoginForm.click();
        mainPage.makeOrderButton.shouldBe(visible);
    }

    @Test
    public void loginRestorePasswordFormButton() {
        mainPage.accountButton.click();
        mainPage.signupButton.shouldBe(visible);
        mainPage.signupButton.click();
        $(By.xpath("//div/main/div/h2[text()='Регистрация']")).shouldBe(visible);
        mainPage.nameInputRegistrationForm.setValue(name);
        mainPage.emailInputRegistrationForm.setValue(email);
        mainPage.passwordInputRegistrationForm.setValue(password);
        mainPage.confirmSignUpButton.click();
        $(By.xpath("/html/body/div/div/main/div/form/button[text() = 'Войти']")).shouldBe(visible);

        refresh();
        mainPage.accountButton.click();
        $(By.xpath("//div/main/div/h2[text()='Вход']")).shouldBe(visible);
        mainPage.restorePasswordButton.click();
        $(By.xpath("//main/div/h2[text()='Восстановление пароля']")).shouldBe(visible);
        mainPage.signInButtonRestorePasswordForm.click();
        mainPage.emailInputLoginForm.setValue(email);
        mainPage.passwordInputLoginForm.setValue(password);
        mainPage.signInButtonLoginForm.click();
        mainPage.makeOrderButton.shouldBe(visible);
    }

    @Test
    public void logOutTest() {
        mainPage.accountButton.click();
        mainPage.signupButton.shouldBe(visible);
        mainPage.signupButton.click();
        $(By.xpath("//div/main/div/h2[text()='Регистрация']")).shouldBe(visible);
        mainPage.nameInputRegistrationForm.setValue(name);
        mainPage.emailInputRegistrationForm.setValue(email);
        mainPage.passwordInputRegistrationForm.setValue(password);
        mainPage.confirmSignUpButton.click();
        $(By.xpath("/html/body/div/div/main/div/form/button[text() = 'Войти']")).shouldBe(visible);

        refresh();
        mainPage.accountButton.click();
        $(By.xpath("//div/main/div/h2[text()='Вход']")).shouldBe(visible);
        mainPage.emailInputLoginForm.setValue(email);
        mainPage.passwordInputLoginForm.setValue(password);
        mainPage.signInButtonLoginForm.click();
        mainPage.makeOrderButton.shouldBe(visible);

        mainPage.accountButton.click();
        $(By.xpath("//div/nav/p[text()='В этом разделе вы можете изменить свои персональные данные']")).shouldBe(visible);
        mainPage.logOutButton.click();
        $(By.xpath("//div/main/div/h2[text()='Вход']")).shouldBe(visible);

    }

    @After
    public void deleteTestData() {
        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);

    }





}

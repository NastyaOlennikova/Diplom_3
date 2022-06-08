import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pageobject.*;
import org.example.testdata.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginAndLogOutTest {

    MainPageObject mainPage = open("https://stellarburgers.nomoreparties.site/",
              MainPageObject.class);
    LoginPageObject loginPage = open("https://stellarburgers.nomoreparties.site/login",
              LoginPageObject.class);
    RegisterPageObject  registerPage = open("https://stellarburgers.nomoreparties.site/register",
              RegisterPageObject.class);
    ForgotPasswordPageObject  forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password",
              ForgotPasswordPageObject.class);
    AccountPageObject accountPage = open("https://stellarburgers.nomoreparties.site/account/profile", AccountPageObject.class);
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        /*если хотим прогнать тесты в firefox необходимо добавить строку: System.setProperty("selenide.browser", "firefox");
        для яндекс браузера (его драйвер сохранен локально), необходимо прописать:
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
                    driver = new ChromeDriver();
                    setWebDriver(driver);*/
        Configuration.startMaximized = true;//опционально

        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(5) + ".ru";
        password = RandomStringUtils.randomAlphabetic(6);
    }

    @Test
    @DisplayName("User login by main page 'Войти в аккаунт' button")
    public void loginMainPageButton() {
        registerPage.signUpUser(name, email, password);
        loginPage.signInHeadingIsVisible();
        mainPage.refreshMainPage();
        mainPage.clickSignInButton();
        loginPage.loginUser(email, password);
        mainPage.makeOrderButtonIsVisible();
    }

    @Test
    @DisplayName("User login by header 'Личный кабинет' button")
    public void loginHeaderAccountButton() {
        registerPage.signUpUser(name, email, password);
        loginPage.signInHeadingIsVisible();
        open("https://stellarburgers.nomoreparties.site/");
        mainPage.goToPersonalAccount();
        loginPage.loginUser(email, password);
        mainPage.makeOrderButtonIsVisible();
    }

    @Test
    @DisplayName("User login by 'Войти' button on restore password page")
    public void loginRestorePasswordFormButton() {
        registerPage.signUpUser(name, email, password);
        loginPage.signInHeadingIsVisible();
        mainPage.goToPersonalAccount();
        loginPage.clickRestorePasswordButton();
        forgotPasswordPage.restorePasswordHeadingIsVisible();
        forgotPasswordPage.clickSignInButton();
        loginPage.loginUser(email, password);
        mainPage.makeOrderButton.shouldBe(visible);
    }

    @Test
    @DisplayName("Log out user")
    public void logOutTest() {
        registerPage.signUpUser(name, email, password);
        loginPage.signInHeadingIsVisible();
        mainPage.goToPersonalAccount();
        loginPage.loginUser(email, password);
        mainPage.makeOrderButton.shouldBe(visible);
        accountPage.logOutUser();
    }

    @After
    public void deleteTestData() {
        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }

}

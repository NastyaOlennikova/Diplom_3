import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pageobject.LoginPageObject;
import org.example.pageobject.MainPageObject;
import org.example.pageobject.RegisterPageObject;
import org.example.testdata.TestData;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class SiteNavigationTest {
    MainPageObject mainPage;
    LoginPageObject loginPage = open("https://stellarburgers.nomoreparties.site/login",
                                   LoginPageObject.class);
    RegisterPageObject registerPage = open("https://stellarburgers.nomoreparties.site/register",
                                         RegisterPageObject.class);
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
        mainPage = open("https://stellarburgers.nomoreparties.site/",
                MainPageObject.class);
        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(5) + ".ru";
        password = RandomStringUtils.randomAlphabetic(6);
    }
    @Test
    @DisplayName("Go to 'Личный кабинет' button as an authorized user")
    public void goToAccountAuthorized() {
        registerPage.registerLoginAndGoToPersonalAccount(name, email, password);

        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }
    @Test
    @DisplayName("Click on logo from personal account")
    public void goToStellarBurgerLogoAuthorized() {
        registerPage.registerLoginAndGoToPersonalAccount(name, email, password);
        mainPage.clickLogo();
        mainPage.makeOrderButtonIsVisible();

        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }
    @Test
    @DisplayName("Go to constructor page as an authorized user")
    public void goToConstructorFromAccount() {
        registerPage.signUpUser(name, email, password);
        loginPage.signInHeadingIsVisible();
        loginPage.loginUser(email, password);
        mainPage.makeOrderButtonIsVisible();
        mainPage.goToConstructor();
        mainPage.constructBurgerHeadingIsVisible();

        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }
    @Test
    @DisplayName("Go to bun section")
    public void goToBunsSection() {
        mainPage.goToSaucesSection();
        mainPage.saucesHeadingIsVisible();
        mainPage.goToBunsSection();
        mainPage.bunsHeadingIsVisible();
    }
    @Test
    @DisplayName("Go to sauces section")
    public void goToSaucesSection() {
        mainPage.goToSaucesSection();
        mainPage.saucesHeadingIsVisible();
    }
    @Test
    @DisplayName("Go to filling section")
    public void goToFillingsSection() {
        mainPage.goToFillingsSection();
        mainPage.fillingsHeadingIsVisible();
    }
}

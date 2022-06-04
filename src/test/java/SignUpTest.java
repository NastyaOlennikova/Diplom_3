import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pageobject.*;
import org.example.testdata.TestData;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignUpTest {

    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        Configuration.startMaximized = true;//опционально
        /*если хотим прогнать тесты в firefox необходимо добавить строку: System.setProperty("selenide.browser", "firefox");
        для яндекс браузера (его драйвер сохранен локально), необходимо прописать:
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
                    driver = new ChromeDriver();
                    setWebDriver(driver);*/
        loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPageObject.class);
        registerPage = open("https://stellarburgers.nomoreparties.site/register",
                RegisterPageObject.class);
        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(5) + ".ru";
        password = RandomStringUtils.randomAlphabetic(6);
    }

    @Test
    public void signUpSuccess() {
        registerPage.signUpUser(name, email, password);
        loginPage.signUpButtonIsVisible();
        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }

    @Test
    public void signUpFail() {
        registerPage.signUpUser(name, email, RandomStringUtils.randomAlphabetic(4));
        registerPage.invalidPasswordErrorMessageIsShown();
    }
}

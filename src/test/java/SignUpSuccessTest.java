import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.StellarBurgersPageObject;
import org.example.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class SignUpSuccessTest {

    StellarBurgersPageObject mainPage;
    ChromeDriver driver;
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        /*System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
        driver = new ChromeDriver();
        setWebDriver(driver);*/
        Configuration.startMaximized = true;//опционально
        mainPage = open("https://stellarburgers.nomoreparties.site/",
                StellarBurgersPageObject.class);
        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(5) + ".ru";;
        password = RandomStringUtils.randomAlphabetic(6);
    }

    @Test
    public void signUp() {

        mainPage.accountButton.click();
        mainPage.signupButton.shouldBe(visible);
        mainPage.signupButton.click();
        $(By.xpath("//div/main/div/h2[text()='Регистрация']")).shouldBe(visible);
        mainPage.nameInputRegistrationForm.setValue(name);
        mainPage.emailInputRegistrationForm.setValue(email);
        mainPage.passwordInputRegistrationForm.setValue(password);
        mainPage.confirmSignUpButton.click();
        $(By.xpath("/html/body/div/div/main/div/form/button[text() = 'Войти']")).shouldBe(visible);
    }

    @After
    public void deleteTestData() {
        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }

}

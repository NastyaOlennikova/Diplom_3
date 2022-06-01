import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.StellarBurgersPageObject;
import org.example.TestData;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SiteNavigationTest {
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
    public void goToAccountAuthorized() {
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

        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }

    @Test
    public void goToStellarBurgerLogoAuthorized() {
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
        mainPage.stellarBurgersLogo.click();
        mainPage.makeOrderButton.shouldBe(visible);

        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }

    @Test
    public void goToConstructorFromAccount() {
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
        mainPage.constructorHeaderButton.click();
        $(By.xpath("/html/body/div/div/main/section[1]/h1[text()='Соберите бургер']")).shouldBe(visible);

        TestData testData = new TestData();
        testData.loginAndDeleteTestUser(email, password);
    }
    @Test
    public void goToBunsSection() {
        mainPage.saucesSectionButton.click();
        $(By.xpath("//section[1]/div[2]/h2[text() = 'Соусы']")).shouldBe(visible);
        mainPage.bunsSectionButton.click();
        $(By.xpath("//section[1]/div[2]/h2[text() = 'Булки']")).shouldBe(visible);
    }

    @Test
    public void goToSaucesSection() {
        mainPage.saucesSectionButton.click();
        $(By.xpath("//section[1]/div[2]/h2[text() = 'Соусы']")).shouldBe(visible);
    }

    @Test
    public void goToFillingsSection() {
        mainPage.fillingsSectionButton.click();
        $(By.xpath("//section[1]/div[2]/h2[text() = 'Начинки']")).shouldBe(visible);
    }


}

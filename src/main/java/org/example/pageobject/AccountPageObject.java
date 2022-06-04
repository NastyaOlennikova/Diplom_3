package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AccountPageObject {
    @FindBy(how = How.XPATH, using = "//nav/ul/li[3]/button[text() = 'Выход']")
    public SelenideElement logOutButton;//кнопка "Выход", личный кабинет

    @FindBy(how = How.XPATH, using = "//div/nav/p[text()='В этом разделе вы можете изменить свои персональные данные']")
    public SelenideElement accountInfoMessage;// информация о том, что в разделе "Личный кабинет" можно поменять данные юзера

    public void infoMessageIsShown() {
        accountInfoMessage.shouldBe(visible);
    }
    public void logOutUser() {
        MainPageObject mainPage;
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageObject.class);
        mainPage.goToPersonalAccount();
        logOutButton.click();
    }


}
package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPageObject {
    @FindBy(how = How.XPATH, using = "//nav/ul/li[3]/button[text() = 'Выход']")
    public SelenideElement logOutButton;//кнопка "Выход", личный кабинет
}

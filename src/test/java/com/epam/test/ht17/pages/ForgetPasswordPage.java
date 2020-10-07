package com.epam.test.ht17.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class ForgetPasswordPage extends BasePage {
    @FindBy(id = "username")
    private TextInput loginField;

    @FindBy(id = "se_userSignIn")
    private Button changeButton;

    @FindBy(className = "login-box__title")
    private TextBlock enterNewPassLabel;

    public ForgetPasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewPassLabelDisplayed(){
        return enterNewPassLabel.isDisplayed();
    }

    public void clickChangeButton(){
        changeButton.click();
    }

    public void fillOutLoginField(String text){
        loginField.clear();
        loginField.sendKeys(text);
    }
}

package com.epam.test.ht20.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

public class SignInPage extends BasePage {
    @FindBy(css = "div.errorboxContainer")
    private List<WebElement> errorMessages;

    @FindBy(id = "se_userLogin")
    private Button login;

    @FindBy(id = "userEmail")
    private TextInput loginField;

    @FindBy(id = "userPass")
    private TextInput passwordField;

    @FindBy(css = "label.error")
    private WebElement invalidLoginError;

    @FindBy(xpath = "//div[@class='errorboxContainer']/label[@for='userPass']")
    private WebElement invalidPasswordError;

    @FindBy(className = "login-form__lostpassword")
    private Button forgetPasswordButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public ForgetPasswordPage clickForgetPasswordButton(){
        forgetPasswordButton.click();
        return new ForgetPasswordPage(driver);
    }

    public void setLoginField(String value){
        loginField.clear();
        loginField.sendKeys(value);
    }

    public void setPasswordField(String value){
        passwordField.clear();
        passwordField.sendKeys(value);
    }

    public boolean IsErrorMessageInvalidLoginDisplayed(){
        return invalidLoginError.isDisplayed();
    }

    public boolean areEmptyErrorMessagesDisplayed(){
        for (var each : errorMessages){
            if(each.isDisplayed()){
                continue;
            }
            return false;
        }
        return true;
    }

    public void clickLoginButton(){
        login.click();
    }

    public boolean IsErrorMessageInvalidPasswordDisplayed(){
        return invalidPasswordError.isDisplayed();
    }
}

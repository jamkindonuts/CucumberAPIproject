package com.qa.studyMate.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[autocomplete='username']")
    WebElement emailInputLogin;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public @FindBy(xpath = "//form/button[@type='button']")
    WebElement forgotPasswordButton;

    public @FindBy(xpath = "//input[@id=':r2:']")    // //div[contains(@class, 'MuiFormControl-root')]//input[@type='text' and @id=':r2:']
    WebElement enterEmailForgotPasswordPart;

    public @FindBy(xpath = "//div[@id='content']//button")
    WebElement submitButton;

    public @FindBy(css = "#mui-component-select-language")
    WebElement languageDropBox;

    @FindBy(css = "li[data-value='ru']")
    WebElement russian;

    @FindBy(css = "li[data-value='en']")
    WebElement english;

    public @FindBy(css = ".MuiAlert-message")
    WebElement alertMessage;

    @FindBy(xpath = "//h2")
    WebElement logInHeader;

    @FindBy(xpath = "//p[.='Sign up with Google']")
    WebElement signWithGoogle;

    public void login(String email, String password) {
        emailInputLogin.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void forgotPassword(String email){
        forgotPasswordButton.click();
        enterEmailForgotPasswordPart.sendKeys(email);
        submitButton.click();
    }

    public void chooseLanguage(String language){
        languageDropBox.click();
        if(language.equalsIgnoreCase("russian")){
            russian.click();
        } else {
            english.click();
        }
    }

    public void checkLoginPageInformation(WebDriver driver, String expectedLoginHeader) {
        Assert.assertEquals(BrowserUtils.getText(logInHeader), expectedLoginHeader);
        Assert.assertTrue(signWithGoogle.isDisplayed() && signWithGoogle.isEnabled());
        Assert.assertTrue(forgotPasswordButton.isDisplayed() && forgotPasswordButton.isEnabled());
        Assert.assertTrue(loginButton.isDisplayed() && loginButton.isEnabled());
    }
}

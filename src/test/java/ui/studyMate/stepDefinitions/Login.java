package ui.studyMate.stepDefinitions;

import ui.studyMate.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Driver;
import utils.WaitUtils;

public class Login {

    WebDriver driver= Driver.getDriver("chrome");
    LoginPage loginPage = new LoginPage(driver);

    @When("User chooses {string}")
    public void user_chooses(String language) {

        loginPage.chooseLanguage(language);
    }

    @When("User clicks forgot password button, enters {string} and clicks submit button")
    public void user_clicks_forgot_password_button_enters_and_clicks_submit_button(String loginEmail) {
//        String emailForLogin = ConfigReader.readProperty(loginEmail);
        loginPage.forgotPassword(ConfigReader.readProperty(loginEmail));
    }

    @Then("User validates the {string}")
    public void user_validates_the(String message) {
        WaitUtils.waitForVisibility(driver, loginPage.alertMessage);
        String actualAlertMessage = loginPage.alertMessage.getText();
        String expectedMessage = message;
        Assert.assertEquals(expectedMessage, actualAlertMessage);
    }

    @When("User enters username {string}, password {string}, clicks login button")
    public void u_ser_enters_username_password_clicks_login_button(String loginEmail, String password) throws InterruptedException {
        loginPage.login(ConfigReader.readProperty(loginEmail), ConfigReader.readProperty(password));
    }
    @Then("verify User us logged in by validating URL")
    public void verify_user_us_logged_in_by_validating_url() {
        String expectedUrl = ConfigReader.readProperty("expected_url_after_login");
        WaitUtils.waitForUrlToBe(driver, expectedUrl);
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}

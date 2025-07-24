package ui.studyMate.stepDefinitions;

import ui.studyMate.pages.TeachersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.Driver;
import utils.WaitUtils;

public class Teachers {

    WebDriver driver = Driver.getDriver("chrome");
    TeachersPage teachersPage = new TeachersPage(driver);

    @When("User clicks Teachers button")
    public void user_clicks_teachers_button() {

        teachersPage.clickTeachersButton();
    }

    @When("User clicks AddTeacher button")
    public void user_clicks_add_teacher_button() {
        WaitUtils.waitForClickAbility(driver, teachersPage.addTeacher);
        BrowserUtils.clickJS(driver, teachersPage.addTeacher);

    }

    @And("User enters {string}, {string}, {string}, {string}, {string} and User clicks procceed button User validates {string}")
    public void user_enters_specialization_and_user_clicks_procceed_button(String name, String lastName, String phoneNumber, String email, String specialization, String expectedMessage) throws InterruptedException {
        teachersPage.validateAddTeacherFunctionality(driver, name, lastName, phoneNumber, email, specialization, expectedMessage);
    }







    @Then("User deletes the First Teacher and validates deletion {string}")
    public void userDeletesTheFirstTeacherAndValidatesDeletionDeletionMessage( String deletionMessage) {
        teachersPage.editTeacherFunctionality(driver,deletionMessage);
    }
}

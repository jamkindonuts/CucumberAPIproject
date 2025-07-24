package ui.studyMate.stepDefinitions;

import ui.studyMate.pages.StudentsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.Driver;
import utils.WaitUtils;

public class Students {

    WebDriver driver = Driver.getDriver("chrome");
    StudentsPage studentsPage = new StudentsPage(driver);

    @When("User clicks Students button")
    public void user_clicks_students_button() {
        WaitUtils.waitForClickAbility(driver, studentsPage.studentsButton);
        BrowserUtils.clickJS(driver, studentsPage.studentsButton);
    }

    @When("User clicks AddStudent button")
    public void user_clicks_add_student_button() {
        WaitUtils.waitForClickAbility(driver, studentsPage.addStudentButton);
        BrowserUtils.clickJS(driver, studentsPage.addStudentButton);
    }

    @When("User clicks cancel button")
    public void user_clicks_cancel_button() {
        WaitUtils.waitForClickAbility(driver, studentsPage.cancelButton);
        studentsPage.cancelButton.click();
    }

    @When("User enters {string}, {string}, {string}, {string}, chooses group and {string}")
    public void user_enters_chooses_group_and(String firstName, String lastName, String phoneNumber, String email, String studyFormat) {
        studentsPage.fillOutStudentForm(driver, firstName, lastName, phoneNumber, email, studyFormat);
    }

    @When("User clicks final add button")
    public void user_clicks_final_add_button() {
        WaitUtils.waitForClickAbility(driver, studentsPage.addFinalButton);
        studentsPage.addFinalButton.click();
    }

    @Then("User validates {string}")
    public void user_validates(String message) {
        WaitUtils.waitForVisibility(driver, studentsPage.successStudentAddedMessage);
        String actualStudentAddedMessage = studentsPage.successStudentAddedMessage.getText();
        String expectedStudentAddedMessage = message;
        Assert.assertEquals(expectedStudentAddedMessage, actualStudentAddedMessage);
    }

    @When("User checks the number of students")
    public void user_checks_the_number_of_students() {
        int numberOfStudents = studentsPage.rowsInStudentsTable.size() - 1;
        System.out.println("We currently have " + numberOfStudents + " students.");
//        Assert.assertEquals(numberOfStudents, expectedNumberOfStudents);
    }

    @When("User clicks on threeDots button, clicks on Edit button, clicks on Cancel button")
    public void user_clicks_on_three_dots_button_clicks_on_edit_button_clicks_on_cancel_button() {
        studentsPage.editStudent(driver);
    }

    @Then("User clicks on threeDots button for the first student, blocks a Student and validates blocking message")
    public void user_clicks_on_three_dots_button_for_the_first_student_clicks_on_block_button_and_validates_blocking_message() {
        studentsPage.blockFirst(driver);
        WaitUtils.waitForVisibility(driver, studentsPage.blockUnblockDeleteMessage);
        String expectedMessage = "Student successfully blocked";
        String actualMessage = studentsPage.blockUnblockDeleteMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User clicks on threeDots button for the second student, blocks a Student and validates blocking message")
    public void user_clicks_on_three_dots_button_for_the_second_student_clicks_on_block_button_and_validates_blocking_message() {
        studentsPage.blockSecond(driver);
        WaitUtils.waitForVisibility(driver, studentsPage.blockUnblockDeleteMessage);
        String expectedMessage = "Student successfully blocked";
        String actualMessage = studentsPage.blockUnblockDeleteMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User Unblocks the First Student and validates unblocking message")
    public void user_clicks_on_three_dots_button_for_the_first_student_clicks_on_unblock_button_and_validates_unblocking_message() {
        driver.navigate().refresh();
        studentsPage.unblockFirst(driver);
        WaitUtils.waitForVisibility(driver, studentsPage.blockUnblockDeleteMessage);
        String expectedMessage = "Student successfully unblocked";
        WaitUtils.waitForTextToBePresentInElement(driver, studentsPage.blockUnblockDeleteMessage, "Student successfully unblocked");
        String actualMessage = studentsPage.blockUnblockDeleteMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User Unblocks the Second Student and validates unblocking message")
    public void user_clicks_on_three_dots_button_for_the_second_student_clicks_on_unblock_button_and_validates_unblocking_message() {
        driver.navigate().refresh();
        studentsPage.unblockSecond(driver);
        WaitUtils.waitForVisibility(driver, studentsPage.blockUnblockDeleteMessage);
        WaitUtils.waitForTextToBePresentInElement(driver, studentsPage.blockUnblockDeleteMessage, "Student successfully unblocked");
        String expectedMessage = "Student successfully unblocked";
        String actualMessage = studentsPage.blockUnblockDeleteMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User deletes the First Student and validates deletion message")
    public void user_deletes_the_first_student_and_validates_deletion_message() {
        studentsPage.deleteFirstOne(driver);
        WaitUtils.waitForVisibility(driver, studentsPage.blockUnblockDeleteMessage);
        String expectedMessage = "Student successfully deleted";
        WaitUtils.waitForTextToBePresentInElement(driver, studentsPage.blockUnblockDeleteMessage, "Student successfully deleted");
        String actualMessage = studentsPage.blockUnblockDeleteMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Then("User deletes the Second student and validates deletion message")
    public void user_deletes_the_second_student_and_validates_deletion_message() {
        driver.navigate().refresh();
        studentsPage.deleteFirstOne(driver);
        WaitUtils.waitForVisibility(driver, studentsPage.blockUnblockDeleteMessage);
        String expectedMessage = "Student successfully deleted";
        WaitUtils.waitForTextToBePresentInElement(driver, studentsPage.blockUnblockDeleteMessage, "Student successfully deleted");
        String actualMessage = studentsPage.blockUnblockDeleteMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }



}

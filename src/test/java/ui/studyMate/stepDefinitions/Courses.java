package ui.studyMate.stepDefinitions;

import ui.studyMate.pages.CoursePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.WaitUtils;

public class Courses {

    WebDriver driver = Driver.getDriver("chrome");
    CoursePage coursePage = new CoursePage(driver);

    @Given("User clicks Courses button")
    public void user_clicks_courses_button() {
        coursePage.coursesBox();
    }

    @Given("User clicks Create Course button")
    public void user_clicks_create_course_button() {
        coursePage.createCourse();
    }

    @When("User clicks cancel creation button")
    public void user_clicks_cancel_creation_button() {
        WaitUtils.waitForClickAbility(driver, coursePage.cancelCreationButton);
        coursePage.cancelCreationButton.click();
    }

    @When("User enters {string}, {string}, {string} and uploads a picture")
    public void user_enters_and_uploads_a_picture(String courseName, String date, String description) {
        coursePage.fillCourseBox(driver, courseName, date, description);
    }

    @When("User clicks final create button")
    public void user_clicks_final_create_button() {
        WaitUtils.waitForClickAbility(driver, coursePage.createFinalButton);
        coursePage.createFinalButton.click();
    }


}



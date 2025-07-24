package com.qa.studyMate.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.WaitUtils;

public class CoursePage {


    public CoursePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='root']/div/div[1]/nav/a[2]/li")
    WebElement CoursesMainPageBox;

    @FindBy(xpath = "//h2[contains(@class,'sc-hBxehG gRTRKz')]")
    WebElement CoursesHeader;

    @FindBy(xpath = "//div[.='Automation']")
    WebElement AutomationButton;

    @FindBy(xpath = "//span[.='2025-12-07']")
    WebElement AutomationDateBox;

    @FindBy(xpath = "//p[contains (text(), 'drag the photo')]")
    WebElement uploadPhotoBox;


    @FindBy(xpath = "//header//button[@type='button']")
    WebElement createCourseButton;

    public @FindBy(xpath = "//form/div[@class='sc-gKPRtg gmDlqC actions']/button[@type='button']")
    WebElement cancelCreationButton;

    @FindBy(xpath = "//input[@name='courseName']")
    WebElement courseNameInput;

    @FindBy(xpath = "//input[@placeholder='dd.mm.y']")
    WebElement newCourseDate;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement courseDescriptionInput;

    public @FindBy(css = "button[type='submit']")
    WebElement createFinalButton;

    public @FindBy(xpath = "//p[@class='sc-dkrFOg hbyUzQ']")
    WebElement courseCreatedMessage;

    @FindBy(xpath = "//p[contains (text(), 'drag the photo')]")
    WebElement uploadCucumberPhotoBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement createNewCourseButton;


    public  void coursesBox() {
        CoursesMainPageBox.click();
    }

    public void createCourse(){
        createCourseButton.click();
    }

    public void fillCourseBox(WebDriver driver, String courseName, String date, String description) {
        WaitUtils.waitForClickAbility(driver, courseNameInput);
        courseNameInput.sendKeys(courseName);
        WaitUtils.waitForClickAbility(driver, newCourseDate);
        newCourseDate.sendKeys(date);
        WaitUtils.waitForClickAbility(driver, courseDescriptionInput);
        courseDescriptionInput.click();
        courseDescriptionInput.sendKeys(description);

        String filePath = System.getProperty("user.dir") + "/src/test/resources/" ;
        WebElement input = driver.findElement(By.xpath("//input[@type='file']"));
        input.sendKeys(filePath);
    }


    public void validateAutomationInformation(String expectedHeader ){
        Assert.assertEquals(BrowserUtils.getText(CoursesMainPageBox), expectedHeader);

    }

    public void checkAutomationInformation(String expectedHeader, String expectedDate) {
        Assert.assertEquals(BrowserUtils.getText(CoursesHeader), expectedHeader);
        Assert.assertTrue(AutomationButton.isDisplayed() && AutomationButton.isEnabled());
        Assert.assertEquals(BrowserUtils.getText(AutomationDateBox), expectedDate);
    }

}
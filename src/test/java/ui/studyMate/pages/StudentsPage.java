package ui.studyMate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.WaitUtils;

import java.util.List;

public class StudentsPage {

    public StudentsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(xpath = "//a[@href='/admin/students']")
    WebElement studentsButton;

//    @FindBy(css = "input[name='search']")
//    WebElement searchBar;

    public @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium css-79mk38')]")
    WebElement addStudentButton;

    @FindBy(css = "input[name='name']")
    WebElement firstNameInput;

    @FindBy(css = "input[name='lastName']")
    WebElement lastNameInput;

    @FindBy(css = "input[placeholder='+1 ___ ___ ____ ']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//div[@class='css-1fk3hej']//input[@name='email']")
    WebElement emailInputStudent;

    @FindBy(id = "mui-component-select-groupId")
    WebElement groupDropDown;

    @FindBy(xpath = "//ul[@role='listbox']/li")
    WebElement groupChoice;

    @FindBy(id = "mui-component-select-studyFormat")
    WebElement studyFormatDropDown;

    @FindBy(css = "li[data-value='ONLINE']")
    WebElement onlineStudyFormat;

    @FindBy(css = "li[data-value='OFFLINE']")
    WebElement offlineStudyFormat;

    public @FindBy(css = "button[type='submit']")
    WebElement addFinalButton;

    public @FindBy(css = "div[class='MuiAlert-message css-1xsto0d']")
    WebElement successStudentAddedMessage;

    public @FindBy(xpath = "//form//button[@type='button']")
    WebElement cancelButton;

    @FindBy(xpath = "//table[@class='MuiTable-root css-1owb465']")
    WebElement tableOfStudents;

    public @FindBy(tagName = "tr")
    List<WebElement> rowsInStudentsTable;

    @FindBy(xpath = "//tr/td[7]//button")
    List<WebElement> threeDotsActionsButtons;

    @FindBy(xpath = "//div[contains(@class, 'css-xc95k')]//ul/li[.='Edit']")
    WebElement editButton;

    @FindBy(xpath = "//div[contains(@class, 'css-xc95k')]//ul/li[.='Block']")
    WebElement blockButton;

    @FindBy(xpath = "//button[.='Block']")
    WebElement confirmBlockButton;

    public @FindBy(xpath = "//div/p[@class='sc-dkrFOg hbyUzQ']")
    WebElement blockUnblockDeleteMessage;

    @FindBy(xpath = "//div[contains(@class, 'css-xc95k')]//ul/li[.='Unblock']")
    WebElement unblockButton;

    @FindBy(xpath = "//button[.='Unblock']")
    WebElement confirmUnblockButton;

    @FindBy(xpath = "//div[contains(@class, 'css-xc95k')]//ul/li[.='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement confirmDeleteButton;

    public void fillOutStudentForm(WebDriver driver, String firstName, String lastName, String phoneNumber,
                                   String studentEmail, String studyFormat) {
        WaitUtils.waitForClickAbility(driver, firstNameInput);
        firstNameInput.sendKeys(firstName);
        WaitUtils.waitForClickAbility(driver, lastNameInput);
        lastNameInput.sendKeys(lastName);
        WaitUtils.waitForClickAbility(driver, phoneNumberInput);
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(phoneNumber);
        emailInputStudent.sendKeys(studentEmail);
        WaitUtils.waitForClickAbility(driver, groupDropDown);
        groupDropDown.click();
        groupChoice.click();
        WaitUtils.waitForClickAbility(driver, studyFormatDropDown);
        studyFormatDropDown.click();
        if (studyFormat.equalsIgnoreCase("online")) {
            onlineStudyFormat.click();
        } else if (studyFormat.equalsIgnoreCase("offline")) {
            offlineStudyFormat.click();
        }

    }

    public void editStudent(WebDriver driver) {
        for (WebElement threeDotsActionsButton : threeDotsActionsButtons) {
            WaitUtils.waitForClickAbility(driver, threeDotsActionsButton);
            threeDotsActionsButton.click();
            WaitUtils.waitForClickAbility(driver, editButton);
            editButton.click();
            WaitUtils.waitForClickAbility(driver, cancelButton);
            cancelButton.click();
        }
    }

    public void blockFirst(WebDriver driver) {
        WaitUtils.waitForClickAbility(driver, threeDotsActionsButtons.get(0));
        threeDotsActionsButtons.get(0).click();
        WaitUtils.waitForClickAbility(driver, blockButton);
        blockButton.click();
        WaitUtils.waitForClickAbility(driver, confirmBlockButton);
        confirmBlockButton.click();
    }

    public void blockSecond(WebDriver driver) {
        WaitUtils.waitForClickAbility(driver, threeDotsActionsButtons.get(1));
        threeDotsActionsButtons.get(1).click();
        WaitUtils.waitForClickAbility(driver, blockButton);
        blockButton.click();
        WaitUtils.waitForClickAbility(driver, confirmBlockButton);
        confirmBlockButton.click();
    }

    public void unblockFirst(WebDriver driver) {
        threeDotsActionsButtons = driver.findElements(By.xpath("//tr/td[7]//button"));
        WaitUtils.waitForClickAbility(driver, threeDotsActionsButtons.get(0));
        BrowserUtils.clickJS(driver, threeDotsActionsButtons.get(0));
        WaitUtils.waitForClickAbility(driver, unblockButton);
        unblockButton.click();
        WaitUtils.waitForClickAbility(driver, confirmUnblockButton);
        confirmUnblockButton.click();
    }

    public void unblockSecond(WebDriver driver) {
        threeDotsActionsButtons = driver.findElements(By.xpath("//tr/td[7]//button"));
        WaitUtils.waitForClickAbility(driver, threeDotsActionsButtons.get(1));
        BrowserUtils.clickJS(driver, threeDotsActionsButtons.get(1));
        WaitUtils.waitForClickAbility(driver, unblockButton);
        unblockButton.click();
        WaitUtils.waitForClickAbility(driver, confirmUnblockButton);
        confirmUnblockButton.click();
    }

    public void deleteFirstOne(WebDriver driver) {
        WaitUtils.waitForClickAbility(driver, threeDotsActionsButtons.get(0));
        threeDotsActionsButtons.get(0).click();
        WaitUtils.waitForClickAbility(driver, deleteButton);
        deleteButton.click();
        WaitUtils.waitForClickAbility(driver, confirmDeleteButton);
        confirmDeleteButton.click();
    }



}

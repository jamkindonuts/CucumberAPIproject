package com.qa.studyMate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Driver.driver;


public class GroupsPage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    public void goToGroups() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Groups']"))).click();
    }

    public void createGroup(String name, String description, String date, String imageName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Create group')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']"))).sendKeys(name);
        driver.findElement(By.tagName("textarea")).sendKeys(description);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='dateOfFinish']"))).sendKeys(date);

        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
        String filePath = System.getProperty("user.dir") + "/src/test/resources/" + imageName;
        fileInput.sendKeys(filePath);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
    }

    public void editGroup(String updatedName, String oldName) {
        String oldElementName = "//div[contains(text(),'" + oldName + "')]/ancestor::div[contains(@class,'MuiPaper-root')]//button[@aria-haspopup='true']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(oldElementName))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@tabindex='0'][1]"))).click();
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        nameInput.clear();
        nameInput.sendKeys(updatedName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@form='group-form']"))).click();

    }

    public void deleteGroup(String name) {
        String oldElementName = "//div[contains(text(),'" + name + "')]/ancestor::div[contains(@class,'MuiPaper-root')]//button[@aria-haspopup='true']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(oldElementName))).click();
        String deleteOption = "//li[@tabindex='-1' and contains(.,'Delete group')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteOption))).click();
        String confirmDelete = "//button[text()='Delete']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirmDelete))).click();
    }

    public void verifyGroupDeleted(String name) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'" + name + "')]")));

        boolean isPresent = driver.getPageSource().contains(name);
        assert !isPresent : "Group not deleted!";
    }
}
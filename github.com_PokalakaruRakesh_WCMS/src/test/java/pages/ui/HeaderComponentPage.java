package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import java.util.ArrayList;
import java.util.List;

public class HeaderComponentPage extends BasePage {

    // Locators for header components (replace with actual locators as needed)
    private By contactsLink = By.linkText("Contacts");
    private By createButton = By.xpath("//button[contains(@class, 'linkedin') and text()='Create']");
    private By logOutLink = By.linkText("Log Out");
    private By settingsIcon = By.xpath("//i[contains(@class, 'settings icon')]"); // TODO: Replace with actual locator if needed
    private By userIcon = By.xpath("//i[contains(@class, 'user red icon')]"); // TODO: Replace with actual locator if needed

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate header components are displayed after login")
    public boolean validateHeaderComponents() {
        List<Boolean> headerElementsPresent = new ArrayList<>();
        try {
            WaitStatementUtils.waitForElementToBeVisible(driver, contactsLink, 10);
            headerElementsPresent.add(driver.findElement(contactsLink).isDisplayed());
        } catch (Exception e) {
            headerElementsPresent.add(false);
        }
        try {
            WaitStatementUtils.waitForElementToBeVisible(driver, createButton, 10);
            headerElementsPresent.add(driver.findElement(createButton).isDisplayed());
        } catch (Exception e) {
            headerElementsPresent.add(false);
        }
        try {
            WaitStatementUtils.waitForElementToBeVisible(driver, logOutLink, 10);
            headerElementsPresent.add(driver.findElement(logOutLink).isDisplayed());
        } catch (Exception e) {
            headerElementsPresent.add(false);
        }
        try {
            WaitStatementUtils.waitForElementToBeVisible(driver, settingsIcon, 10);
            headerElementsPresent.add(driver.findElement(settingsIcon).isDisplayed());
        } catch (Exception e) {
            headerElementsPresent.add(false);
        }
        try {
            WaitStatementUtils.waitForElementToBeVisible(driver, userIcon, 10);
            headerElementsPresent.add(driver.findElement(userIcon).isDisplayed());
        } catch (Exception e) {
            headerElementsPresent.add(false);
        }
        // All header elements should be present
        return !headerElementsPresent.contains(false);
    }
}

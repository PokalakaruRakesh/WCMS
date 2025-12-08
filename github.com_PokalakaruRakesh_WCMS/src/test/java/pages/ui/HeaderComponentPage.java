package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {
    // Locators for header components
    private By contactsLink = By.linkText("Contacts");
    private By createButton = By.xpath("//button[contains(@class, 'linkedin button') and text()='Create']");
    private By logOutLink = By.linkText("Log Out");
    private By settingsIcon = By.xpath("//i[contains(@class, 'settings icon')]");
    private By userIcon = By.xpath("//i[contains(@class, 'large user red icon')]");

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate all header components are displayed and interactable after login")
    public void validateHeaderComponents() {
        // Wait for and validate Contacts link
        waitForElementPresent(contactsLink);
        WebElement contacts = driver.findElement(contactsLink);
        if (!contacts.isDisplayed()) {
            throw new AssertionError("Contacts link is not displayed in header");
        }
        // Wait for and validate Create button
        waitForElementPresent(createButton);
        WebElement create = driver.findElement(createButton);
        if (!create.isDisplayed()) {
            throw new AssertionError("Create button is not displayed in header");
        }
        // Wait for and validate Log Out link
        waitForElementPresent(logOutLink);
        WebElement logout = driver.findElement(logOutLink);
        if (!logout.isDisplayed()) {
            throw new AssertionError("Log Out link is not displayed in header");
        }
        // Wait for and validate Settings icon
        waitForElementPresent(settingsIcon);
        WebElement settings = driver.findElement(settingsIcon);
        if (!settings.isDisplayed()) {
            throw new AssertionError("Settings icon is not displayed in header");
        }
        // Wait for and validate User icon
        waitForElementPresent(userIcon);
        WebElement user = driver.findElement(userIcon);
        if (!user.isDisplayed()) {
            throw new AssertionError("User icon is not displayed in header");
        }
    }
}

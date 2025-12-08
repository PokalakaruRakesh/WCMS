package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {
    // Locators for header components after login
    private By contactsLink = By.linkText("Contacts");
    private By createButton = By.linkText("Create");
    private By logOutLink = By.linkText("Log Out");
    private By settingsIcon = By.className("settings icon");
    private By userIcon = By.cssSelector("i.large.user.red.icon");

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate header components after login")
    public boolean validateHeaderComponents() {
        try {
            // Wait for and validate Contacts link
            waitForElementPresent(contactsLink);
            WebElement contacts = driver.findElement(contactsLink);
            if (!contacts.isDisplayed()) return false;

            // Wait for and validate Create button
            waitForElementPresent(createButton);
            WebElement create = driver.findElement(createButton);
            if (!create.isDisplayed()) return false;

            // Wait for and validate Log Out link
            waitForElementPresent(logOutLink);
            WebElement logout = driver.findElement(logOutLink);
            if (!logout.isDisplayed()) return false;

            // Wait for and validate Settings icon
            waitForElementPresent(settingsIcon);
            WebElement settings = driver.findElement(settingsIcon);
            if (!settings.isDisplayed()) return false;

            // Wait for and validate User icon
            waitForElementPresent(userIcon);
            WebElement user = driver.findElement(userIcon);
            if (!user.isDisplayed()) return false;

            return true;
        } catch (Exception e) {
            // Optionally log the exception
            return false;
        }
    }
}

package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {

    // Locators for header components (placeholders, update as needed)
    private By logo = By.xpath("<PLACEHOLDER_logo>"); // TODO: Replace with actual locator
    private By navigationMenu = By.xpath("<PLACEHOLDER_navigation_menu>"); // TODO: Replace with actual locator
    private By userProfileIcon = By.xpath("<PLACEHOLDER_user_profile_icon>"); // TODO: Replace with actual locator
    private By notificationsIcon = By.xpath("<PLACEHOLDER_notifications_icon>"); // TODO: Replace with actual locator
    private By logoutButton = By.xpath("<PLACEHOLDER_logout_button>"); // TODO: Replace with actual locator

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate all header components are visible and interactable")
    public void validateHeaderComponents() {
        // Validate logo is displayed
        waitForElementPresent(logo);
        if (!driver.findElement(logo).isDisplayed()) {
            throw new AssertionError("Header logo is not displayed");
        }
        // Validate navigation menu is displayed
        waitForElementPresent(navigationMenu);
        if (!driver.findElement(navigationMenu).isDisplayed()) {
            throw new AssertionError("Header navigation menu is not displayed");
        }
        // Validate user profile icon is displayed
        waitForElementPresent(userProfileIcon);
        if (!driver.findElement(userProfileIcon).isDisplayed()) {
            throw new AssertionError("User profile icon is not displayed");
        }
        // Validate notifications icon is displayed
        waitForElementPresent(notificationsIcon);
        if (!driver.findElement(notificationsIcon).isDisplayed()) {
            throw new AssertionError("Notifications icon is not displayed");
        }
        // Validate logout button is displayed
        waitForElementPresent(logoutButton);
        if (!driver.findElement(logoutButton).isDisplayed()) {
            throw new AssertionError("Logout button is not displayed");
        }
    }
}

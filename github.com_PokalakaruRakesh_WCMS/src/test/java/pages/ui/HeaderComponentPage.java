package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage {
    private WebDriver driver;

    // Locators for header components (placeholders, update with actual locators as needed)
    private By logo = By.xpath("<PLACEHOLDER_logo>"); // TODO: Replace with actual locator
    private By navigationMenu = By.xpath("<PLACEHOLDER_navigation_menu>"); // TODO: Replace with actual locator
    private By userProfileIcon = By.xpath("<PLACEHOLDER_user_profile_icon>"); // TODO: Replace with actual locator
    private By notificationsIcon = By.xpath("<PLACEHOLDER_notifications_icon>"); // TODO: Replace with actual locator
    private By logoutButton = By.xpath("<PLACEHOLDER_logout_button>"); // TODO: Replace with actual locator

    public HeaderComponentPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate all header components are visible and interactable")
    public void validateHeaderComponents() {
        // Wait for and validate logo
        WaitStatementUtils.waitForElementPresent(driver, logo, 10);
        WebElement logoElement = driver.findElement(logo);
        if (!logoElement.isDisplayed()) {
            throw new AssertionError("Header logo is not displayed");
        }

        // Wait for and validate navigation menu
        WaitStatementUtils.waitForElementPresent(driver, navigationMenu, 10);
        WebElement navMenuElement = driver.findElement(navigationMenu);
        if (!navMenuElement.isDisplayed()) {
            throw new AssertionError("Header navigation menu is not displayed");
        }

        // Wait for and validate user profile icon
        WaitStatementUtils.waitForElementPresent(driver, userProfileIcon, 10);
        WebElement profileIconElement = driver.findElement(userProfileIcon);
        if (!profileIconElement.isDisplayed()) {
            throw new AssertionError("User profile icon is not displayed");
        }

        // Wait for and validate notifications icon
        WaitStatementUtils.waitForElementPresent(driver, notificationsIcon, 10);
        WebElement notificationsElement = driver.findElement(notificationsIcon);
        if (!notificationsElement.isDisplayed()) {
            throw new AssertionError("Notifications icon is not displayed");
        }

        // Wait for and validate logout button
        WaitStatementUtils.waitForElementPresent(driver, logoutButton, 10);
        WebElement logoutBtnElement = driver.findElement(logoutButton);
        if (!logoutBtnElement.isDisplayed()) {
            throw new AssertionError("Logout button is not displayed");
        }
    }
}

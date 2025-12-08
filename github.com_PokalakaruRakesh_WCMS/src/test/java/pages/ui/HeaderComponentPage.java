package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {

    // Locators for header components (placeholders, update with actual locators as needed)
    private By logo = By.xpath("<PLACEHOLDER_logo>"); // TODO: Replace with actual locator
    private By navigationMenu = By.xpath("<PLACEHOLDER_navigation_menu>"); // TODO: Replace with actual locator
    private By userProfileIcon = By.xpath("<PLACEHOLDER_user_profile_icon>"); // TODO: Replace with actual locator
    private By notificationsIcon = By.xpath("<PLACEHOLDER_notifications_icon>"); // TODO: Replace with actual locator
    private By logoutLink = By.xpath("<PLACEHOLDER_logout_link>"); // TODO: Replace with actual locator

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates that all key header components are visible after successful login.
     */
    @Step("Validate header components are visible after login")
    public boolean validateHeaderComponentsVisible() {
        try {
            waitForElementPresent(logo);
            waitForElementPresent(navigationMenu);
            waitForElementPresent(userProfileIcon);
            waitForElementPresent(notificationsIcon);
            waitForElementPresent(logoutLink);
            return driver.findElement(logo).isDisplayed()
                && driver.findElement(navigationMenu).isDisplayed()
                && driver.findElement(userProfileIcon).isDisplayed()
                && driver.findElement(notificationsIcon).isDisplayed()
                && driver.findElement(logoutLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Optionally, add getters for header elements if required by other scenarios
    public WebElement getLogo() {
        waitForElementPresent(logo);
        return driver.findElement(logo);
    }

    public WebElement getNavigationMenu() {
        waitForElementPresent(navigationMenu);
        return driver.findElement(navigationMenu);
    }

    public WebElement getUserProfileIcon() {
        waitForElementPresent(userProfileIcon);
        return driver.findElement(userProfileIcon);
    }

    public WebElement getNotificationsIcon() {
        waitForElementPresent(notificationsIcon);
        return driver.findElement(notificationsIcon);
    }

    public WebElement getLogoutLink() {
        waitForElementPresent(logoutLink);
        return driver.findElement(logoutLink);
    }
}

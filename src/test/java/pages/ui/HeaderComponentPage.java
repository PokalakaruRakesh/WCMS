package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import java.time.Duration;

/**
 * Page Object for validating header components as per INT-123.
 * Follows existing repository patterns (see HomePage_WCMS, BasePage).
 */
public class HeaderComponentPage extends BasePage {

    // Example header locators (replace with actual locators as needed)
    private By logo = By.xpath("//header//img[contains(@alt, 'Logo')]"); // TODO: Replace with actual locator
    private By navigationMenu = By.xpath("//header//nav"); // TODO: Replace with actual locator
    private By searchIcon = By.xpath("//header//*[contains(@class, 'search-icon')]"); // TODO: Replace with actual locator
    private By userProfileIcon = By.xpath("//header//*[contains(@class, 'user-profile')]"); // TODO: Replace with actual locator
    private By notificationsIcon = By.xpath("//header//*[contains(@class, 'notifications')]"); // TODO: Replace with actual locator

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if the logo is displayed in the header.
     */
    public boolean isLogoDisplayed() {
        waitForElementPresent(logo);
        return getElement(logo).isDisplayed();
    }

    /**
     * Checks if the navigation menu is displayed in the header.
     */
    public boolean isNavigationMenuDisplayed() {
        waitForElementPresent(navigationMenu);
        return getElement(navigationMenu).isDisplayed();
    }

    /**
     * Checks if the search icon is displayed in the header.
     */
    public boolean isSearchIconDisplayed() {
        waitForElementPresent(searchIcon);
        return getElement(searchIcon).isDisplayed();
    }

    /**
     * Checks if the user profile icon is displayed in the header.
     */
    public boolean isUserProfileIconDisplayed() {
        waitForElementPresent(userProfileIcon);
        return getElement(userProfileIcon).isDisplayed();
    }

    /**
     * Checks if the notifications icon is displayed in the header.
     */
    public boolean isNotificationsIconDisplayed() {
        waitForElementPresent(notificationsIcon);
        return getElement(notificationsIcon).isDisplayed();
    }

    /**
     * Clicks on the search icon in the header.
     */
    public void clickSearchIcon() {
        clickOnMethod(searchIcon);
    }

    /**
     * Clicks on the user profile icon in the header.
     */
    public void clickUserProfileIcon() {
        clickOnMethod(userProfileIcon);
    }

    /**
     * Clicks on the notifications icon in the header.
     */
    public void clickNotificationsIcon() {
        clickOnMethod(notificationsIcon);
    }

    // Additional placeholder methods for header interactions can be added here as needed

    // Header logo locator and validation
    private By headerLogo = By.id("PLACEHOLDER_header_logo"); // TODO: Replace with actual locator
    public boolean isHeaderLogoDisplayed() {
        waitForElementPresent(headerLogo);
        return getElement(headerLogo).isDisplayed();
    }

    // Navigation menu locator and validation
    private By navigationMenuHeader = By.id("PLACEHOLDER_navigation_menu"); // TODO: Replace with actual locator
    public boolean isNavigationMenuHeaderDisplayed() {
        waitForElementPresent(navigationMenuHeader);
        return getElement(navigationMenuHeader).isDisplayed();
    }

    // Search bar locator and validation
    private By searchBar = By.id("PLACEHOLDER_search_bar"); // TODO: Replace with actual locator
    public boolean isSearchBarDisplayed() {
        waitForElementPresent(searchBar);
        return getElement(searchBar).isDisplayed();
    }

    // User profile icon locator and validation
    private By userProfileIconHeader = By.id("PLACEHOLDER_user_profile_icon"); // TODO: Replace with actual locator
    public boolean isUserProfileIconHeaderDisplayed() {
        waitForElementPresent(userProfileIconHeader);
        return getElement(userProfileIconHeader).isDisplayed();
    }

    // Notification bell locator and validation
    private By notificationBell = By.id("PLACEHOLDER_notification_bell"); // TODO: Replace with actual locator
    public boolean isNotificationBellDisplayed() {
        waitForElementPresent(notificationBell);
        return getElement(notificationBell).isDisplayed();
    }

    // Generic method to validate all header components are displayed
    public boolean areAllHeaderComponentsDisplayed() {
        return isHeaderLogoDisplayed() &&
               isNavigationMenuHeaderDisplayed() &&
               isSearchBarDisplayed() &&
               isUserProfileIconHeaderDisplayed() &&
               isNotificationBellDisplayed();
    }
}
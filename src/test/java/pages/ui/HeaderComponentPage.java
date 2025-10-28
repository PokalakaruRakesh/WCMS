package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import java.time.Duration;
import java.util.List;

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

    // Header container locator
    private By headerContainer = By.xpath("//header"); // TODO: Replace with actual locator if different

    // Placeholder locators for header components
    private By headerLogo = By.xpath("//header//img[contains(@class, 'header-logo')]"); // TODO: Replace with actual locator
    private By headerNavigationLinks = By.xpath("//header//nav//a"); // TODO: Replace with actual locator
    private By headerSearchIcon = By.xpath("//header//*[contains(@class, 'search-icon')]"); // TODO: Replace with actual locator
    private By headerUserProfile = By.xpath("//header//*[contains(@class, 'user-profile')]"); // TODO: Replace with actual locator
    private By headerCartIcon = By.xpath("//header//*[contains(@class, 'cart-icon')]"); // TODO: Replace with actual locator

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

    /**
     * Checks if the header container is displayed
     */
    public boolean isHeaderDisplayed() {
        waitForElementPresent(headerContainer);
        return getElement(headerContainer).isDisplayed();
    }

    /**
     * Checks if the header logo is displayed
     */
    public boolean isHeaderLogoDisplayed() {
        waitForElementPresent(headerLogo);
        return getElement(headerLogo).isDisplayed();
    }

    /**
     * Returns the list of navigation links in the header
     */
    public List<WebElement> getHeaderNavigationLinks() {
        waitForElementPresent(headerNavigationLinks);
        return getElements(headerNavigationLinks);
    }

    /**
     * Checks if the header search icon is displayed
     */
    public boolean isHeaderSearchIconDisplayed() {
        waitForElementPresent(headerSearchIcon);
        return getElement(headerSearchIcon).isDisplayed();
    }

    /**
     * Checks if the header user profile icon is displayed
     */
    public boolean isHeaderUserProfileDisplayed() {
        waitForElementPresent(headerUserProfile);
        return getElement(headerUserProfile).isDisplayed();
    }

    /**
     * Checks if the header cart icon is displayed
     */
    public boolean isHeaderCartIconDisplayed() {
        waitForElementPresent(headerCartIcon);
        return getElement(headerCartIcon).isDisplayed();
    }

    /**
     * Clicks a header navigation link by its visible text
     * @param linkText the visible text of the link
     */
    public void clickHeaderNavigationLinkByText(String linkText) {
        By linkLocator = By.xpath("//header//nav//a[normalize-space(text())='" + linkText + "']");
        waitForElementPresent(linkLocator);
        clickOnMethod(linkLocator);
    }

    /**
     * Checks if a specific header navigation link is present
     * @param linkText the visible text of the link
     * @return true if present, false otherwise
     */
    public boolean isHeaderNavigationLinkPresent(String linkText) {
        By linkLocator = By.xpath("//header//nav//a[normalize-space(text())='" + linkText + "']");
        try {
            waitForElementPresent(linkLocator);
            return getElement(linkLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
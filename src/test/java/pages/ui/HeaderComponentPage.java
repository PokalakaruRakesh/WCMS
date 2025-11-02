package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HeaderComponentPage extends BasePage {

    // Placeholder locators for header components
    private By logo = By.id("PLACEHOLDER_header_logo"); // TODO: Replace with actual locator
    private By navigationMenu = By.id("PLACEHOLDER_header_navigation_menu"); // TODO: Replace with actual locator
    private By searchIcon = By.id("PLACEHOLDER_header_search_icon"); // TODO: Replace with actual locator
    private By loginButton = By.id("PLACEHOLDER_header_login_button"); // TODO: Replace with actual locator
    private By languageSelector = By.id("PLACEHOLDER_header_language_selector"); // TODO: Replace with actual locator

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoDisplayed() {
        waitForElementPresent(logo);
        return getElement(logo).isDisplayed();
    }

    public boolean isNavigationMenuDisplayed() {
        waitForElementPresent(navigationMenu);
        return getElement(navigationMenu).isDisplayed();
    }

    public boolean isSearchIconDisplayed() {
        waitForElementPresent(searchIcon);
        return getElement(searchIcon).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        waitForElementPresent(loginButton);
        return getElement(loginButton).isDisplayed();
    }

    public boolean isLanguageSelectorDisplayed() {
        waitForElementPresent(languageSelector);
        return getElement(languageSelector).isDisplayed();
    }

    public void clickLogo() {
        clickOnMethod(logo);
    }

    public void clickNavigationMenu() {
        clickOnMethod(navigationMenu);
    }

    public void clickSearchIcon() {
        clickOnMethod(searchIcon);
    }

    public void clickLoginButton() {
        clickOnMethod(loginButton);
    }

    public void selectLanguage(String language) {
        clickOnMethod(languageSelector);
        // TODO: Implement language selection dropdown logic
        // Example placeholder:
        By languageOption = By.xpath("//li[contains(text(),'" + language + "')]"); // TODO: Replace with actual locator
        waitForElementPresent(languageOption);
        clickOnMethod(languageOption);
    }

    public List<WebElement> getAllHeaderLinks() {
        By headerLinks = By.cssSelector("PLACEHOLDER_header_links"); // TODO: Replace with actual locator
        waitForElementPresent(headerLinks);
        return getElements(headerLinks);
    }

    public String getHeaderLinkText(int index) {
        List<WebElement> links = getAllHeaderLinks();
        if (links != null && links.size() > index) {
            return links.get(index).getText();
        }
        return null;
    }

    public boolean isHeaderComponentDisplayed(By componentLocator) {
        waitForElementPresent(componentLocator);
        return getElement(componentLocator).isDisplayed();
    }

    // Locators for header components based on provided locators and actual page structure
    private By astmLogo = By.className("astm-logo");
    private By navigationMenuNew = By.xpath("<PLACEHOLDER>"); // TODO: Replace with actual locator for navigation menu
    private By searchIconNew = By.xpath("<PLACEHOLDER>"); // TODO: Replace with actual locator for search icon
    private By userProfileIcon = By.xpath("<PLACEHOLDER>"); // TODO: Replace with actual locator for user profile icon
    private By notificationsIcon = By.xpath("<PLACEHOLDER>"); // TODO: Replace with actual locator for notifications icon

    /**
     * Validates that all main header components are displayed after login.
     * This includes ASTM logo, navigation menu, search icon, user profile icon, and notifications icon.
     *
     * Usage: Call after successful login to verify header is rendered.
     */
    public boolean areHeaderComponentsDisplayed() {
        try {
            waitForElementPresent(astmLogo);
            boolean logoDisplayed = getElement(astmLogo).isDisplayed();

            // Navigation menu placeholder
            boolean navigationMenuDisplayed = true;
            try {
                waitForElementPresent(navigationMenuNew);
                navigationMenuDisplayed = getElement(navigationMenuNew).isDisplayed();
            } catch (Exception e) {
                navigationMenuDisplayed = false; // If not found, mark as not displayed
            }

            // Search icon placeholder
            boolean searchIconDisplayed = true;
            try {
                waitForElementPresent(searchIconNew);
                searchIconDisplayed = getElement(searchIconNew).isDisplayed();
            } catch (Exception e) {
                searchIconDisplayed = false;
            }

            // User profile icon placeholder
            boolean userProfileDisplayed = true;
            try {
                waitForElementPresent(userProfileIcon);
                userProfileDisplayed = getElement(userProfileIcon).isDisplayed();
            } catch (Exception e) {
                userProfileDisplayed = false;
            }

            // Notifications icon placeholder
            boolean notificationsDisplayed = true;
            try {
                waitForElementPresent(notificationsIcon);
                notificationsDisplayed = getElement(notificationsIcon).isDisplayed();
            } catch (Exception e) {
                notificationsDisplayed = false;
            }

            return logoDisplayed && navigationMenuDisplayed && searchIconDisplayed && userProfileDisplayed && notificationsDisplayed;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns true if the ASTM logo is displayed in the header.
     */
    public boolean isAstmLogoDisplayed() {
        try {
            waitForElementPresent(astmLogo);
            return getElement(astmLogo).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns true if the navigation menu is displayed in the header.
     * Placeholder: Update locator when actual navigation menu locator is known.
     */
    public boolean isNavigationMenuNewDisplayed() {
        try {
            waitForElementPresent(navigationMenuNew);
            return getElement(navigationMenuNew).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns true if the search icon is displayed in the header.
     * Placeholder: Update locator when actual search icon locator is known.
     */
    public boolean isSearchIconNewDisplayed() {
        try {
            waitForElementPresent(searchIconNew);
            return getElement(searchIconNew).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns true if the user profile icon is displayed in the header.
     * Placeholder: Update locator when actual user profile icon locator is known.
     */
    public boolean isUserProfileIconDisplayed() {
        try {
            waitForElementPresent(userProfileIcon);
            return getElement(userProfileIcon).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns true if the notifications icon is displayed in the header.
     * Placeholder: Update locator when actual notifications icon locator is known.
     */
    public boolean isNotificationsIconDisplayed() {
        try {
            waitForElementPresent(notificationsIcon);
            return getElement(notificationsIcon).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
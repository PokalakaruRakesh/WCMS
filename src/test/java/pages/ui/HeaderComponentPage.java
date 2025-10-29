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
}

package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

/**
 * Page Object for validating header and footer components (Test Case: INT-124)
 * Follows repository patterns: By locators, constructor injection, BasePage extension, and utility usage.
 */
public class HeaderFooterComponentPage extends BasePage {

    // Header Locators
    private By headerLogo = By.xpath("//header//img[@alt='ASTM Logo']"); // TODO: Replace with actual locator if different
    private By headerNavigationMenu = By.xpath("//header//nav"); // TODO: Replace with actual locator
    private By headerSearchIcon = By.xpath("//header//button[contains(@class, 'search')]"); // TODO: Replace with actual locator
    private By headerContactLink = By.xpath("//header//a[contains(@href, 'contact')]"); // TODO: Replace with actual locator
    private By headerLoginButton = By.xpath("//header//a[contains(@href, 'login') or contains(text(),'Login')]"); // TODO: Replace with actual locator

    // Footer Locators
    private By footerSection = By.xpath("//footer"); // TODO: Replace with actual locator
    private By footerLinks = By.xpath("//footer//a"); // TODO: Replace with actual locator
    private By footerSocialIcons = By.xpath("//footer//a[contains(@class, 'social') or contains(@href, 'facebook') or contains(@href, 'twitter') or contains(@href, 'linkedin')]"); // TODO: Replace with actual locator
    private By footerCopyright = By.xpath("//footer//*[contains(text(),'Copyright') or contains(text(),'©')]"); // TODO: Replace with actual locator
    private By footerPrivacyPolicy = By.xpath("//footer//a[contains(text(),'Privacy Policy')]"); // TODO: Replace with actual locator

    public HeaderFooterComponentPage(WebDriver driver) {
        super(driver);
    }

    // ===== HEADER METHODS =====
    public boolean isHeaderLogoDisplayed() {
        waitForElementPresent(headerLogo);
        return getElement(headerLogo).isDisplayed();
    }

    public boolean isHeaderNavigationMenuDisplayed() {
        waitForElementPresent(headerNavigationMenu);
        return getElement(headerNavigationMenu).isDisplayed();
    }

    public boolean isHeaderSearchIconDisplayed() {
        waitForElementPresent(headerSearchIcon);
        return getElement(headerSearchIcon).isDisplayed();
    }

    public boolean isHeaderContactLinkDisplayed() {
        waitForElementPresent(headerContactLink);
        return getElement(headerContactLink).isDisplayed();
    }

    public boolean isHeaderLoginButtonDisplayed() {
        waitForElementPresent(headerLoginButton);
        return getElement(headerLoginButton).isDisplayed();
    }

    public void clickHeaderLoginButton() {
        clickOnMethod(headerLoginButton);
    }

    // ===== FOOTER METHODS =====
    public boolean isFooterSectionDisplayed() {
        waitForElementPresent(footerSection);
        return getElement(footerSection).isDisplayed();
    }

    public List<WebElement> getFooterLinks() {
        waitForElementPresent(footerLinks);
        return getElements(footerLinks);
    }

    public boolean isFooterLinkPresent(String linkText) {
        List<WebElement> links = getFooterLinks();
        for (WebElement link : links) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFooterSocialIconsDisplayed() {
        List<WebElement> icons = getElements(footerSocialIcons);
        return icons != null && !icons.isEmpty();
    }

    public boolean isFooterCopyrightDisplayed() {
        waitForElementPresent(footerCopyright);
        return getElement(footerCopyright).isDisplayed();
    }

    public boolean isFooterPrivacyPolicyDisplayed() {
        waitForElementPresent(footerPrivacyPolicy);
        return getElement(footerPrivacyPolicy).isDisplayed();
    }

    public void clickFooterPrivacyPolicy() {
        clickOnMethod(footerPrivacyPolicy);
    }

    // ===== GENERIC VALIDATION METHODS =====
    public boolean validateAllHeaderComponents() {
        return isHeaderLogoDisplayed() &&
               isHeaderNavigationMenuDisplayed() &&
               isHeaderSearchIconDisplayed() &&
               isHeaderContactLinkDisplayed() &&
               isHeaderLoginButtonDisplayed();
    }

    public boolean validateAllFooterComponents() {
        return isFooterSectionDisplayed() &&
               isFooterSocialIconsDisplayed() &&
               isFooterCopyrightDisplayed() &&
               isFooterPrivacyPolicyDisplayed();
    }
}

package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class FooterPage_WCMS extends BasePage {

    // Example locators for footer components
    // TODO: Replace with actual locators
    private By footerContainer = By.xpath("//footer"); // TODO: Replace with actual locator
    private By footerLinks = By.xpath("//footer//a"); // TODO: Replace with actual locator
    private By footerLogo = By.xpath("//footer//img[contains(@class, 'footer-logo')]"); // TODO: Replace with actual locator
    private By footerSocialIcons = By.xpath("//footer//a[contains(@class, 'social-icon')]"); // TODO: Replace with actual locator
    private By footerCopyright = By.xpath("//footer//*[contains(text(),'Copyright')]"); // TODO: Replace with actual locator

    public FooterPage_WCMS(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if the footer container is displayed
     */
    public boolean isFooterDisplayed() {
        waitForElementPresent(footerContainer);
        return getElement(footerContainer).isDisplayed();
    }

    /**
     * Returns the list of footer links
     */
    public List<WebElement> getFooterLinks() {
        waitForElementPresent(footerContainer);
        return getElements(footerLinks);
    }

    /**
     * Checks if the footer logo is displayed
     */
    public boolean isFooterLogoDisplayed() {
        waitForElementPresent(footerLogo);
        return getElement(footerLogo).isDisplayed();
    }

    /**
     * Returns the list of social media icons in the footer
     */
    public List<WebElement> getFooterSocialIcons() {
        waitForElementPresent(footerSocialIcons);
        return getElements(footerSocialIcons);
    }

    /**
     * Gets the copyright text from the footer
     */
    public String getFooterCopyrightText() {
        waitForElementPresent(footerCopyright);
        return getElement(footerCopyright).getText();
    }

    /**
     * Clicks a footer link by its visible text
     * @param linkText the visible text of the link
     */
    public void clickFooterLinkByText(String linkText) {
        By linkLocator = By.xpath("//footer//a[normalize-space(text())='" + linkText + "']");
        waitForElementPresent(linkLocator);
        clickOnMethod(linkLocator);
    }

    /**
     * Checks if a specific footer link is present
     * @param linkText the visible text of the link
     * @return true if present, false otherwise
     */
    public boolean isFooterLinkPresent(String linkText) {
        By linkLocator = By.xpath("//footer//a[normalize-space(text())='" + linkText + "']");
        try {
            waitForElementPresent(linkLocator);
            return getElement(linkLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if a specific social icon is present by aria-label or title
     * @param socialName the aria-label or title of the social icon (e.g., 'Twitter', 'LinkedIn')
     * @return true if present, false otherwise
     */
    public boolean isFooterSocialIconPresent(String socialName) {
        By iconLocator = By.xpath("//footer//a[contains(@aria-label, '" + socialName + "') or contains(@title, '" + socialName + "')]");
        try {
            waitForElementPresent(iconLocator);
            return getElement(iconLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

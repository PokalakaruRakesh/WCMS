package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class FooterPage_WCMS extends BasePage {

    // Example footer locators (replace with actual locators as needed)
    private By footerContainer = By.xpath("//footer"); // TODO: Replace with actual locator if different
    private By footerLinks = By.xpath("//footer//a"); // TODO: Replace with actual locator
    private By footerLogo = By.xpath("//footer//img[contains(@alt, 'logo')]"); // TODO: Replace with actual locator
    private By footerCopyright = By.xpath("//footer//*[contains(text(),'Copyright')]"); // TODO: Replace with actual locator
    private By footerSocialIcons = By.xpath("//footer//a[contains(@class, 'social')]"); // TODO: Replace with actual locator

    public FooterPage_WCMS(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifies that the footer is displayed on the page.
     */
    public boolean isFooterDisplayed() {
        waitForElementPresent(footerContainer);
        return getElement(footerContainer).isDisplayed();
    }

    /**
     * Returns a list of all footer link elements.
     */
    public List<WebElement> getFooterLinks() {
        waitForElementPresent(footerContainer);
        return getElements(footerLinks);
    }

    /**
     * Clicks a footer link by its visible text.
     */
    public void clickFooterLinkByText(String linkText) {
        By linkBy = By.xpath("//footer//a[normalize-space(text())='" + linkText + "']");
        waitForElementPresent(linkBy);
        clickOnMethod(linkBy);
    }

    /**
     * Checks if the footer logo is displayed.
     */
    public boolean isFooterLogoDisplayed() {
        waitForElementPresent(footerLogo);
        return getElement(footerLogo).isDisplayed();
    }

    /**
     * Gets the copyright text from the footer.
     */
    public String getFooterCopyrightText() {
        waitForElementPresent(footerCopyright);
        return getElement(footerCopyright).getText();
    }

    /**
     * Returns a list of all social icon elements in the footer.
     */
    public List<WebElement> getFooterSocialIcons() {
        waitForElementPresent(footerSocialIcons);
        return getElements(footerSocialIcons);
    }

    /**
     * Verifies if a specific social icon is present by its aria-label or title.
     */
    public boolean isSocialIconPresent(String iconLabel) {
        By iconBy = By.xpath("//footer//a[@aria-label='" + iconLabel + "' or @title='" + iconLabel + "']");
        try {
            waitForElementPresent(iconBy);
            return getElement(iconBy).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Add more methods as needed for all 108 test steps, using placeholder locators where necessary.
    // For any missing locator, use the pattern below:
    // private By PLACEHOLDER_descriptiveName = By.id("PLACEHOLDER_descriptiveName"); // TODO: Replace with actual locator
    // public void actionOnDescriptiveName() { ... }
}

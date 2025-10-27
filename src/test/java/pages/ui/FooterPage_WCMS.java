package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class FooterPage_WCMS extends BasePage {

    // Example footer locators (replace PLACEHOLDER with actual locators when available)
    private By footerContainer = By.xpath("//footer"); // TODO: Replace with actual locator if different
    private By footerLinks = By.cssSelector("footer a"); // TODO: Replace with actual locator if needed
    private By footerLogo = By.xpath("//footer//img[contains(@alt, 'logo')]"); // TODO: Replace with actual locator
    private By footerSocialIcons = By.cssSelector("footer .social-icons a"); // TODO: Replace with actual locator
    private By footerCopyright = By.xpath("//footer//*[contains(text(), 'Copyright')]"); // TODO: Replace with actual locator

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
     * Returns the list of all footer links
     */
    public List<WebElement> getFooterLinks() {
        waitForElementPresent(footerLinks);
        return getElements(footerLinks);
    }

    /**
     * Clicks a footer link by visible text
     */
    public void clickFooterLinkByText(String linkText) {
        List<WebElement> links = getFooterLinks();
        for (WebElement link : links) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                link.click();
                return;
            }
        }
        throw new RuntimeException("Footer link with text '" + linkText + "' not found");
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
     * Checks if the copyright text is present in the footer
     */
    public boolean isFooterCopyrightDisplayed() {
        waitForElementPresent(footerCopyright);
        return getElement(footerCopyright).isDisplayed();
    }

    /**
     * Gets the copyright text from the footer
     */
    public String getFooterCopyrightText() {
        waitForElementPresent(footerCopyright);
        return getElement(footerCopyright).getText();
    }

    // Add more methods as needed for the 108 test steps, following the above pattern.
    // For any missing elements, add placeholder locators and methods with descriptive names.
}

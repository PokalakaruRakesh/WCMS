package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import org.testng.Assert;

public class FooterPage_WCMS extends BasePage {

    public FooterPage_WCMS(WebDriver driver) {
        super(driver);
    }

    // Placeholder locators for footer components (replace with actual locators)
    private By footerSection = By.xpath("//footer"); // TODO: Replace with actual locator if more specific
    private By footerCopyright = By.xpath("//footer//*[contains(text(),'Copyright')]"); // TODO: Replace with actual locator
    private By footerPrivacyPolicyLink = By.xpath("//footer//a[contains(text(),'Privacy Policy')]"); // TODO: Replace with actual locator
    private By footerTermsOfUseLink = By.xpath("//footer//a[contains(text(),'Terms of Use')]"); // TODO: Replace with actual locator
    private By footerContactUsLink = By.xpath("//footer//a[contains(text(),'Contact Us')]"); // TODO: Replace with actual locator
    
    // Example: Validate footer section is displayed
    public boolean isFooterDisplayed() {
        try {
            waitForElementPresent(footerSection);
            return getElement(footerSection).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Example: Validate copyright text is present
    public boolean isCopyrightDisplayed() {
        try {
            waitForElementPresent(footerCopyright);
            return getElement(footerCopyright).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Example: Validate Privacy Policy link is present and clickable
    public boolean isPrivacyPolicyLinkDisplayed() {
        try {
            waitForElementPresent(footerPrivacyPolicyLink);
            return getElement(footerPrivacyPolicyLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickPrivacyPolicyLink() {
        try {
            ReusableMethods.scrollIntoView(getElement(footerPrivacyPolicyLink), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(footerPrivacyPolicyLink));
            getElement(footerPrivacyPolicyLink).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example: Validate Terms of Use link is present and clickable
    public boolean isTermsOfUseLinkDisplayed() {
        try {
            waitForElementPresent(footerTermsOfUseLink);
            return getElement(footerTermsOfUseLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickTermsOfUseLink() {
        try {
            ReusableMethods.scrollIntoView(getElement(footerTermsOfUseLink), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(footerTermsOfUseLink));
            getElement(footerTermsOfUseLink).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example: Validate Contact Us link is present and clickable
    public boolean isContactUsLinkDisplayed() {
        try {
            waitForElementPresent(footerContactUsLink);
            return getElement(footerContactUsLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContactUsLink() {
        try {
            ReusableMethods.scrollIntoView(getElement(footerContactUsLink), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(footerContactUsLink));
            getElement(footerContactUsLink).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example: Validate all footer components are visible
    public void validateAllFooterComponentsVisible() {
        Assert.assertTrue(isFooterDisplayed(), "Footer section is not displayed");
        Assert.assertTrue(isCopyrightDisplayed(), "Copyright is not displayed in footer");
        Assert.assertTrue(isPrivacyPolicyLinkDisplayed(), "Privacy Policy link is not displayed in footer");
        Assert.assertTrue(isTermsOfUseLinkDisplayed(), "Terms of Use link is not displayed in footer");
        Assert.assertTrue(isContactUsLinkDisplayed(), "Contact Us link is not displayed in footer");
    }
}

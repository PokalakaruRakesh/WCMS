package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Set;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import com.astm.commonFunctions.WCMSICommon;

public class FooterSectionPage extends BasePage {

    // Locators for social media icons in the footer
    public By twitterLink = By.xpath("//a[@href='https://twitter.com/ASTMIntl']");
    public By facebookLink = By.xpath("//a[@href='https://www.facebook.com/ASTMInternational/']");
    public By youtubeLink = By.xpath("//a[@href='https://www.youtube.com/ASTMIntl']");
    public By linkedinLink = By.xpath("//a[@href='https://www.linkedin.com/company/astm-international']");
    public By instagramLink = By.xpath("//a[@href='https://www.instagram.com/astmintl/']");

    public FooterSectionPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Comprehensive method to validate Twitter footer link functionality:
     *  - Scrolls to footer
     *  - Verifies Twitter link is present and correct
     *  - Clicks Twitter link and verifies Twitter page loads in new tab
     *  - Closes new tab and returns to original
     *
     * @param expectedTwitterUrl The expected Twitter URL (e.g., "https://twitter.com/ASTMIntl")
     * @return true if Twitter page loads successfully, false otherwise
     */
    public boolean validateTwitterFooterLink(String expectedTwitterUrl) {
        try {
            // Scroll to the footer Twitter icon
            ReusableMethods.scrollToElement(driver, twitterLink);
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(twitterLink), 10);
            WebElement twitter = getElement(twitterLink);
            // Verify href property
            String href = twitter.getAttribute("href");
            if (!expectedTwitterUrl.equals(href)) {
                return false;
            }
            // Click the Twitter link (opens in new tab)
            String originalWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            twitter.click();
            WCMSICommon.waitForSec(2);
            // Wait for new tab
            Set<String> newWindows = driver.getWindowHandles();
            newWindows.removeAll(oldWindows);
            if (newWindows.size() != 1) {
                return false;
            }
            String newTab = newWindows.iterator().next();
            driver.switchTo().window(newTab);
            WaitStatementUtils.waitForPageLoad(driver, 15);
            String currentUrl = driver.getCurrentUrl();
            boolean result = currentUrl.startsWith(expectedTwitterUrl);
            driver.close();
            driver.switchTo().window(originalWindow);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

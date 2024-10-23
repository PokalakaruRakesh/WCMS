
package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CommonPage_WCMS extends BasePage {

    public CommonPage_WCMS(WebDriver driver) {
        super(driver);

    }

    Actions action = new Actions(driver);

    public WebElement getLearnMoreLinksUnderTiles(int index, String section) {
        return driver.findElement(By.xpath("(//h4[text()='" + section + "']/../div//a[text()='Learn More'])[" + index + "]"));
    }

    public By aboutNavigation = By.xpath("(//button[text()='About ASTM'])[last()]");
    public By aboutASTMOverview = By.xpath("(//a[@href='/about'][text()='About ASTM Overview'])[last()]");

    @Step("Click on 'About' Navigation Option")
    public void ClickOnAboutNavigationOption() {
        try {
            ReusableMethods.mouseHover(driver, getElement(aboutNavigation), "Click on About ASTM Option");
            getElement(aboutNavigation).click();
        } catch (Exception e) {
            e.getStackTrace();// TODO: handle exception
        }
    }

    @Step("Click on 'About ASTM overview' Option")
    public void ClickOnAboutOverviewOption() {
        try {
            WCMSICommon.waitForSec(3);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(aboutASTMOverview));
            getElement(aboutASTMOverview).click();
        } catch (Exception e) {
            e.getStackTrace();// TODO: handle exception
        }
    }

    @Step("Click on 'Standard_Solution_Overview' Option")
    public void getstandardandSolution() {
        try {
            WCMSICommon.waitForSec(3);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(aboutASTMOverview));
            getElement(aboutASTMOverview).click();
        } catch (Exception e) {
            e.getStackTrace();// TODO: handle exception
        }
    }


    @Step("Validate {message} redirects to the correct page")
    public Boolean ValidateLink(By locator, String link, String expectedTitle, String message) {
        try {
            ReusableMethods.scrollIntoView(getElement(locator), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(locator));
            Assert.assertTrue(getElement(locator).getAttribute("href").contains(link));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(Common.clickonWebElement(driver, locator));
            WCMSICommon.waitForSec(3);
            Assert.assertEquals(driver.getTitle(), expectedTitle);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            driver.navigate().back();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Step("Validate {message} redirects to the correct page")
    public Boolean ValidateLinkNewtab(By locator, String link, String expectedTitle, String message) {
        try {
            ReusableMethods.scrollIntoView(getElement(locator), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(locator));
            // Validate that the href contains the correct link
            Assert.assertTrue(getElement(locator).getAttribute("href").contains(link));
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Click on the element
            Assert.assertTrue(Common.clickonWebElement(driver, locator));
            WCMSICommon.waitForSec(3);

            // Switch to the new tab
            String originalWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Validate the title of the new tab
            Assert.assertEquals(driver.getTitle(), expectedTitle);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Close the new tab and switch back to the original tab
            driver.close();
            driver.switchTo().window(originalWindow);
            //driver.switchTo().defaultContent();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Step("Validate Learn More link In cards under {Section} section")
    public Boolean ValidateLinksUnderTiles(List<WebElement> links, List<String> expectedLinks, String Section) {
        try {
            for (int i = 0; i < links.size(); i++) {
                WebElement linkElement = getLearnMoreLinksUnderTiles(i + 1, Section);
                String expectedLink = expectedLinks.get(i);// Get the corresponding expected line
                // Validate link redirection
                ReusableMethods.scrollToElement(driver, linkElement);
                WaitStatementUtils.waitForElementToBeClickable(driver, linkElement);
                Assert.assertTrue(linkElement.getAttribute("href").contains(expectedLink));
                ScreenshotUtil.takeScreenshotForAllure(driver);
                linkElement.click();
                WCMSICommon.waitForSec(2);
                Assert.assertTrue(driver.getCurrentUrl().contains(expectedLink));
                ScreenshotUtil.takeScreenshotForAllure(driver);
                driver.navigate().back();
                WCMSICommon.waitForSec(2);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
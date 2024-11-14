
package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CommonPage_WCMS extends BasePage {

    public CommonPage_WCMS(WebDriver driver) {
        super(driver);

    }

    Actions action = new Actions(driver);

    public WebElement getLearnMoreLinksUnderTiles(int index, String section) {
        return driver.findElement(By.xpath("(//h4[text()='" + section + "']/../div//a[text()='Learn More'])[" + index + "]"));
    }
    public By videoLink = By.xpath("(//iframe[@title='Video'])[1]");

    public WebElement getVideoLink() {
        return driver.findElement(videoLink);
    }

    public WebElement getWistiaVideoLink(String heading) {
        return driver.findElement(By.xpath("//h4[text()='"+heading+"']/following-sibling::iframe[@title='Wistia video player']"));
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

    public By faqNavigation = By.xpath("//header//*[text()='FAQ'][last()]");

    @Step("Click on 'FAQ' Navigation Option")
    public void ClickOnFAQNavigationOption() {
        try {
            WCMSICommon.waitForSec(3);
            ReusableMethods.mouseHover(driver, getElement(faqNavigation), "Click on FAQ Option");
            getElement(faqNavigation).click();
        } catch (Exception e) {
            e.getStackTrace();// TODO: handle exception
        }
    }

    public By standardSolutionNavigation = By.xpath("(//button[text()='Standards & Solutions'])[last()]");

    @Step("Click on 'Standard_Solution_Overview' Option")
    public void getstandardandSolution() {
        try {
            WCMSICommon.waitForSec(3);
            ReusableMethods.mouseHover(driver, getElement(standardSolutionNavigation), "Click on Standard & solution Option");
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(standardSolutionNavigation));
            getElement(standardSolutionNavigation).click();
        } catch (Exception e) {
            e.getStackTrace();// TODO: handle exception
        }
    }

    public By trackerServiceNavigation = By.xpath("(//a[contains(text(),'ASTM Standards Tracker')])[last()]");

    @Step("Click on 'Tracker Services' Option")
    public void clickOnTrackerServices() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(trackerServiceNavigation));
            getElement(trackerServiceNavigation).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By ASTMDigitalServiceNavigation = By.xpath("(//a[@title='Digital Library'])[5]");

    @Step("Click on 'Digital Library' Option")
    public void clickonASTMDigitalLibrary() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ASTMDigitalServiceNavigation));
            getElement(ASTMDigitalServiceNavigation).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By ASTMBookofStandardNavigation = By.xpath("(//a[@title='Book of Standards'])[5]");

    @Step("Click on 'Book of Standard' Option")
    public void clickonASTMBookofStandard() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ASTMBookofStandardNavigation));
            getElement(ASTMBookofStandardNavigation).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By laboratoryServices = By.xpath("(//a[@title='Laboratory Services'])[5]");

    @Step("Click on 'Laboratory Services' Option")
    public void clickOnLaboratoryServices() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(laboratoryServices));
            getElement(laboratoryServices).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By standardpublications = By.xpath("(//a[@title='Standards & Publications'])[5]");

    @Step("Click on 'Standard & Publications' Option")
    public void clickOnStandardAndPublications() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(standardpublications));
            getElement(standardpublications).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By MarketInsightInnovation = By.xpath("(//a[@title='Market Insights & Innovation'])[5]");

    @Step("Click on 'Market Insights and Innovation' Option")
    public void clickOnMarketInsightsInnovation() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(MarketInsightInnovation));
            getElement(MarketInsightInnovation).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By TrainningByIndustry = By.xpath("(//a[@title='Training by Industry'])[4]");

    @Step("Click on 'Training By Industry' Option")
    public void clickonTrainningByIndustry() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(TrainningByIndustry));
            getElement(TrainningByIndustry).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By enterpriseSolution = By.xpath("(//a[@title='Enterprise Solutions'])[5]");

    @Step("Click on 'Enterprise Solutions' Option")
    public void clickOnEnterpriseSolution() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(enterpriseSolution));
            getElement(enterpriseSolution).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public By ASTMMultimediaSolution= By.xpath("(//a[@title='Multimedia Services'])[4]");
    public void clickonASTMMultimediaSolutions() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(ASTMMultimediaSolution));
            getElement(ASTMMultimediaSolution).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By astmCompass = By.xpath("(//a[contains(@title, 'ASTM Compass')])[4]");

    public void clickOnASTMCompass() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(astmCompass));
            getElement(astmCompass).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
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
            Assert.assertTrue(driver.getTitle().contains(expectedTitle));
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
            WCMSICommon.waitForSec(5);
            // Validate the title of the new tab
            Assert.assertTrue(driver.getTitle().contains(expectedTitle));
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
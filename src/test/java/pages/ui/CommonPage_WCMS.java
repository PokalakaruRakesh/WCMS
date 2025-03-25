
package pages.ui;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        return driver.findElement(By.xpath("//h4[text()='" + heading + "']/following-sibling::iframe[@title='Wistia video player']"));
    }

    public By aboutNavigation = By.xpath("(//button[text()='About ASTM'])[last()]");
    public By aboutASTMOverview = By.xpath("(//a[@href='/about'][text()='About ASTM Overview'])[last()]");
    public By Search = By.xpath("(//input[@aria-label='Search'])[2]");
    public By SearchIcon = By.xpath("(//button[@type='submit'])[2]");
    public By SearchResult = By.xpath("//h2[text()='Search Result']");
    public By show = By.xpath("(//select[@id='limitSelect'])[2]");
    public By SortBy = By.xpath("(//select[@name='Sort by'])[2]");
    public By ArrowIcon = By.xpath("(//*[@data-role='direction-switcher'])[2]");
    public By PreviousButton = By.xpath("//button[@aria-label='Previous']");
    public By Nextbutton = By.xpath("//button[@aria-label='Next']");
    public By ActivePage = By.xpath("//li[contains(@class,'searchComponent_active')]");
    public By SearchResults = By.xpath("//h4[contains(@class,'searchComponent_title')]");
    public By  DidNotProduceAnyResults = By.xpath(" //*[text()=' did not produce any results']");
    public By  SubmitMessageBtn = By.xpath("//p[text()='Submit Message' or text()='Submit']");

    public By dropDown(String buttonText) {
        return By.xpath(String.format("//button[contains(text(),'%s')]", buttonText));
    }
    public By getElement(String text) {
        return By.xpath("//a[contains(text(),'"+text+"')]");
    }
    public By clickOnDropDown(String text) {
        return By.xpath("//button[contains(text(),'"+text+"')]");
    }
    public By selectFileByName(String fileName) {
        return By.xpath("//a[contains(text(),'"+fileName+"')]");
    }
    public By verifyEmailByCommitteeName(String committe,String mail) {
        return By.xpath("//p[contains(text(),'"+committe+"')]/a[text()='"+mail+"']");
    }
    public String getFieldMessage(String name) {
        By locator=By.xpath("//p[contains(text(),'"+name+"')]/../../span[@class='invalid-feedback']");
        ReusableMethods.scrollToElement(driver,locator);
        return getElement(locator).getText();
    }
    public By enterFormField(String filedName) {
        return By.xpath("//*[contains(@title,'"+filedName+"') or @id='"+filedName+"']");
    }
    @Step("Click on 'About' Navigation Option")
    public void ClickOnAboutNavigationOption() {
        try {
            ReusableMethods.mouseHover(driver, getElement(aboutNavigation), "Click on About ASTM Option");
            getElement(aboutNavigation).click();
        } catch (Exception e) {
            e.getStackTrace();// TODO: handle exception
        }
    }

    public By anniversaryCaseStudies = By.xpath("(//a[contains(@href, '125th-anniversary-case-studies')])[4]");

    @Step("Click on '125th Anniversary Case Studies' Navigation Option")
    public void clickOnAnniversaryCaseStudies() {
        try {
            ReusableMethods.mouseHover(driver, getElement(aboutNavigation), "Click on About ASTM Option");
            getElement(anniversaryCaseStudies).click();
            WCMSICommon.waitForSec(3);
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

    @Step("Click on 'Standard_Solution' Option")
    public void getstandardandSolution() {
        try {
            WCMSICommon.waitForSec(1);
            ReusableMethods.mouseHover(driver, getElement(standardSolutionNavigation), "Click on Standard & solution Option");
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(standardSolutionNavigation));
            getElement(standardSolutionNavigation).click();
        } catch (Exception e) {
            e.getStackTrace();// TODO: handle exception
        }
    }

    public By standardSolutionOverview = By.xpath("(//a[text()='Standards & Solutions Overview'])[2]");

    @Step("Click on 'Standard_Solution_Overview' Option")
    public void clickStandardAndSolutionOverview() {
        try {
            WCMSICommon.waitForSec(2);
            ReusableMethods.mouseHover(driver, getElement(standardSolutionOverview), "Click on Standard & solution Overview Option");
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(standardSolutionOverview));
            getElement(standardSolutionOverview).click();
            WCMSICommon.waitForSec(2);

        } catch (Exception e) {
            e.getStackTrace();// TODO: handle exception
        }
    }

    public By membershipParticipationNavigation = By.xpath("(//button[text()='Membership & Participation'])[last()]");

    @Step("Click on 'Membership And Participation' Option")
    public void clickOnMembershipParticipation() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(membershipParticipationNavigation));
            getElement(membershipParticipationNavigation).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By membershipParticipationOverview = By.xpath("(//a[contains(text(), 'Membership & Participation Overview')])[2]");

    @Step("Click on 'Membership And Participation overview' Option")
    public void clickOnMembershipAndParticipationOverviewNavigation() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(membershipParticipationOverview));
            getElement(membershipParticipationOverview).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By emergingProfessionalsNavigation = By.xpath("(//a[@title='Emerging Professionals'])[5]");

    @Step("Click on 'Emerging Professionals Navigation' Option")
    public void clickOnEmergingProfessionals() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(emergingProfessionalsNavigation));
            getElement(emergingProfessionalsNavigation).click();
            WCMSICommon.waitForSec(3);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By technicalCommitteesNavigation = By.xpath("(//a[@title='Technical Committees'])[5]");

    @Step("Click on 'Technical Committees' Option")
    public void clickOnTechnicalCommittees() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(technicalCommitteesNavigation));
            getElement(technicalCommitteesNavigation).click();
            WCMSICommon.waitForSec(3);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By students = By.xpath("(//a[@title='Student Members'])[4]");

    @Step("Click on 'Students' Option")
    public void clickOnStudents() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(students));
            getElement(students).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By membership = By.xpath("(//a[@title='Membership'])[5]");

    @Step("Click on 'Membership' Option")
    public void clickOnMembership() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(membership));
            getElement(membership).click();
            WCMSICommon.waitForSec(3);
        } catch (Exception e) {
            e.getStackTrace();
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

    public By ASTMMultimediaSolution = By.xpath("(//a[@title='Multimedia Services'])[4]");

    @Step("Click on 'ASTM Multimedia Solution' Option")
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

    @Step("Click on 'ASTM Compass' Option")
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

    public By specBuilder = By.xpath("(//a[contains(@title, 'ASTM SpecBuilder')])[4]");

    @Step("Click on 'ASTM Specbuilder' Option")
    public void clickOnASTMSpecbuilder() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(specBuilder));
            getElement(specBuilder).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By regionalOffices = By.xpath("(//a[@title='Regional Offices and Support'])[5]");

    @Step("Click on 'Regional Offices' Option")
    public void clickOnRegionalOffices() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(regionalOffices));
            getElement(regionalOffices).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By help = By.xpath("(//button[text()='Help'])[last()]");

    @Step("Click on 'Help' Option")
    public void getHelp() {
        try {
            WCMSICommon.waitForSec(1);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(help));
            getElement(help).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By helpoverview = By.xpath("(//a[text()='Help Overview'])[2]");

    @Step("Click on 'Help' Option")
    public void clickHelpOverview() {
        try {
            WCMSICommon.waitForSec(1);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(helpoverview));
            getElement(helpoverview).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Step("Validate {message} redirects to the correct page")
    public Boolean ValidateLink(By locator, String link, String expectedTitle, String message) {
        try {
            ReusableMethods.scrollIntoView(getElement(locator), driver);
            WaitStatementUtils.waitForElementStaleness(driver, getElement(locator),3);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(locator));
            Assert.assertTrue(getElement(locator).getAttribute("href").contains(link));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(Common.clickonWebElement(driver, locator));
            WCMSICommon.waitForSec(5);
            Assert.assertTrue(driver.getTitle().contains(expectedTitle));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            driver.navigate().back();
            WCMSICommon.waitForSec(3);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Step("Validate Play Pause button functionality on Postcast")
    public Boolean validatePlayPauseButton(By buttonLocator, String playPath, String pausePath, String message) {
        try {
            // Scroll to the button and ensure it is clickable
            ReusableMethods.scrollIntoView(getElement(buttonLocator), driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(buttonLocator));

            // Locate the <path> element inside the Play/Pause button
            WebElement pathElement = getElement(By.xpath(buttonLocator + "//path"));

            // Capture the initial state of the button
            String initialPathData = pathElement.getAttribute("d");
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Verify the initial state is Play
            if (!initialPathData.contains(playPath) && !initialPathData.contains(pausePath)) {
                throw new AssertionError("Button state is neither Play nor Pause.");
            }
            System.out.println("Initial button state: " + (initialPathData.contains(playPath) ? "Play" : "Pause"));

            // Click the button to toggle state
            Assert.assertTrue(Common.clickonWebElement(driver, buttonLocator));
            WCMSICommon.waitForSec(2); // Allow time for the state change

            // Capture the updated state of the button
            String updatedPathData = pathElement.getAttribute("d");
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Validate that the state has toggled
            if (initialPathData.contains(playPath)) {
                Assert.assertTrue(updatedPathData.contains(pausePath), "Button did not toggle to Pause.");
                System.out.println("Button toggled to Pause state.");
            } else if (initialPathData.contains(pausePath)) {
                Assert.assertTrue(updatedPathData.contains(playPath), "Button did not toggle to Play.");
                System.out.println("Button toggled to Play state.");
            }

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
            WaitStatementUtils.waitForElementStaleness(driver, getElement(locator),3);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(locator));
            // Validate that the href contains the correct link
            Assert.assertTrue(getElement(locator).getAttribute("href").contains(link));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            // Click on the element
            Assert.assertTrue(Common.clickonWebElement(driver, locator));
            WCMSICommon.waitForSec(4);
            // Switch to the new tab
            String originalWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
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

    public By News = By.xpath("(//button[text()='News'])[last()]");

    public void getNews() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(News));
            getElement(News).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By NewsOption = By.xpath("(//a[text()='News' and @href='/news'])[2]");

    public void clickOnNews() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(NewsOption));
            getElement(NewsOption).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public By STANDARDIZATIONNewsOption = By.xpath("(//a[text()='Standardization News'])[5]");

    public void clickOnSTANDARDIZATIONNews() {
        try {
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(STANDARDIZATIONNewsOption));
            getElement(STANDARDIZATIONNewsOption).click();
            WCMSICommon.waitForSec(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    @Step("Validate {message} redirects to the correct page")
    public Boolean ValidateLink(By locator, String link, String expectedTitle) {
        try {
            ReusableMethods.scrollIntoView(getElement(locator), driver);
            WaitStatementUtils.waitForElementStaleness(driver, getElement(locator),5);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(locator));
            Assert.assertTrue(getElement(locator).getAttribute("href").contains(link));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(Common.clickonWebElement(driver, locator));
            WCMSICommon.waitForSec(4);
            String originalWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    if (windowHandles.size() == 3 && driver.getCurrentUrl().contains("chrome-extension://")) {
                        continue;
                    }
                    break;
                }
            }
            WCMSICommon.waitForSec(3);
             if(driver.getTitle().contains("404 Not Found")){
              Assert.fail("Page returned 404 Not Found instead of the expected title.");
            }else if (driver.getCurrentUrl().contains(".pdf") && driver.getTitle().contains("")){
                System.out.println("This is pdf file");
            }else {
                 String title=driver.getTitle();
                Assert.assertTrue(driver.getTitle().contains(expectedTitle));
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
            if (windowHandles.size() == 3 || windowHandles.size() == 2){
                driver.close();
                driver.switchTo().window(originalWindow);
            }else {
                driver.navigate().back();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Step("Validate {message}  download the file")
    public Boolean ValidateDownloadedFile(By locator,String fileName) {
        try {
            String downloadFolder=System.getProperty("user.dir")+"\\"+ ConfigReader.getValue("DownloadPath")+"\\downloads";
            ReusableMethods.scrollIntoView(getElement(locator), driver);
            WaitStatementUtils.waitForElementStaleness(driver, getElement(locator),2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(locator));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(Common.clickonWebElement(driver, locator));
            WCMSICommon.waitForSec(5);
            Assert.assertTrue(ReusableMethods.checkIfFileExists(downloadFolder,fileName));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Step("Validate {message} redirects to the correct page")
    public void downloadFileSetup(String url) {
        try {
            driver.close();
            String path=System.getProperty("user.dir")+"\\"+ ConfigReader.getValue("DownloadPath")+"\\downloads";
            ReusableMethods.deleteFilesInsideFolder(path);
            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdir();
            }
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("download.default_directory", path);
            prefs.put("plugins.always_open_pdf_externally", true);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            WebDriver driver = new ChromeDriver(options);
            Page page=new BasePage(driver);
            BasePage basePage=new BasePage(driver);
            driver.manage().window().maximize();
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Step("scroll To Element And Fill Field")
    public static void scrollToElementAndFillField(WebDriver driver, By locator, String value) {
        try {
            ReusableMethods.scrollToElement(driver,locator);
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(value);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
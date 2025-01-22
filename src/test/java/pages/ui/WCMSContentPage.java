package pages.ui;


import base.utils.JsonFileReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import com.google.gson.JsonObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WCMSContentPage extends  BasePage {
    public WCMSContentPage(WebDriver driver) {
        super(driver);
    }
    JsonFileReader jsonFileReader =new JsonFileReader();
    CookiePage cookiePage=getInstance(CookiePage.class);

    private String menu = "(//button[contains(text(),'[MENU]')])[2]|(//a[contains(@title,'[MENU]')])[2]";
    private String submenu = "(//div[contains(@class,'submenuMain')]/following::a[contains(text(),'[SUBMENU]')])[2]";
    private String submenuList = "//nav[@data-testid='navbar']//a[contains(text(),'[TEXT]')]";
    private String mainHeader = "//h2[contains(text(),'[MAINHEADER]')]|//h2//strong[contains(text(),'[MAINHEADER]')]";
    private String header = "//h4[contains(text(),'[HEADER]')]|//h4/span[contains(text(),'[HEADER]')]|//h4//strong[contains(text(),'[HEADER]')]|//h5[contains(text(),'[HEADER]')]|//h5/span[contains(text(),'[HEADER]')]";
    private String subheader = "//h6[contains(text(),'[SUBHEADER]')]|//h6/span[contains(text(),'[SUBHEADER]')]|//h5[contains(text(),'[SUBHEADER]')]";
    private String linkText = "//a[contains(text(),'[TEXT]')]";
    private String textUnderMainheader = "//h2[contains(text(),'[MAINHEADER]')]/..//p[contains(text(),'[TEXT]')]|//h2[contains(text(),'[MAINHEADER]')]/following::h5[contains(text(),'[TEXT]')]";
    private String textUnderMainheader1 = "//h2[contains(text(),'[MAINHEADER]')]/..//p[contains(text(),\"[TEXT]\")]";
    private String textUnderHeader = "//h4[contains(text(),'[HEADER]')]/..//*[contains(text(),'[TEXT]')]|//h4[contains(text(),'[HEADER]')]/parent::div[contains(text(),'[TEXT]')]|//h5[contains(text(),'[HEADER]')]/..//*[contains(text(),'[TEXT]')]";
    private String textUnderHeader1 = "//h5[contains(text(),'[HEADER]')]/..//*[contains(text(),\"[TEXT]\")]";
    private String headerUnderMainheader = "//h2[contains(text(),'[MAINHEADER]')]/..//h6[contains(text(),'[HEADER]')]";
    private String subheaderUnderHeader = "//h4[contains(text(),'[HEADER]')]/..//h6[contains(text(),'[SUBHEADER]')]|//h4[contains(text(),'[HEADER]')]/..//h5[contains(text(),'[SUBHEADER]')]|//h4[contains(text(),'[HEADER]')]/..//h6/strong[contains(text(),'[SUBHEADER]')]";
    private String subheaderUnderSubheader = subheader+"/../..//h6[contains(text(),'[SUBHEADER2]')]";
    private String subheaderUnderHeader1 = "//h4[contains(text(),'[HEADER]')]/..//h4[contains(text(),'[SUBHEADER]')]";
    private String subheaderUnderMainheader = "//h2[contains(text(),'[MAINHEADER]')]/..//h2[contains(text(),'[SUBHEADER]')]";
    private String linkUnderHeader = "//h4[contains(text(),'[HEADER]')]/..//a[contains(text(),'[LINK]')]|//h4/span[contains(text(),'[HEADER]')]/../..//a[contains(text(),'[LINK]')]|//h5[contains(text(),'[HEADER]')]/../..//a[contains(text(),'[LINK]')]";
    private String buttonUnderHeader = header+"/..//a[contains(text(),'[TEXT]')]|"+header+"/../../following::div/a[contains(text(),'[TEXT]')]|"+header+"/..//a[contains(text(),'[TEXT]')]";
    private String dropdown = "//h4[contains(text(),'[HEADER]')]/..//button[contains(text(),'[TEXT]')]";
    private String buttonUnderMainheader = mainHeader+"/../../following-sibling::div/a[contains(text(),'[BUTTON]')]";
    private String buttonUnderSubheader = "//h6[contains(text(),'[HEADER]')]/..//button[contains(text(),'[BUTTON]')]|//h6[contains(text(),'[HEADER]')]/../following-sibling::a[contains(text(),'[BUTTON]')]|//h6[contains(text(),'[HEADER]')]/following::div/a[contains(text(),'[BUTTON]')]|//h6/span[contains(text(),'[HEADER]')]/../following-sibling::div/a[contains(text(),'[BUTTON]')]|//h5[contains(text(),'[HEADER]')]/../following-sibling::a[contains(text(),'[BUTTON]')]";
    private String buttonUnderSubheader1 = "//h6[contains(text(),'[HEADER]')]/../following-sibling::a[contains(text(),'[BUTTON]')]|//h6[contains(text(),'[HEADER]')]/../following::a[contains(text(),'[BUTTON]')]";
    private String linkUnderSubheader = "//h6[contains(text(),'[HEADER]')]/../../a[contains(text(),'[LINK]')]|//h5[contains(text(),'[HEADER]')]/../../a[contains(text(),'[LINK]')]";
    private String linkUnderSubheader1 = "//h6[contains(text(),'[HEADER]')]/../../following-sibling::div/a[contains(text(),'[LINK]')]";
    private String textUnderSubheader = "//h6[contains(text(),'[SUBHEADER]')]/../../div//*[contains(text(),'[TEXT]')]|//h5[contains(text(),'[SUBHEADER]')]/../../div//*[contains(text(),'[TEXT]')]";
    private String textUnderSubheader1 = "//h4[contains(text(),'[SUBHEADER]')]/../../div//p[contains(text(),'[TEXT]')]|//h6/strong[contains(text(),'[SUBHEADER]')]/../..//*[contains(text(),'[TEXT]')]";
    private String imageTextUnderHeader = "//span[contains(text(),'[TEXT1]')]/../../following-sibling::div[contains(text(),'[TEXT2]')]";
    private String text = "//*[contains(text(),'[TEXT]')]";
    private String textUnderdrp = "//button[contains(text(),'[TEXT]')]/../following-sibling::div/div";
    private String textByHeader = "//*[contains(text(),'[HEADER]')]/..//*[contains(text(),'[TEXT]')]";
    private String button = "//button[contains(text(),'[BUTTON]')]";
    public By PCRLinks = By.xpath("//h6[text()='ASTM International has published the following PCR.']/ancestor::div//ul//a[contains(text(),'PCR')]");
    public By EPDLinks = By.xpath("//h2[text()='Published Environmental Product Declarations']/..//ul//a");
    public By ASTMHeadquarters = By.xpath("//h4[text()='ASTM Headquarters']/..");
    public String Spotify = "(//*[contains(@id,'next')]//*[text()='[TEXT]'])[1]";
    public By frame = By.xpath("//iframe[@title='ASTM Podcast']");
    public By languageDrp = By.xpath("//button[@data-testid='selected-language']");
    public By englishlanguage = By.xpath("//button[@data-testid='language-change-button']//*[text()='English']");
    private  By bannerText=By.xpath("//*[contains(@data-testid,'banner-text')]");
    private  String buttonText="//a[text()='[TEXT]']";


    public By getMenu(String menuName) {
        return By.xpath(menu.replace("[MENU]", menuName));
    }
    public By getSubmenuList(String text) {
        return By.xpath(submenuList.replace("[TEXT]", text));
    }
    public By getSubmenu(String submenuName) {
        return By.xpath(submenu.replace("[SUBMENU]", submenuName));
    }
    public By getMainHeader(String mainheader) {
        return By.xpath(mainHeader.replace("[MAINHEADER]", mainheader));
    }

    public By getHeader(String headerName) {
        return By.xpath(header.replace("[HEADER]", headerName));
    }
    public By getsubheader(String subheaderName) {
        return By.xpath(subheader.replace("[SUBHEADER]", subheaderName));
    }
    public By getLinkText(String text) {
        return By.xpath(linkText.replace("[TEXT]", text));
    }
    public By getTextUnderMainheader(String mainheader, String text) {
        return By.xpath(textUnderMainheader.replace("[MAINHEADER]", mainheader).replace("[TEXT]", text));
    }
    public By getTextUnderMainheader1(String mainheader, String text) {
        return By.xpath(textUnderMainheader1.replace("[MAINHEADER]", mainheader).replace("[TEXT]", text));
    }

    public By getSubheaderUnderMainheader(String mainheader, String subheader) {
        return By.xpath(subheaderUnderMainheader.replace("[MAINHEADER]", mainheader).replace("[SUBHEADER]", subheader));
    }

    public By getHeaderUnderMainheader(String mainheader, String header) {
        return By.xpath(headerUnderMainheader.replace("[MAINHEADER]", mainheader).replace("[HEADER]", header));
    }

    public By getSubheaderUnderHeader(String header, String subheader) {
        return By.xpath(subheaderUnderHeader.replace("[HEADER]", header).replace("[SUBHEADER]", subheader));
    }
    public By getSubheaderUnderSubheader(String subheader1, String subheader2) {
        return By.xpath(subheaderUnderSubheader.replace("[SUBHEADER]", subheader1).replace("[SUBHEADER2]", subheader2));
    }
    public By getSubheaderUnderHeader1(String header, String subheader) {
        return By.xpath(subheaderUnderHeader1.replace("[HEADER]", header).replace("[SUBHEADER]", subheader));
    }

    public By getTextUnderHeader(String header, String text) {
        return By.xpath(textUnderHeader.replace("[HEADER]", header).replace("[TEXT]", text));
    }
    public By getTextUnderHeader1(String header, String text) {
        return By.xpath(textUnderHeader1.replace("[HEADER]", header).replace("[TEXT]", text).replaceAll("_APOS_",String.valueOf((char)39)));
    }
    public By getLinkUnderHeader(String header, String link) {
        return By.xpath(linkUnderHeader.replace("[HEADER]", header).replace("[LINK]", link));
    }
    public By getButtonUnderHeader(String header, String text) {
        return By.xpath(buttonUnderHeader.replace("[HEADER]", header).replace("[TEXT]", text));
    }
    public By getButtonUnderMainheader(String mainheader, String button) {
        return By.xpath(buttonUnderMainheader.replace("[MAINHEADER]", mainheader).replace("[BUTTON]", button));
    }
    public By getDropdown(String header, String text) {
        return By.xpath(dropdown.replace("[HEADER]", header).replace("[TEXT]", text));
    }
    public By getButtonUnderSubheader(String header, String button) {
        return By.xpath(buttonUnderSubheader.replace("[HEADER]", header).replace("[BUTTON]", button));
    }
    public By getButtonUnderSubheader1(String header, String button) {
        return By.xpath(buttonUnderSubheader1.replace("[HEADER]", header).replace("[BUTTON]", button));
    }
    public By getLinkUnderSubheader(String header, String link) {
        return By.xpath(linkUnderSubheader.replace("[HEADER]", header).replace("[LINK]", link));
    }
    public By getLinkUnderSubheader1(String header, String link) {
        return By.xpath(linkUnderSubheader1.replace("[HEADER]", header).replace("[LINK]", link));
    }
    public By getTextUnderSubheader(String subheader, String text) {
        return By.xpath(textUnderSubheader.replace("[SUBHEADER]", subheader).replace("[TEXT]", text));
    }
    public By getTextUnderSubheader1(String subheader, String text) {
        return By.xpath(textUnderSubheader1.replace("[SUBHEADER]", subheader).replace("[TEXT]", text));
    }
    public By getButton(String button1) {
        return By.xpath(button.replace("[BUTTON]", button1));
    }
    public String getText1(String text1) {
        return getElement(By.xpath(text.replace("[TEXT]", text1))).getText();
    }
    public By getText2(String text1) {
        return By.xpath(text.replace("[TEXT]", text1));
    }
    public WebElement getFrame() {
        return getElement(frame);
    }
    public By getSpotify(String text1) {
        return By.xpath(Spotify.replace("[TEXT]", text1));
    }
    public By getImageTextUnderHeader(String text1, String text2) {
        return By.xpath(imageTextUnderHeader.replace("[TEXT1]", text1).replace("[TEXT2]", text2));
    }
    public String getBannerText() {
        return getElement(bannerText).getText();
    }
    public String getButtonText(String text) {
        return getElement(By.xpath(buttonText.replace("[TEXT]", text))).getText();}
    public String getText(String text1) {
        By locator=By.xpath(text.replace("[TEXT]", text1));
        ReusableMethods.scrollToElement(driver,locator);
        String txt=getElement(locator).getText().replaceAll(String.valueOf((char)39),"")
                .replaceAll(String.valueOf((char)8217),"").replace("\n", "").replace(String.valueOf((char) 0x2022 ), "").
                replaceAll(String.valueOf((char) 8220),"").replaceAll(String.valueOf((char) 8221),"").replaceAll(String.valueOf((char) 174),"")
                .replaceAll(String.valueOf((char) 8211),"").trim();
        return txt;
    }
    public String getTextByHeader(String header,String text) {
        By locator=By.xpath(textByHeader.replace("[HEADER]", header).replace("[TEXT]", text));
        ReusableMethods.scrollToElement(driver,locator);
        String txt=getElement(locator).getText().replaceAll(String.valueOf((char)39),"")
                .replaceAll(String.valueOf((char)8217),"").replace("\n", "").replace(String.valueOf((char) 0x2022 ), "").
                replaceAll(String.valueOf((char) 8220),"").replaceAll(String.valueOf((char) 8221),"").replaceAll(String.valueOf((char) 174),"")
                .replaceAll(String.valueOf((char) 8211),"").replaceAll(String.valueOf((char) 34),"").replaceAll(String.valueOf((char) 0x2014),"").trim();
        return txt;
    }
    public String getTextUnderDropDown(String text) {
        WebElement webElement=getElement(By.xpath(textUnderdrp.replace("[TEXT]", text)));
        ReusableMethods.scrollToElement(driver,webElement);
        WCMSICommon.waitForSec(2);
        String txt=webElement.getText().replaceAll(String.valueOf((char)39),"")
                .replaceAll(String.valueOf((char)8217),"").replace("\n", "").replace(String.valueOf((char) 0x2022 ), "").
                replaceAll(String.valueOf((char) 8220),"").replaceAll(String.valueOf((char) 8221),"").replaceAll(String.valueOf((char) 174),"")
                .replaceAll(String.valueOf((char) 8211),"").replaceAll(String.valueOf((char) 34),"").trim();
        return txt;
    }
    public String getTextByUnderMainHeader(String mainheader,String text) {
        By locator=By.xpath(textUnderMainheader.replace("[MAINHEADER]", mainheader).replace("[TEXT]", text));
        ReusableMethods.scrollToElement(driver,locator);
        String txt=getElement(locator).getText().replaceAll(String.valueOf((char)39),"")
                .replaceAll(String.valueOf((char)8217),"").replace("\n", "").replace(String.valueOf((char) 0x2022 ), "").
                replaceAll(String.valueOf((char) 8220),"").replaceAll(String.valueOf((char) 8221),"").replaceAll(String.valueOf((char) 174),"")
                .replaceAll(String.valueOf((char) 8211),"").replaceAll(String.valueOf((char) 34),"").replaceAll(String.valueOf((char) 0x2014),"")
                .replaceAll(String.valueOf((char) 45),"").trim();
        return txt;
    }

    public String getTextSubHeader(String subheader,String text) {
        By locator=By.xpath(textUnderSubheader.replace("[SUBHEADER]", subheader).replace("[TEXT]", text));
        ReusableMethods.scrollToElement(driver,locator);
        String txt=getElement(locator).getText().replaceAll(String.valueOf((char)39),"")
                .replaceAll(String.valueOf((char)8217),"").replace("\n", "").replace(String.valueOf((char) 0x2022 ), "").
                replaceAll(String.valueOf((char) 8220),"").replaceAll(String.valueOf((char) 8221),"").replaceAll(String.valueOf((char) 174),"")
                .replaceAll(String.valueOf((char) 8211),"").replaceAll(String.valueOf((char) 34),"").replaceAll(String.valueOf((char) 0x2014),"")
                .replaceAll(String.valueOf((char) 45),"").trim();
        return txt;
    }
    @Step("Navigate to page")
    public void NavigateToPage(String menu,String submenu,String title) {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(getMenu(menu)),10);
            getElement(getMenu(menu)).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(getSubmenu(submenu)),10);
            getElement(getSubmenu(submenu)).click();
            WCMSICommon.waitForSec(4);
            String titleFromApp=driver.getTitle();
            //Assert.assertTrue(titleFromApp.contains(title),"Both "+titleFromApp+" and "+title+" not matched");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            cookiePage.handleOneTrustCookie();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Step("Navigate to page")
    public void NavigateToPage1(String menu,String title) {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(getMenu(menu)),10);
            getElement(getMenu(menu)).click();
            WCMSICommon.waitForSec(4);
            //Assert.assertEquals(driver.getTitle(),title);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            cookiePage.handleOneTrustCookie();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Step("Navigate To Submenu List")
    public void NavigateToSubmenuList(String text,String title) {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(getSubmenuList(text)),10);
            ReusableMethods.scrollToElement(driver,getSubmenuList(text));
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getSubmenuList(text)));
            WCMSICommon.JSClick(getElement(getSubmenuList(text)),driver);
            WCMSICommon.waitForSec(4);
            //Assert.assertEquals(driver.getTitle(),title);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Step("Get json data")
    public JsonObject jsonData(String JsonfileName, String JsonPrimeElement) {
        JsonObject jsonObject = null;
        try {
            jsonObject=jsonFileReader.readJsonData(JsonfileName,JsonPrimeElement);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to get json data", e);
        }
        return jsonObject;
    }
    @Step("Get json value")
    public String jsonValue(JsonObject jsonObject, String element) {
        String value = null;
        try {
            value=jsonObject.get(element).toString().replace('"',' ').trim();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to get json data", e);
        }
        return value;
    }
    @Step("Click On Dropdown")
    public void clickOnDropdown(JsonObject jsonObject,String header, String dropdown) {
        try {
            By locator=getDropdown(jsonValue(jsonObject,header),jsonValue(jsonObject,dropdown));
            ReusableMethods.scrollToElement(driver,locator);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(locator));
            WCMSICommon.JSClick(getElement(locator),driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to click On Dropdown", e);
        }
    }
    @Step("Click On Change Language")
    public void changeLanguage() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(languageDrp),10);
            ReusableMethods.scrollToElement(driver,languageDrp);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(languageDrp));
            WCMSICommon.JSClick(getElement(languageDrp),driver);
            WCMSICommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(englishlanguage));
            WCMSICommon.JSClick(getElement(englishlanguage),driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to change Language", e);
        }
    }
    @Step("Validate the URL redirection")
    public void ValidateURLRedirection(String expectedUrl) {
        try {
            WebElement link = driver.findElement(By.id("newTabLink")); // Replace with actual locator
            link.click();
            // Switch to the new tab
            String originalWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            String redirectedUrl = driver.getCurrentUrl();
            Assert.assertEquals(redirectedUrl, expectedUrl, "Redirection validation failed redirected Url "+redirectedUrl+" and expected Url "+expectedUrl+" not matched");
            // Close the new tab and switch back to the original tab
            driver.close();
            driver.switchTo().window(originalWindow);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to change Language", e);
        }
    }
}

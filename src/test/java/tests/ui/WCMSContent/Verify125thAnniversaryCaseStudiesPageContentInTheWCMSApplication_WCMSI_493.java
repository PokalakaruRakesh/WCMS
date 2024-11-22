package tests.ui.WCMSContent;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import com.google.gson.JsonObject;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CookiePage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class Verify125thAnniversaryCaseStudiesPageContentInTheWCMSApplication_WCMSI_493 extends BaseTest {
    static final String jiraTestID = "WCMSI-493";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the 125th Anniversary Case Studies content in the WCMS application - Set 2")
    @Test(description = jiraTestID
            + ": Verify the 125th Anniversary Case Studies content in the WCMS application - Set 2", groups = {""})
    public void verify125thAnniversaryCaseStudiesContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"About ASTM");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"125th Anniversary Case Studies");
            validateContentUnder125thAnniversaryCaseStudiesHeader("125thAnniversaryCaseStudies");
            validateContentUnderTheWinnersWereAsFollowsHeader("TheWinnersWereFollows");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the '125th Anniversary Case Studies' content in the WCMS application - Set 2", e);
        }
        System.out.println("Successfully Verify the '125th Anniversary Case Studies' content in the WCMS application - Set 2");
    }


    @Step("Validate Content under '125th Anniversary Case Studies' header")
    public void validateContentUnder125thAnniversaryCaseStudiesHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text")),WCMSPage.jsonValue(jsonObject,"Text"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under '125th Anniversary Case Studies' header ", e);
        }
    }
    @Step("Validate Content under 'The winners were as follows' header")
    public void validateContentUnderTheWinnersWereAsFollowsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader1(WCMSPage.jsonValue(jsonObject,"Header1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(WCMSPage.jsonValue(jsonObject,"Header1"),
                    WCMSPage.jsonValue(jsonObject,"Linktext"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader1(WCMSPage.jsonValue(jsonObject,"Header2"),
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(WCMSPage.jsonValue(jsonObject,"Header2"),
                    WCMSPage.jsonValue(jsonObject,"Linktext"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader1(WCMSPage.jsonValue(jsonObject,"Header3"),
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(WCMSPage.jsonValue(jsonObject,"Header3"),
                    WCMSPage.jsonValue(jsonObject,"Linktext"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader1(WCMSPage.jsonValue(jsonObject,"Header4"),
                    WCMSPage.jsonValue(jsonObject,"Text4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(WCMSPage.jsonValue(jsonObject,"Header4"),
                    WCMSPage.jsonValue(jsonObject,"Linktext"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader1(WCMSPage.jsonValue(jsonObject,"Header5"),
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(WCMSPage.jsonValue(jsonObject,"Header5"),
                    WCMSPage.jsonValue(jsonObject,"Linktext"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader1(WCMSPage.jsonValue(jsonObject,"Header6"),
                    WCMSPage.jsonValue(jsonObject,"Text6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(WCMSPage.jsonValue(jsonObject,"Header6"),
                    WCMSPage.jsonValue(jsonObject,"Linktext"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader1(WCMSPage.jsonValue(jsonObject,"Header7"),
                    WCMSPage.jsonValue(jsonObject,"Text7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(WCMSPage.jsonValue(jsonObject,"Header7"),
                    WCMSPage.jsonValue(jsonObject,"Linktext"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header8"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Header8"),WCMSPage.jsonValue(jsonObject,"text8"))
                    ,WCMSPage.jsonValue(jsonObject,"Text8"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(WCMSPage.jsonValue(jsonObject,"Header8"),
                    WCMSPage.jsonValue(jsonObject,"Linktext"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'The winners were as follows' header ", e);
        }
    }
}

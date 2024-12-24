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

public class VerifyRegionalOfficesPageContentInWCMSApplication_WCMSI_508 extends BaseTest {
    static final String jiraTestID = "WCMSI-508";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Regional Offices' page content in WCMS application-Set 2")
    @Test(description = jiraTestID
            + ": Verify 'Regional Offices' page content in WCMS application-Set 2", groups = {""})
    public void verifyRegionalOfficesPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"");
            validateRegionalOfficesSupportHeader("RegionalOffices");
            validateContentUnderRegionalWebsitesHeader("RegionalWebsites");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify 'Regional Offices' page content in WCMS application-Set 2", e);
        }
        System.out.println("Successfully Verify 'Regional Offices' page content in WCMS application-Set 2");
    }

    @Step("Validate Content under 'Regional Offices and Support' header")
    public void validateRegionalOfficesSupportHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Mainheader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertEquals((page.getElement(WCMSPage.ASTMHeadquarters).getText().replace("\n", "")),WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(WCMSPage.jsonValue(jsonObject,"Header"),
                    WCMSPage.jsonValue(jsonObject,"Button"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader5"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader6"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Regional Offices and Support' header ", e);
        }
    }
    @Step("Validate Content under 'Regional Websites' header")
    public void validateContentUnderRegionalWebsitesHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText5"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Regional Websites' header ", e);
        }
    }
}

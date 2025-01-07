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

public class VerifyPressReleasesPageContentInWCMSApplication_WCMSI_1060 extends BaseTest {
    static final String jiraTestID = "WCMSI-1060";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Press Releases' Page content in WCMS application-Set 3")
    @Test(description = jiraTestID
            + ": Verify 'Press Releases' Page content in WCMS application-Set 3", groups = {""})
    public void verifyPressReleasesPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);


            String url=driver.getCurrentUrl()+jsonFileReader.getJsonString("AddURL");
            driver.navigate().to(url);
            cookiePage.handleOneTrustCookie();
            validateContentUnderLatestArticlesHeader("PressReleases");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify 'Press Releases' Page content in WCMS application-Set 3", e);
        }
        System.out.println("Successfully Verify 'Press Releases' Page content in WCMS application-Set 3");
    }
    @Step("Validate Content under 'Press Releases' header")
    public void validateContentUnderLatestArticlesHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            String Header=WCMSPage.jsonValue(jsonObject,"Header");
            String SubHeader1=WCMSPage.jsonValue(jsonObject,"SubHeader1");
            String SubHeader2=WCMSPage.jsonValue(jsonObject,"SubHeader2");
            String SubHeader3=WCMSPage.jsonValue(jsonObject,"SubHeader3");
            String SubHeader4=WCMSPage.jsonValue(jsonObject,"SubHeader4");
            String SubHeader5=WCMSPage.jsonValue(jsonObject,"SubHeader5");
            String SubHeader6=WCMSPage.jsonValue(jsonObject,"SubHeader6");
            String SubHeader7=WCMSPage.jsonValue(jsonObject,"SubHeader7");
            String SubHeader8=WCMSPage.jsonValue(jsonObject,"SubHeader8");
            String SubHeader9=WCMSPage.jsonValue(jsonObject,"SubHeader9");
            String SubHeader10=WCMSPage.jsonValue(jsonObject,"SubHeader10");
            String SubHeader11=WCMSPage.jsonValue(jsonObject,"SubHeader11");
            String SubHeader12=WCMSPage.jsonValue(jsonObject,"SubHeader12");
            String SubHeader13=WCMSPage.jsonValue(jsonObject,"SubHeader13");
            String SubHeader14=WCMSPage.jsonValue(jsonObject,"SubHeader14");
            String SubHeader15=WCMSPage.jsonValue(jsonObject,"SubHeader15");
            String SubHeader16 =WCMSPage.jsonValue(jsonObject,"SubHeader16");
            String Button=WCMSPage.jsonValue(jsonObject,"Button");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(Header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader5)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader6)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader7)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader8)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader9)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader10)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader11)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader12)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader13)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader14)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader15)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader16)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderMainheader(Header, Button)));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Press Releases' header ", e);
        }
    }
}

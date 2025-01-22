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

public class VerifyMediaKitsPageContentInWCMSApplication_WCMSI_1063 extends BaseTest {
    static final String jiraTestID = "WCMSI-1063";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Media Kits' Page content in WCMS application-Set 3")
    @Test(description = jiraTestID
            + ": Verify 'Media Kits' Page content in WCMS application-Set 3", groups = {""})
    public void verifyMediaKitsPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            String url=driver.getCurrentUrl()+jsonFileReader.getJsonString("AddURL");
            driver.navigate().to(url);
            cookiePage.handleOneTrustCookie();
            validateContentUnderEditorialCalendarMediaKitHeader("EditorialCalendaMediaKit");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify 'Media Kits' Page content in WCMS application-Set 3", e);
        }
        System.out.println("Successfully verify 'Media Kits' Page content in WCMS application-Set 3");
    }
    @Step("Validate Content under 'Editorial Calendar and Media Kit' header")
    public void validateContentUnderEditorialCalendarMediaKitHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            String Header=WCMSPage.jsonValue(jsonObject,"Header");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");
            String Text2_1=WCMSPage.jsonValue(jsonObject,"Text2_1");
            String Text2_2=WCMSPage.jsonValue(jsonObject,"Text2_2");
            String Button=WCMSPage.jsonValue(jsonObject,"Button");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(Header)));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")), Text1);
            Assert.assertTrue(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")).contains(Text2_1));
            Assert.assertTrue(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")).contains(Text2_2));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderMainheader(Header,Button)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Editorial Calendar and Media Kit' header ", e);
        }
    }
}

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

public class VerifyQueryPageContentInWCMSApplication_WCMSI_1064 extends BaseTest {
    static final String jiraTestID = "WCMSI-1064";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Query' Page content in WCMS application-Set 3")
    @Test(description = jiraTestID
            + ": Verify 'Query' Page content in WCMS application-Set 3", groups = {""})
    public void verifyQueryPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            String url=driver.getCurrentUrl()+jsonFileReader.getJsonString("AddURL");
            driver.navigate().to(url);
            cookiePage.handleOneTrustCookie();
            validateContentUnderQueriedCategoryHeader("QueriedCategory");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify 'Query' Page content in WCMS application-Set 3", e);
        }
        System.out.println("Successfully verify 'Query' Page content in WCMS application-Set 3");
    }
    @Step("Validate Content under 'Queried Category - update' header")
    public void validateContentUnderQueriedCategoryHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Header=WCMSPage.jsonValue(jsonObject,"Header");
            String Subheader1=WCMSPage.jsonValue(jsonObject,"Subheader1");
            String Subheader2=WCMSPage.jsonValue(jsonObject,"Subheader2");
            String Subheader3=WCMSPage.jsonValue(jsonObject,"Subheader3");
            String Subheader4=WCMSPage.jsonValue(jsonObject,"Subheader4");
            String Subheader5=WCMSPage.jsonValue(jsonObject,"Subheader5");
            String Subheader6=WCMSPage.jsonValue(jsonObject,"Subheader6");
            String Subheader7=WCMSPage.jsonValue(jsonObject,"Subheader7");
            String Subheader8=WCMSPage.jsonValue(jsonObject,"Subheader8");
            String Subheader9=WCMSPage.jsonValue(jsonObject,"Subheader9");
            String Subheader10=WCMSPage.jsonValue(jsonObject,"Subheader10");
            String Subheader11=WCMSPage.jsonValue(jsonObject,"Subheader11");
            String Subheader12=WCMSPage.jsonValue(jsonObject,"Subheader12");
            String Button=WCMSPage.jsonValue(jsonObject,"Button");

            Assert.assertTrue(WCMSPage.getText1(WCMSPage.jsonValue(jsonObject,"Header")).contains(Header));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader5)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader6)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader7)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader8)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader9)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader10)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader11)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader12)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButton(Button)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Queried Category - update' header ", e);
        }
    }
}

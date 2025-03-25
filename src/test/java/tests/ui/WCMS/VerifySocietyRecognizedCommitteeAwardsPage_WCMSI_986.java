package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.BasePage;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

import java.util.List;

public class VerifySocietyRecognizedCommitteeAwardsPage_WCMSI_986 extends BaseTest {
    static final String jiraTestID = "WCMSI-986";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Society Recognized Committee Awards Page")
    @Test(description = jiraTestID + ": Verify Society Recognized Committee Awards Page")
    public void VerifyVerifySocietyRecognizedCommitteeAwardsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM") + "membership-participation/memberships/society-recognized-committee-awards");
            cookiePage.handleOneTrustCookie();
            ValidateSocietyRecognizedCommitteeAwardsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify Society Recognized Committee Awards Page", e);
        }
    }

    @Step("Validate Society Recognized Committee Awards Page")
    public void ValidateSocietyRecognizedCommitteeAwardsPage() {
        try {
            scrollAndVerifyElementPresence("A01", "sorthey@astm.org");
            scrollAndVerifyElementPresence("A05", "kstraiton@astm.org");
            scrollAndVerifyElementPresence("B02", "jtursi@astm.org");
            scrollAndVerifyElementPresence("B08", "jtursi@astm.org");
            scrollAndVerifyElementPresence("B10", "jtursi@astm.org");
            scrollAndVerifyElementPresence("C01", "sorthey@astm.org");
            scrollAndVerifyElementPresence("C09", "sorthey@astm.org");
            scrollAndVerifyElementPresence("C13", "jfarrell@astm.org");
            scrollAndVerifyElementPresence("C15", "krobbins@astm.org");
            scrollAndVerifyElementPresence("C18", "dlee@astm.org");
            scrollAndVerifyElementPresence("C24", "dlee@astm.org");
            scrollAndVerifyElementPresence("C26 ", "smawn@astm.org");
            scrollAndVerifyElementPresence("C28", "jfarrell@astm.org");
            scrollAndVerifyElementPresence("E08 ", "mzamorski@astm.org");
            scrollAndVerifyElementPresence("D01", "jtursi@astm.org");
            scrollAndVerifyElementPresence("D02", "afick@astm.org");
            scrollAndVerifyElementPresence("D04", "awiand@astm.org");
            scrollAndVerifyElementPresence("D05", "mmarcinowski@astm.org");
            scrollAndVerifyElementPresence("D08", "jhuffnagle@astm.org");
            scrollAndVerifyElementPresence("D09", "afick@astm.org");
            scrollAndVerifyElementPresence("D10", "sorthey@astm.org");
            scrollAndVerifyElementPresence("D11", "mmarcinowski@astm.org");
            scrollAndVerifyElementPresence("D12", "dlee@astm.org");
            scrollAndVerifyElementPresence("D14", "fmcconnell@astm.org");
            scrollAndVerifyElementPresence("D15", "awiand@astm.org");
            scrollAndVerifyElementPresence("D18", "kkoperna@astm.org");
            scrollAndVerifyElementPresence("D19", "bmilewski@astm.org");
            scrollAndVerifyElementPresence("D20 ", "afick@astm.org");
            scrollAndVerifyElementPresence("D24", "mmarcinowski@astm.org");
            scrollAndVerifyElementPresence("D27", "kpaul@astm.org");
            scrollAndVerifyElementPresence("D30 ", "mmarcinowski@astm.org");
            scrollAndVerifyElementPresence("D34", "bmilewski@astm.org");
            scrollAndVerifyElementPresence("E02", "jhuffnagle@astm.org");
            scrollAndVerifyElementPresence("E01 ", "jhuffnagle@astm.org");
            scrollAndVerifyElementPresence("E04", "tmurdock@astm.org");
            scrollAndVerifyElementPresence("E05", "kshanahan@astm.org");
            scrollAndVerifyElementPresence("E06", "fmcconnell@astm.org");
            scrollAndVerifyElementPresence("E07", "kstraiton@astm.org");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Verify Society Recognized Committee Awards Page", e);
        }
    }

    public void scrollAndVerifyElementPresence(String committe, String mail) {
        try {
            Assert.assertTrue(ReusableMethods.scrollToElement(driver, commonPage.verifyEmailByCommitteeName(committe, mail)));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Search Results", e);
        }
    }

}

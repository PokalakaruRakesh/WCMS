package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.ui.base.BaseTest;

public class VerifyFAQPageFunctionalityWCMSI extends BaseTest {
    static final String jiraTestID = "WCMSI-514";
    WCMSICommon publicCommon;
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("")
    @Description("Verification of the FAQ Page functionality")
    @Test(description = jiraTestID + "")
    public void ValidateTheFAQPage() {
        try{

            //Validate About page is loaded successfully

            //Validate content on About page
        }
        catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to FAQ Page", e);
        }
    }
}

package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyAccreditationsPage_WCMSI_978 extends BaseTest {
    static final String jiraTestID = "WCMSI-982";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    TrainingByIndustryWCMS TrainingIndustry;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Accreditations: Verify the UI, Responsiveness, content and Links of the page")
    @Test(description = jiraTestID + ": Accreditations: Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyAccreditationsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ValidateAccreditationsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Accreditations page", e);
        }
    }
    @Step("Validate Accreditations Page")
    public void ValidateAccreditationsPage() {
        try {
            basePage.clickOnMethod(TrainingIndustry.Accreditations);
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.accreditationsContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Reference Materials", e);
        }
    }

}

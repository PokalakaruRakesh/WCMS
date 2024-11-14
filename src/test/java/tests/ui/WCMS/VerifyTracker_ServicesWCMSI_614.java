package tests.ui.WCMS;

import base.utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.Tracker_ServicesWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyTracker_ServicesWCMSI_614 extends BaseTest {
    static final String jiraTestID = "WCMSI-614";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    Tracker_ServicesWCMS TrackerService;
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-372:  Set 5: Market Insights & Innovation, Standards & Publications, Book of Standards, Digital Library, Laboratory Services, Tracker Services")
    @Description("To validate the navigation to Tracker Services")
    @Test(description = jiraTestID + "Validate the navigation and to Tracker Services page")
    public void validateTrackerService(){
        commonPage = page.getInstance(CommonPage_WCMS.class);
        TrackerService = page.getInstance(Tracker_ServicesWCMS.class);
        cookiePage= page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoTrackerService();
        validateTrackerServiceContent();
    }
    public void validateTrackerServiceContent() {
        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrackerService.clickhere, "https://marketing.astm.org/acton/media/9652/astm-subscription", "Subscription Preferences Form 051518", "\'log in to your tracker account\' link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrackerService.loginTrackerAccount, "https://www.astm.org/customer/account/login/", "Customer Login", "\'Click here\' link"));
    }
    public void navigatetoTrackerService(){
        commonPage.getstandardandSolution();
        commonPage.clickOnTrackerServices();
        Assert.assertTrue(driver.getTitle().contains("ASTM Standards Tracker"));
    }

}

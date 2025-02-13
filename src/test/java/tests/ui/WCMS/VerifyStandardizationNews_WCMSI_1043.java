package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.StandardizationNewsWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyStandardizationNews_WCMSI_1043 extends BaseTest {
    static final String jiraTestID = "WCMSI-1043";
    CookiePage cookiePage;
    StandardizationNewsWCMS StandardizationNews;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-350 - Set 3: News pages")
    @Description("To validate the Standardization News Page functionality")
    @Test(description = jiraTestID + "Validate the navigation on the page")
    public void ValidateEnterpriseSolutionsPage() {
        try {
            StandardizationNews = page.getInstance(StandardizationNewsWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            navigateToStandardizationNewsPage();
            validateStandardizationNewsPageLinks();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Standardization News page", e);
        }
    }

    @Step("Validate links and buttons available on page")
    private void validateStandardizationNewsPageLinks() {
        Assert.assertTrue(commonPage.ValidateLink(StandardizationNews.DifferencePodcast, "/news/biobased-plastic-vs-biodegradable-plastic-what-s-the-difference-podcast", "Biobased Plastic vs. Biodegradable Plastic – What&#039;s the Difference? Podcast", "\'Biobased Plastic vs. Biodegradable Plastic – What's the Difference? Podcast\' Link"));
        Assert.assertTrue(commonPage.ValidateLink(StandardizationNews.DifferencePodcastReadMore, "/news/biobased-plastic-vs-biodegradable-plastic-what-s-the-difference-podcast", "Biobased Plastic vs. Biodegradable Plastic – What&#039;s the Difference? Podcast", "\'Biobased Plastic vs. Biodegradable Plastic – What's the Difference? Podcast\' Read More Link"));
        Assert.assertTrue(commonPage.ValidateLink(StandardizationNews.RollerCoastersTechnologyNewHeightsPodcast, "/news/how-roller-coasters-are-using-technology-to-reach-new-heights-podcast", "How Roller Coasters Are Using Technology to Reach New Heights – Podcast", "\'How Roller Coasters Are Using Technology to Reach New Heights – Podcast\' Link"));
        Assert.assertTrue(commonPage.ValidateLink(StandardizationNews.RollerCoastersTechnologyNewHeightsPodcastReadMore, "/news/how-roller-coasters-are-using-technology-to-reach-new-heights-podcast", "How Roller Coasters Are Using Technology to Reach New Heights – Podcast", "\'How Roller Coasters Are Using Technology to Reach New Heights – Podcast\' Read More Link"));
    }

    @Step("Validate navigation to Standardization News page")
    public void navigateToStandardizationNewsPage() {
        try {
            commonPage.getNews();
            commonPage.clickOnSTANDARDIZATIONNews();
            WCMSICommon.waitForSec(3);
            Assert.assertTrue(driver.getTitle().contains("STANDARDIZATION NEWS"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Standardization News page", e);
        }
    }
}


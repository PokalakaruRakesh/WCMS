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
import pages.ui.NewsPage_WCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyNew_WCMSI_1039 extends BaseTest {
    static final String jiraTestID = "WCMSI-1039";
    CookiePage cookiePage;
    NewsPage_WCMS news;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-350 - Set 3: News pages")
    @Description("To validate the News Page functionality")
    @Test(description = jiraTestID + "Validate the navigation on the page")
    public void ValidateEnterpriseSolutionsPage() {
        try {
            news = page.getInstance(NewsPage_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            navigateToNewsPage();
            validateNewsPageLinks();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to News page", e);
        }
    }

    @Step("Validate links and buttons available on page")
    private void validateNewsPageLinks() {
        Assert.assertTrue(commonPage.ValidateLink(news.DifferencePodcast, "/news/biobased-plastic-vs-biodegradable-plastic-what-s-the-difference-podcast", "Biobased Plastic vs. Biodegradable Plastic – What&#039;s the Difference? Podcast", "\'Biobased Plastic vs. Biodegradable Plastic – What's the Difference? Podcast\' Link"));
        Assert.assertTrue(commonPage.ValidateLink(news.DifferencePodcastReadMore, "/news/biobased-plastic-vs-biodegradable-plastic-what-s-the-difference-podcast", "Biobased Plastic vs. Biodegradable Plastic – What&#039;s the Difference? Podcast", "\'Biobased Plastic vs. Biodegradable Plastic – What's the Difference? Podcast\' Read More Link"));
        Assert.assertTrue(commonPage.ValidateLink(news.RollerCoastersTechnologyNewHeightsPodcast, "/news/how-roller-coasters-are-using-technology-to-reach-new-heights-podcast", "How Roller Coasters Are Using Technology to Reach New Heights – Podcast", "\'How Roller Coasters Are Using Technology to Reach New Heights – Podcast\' Link"));
        Assert.assertTrue(commonPage.ValidateLink(news.RollerCoastersTechnologyNewHeightsPodcastReadMore, "/news/how-roller-coasters-are-using-technology-to-reach-new-heights-podcast", "How Roller Coasters Are Using Technology to Reach New Heights – Podcast", "\'How Roller Coasters Are Using Technology to Reach New Heights – Podcast\' Read More Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(news.Viewissue, "https://go.astm.org/SN-July-August-2024", "Standardization News - Cover", "\'STANDARDIZATION NEWS\' View Issue Button"));
        Assert.assertTrue(commonPage.ValidateLink(news.PublicityRequestForm, "/membership-participation/technical-committees/publicity-request", "Media/Publicity Request Form", "\'Fill out this form to start the process\' Link"));
        // New Play/Pause button validation
        String playPathData = "M1 12C1 5.925 ..."; // Replace with actual Play path data
        String pausePathData = "M2 13D 9.1 ...";  // Replace with actual Pause path data
        Assert.assertTrue(commonPage.validatePlayPauseButton(news.playPauseButtonLocator, playPathData, pausePathData, "Validating Play/Pause button functionality."));
    }


    @Step("Validate navigation to News page")
    public void navigateToNewsPage() {
        try {
            commonPage.getNews();
            commonPage.clickOnNews();
            WCMSICommon.waitForSec(3);
            Assert.assertEquals(driver.getTitle(), "News");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to News page", e);
        }
    }
}


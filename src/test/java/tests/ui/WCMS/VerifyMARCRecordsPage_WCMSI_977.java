package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyMARCRecordsPage_WCMSI_977 extends BaseTest {
    static final String jiraTestID = "WCMSI-977";
    CookiePage cookiePage;
    ASTMDigital_LibraryWCMS digitalLibrary;
    TechnicalCommitteesWCMS technicalCommittees;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("MARC Records: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": MARC Records: Navigation Verification for All Buttons and Links")
    public void VerifyMARCRecordsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            digitalLibrary = page.getInstance(ASTMDigital_LibraryWCMS.class);
            technicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);
            basePage = page.getInstance(BasePage.class);

            commonPage.downloadFileSetup(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"standards-and-solutions/digital-library/marc-records");
            cookiePage.handleOneTrustCookie();
            ValidateMARCRecordsProgramPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to MARC Records: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate MARC Records Page")
    public void ValidateMARCRecordsProgramPage() {
        try {
            basePage.clickOnMethod(commonPage.clickOnDropDown("ACEM"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("ACEM.mrc"),"ACEM.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("ACEM.mrk"),"ACEM.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("ACEM.txt"),"ACEM.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("ACEM.xml"),"ACEM.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("CCA"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("CCA.mrc"),"CCA.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("CCA.mrk"),"CCA.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("CCA.txt"),"CCA.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("CCA.xml"),"CCA.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("GTJ"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("GTJ.mrc"),"GTJ.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("GTJ.mrk"),"GTJ.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("GTJ.txt"),"GTJ.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("GTJ.xml"),"metadata.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("JOTE"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("JOTE.mrc"),"JTE.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("JOTE.mrk"),"JTE.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("JOTE.txt"),"JTE.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("JOTE.xml"),"JTE.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("JAI"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("JAI.mrc"),"JAI.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("JAI.mrk"),"JAI.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("JAI.txt"),"JAI.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("JAI.xml"),"JAI.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("JCTR"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("JCTR.mrc"),"JCTR.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("JCTR.mrk"),"JCTR.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("JCTR.txt"),"JCTR.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("JCTR.xml"),"JCTR.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("JOFS"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("JOFS.mrc"),"JOFS.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("JOFS.mrk"),"JOFS.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("JOFS.txt"),"JOFS.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("JOFS.xml"),"JOFS.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("MPC"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("MPC.mrc"),"MPC.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("MPC.mrk"),"MPC.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("MPC.txt"),"MPC.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("MPC.xml"),"MPC.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("SSMS"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("SSMS.mrc"),"SSMS.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("SSMS.mrk"),"SSMS.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("SSMS.txt"),"SSMS.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("SSMS.xml"),"SSMS.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("MNLs"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("MNLs.mrc"),"MNLs.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("MNLs.mrk"),"MNLs.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("MNLs.txt"),"MNLs.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("MNLs.xml"),"MNLs.xml",""));

            basePage.clickOnMethod(commonPage.clickOnDropDown("STPs"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("STPs.mrc"),"STPs.mrc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(commonPage.selectFileByName("STPs.mrk"),"STPs.mrk"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("STPs.txt"),"STPs.txt",""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.selectFileByName("STPs.xml"),"STPs.xml",""));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on MARC Records page", e);
        }
    }

}

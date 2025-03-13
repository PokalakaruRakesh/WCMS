package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyCertificationPage_WCMSI_708 extends BaseTest {
    static final String jiraTestID = "WCMSI-708";
    CookiePage cookiePage;
    CertificationWCMS CertificationPage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Certification: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Certification: Navigation Verification for All Buttons and Links")
    public void VerifyCertificationPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            CertificationPage = page.getInstance(CertificationWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Certification");
            ValidateCertificationPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Certification Page: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Certification Page")
    public void ValidateCertificationPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.ProductCertification,"www.seinet.org", "Welcome to Safety Equipment Institute"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.EnvironmentalProductDeclarations,"environmental-product-declarations", "Environmental Product Declarations"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.LearnMoreAboutPersonalCertification,"credentialing.training.astm.org", "ASTM Personnel Certification"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.HowItWorks,"/seiprogramrequirements", "SEI Program Requirements"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.WhySEI,"https://marketing.astm.org/acton", ""));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.ProductCertificationLeranMore,"https://www.seinet.org/", "Welcome to Safety Equipment Institute"));


            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.SearchByProduct,"www.seinet.org/search", "Certified Products"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.LearnMoreAboutSEI,"/newparticipantinfokit", "New Participant Information"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.ConstructionMaterials,"/pKIWagVykoZm2yeUL64FCM0clBut-0Gj", "ASTM Construction Materials Testing"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.PetroleumLaboratory,"/lessons/RG-RV_QTV-XmNU6cL4_RhPz2giWz3L85", "ASTM Petroleum Laboratory Professional"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.LiabilitiesProfessional,"/GTqp-j7mok8lhTjM53BYBvPG2gBw9NsM", "ASTM Certified Environmental Liabilities"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.ASTMCertifiedEnvironmental,"/Rc3T0BEEuYcZCb-QhMlYHbHCV4Yst90O", "ASTM Certified Environmental Professional"));

            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.PersonnelCertificationLeranMore,"//credentialing.training", "ASTM Personnel Certification "));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.ASTMCANNQLeranMore,"/testing-certifications", ""));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.AdditiveManufacturingLeranMore,"/products-and-services/operator-cert", "Machine Operator Certification"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.LearnMoreAboutNCATT,"/certification/ncatt", "NCATT Personnel"));
            Assert.assertTrue(commonPage.ValidateLink(CertificationPage.EnvironmentalProductLeranMore,"/environmental-product-declarations", "Environmental Product Declarations"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Certification", e);
        }
    }

}

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

public class VerifyASTMIndustryTrainingSolutionsPageContentInWCMSApplication_WCMSI_604 extends BaseTest {
    static final String jiraTestID = "WCMSI-604";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify \"Market Insights & Innovation\" Page content in WCMS application-Set 5")
    @Test(description = jiraTestID
            + ": Verify \"Market Insights & Innovation\" Page content in WCMS application-Set 5", groups = {""})
    public void verify125thAnniversaryCaseStudiesContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"Market Insights and Innovation");
            validateContentUnderASTMIndustryTrainingSolutionsHeader("ASTMIndustry");
            validateWhatsNewHeader("WhatsNew");
            validateCostEffectiveInteractiveHeader("CostEffectiveInteractive");
            validateIndustriesHeader("Industries");
            validateASTMMemberTrainingHeader("ASTMMemberTraining");
            validatePersonnelCertificationHeader("PersonnelCertification");
            validateTrainingAndELearningHeader("TrainingAndELearning");
            validateBrandingAndSponsorshipHeader("BrandingAndSponsorship");
            validatePersonnelCertification_Header("PersonnelCertifications");
            validateSuggestATrainingProgramHeader("SuggestATrainingProgram");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify \"Market Insights & Innovation\" Page content in WCMS application-Set 5", e);
        }
        System.out.println("Successfully Verify \"Market Insights & Innovation\" Page content in WCMS application-Set 5");
    }


    @Step("Validate Content under 'ASTM Industry Training Solutions' header")
    public void validateContentUnderASTMIndustryTrainingSolutionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String mainHeader=WCMSPage.jsonValue(jsonObject,"MainHeader");
            String Subheader=WCMSPage.jsonValue(jsonObject,"Subheader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(mainHeader)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(Subheader)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(Subheader,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(Subheader,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(Subheader,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Industry Training Solutions' header ", e);
        }
    }
    @Step("Validate Content under 'What's New'")
    public void validateWhatsNewHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subheader=WCMSPage.jsonValue(jsonObject,"Subheader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,WCMSPage.jsonValue(jsonObject,"LinkText"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'What's New' header ", e);
        }
    }


    @Step("Validate Content under 'Cost-Effective, Interactive Training Solutions'")
    public void validateCostEffectiveInteractiveHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Header=WCMSPage.jsonValue(jsonObject,"Header");
            String SubHeader1=WCMSPage.jsonValue(jsonObject,"SubHeader1");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");
            String SubHeader2=WCMSPage.jsonValue(jsonObject,"SubHeader2");
            String Text2=WCMSPage.jsonValue(jsonObject,"Text2");
            String SubHeader3=WCMSPage.jsonValue(jsonObject,"SubHeader3");
            String Text3=WCMSPage.jsonValue(jsonObject,"Text3");
            String SubHeader4=WCMSPage.jsonValue(jsonObject,"SubHeader4");
            String Text4=WCMSPage.jsonValue(jsonObject,"Text4");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(Header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(Header,SubHeader1)));
            Assert.assertEquals(WCMSPage.getTextByHeader(SubHeader1,WCMSPage.jsonValue(jsonObject,"text1")),Text1);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(Header,SubHeader2)));
            Assert.assertEquals(WCMSPage.getTextByHeader(SubHeader2,WCMSPage.jsonValue(jsonObject,"text2")),Text2);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(Header,SubHeader3)));
            Assert.assertEquals(WCMSPage.getTextByHeader(SubHeader3,WCMSPage.jsonValue(jsonObject,"text3")),Text3);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(Header,SubHeader4)));
            Assert.assertEquals(WCMSPage.getTextByHeader(SubHeader4,WCMSPage.jsonValue(jsonObject,"text4")),Text4);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'What's New' header ", e);
        }
    }

    @Step("Validate Content under 'Industries'")
    public void validateIndustriesHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText9"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText10"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText14"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText15"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText16"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(
                    WCMSPage.jsonValue(jsonObject,"LinkText17"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Industries' header ", e);
        }
    }

    @Step("Validate Content under 'ASTM Member Training'")
    public void validateASTMMemberTrainingHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Member Training' header ", e);
        }
    }

    @Step("Validate Content under 'Personnel Certification and Certificate Programs'")
    public void validatePersonnelCertificationHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Personnel Certification and Certificate Programs' header ", e);
        }
    }

    @Step("Validate Content under 'Training and eLearning Accreditations'")
    public void validateTrainingAndELearningHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subheader1=WCMSPage.jsonValue(jsonObject,"Subheader1");
            String subheader2=WCMSPage.jsonValue(jsonObject,"Subheader2");
            String subheader3=WCMSPage.jsonValue(jsonObject,"Subheader3");
            String subheader4=WCMSPage.jsonValue(jsonObject,"Subheader4");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader4)));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader1,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader2,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader3,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader1(subheader4,
                    WCMSPage.jsonValue(jsonObject,"Button4"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Training and eLearning Accreditations' header ", e);
        }
    }

    @Step("Validate Content under 'Branding and Sponsorship Opportunities'")
    public void validateBrandingAndSponsorshipHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button"))));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Branding and Sponsorship Opportunities' header ", e);
        }
    }

    @Step("Validate Content under 'Personnel Certification and Certificate Programs'")
    public void validatePersonnelCertification_Header(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText5"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Personnel Certification and Certificate Programs' header ", e);
        }
    }


    @Step("Validate Content under 'Suggest a Training Program'")
    public void validateSuggestATrainingProgramHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subheader=WCMSPage.jsonValue(jsonObject,"subheader");


            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,subheader)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button"))));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Suggest a Training Program' header ", e);
        }
    }
}


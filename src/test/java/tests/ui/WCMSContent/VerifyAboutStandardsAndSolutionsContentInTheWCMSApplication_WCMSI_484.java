package tests.ui.WCMSContent;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import com.google.gson.JsonObject;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ui.WCMSContentPage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyAboutStandardsAndSolutionsContentInTheWCMSApplication_WCMSI_484 extends BaseTest {
    static final String jiraTestID = "WCMSI-484";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the Standards and Solutions page content in the WCMS application - Set 1")
    @Test(description = jiraTestID
            + ": Verify the Standards and Solutions page content in the WCMS application - Set 1", groups = {""})
    public void verifyAboutStandardsAndSolutionsContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            softAssert = new SoftAssert();

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"));
            validateContentUnderStandardsSolutionsHeader("StandardsSolutions");
            validateContentUnderStandardsHeader("Standards");
            validateContentUnderEnterpriseSolutionsHeader("EnterpriseSolutions");
            validateContentUnderDigitalLibraryHeader("DigitalLibrary");
            validateContentUnderMarketInsightsInnovationHeader("MarketInsightsInnovation");
            validateContentUnderLaboratoryServicessHeader("LaboratoryServices");
            validateContentUnderTrainingCertificationHeader("TrainingCertification");
            validateContentUnderCementAndConcreteReferenceLaboratoryHeader("CementandConcreteReferenceLaboratory");
            //Latest News script needs to add
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the Standards and Solutions page content in the WCMS application - Set 1", e);
        }
        System.out.println("Successfully Verify the Standards and Solutions  page content in the WCMS application - Set 1");
    }


    @Step("Validate Content under 'Standards & Solutions' header")
    public void validateContentUnderStandardsSolutionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(header)));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Standards & Solutions' header ", e);
        }
    }
    @Step("Validate content under 'Standards' header")
    public void validateContentUnderStandardsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Standards' header ", e);
        }
    }
    @Step("Validate content under 'Enterprise Solutions' header")
    public void validateContentUnderEnterpriseSolutionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header1"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header2"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header3"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header4"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header5"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Enterprise Solutions' header ", e);
        }
    }
    @Step("Validate content under 'Digital Library' header")
    public void validateContentUnderDigitalLibraryHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Text1"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Digital Library' header ", e);
        }
    }
    @Step("Validate content under 'Market Insights & Innovation' header")
    public void validateContentUnderMarketInsightsInnovationHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));


            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader4"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader5"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button4"))));

            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Market Insights & Innovation' header ", e);
        }
    }
    @Step("Validate content under 'Laboratory Services' header")
    public void validateContentUnderLaboratoryServicessHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Button1"))));
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Laboratory Services' header ", e);
        }
    }

    @Step("Validate content under 'Training & Certification' header")
    public void validateContentUnderTrainingCertificationHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Training & Certification' header ", e);
        }
    }

    @Step("Validate content under 'Cement and Concrete Reference Laboratory' header")
    public void validateContentUnderCementAndConcreteReferenceLaboratoryHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Cement and Concrete Reference Laboratory' header ", e);
        }
    }
}

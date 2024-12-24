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
import org.testng.asserts.SoftAssert;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyASTMSpecBuilder_StandardSolutionsInTheWCMSApplication_WCMSI_602 extends BaseTest {
    static final String jiraTestID = "WCMSI-602";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify ASTM SpecBuilder Page content in WCMS application-Set 6")
    @Test(description = jiraTestID
            + ":Verify ASTM SpecBuilder Page content in WCMS application-Set 6", groups = {""})
    public void verifyASTMSpecBuilder_StandardSolutionsInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"),"Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"ASTM SpecBuilder");
            validateContentUnderASTMSpecBuilderHeader("ASTM SpecBuilder");
            validateContentUnderSpecBuilderResourcesHeader("SpecBuilder Resources");
            validateContentUnderSpecBuilderTestimonialHeader("SpecBuilder Testimonial");
            validateContentUnderRequestDemoHeader("Request a Demo");


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify ASTM SpecBuilder Page content in WCMS application-Set 6", e);
        }
        System.out.println("Successfully Verify ASTM SpecBuilder Page content in WCMS application-Set 6");
    }
    @Step("Validate Content under 'ASTM SpecBuilder' header")
    public void validateContentUnderASTMSpecBuilderHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String mainHeader=WCMSPage.jsonValue(jsonObject,"MainHeader");
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader1=WCMSPage.jsonValue(jsonObject,"subHeader1");
            String subHeader2=WCMSPage.jsonValue(jsonObject,"subHeader2");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(mainHeader)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader2,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader2,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader2,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader2,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'ASTM SpecBuilder' header", e);
        }
    }
    @Step("Validate Content under 'SpecBuilder Resources' header")
    public void validateContentUnderSpecBuilderResourcesHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader1=WCMSPage.jsonValue(jsonObject,"subHeader1");
            String subHeader2=WCMSPage.jsonValue(jsonObject,"subHeader2");
            String subHeader3=WCMSPage.jsonValue(jsonObject,"subHeader3");
            String subHeader4=WCMSPage.jsonValue(jsonObject,"subHeader4");
            String subHeader5=WCMSPage.jsonValue(jsonObject,"subHeader5");
            String subHeader6=WCMSPage.jsonValue(jsonObject,"subHeader6");
            String subHeader7=WCMSPage.jsonValue(jsonObject,"subHeader7");
            String subHeader8=WCMSPage.jsonValue(jsonObject,"subHeader8");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader5)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader6)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader7)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader8)));


            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader4,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader5,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader6,WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader7,WCMSPage.jsonValue(jsonObject,"text7")),
                    WCMSPage.jsonValue(jsonObject,"Text7"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader8,WCMSPage.jsonValue(jsonObject,"text8")),
                    WCMSPage.jsonValue(jsonObject,"Text8"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'SpecBuilder Resources' header", e);
        }
    }

    @Step("Validate Content under 'SpecBuilder Testimonial' header")
    public void validateContentUnderSpecBuilderTestimonialHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");
            String subHeader1 = WCMSPage.jsonValue(jsonObject, "subHeader1");


            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subHeader1)));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text1")),
                    WCMSPage.jsonValue(jsonObject, "Text1"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'SpecBuilder Testimonial' header", e);
        }
    }
    @Step("Validate Content under 'Request a Demo' header")
    public void validateContentUnderRequestDemoHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String subHeader = WCMSPage.jsonValue(jsonObject, "subHeader");
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subHeader)));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader, WCMSPage.jsonValue(jsonObject, "text1")),
                    WCMSPage.jsonValue(jsonObject, "Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Request a Demo' header", e);
        }
    }
}

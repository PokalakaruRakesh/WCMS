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
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyMembershipPageContentInTheWCMSApplication_WCMSI_497 extends BaseTest {
    static final String jiraTestID = "WCMSI-497";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
       driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the Membership page content in the WCMS application - Set 2")
    @Test(description = jiraTestID
            + ": Verify the Membership page content in the WCMS application - Set 2", groups = {""})
    public void verifyMembershipPageContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"Membership & Participation");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"ASTM Membership");
            validateContentUnderASTMMembershipHeader("ASTMMembership");
            validateContentUnderMembershipHeader("Membership");
            validateContentUnderJoinASTMTechnicalCommitteeHeader("JoinASTMTechnicalCommittee");
            validateContentUnderMemberTrainingToolsHeader("MemberTrainingTools");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the 'Membership' content in the WCMS application - Set 2", e);
        }
        System.out.println("Successfully Verify the 'Membership' content in the WCMS application - Set 2");
    }


    @Step("Validate Content under 'ASTM Membership' header")
    public void validateContentUnderASTMMembershipHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(WCMSPage.jsonValue(jsonObject,"Mainheader"),
                    WCMSPage.jsonValue(jsonObject,"Subheader"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(WCMSPage.jsonValue(jsonObject,"Mainheader"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(WCMSPage.jsonValue(jsonObject,"Mainheader"),
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(WCMSPage.jsonValue(jsonObject,"Mainheader"),
                    WCMSPage.jsonValue(jsonObject,"Text3"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Membership' header ", e);
        }
    }
    @Step("Validate Content under 'Membership' header")
    public void validateContentUnderMembershipHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            String Subheader1=WCMSPage.jsonValue(jsonObject,"Subheader1");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Price1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text9"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader1(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

            String Subheader3=WCMSPage.jsonValue(jsonObject,"Subheader3");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Price2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text10"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Subheader4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text14"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text15"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader1(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));

            String Subheader5=WCMSPage.jsonValue(jsonObject,"Subheader5");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Price3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Text16"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Text17"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Subheader6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Text18"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Text19"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader1(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));

            String Subheader7=WCMSPage.jsonValue(jsonObject,"Subheader7");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text20"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text21_1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text21_2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Subheader8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text22"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text23"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text24"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader1(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Button4"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Membership' header ", e);
        }
    }
    @Step("Validate Content under 'Join an ASTM Technical Committee' header")
    public void validateContentUnderJoinASTMTechnicalCommitteeHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Header"),
                    WCMSPage.jsonValue(jsonObject,"Text"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Header"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(WCMSPage.jsonValue(jsonObject,"Header"),
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Header"),
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(WCMSPage.jsonValue(jsonObject,"Header"),
                    WCMSPage.jsonValue(jsonObject,"Button2"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Join an ASTM Technical Committee' header ", e);
        }
    }
    @Step("Validate Content under 'Member Training & Tools' header")
    public void validateContentUnderMemberTrainingToolsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"LinkText"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"LinkText"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"LinkText"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"LinkText"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader5"),
                    WCMSPage.jsonValue(jsonObject,"LinkText"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader6"),
                    WCMSPage.jsonValue(jsonObject,"LinkText"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader7"),
                    WCMSPage.jsonValue(jsonObject,"LinkText"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader8"),
                    WCMSPage.jsonValue(jsonObject,"LinkText"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Member Training & Tools' header ", e);
        }
    }
}

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

public class VerifyHistoryContentInTheWCMSApplication_WCMSI_489 extends BaseTest {
    static final String jiraTestID = "WCMSI-489";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the History content in the WCMS application - Set 2")
    @Test(description = jiraTestID
            + ": Verify the History content in the WCMS application - Set 2", groups = {""})
    public void verifyHistoryContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"About ASTM");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"History");
            validateContentUnderFrequentlyAskedQuestionsHeader("History");
            validateContentUnderAllYearsHeader("Years");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the 'History' content in the WCMS application - Set 2", e);
        }
        System.out.println("Successfully Verify the 'History' content in the WCMS application - Set 2");
    }


    @Step("Validate Content under 'History' header")
    public void validateContentUnderFrequentlyAskedQuestionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"),WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Frequently Asked Questions' header ", e);
        }
    }
    @Step("Validate Content under all 'Years' header")
    public void validateContentUnderAllYearsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year1"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year2"),
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year3"),
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year4"),
                    WCMSPage.jsonValue(jsonObject,"Text4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year5"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year6"),
                    WCMSPage.jsonValue(jsonObject,"Text6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year7"),
                    WCMSPage.jsonValue(jsonObject,"Text7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year8"),
                    WCMSPage.jsonValue(jsonObject,"Text8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year9"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text9")),
                    WCMSPage.jsonValue(jsonObject,"Text9"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year10"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text10")),
                    WCMSPage.jsonValue(jsonObject,"Text10"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year11"),
                    WCMSPage.jsonValue(jsonObject,"Text11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year12"),
                    WCMSPage.jsonValue(jsonObject,"Text12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year13"),
                    WCMSPage.jsonValue(jsonObject,"Text13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year14"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year14"),
                    WCMSPage.jsonValue(jsonObject,"Text14"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year15"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year15"),
                    WCMSPage.jsonValue(jsonObject,"Text15"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year16"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year16"),
                    WCMSPage.jsonValue(jsonObject,"Text16"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year17"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year17"),
                    WCMSPage.jsonValue(jsonObject,"Text17"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year18"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year18"),
                    WCMSPage.jsonValue(jsonObject,"Text18"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year19"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year19"),
                    WCMSPage.jsonValue(jsonObject,"Text19"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year20"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year20"),
                    WCMSPage.jsonValue(jsonObject,"Text20"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year21"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year21"),
                    WCMSPage.jsonValue(jsonObject,"Text21"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year22"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text22")),
                    WCMSPage.jsonValue(jsonObject,"Text22"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year23"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year23"),
                    WCMSPage.jsonValue(jsonObject,"Text23"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year24"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year24"),
                    WCMSPage.jsonValue(jsonObject,"Text24"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year25"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text25")),
                    WCMSPage.jsonValue(jsonObject,"Text25"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year26"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text26")),
                    WCMSPage.jsonValue(jsonObject,"Text26"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Year27"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Year27"),
                    WCMSPage.jsonValue(jsonObject,"Text27"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'General' header ", e);
        }
    }
}

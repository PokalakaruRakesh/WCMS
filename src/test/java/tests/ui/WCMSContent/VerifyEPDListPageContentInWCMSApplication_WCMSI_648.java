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
import pages.ui.EnvironmentalProductDeclarationsWCMS;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyEPDListPageContentInWCMSApplication_WCMSI_648 extends BaseTest {
    static final String jiraTestID = "WCMSI-648";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    EnvironmentalProductDeclarationsWCMS EPDPage;
    CookiePage cookiePage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));}
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'EPD List' Page content in WCMS application")
    @Test(description = jiraTestID
            + ": Verify 'EPD List'Page content in WCMS application", groups = {""})
    public void verifyEPDListPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            EPDPage = page.getInstance(EnvironmentalProductDeclarationsWCMS.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);


           /* driver.get("https://qa-www.astm.org/membership-participation/publish-with-astm");
            String a=page.getElement(EPDPage.category).getText();

            String[] splitDataFromWCMS = a.split("\n");
            List<String> splitData1 = new ArrayList<>();
            for (String part : splitDataFromWCMS) {
                if (!part.isBlank()) {
                    splitData1.add(part.trim());
                }
            }

            driver.get("https://www.astm.org/get-involved/publish-with-astm.html");
            String b=page.getElement(EPDPage.category1).getText();

            String[] splitDataFromProd = b.split("\n");
            List<String> splitData2 = new ArrayList<>();

            for (String part : splitDataFromProd) {
                if (!part.isBlank()) {
                    splitData2.add(part.trim());
                }
            }

            for (int i = 0; i < splitData1.size(); i++) {
                Assert.assertEquals(splitData1.get(i),splitData2.get(i),""+splitData1.get(i)+ "and "+splitData2.get(i)+" both not matching");
            }*/


           /* String url=driver.getCurrentUrl()+jsonFileReader.getJsonString("AddURL");
            driver.navigate().to(url);
            WCMSICommon.openNewTabAndSwitch(driver);
            driver.get(ConfigReader.getValue("BASE_URL_ASTM")+jsonFileReader.getJsonString("AddURL_Prod"));
            WCMSICommon.switchTabs(driver,0);
            validateEnvironmentalProductDeclarationsHeader();
            validatePublishedEnvironmentalProductDeclarationsHeader();*/
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify 'EPD List' Page content in WCMS application", e);
        }
        System.out.println("Successfully Verify 'EPD List' Page content in WCMS application");
    }


    @Step("Validate Content under 'Environmental Product Declarations' header")
    public void validateEnvironmentalProductDeclarationsHeader() {
        try {
            Assert.assertTrue(Common.isElementDisplayed(driver,EPDPage.EnvironmentalProductDeclarations));
            cookiePage.handleOneTrustCookie();
            String header=WCMSICommon.getText(driver,EPDPage.EnvironmentalProductDeclarations);
            String subHeader=WCMSICommon.getText(driver,EPDPage.PublishedProductCategoryRules);
            String text1=WCMSICommon.getText(driver,EPDPage.ProductCategoryRulesText);
            String text2=WCMSICommon.getText(driver,EPDPage.ASTMInternationalPublishedPCR);
            List<String> PCRLinksFromWCMS=WCMSICommon.getTextOfWebElements(driver,EPDPage.PCRLinks);

            WCMSICommon.switchTabs(driver,1);
            Assert.assertTrue(Common.isElementDisplayed(driver,EPDPage.EnvironmentalProductDeclarations1));
            cookiePage.handleOneTrustCookie();
            Assert.assertEquals(header,WCMSICommon.getText(driver,EPDPage.EnvironmentalProductDeclarations1));
            Assert.assertEquals(subHeader,WCMSICommon.getText(driver,EPDPage.PublishedProductCategoryRules));
            Assert.assertEquals(text1,WCMSICommon.getText(driver,EPDPage.ProductCategoryRulesText));
            Assert.assertEquals(text2,WCMSICommon.getText(driver,EPDPage.ASTMInternationalPublishedPCR1));
            List<String> PCRLinks=WCMSICommon.getTextOfWebElements(driver,EPDPage.PCRLinks1);
            Assert.assertEquals(PCRLinksFromWCMS,PCRLinks," "+PCRLinksFromWCMS+" list not matched with "+PCRLinks+" ");
            WCMSICommon.switchTabs(driver,0);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Environmental Product Declarations' header ", e);
        }
    }
    @Step("Validate Content under 'Published Environmental Product Declarations' header")
    public void validatePublishedEnvironmentalProductDeclarationsHeader() {
        try {
            Assert.assertTrue(Common.isElementDisplayed(driver,EPDPage.PublishedEnvironmentalProductDeclarations));
            String header=WCMSICommon.getText(driver,EPDPage.PublishedEnvironmentalProductDeclarations);
            String text=WCMSICommon.getText(driver,EPDPage.EnvironmentalProductText);
            List<String> EPDLinksFromWCMS=WCMSICommon.getTextOfWebElements(driver,EPDPage.EPDLinks);

            WCMSICommon.switchTabs(driver,1);
            Assert.assertTrue(Common.isElementDisplayed(driver,EPDPage.PublishedEnvironmentalProductDeclarations1));
            Assert.assertEquals(header,WCMSICommon.getText(driver,EPDPage.PublishedEnvironmentalProductDeclarations1));
            Assert.assertEquals(text,WCMSICommon.getText(driver,EPDPage.EnvironmentalProductText));
            List<String> EPDLinks=WCMSICommon.getTextOfWebElements(driver,EPDPage.EPDLinks1);
            Assert.assertEquals(EPDLinksFromWCMS,EPDLinks," "+EPDLinksFromWCMS+" list not matched with "+EPDLinks+" ");
            WCMSICommon.switchTabs(driver,0);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Published Environmental Product Declarations' header ", e);
        }
    }

    public static List<String> compareLineByLine(String source1, String source2) {
        List<String> differences = new ArrayList<>();

        try (BufferedReader reader1 = new BufferedReader(new StringReader(source1));
             BufferedReader reader2 = new BufferedReader(new StringReader(source2))) {

            String line1, line2;
            int lineNumber = 1;

            while ((line1 = reader1.readLine()) != null | (line2 = reader2.readLine()) != null) {
                if (line1 == null || line2 == null || !line1.equals(line2)) {
                    differences.add("Line " + lineNumber + " differs:");
                    differences.add("Page 1: " + (line1 == null ? "null" : line1));
                    differences.add("Page 2: " + (line2 == null ? "null" : line2));
                }
                lineNumber++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            differences.add("Error during comparison: " + e.getMessage());
        }

        return differences;
    }
}

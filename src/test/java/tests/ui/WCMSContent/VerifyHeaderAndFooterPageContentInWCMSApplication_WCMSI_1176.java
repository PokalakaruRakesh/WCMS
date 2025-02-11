package tests.ui.WCMSContent;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
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

public class VerifyHeaderAndFooterPageContentInWCMSApplication_WCMSI_1176 extends BaseTest {
    static final String jiraTestID = "WCMSI-1176";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Header/Footer' Page content in WCMS application")
    @Test(description = jiraTestID
            + ": Verify 'Header/Footer' Page content in WCMS application", groups = {""})
    public void verifyHeaderAndFooterPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            cookiePage.handleOneTrustCookie();
            ValidateSubmenuListUnderHome("Home");
            ValidateSubmenuListUnderAboutASTM("About ASTM");
            ValidateSubmenuListUnderMembershipParticipation("Membership & Participation");
            ValidateSubmenuListUnderStandardsSolutions("Standards & Solutions");
            ValidateSubmenuListUnderNews("News");
            ValidateSubmenuListUnderHelp("Help");
            ValidateSubmenuListUnderFAQ("FAQ");
            ValidateFootersection("Footer");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify 'Header/Footer' Page content in WCMS application", e);
        }
        System.out.println("Successfully verify 'Header/Footer' Page content in WCMS application");
    }
    @Step("Validate Submenu list under Home")
    public void ValidateSubmenuListUnderHome(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String Menu = WCMSPage.jsonValue(jsonObject, "Menu");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getMenu(Menu)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Submenu list under Home", e);
        }
    }
    @Step("Validate Submenu list under About ASTM")
    public void ValidateSubmenuListUnderAboutASTM(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Menu=WCMSPage.jsonValue(jsonObject,"Menu");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMenu(Menu)));
            WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(WCMSPage.getMenu(Menu)),10);
            page.getElement(WCMSPage.getMenu(Menu)).click();
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu(WCMSPage.jsonValue(jsonObject,"Submenu1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu9"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu10"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu14"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Submenu list under About ASTM", e);
        }
    }
    @Step("Validate Submenu list under Membership & Participation")
    public void ValidateSubmenuListUnderMembershipParticipation(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Menu=WCMSPage.jsonValue(jsonObject,"Menu");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMenu(Menu)));
            WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(WCMSPage.getMenu(Menu)),10);
            page.getElement(WCMSPage.getMenu(Menu)).click();
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu(WCMSPage.jsonValue(jsonObject,"Submenu1"))));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu9"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu10"))));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu14"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu15"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu16"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu17"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu18"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu19"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu20"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu21"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu22"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu23"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu24"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu25"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu26"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu27"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu28"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu29"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu30"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu31"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Submenu list under Membership & Participation", e);
        }
    }
    @Step("Validate Submenu list under Standards & Solutions")
    public void ValidateSubmenuListUnderStandardsSolutions(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Menu=WCMSPage.jsonValue(jsonObject,"Menu");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMenu(Menu)));
            WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(WCMSPage.getMenu(Menu)),10);
            page.getElement(WCMSPage.getMenu(Menu)).click();
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu(WCMSPage.jsonValue(jsonObject,"Submenu1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu9"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu10"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu14"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu15"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu16"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu17"))));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu18"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu19"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu20"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu21"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu22"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu23"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu24"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu25"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu26"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu27"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu28"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu29"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu30"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu31"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu32"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu33"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu34"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu35"))));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu36"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu37"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu38"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu39"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu40"))));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu41"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu2(WCMSPage.jsonValue(jsonObject,"Submenu42"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Submenu list under Standards & Solutions", e);
        }
    }
    @Step("Validate Submenu list under News")
    public void ValidateSubmenuListUnderNews(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Menu=WCMSPage.jsonValue(jsonObject,"Menu");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMenu(Menu)));
            WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(WCMSPage.getMenu(Menu)),10);
            page.getElement(WCMSPage.getMenu(Menu)).click();
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu(WCMSPage.jsonValue(jsonObject,"Submenu1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu3"))));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu6"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Submenu list under News", e);
        }
    }
    @Step("Validate Submenu list under Help")
    public void ValidateSubmenuListUnderHelp(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Menu=WCMSPage.jsonValue(jsonObject,"Menu");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMenu(Menu)));
            WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(WCMSPage.getMenu(Menu)),10);
            page.getElement(WCMSPage.getMenu(Menu)).click();
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu(WCMSPage.jsonValue(jsonObject,"Submenu1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubmenu1(WCMSPage.jsonValue(jsonObject,"Submenu3"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Submenu list under News", e);
        }
    }
    @Step("Validate Submenu list under FAQ")
    public void ValidateSubmenuListUnderFAQ(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Menu=WCMSPage.jsonValue(jsonObject,"Menu");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMenu(Menu)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Submenu list under FAQ", e);
        }
    }
    @Step("Validate Footer section")
    public void ValidateFootersection(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer9"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer10"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer14"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer15"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer16"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer17"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer18"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer19"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer20"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer21"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer22"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer23"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer24"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer25"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer26"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer27"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer28"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer29"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer30"))));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer31"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer32"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer33"))));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer34"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer35"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer36"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer37"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer38"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer39"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer40"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer41"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer42"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getFooter(WCMSPage.jsonValue(jsonObject,"Footer43"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Footer section", e);
        }
    }
}

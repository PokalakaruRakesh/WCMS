package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.BasePage;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyPublicityRequestFormValidations_WCMSI_1072 extends BaseTest {
    static final String jiraTestID = "WCMSI-1072";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Publicity Request Form Validations")
    @Test(description = jiraTestID + ": Verify Publicity Request Form Validations")
    public void VerifyPublicityRequestFormValidations() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"membership-participation/technical-committees/publicity-request");
            cookiePage.handleOneTrustCookie();
            validateAllFormFieldsMessageWithoutEnterData();
            validateFieldsEnterInvalidData();
            verifyAndSubmitForm();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify Publicity Request Form Validations", e);
        }
    }
    @Step("Validate All The Form Fields Without Enter Data")
    public void validateAllFormFieldsMessageWithoutEnterData() {
        try {
            basePage.clickOnMethod(commonPage.SubmitMessageBtn);
            Assert.assertTrue(commonPage.getFieldMessage("Name").contains("Please enter a company name"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.getFieldMessage("Job title").contains("Please enter company information"));
            Assert.assertTrue(commonPage.getFieldMessage("ASTM committee").contains("Please enter committee information"));
            Assert.assertTrue(commonPage.getFieldMessage("Email").contains("Please enter company Email address"));
            Assert.assertTrue(commonPage.getFieldMessage("Phone Number").contains("Please enter company phone number"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.getFieldMessage("publicity for a proposed").contains("Please enter reason for seeking publicity"));
            Assert.assertTrue(commonPage.getFieldMessage("practical applications").contains("Please enter practical applications"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate All  Form Fields Message Without Enter Data", e);
        }
    }
    @Step("validate fields enter invalid data")
    public void validateFieldsEnterInvalidData() {
        try {
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Email"),"test$gmail.com");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("publicity for a proposed"),RandomStringUtils.randomAlphabetic(300));
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("practical applications"), RandomStringUtils.randomAlphabetic(300));
            basePage.clickOnMethod(commonPage.SubmitMessageBtn);
            Assert.assertTrue(commonPage.getFieldMessage("Email").contains("Please enter a valid email address"));
            Assert.assertTrue(commonPage.getFieldMessage("publicity for a proposed").contains("Please enter less or equal than 255 symbols"));
            Assert.assertTrue(commonPage.getFieldMessage("practical applications").contains("Please enter less or equal than 255 symbols"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate fields enter invalid data", e);
        }
    }
    @Step("verify And Submit Form")
    public void verifyAndSubmitForm() {
        try {
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Name"),"Test");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Job title"),"Auto");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("ASTM committee"),"A01");
            //commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Email"),"test@astm.org");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Phone Number"),"676545678");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("publicity for a proposed"),"Test");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("practical applications"),"Test");
            //basePage.clickOnMethod(commonPage.SubmitMessageBtn);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify And Submit Form", e);
        }
    }
}

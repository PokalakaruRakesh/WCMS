package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.BasePage;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyFeedbackFormValidations_WCMSI_1073 extends BaseTest {
    static final String jiraTestID = "WCMSI-1073";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Feedback Form Validations")
    @Test(description = jiraTestID + ": Verify Feedback Form Validations")
    public void VerifyFeedbackFormValidations() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"membership-participation/consumer-participation/feedback-form");
            cookiePage.handleOneTrustCookie();
            validateAllFormFieldsMessageWithoutEnterData();
            validateFieldsEnterInvalidData();
            verifyAndSubmitForm();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify Feedback Form Validations", e);
        }
    }
    @Step("Validate All The Form Fields Without Enter Data")
    public void validateAllFormFieldsMessageWithoutEnterData() {
        try {
            basePage.clickOnMethod(commonPage.SubmitMessageBtn);
            Assert.assertTrue(commonPage.getFieldMessage("First Name").contains("This is a required field"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.getFieldMessage("Last Name").contains("This is a required field"));
            Assert.assertTrue(commonPage.getFieldMessage("Email").contains("This is a required field"));
            Assert.assertTrue(commonPage.getFieldMessage("Phone").contains(""));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.getFieldMessage("Message").contains("This is a required field"));
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
            basePage.clickOnMethod(commonPage.SubmitMessageBtn);
            Assert.assertTrue(commonPage.getFieldMessage("Email").contains("Please enter a valid email address"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate fields enter invalid data", e);
        }
    }
    @Step("verify And Submit Form")
    public void verifyAndSubmitForm() {
        try {
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("First Name"),"Test");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Last Name"),"Auto");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Phone"),"1234567890");
            //commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Email"),"test@astm.org");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Message"),"test description");
            //basePage.clickOnMethod(commonPage.SubmitMessageBtn);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify And Submit Form", e);
        }
    }
}

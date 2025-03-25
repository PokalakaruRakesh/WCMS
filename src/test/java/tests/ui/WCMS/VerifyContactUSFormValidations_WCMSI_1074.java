package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyContactUSFormValidations_WCMSI_1074 extends BaseTest {
    static final String jiraTestID = "WCMSI-1074";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Contact US Form Validations")
    @Test(description = jiraTestID + ": Verify Contact US Form Validations")
    public void VerifyContactUSFormValidations() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"help/contact");
            cookiePage.handleOneTrustCookie();
            validateAllFormFieldsMessageWithoutEnterData();
            validateFieldsEnterInvalidData();
            verifyAndSubmitForm();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify Contact US Form Validations", e);
        }
    }
    @Step("Validate All The Form Fields Without Enter Data")
    public void validateAllFormFieldsMessageWithoutEnterData() {
        try {
            basePage.clickOnMethod(commonPage.SubmitMessageBtn);
            Assert.assertTrue(commonPage.getFieldMessage("First Name").contains("Please enter a First Name"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.getFieldMessage("Last Name").contains("Please enter a Last Name"));
            Assert.assertTrue(commonPage.getFieldMessage("Phone").contains("Please enter a Phone"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.getFieldMessage("Email").contains("Please enter a Email"));
            Assert.assertTrue(commonPage.getFieldMessage("Department").contains("Please enter a Department"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.getFieldMessage("Topic").contains("Please enter a Topic"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.getFieldMessage("Subject").contains("Please enter a Subject"));
            Assert.assertTrue(commonPage.getFieldMessage("Description").contains("Please enter a Description"));
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
            Assert.assertTrue(WCMSICommon.selectValueInDropdownbyVisibleText(page.getElement(commonPage.enterFormField("Department")),"Technical Support"));
            Assert.assertTrue(WCMSICommon.selectValueInDropdownbyVisibleText(page.getElement(commonPage.enterFormField("Topic")),"Work Item Issue"));
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Subject"),"Test");
            commonPage.scrollToElementAndFillField(driver,commonPage.enterFormField("Description"),"test description");
            //basePage.clickOnMethod(commonPage.SubmitMessageBtn);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify And Submit Form", e);
        }
    }
}

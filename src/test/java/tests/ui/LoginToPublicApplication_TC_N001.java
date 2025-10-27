package tests.ui;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ui.LoginPage;
import pages.ui.HomePage_WCMS;
import com.astm.commonFunctions.Common;

public class LoginToPublicApplication_TC_N001 extends base.BaseTest {
    private LoginPage loginPage;
    private HomePage_WCMS homePage;

    @BeforeMethod
    public void setUp() {
        loginPage = page.getInstance(LoginPage.class);
        homePage = page.getInstance(HomePage_WCMS.class);
    }

    @Test(description = "TC-N001: To verify that a user can successfully log into the public application.")
    @Description("TC-N001: To verify that a user can successfully log into the public application.")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLoginToPublicApplication_TC_N001() {
        String username = System.getProperty("test.username", "publicUser"); // Replace with actual username if needed
        String password = System.getProperty("test.password", "publicPass"); // Replace with actual password if needed

        stepEnterUsername(username);
        stepEnterPassword(password);
        stepClickLoginButton();
        stepVerifyUserLoggedIn();
    }

    @Step("Enter username: {username}")
    public void stepEnterUsername(String username) {
        try {
            loginPage.enterUsername(username);
            Common.reportPass("Username entered successfully: " + username);
        } catch (Exception e) {
            Common.reportFailAssert("Failed to enter username: " + e.getMessage());
        }
    }

    @Step("Enter password: {password}")
    public void stepEnterPassword(String password) {
        try {
            loginPage.enterPassword(password);
            Common.reportPass("Password entered successfully");
        } catch (Exception e) {
            Common.reportFailAssert("Failed to enter password: " + e.getMessage());
        }
    }

    @Step("Click login button")
    public void stepClickLoginButton() {
        try {
            loginPage.clickLoginButton();
            Common.reportPass("Clicked login button successfully");
        } catch (Exception e) {
            Common.reportFailAssert("Failed to click login button: " + e.getMessage());
        }
    }

    @Step("Verify user is logged in")
    public void stepVerifyUserLoggedIn() {
        try {
            Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in successfully");
            Common.reportPass("User verified as logged in");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Login verification failed: " + e.getMessage());
        }
    }
}

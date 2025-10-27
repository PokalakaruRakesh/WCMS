package tests.ui;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ui.LoginPage;
import pages.ui.HomePage;
import base.utils.PublicCommon;
import tests.ui.base.BaseTest;

public class VerifyLoginFunctionality_TC_N001 extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        loginPage = page.getInstance(LoginPage.class);
        homePage = page.getInstance(HomePage.class);
    }

    @Test(description = "TC-N001: User should be able to log in successfully.")
    @Description("Verify that a user can log in successfully with valid credentials.")
    @Severity(SeverityLevel.CRITICAL)
    public void testUserLogin_TC_N001() {
        String username = System.getProperty("test.username", "testuser");
        String password = System.getProperty("test.password", "password123");

        stepEnterUsername(username);
        stepEnterPassword(password);
        stepClickLoginButton();
        stepVerifyUserLoggedIn();
    }

    @Step("Enter username: {username}")
    public void stepEnterUsername(String username) {
        try {
            loginPage.enterUsername(username);
            PublicCommon.reportPass("Username entered successfully: " + username);
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to enter username: " + e.getMessage());
        }
    }

    @Step("Enter password: {password}")
    public void stepEnterPassword(String password) {
        try {
            loginPage.enterPassword(password);
            PublicCommon.reportPass("Password entered successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to enter password: " + e.getMessage());
        }
    }

    @Step("Click login button")
    public void stepClickLoginButton() {
        try {
            loginPage.clickLoginButton();
            PublicCommon.reportPass("Clicked login button successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to click login button: " + e.getMessage());
        }
    }

    @Step("Verify user is logged in")
    public void stepVerifyUserLoggedIn() {
        try {
            Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in successfully");
            PublicCommon.reportPass("User verified as logged in");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Login verification failed: " + e.getMessage());
        }
    }
}

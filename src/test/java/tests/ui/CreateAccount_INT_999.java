package tests.ui;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ui.CreateAccountPage;

public class CreateAccount_INT_999 {

    @Test(description = "INT-999: Verify account creation flow displays confirmation message on success")
    @Description("Verify that a new account can be created successfully and a confirmation message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Steps: Navigate to Create Account → Fill details → Submit → Verify confirmation message")
    public void testCreateAccount() {
        CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);
        
        // Comprehensive method call as per Page Object best practices
        boolean isConfirmationDisplayed = createAccountPage.createAccount();
        
        assert isConfirmationDisplayed : "Account creation confirmation message was not displayed.";
    }
}

package tests.ui.WCMS;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ui.HeaderComponentPage;

public class ValidateHeaderComponents_WCMSI_INT123 {

    @Test(description = "INT-123: Validate header components are visible and functional")
    @Description("User should be able to see the header components successfully.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Validate all header components are visible and functional")
    public void validateHeaderComponents() {
        HeaderComponentPage headerComponentPage = page.getInstance(HeaderComponentPage.class);

        // Validate Logo is clickable
        headerComponentPage.clickLogo();

        // Validate Navigation Menu is clickable
        headerComponentPage.clickNavigationMenu();

        // Validate Search Icon is clickable
        headerComponentPage.clickSearchIcon();

        // Validate Login Button is clickable
        headerComponentPage.clickLoginButton();

        // Validate Language selection is functional (example: select 'English')
        headerComponentPage.selectLanguage("English");

        // Add assertions as per the actual implementation, e.g.:
        // assert headerComponentPage.isHeaderComponentDisplayed() : "Header component not displayed as expected.";
    }
}

package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import tests.ui.base.BaseTest;
import pages.ui.HeaderComponentPage;

public class ValidateHeaderComponents_INT_123 extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        // No specific preconditions or URL navigation required as per test data
    }

    @Test(description = "INT-123: Validate header components are visible")
    @Description("INT-123: User should be able to see the header components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_123() {
        try {
            HeaderComponentPage headerComponentPage = page.getInstance(HeaderComponentPage.class);
            boolean areHeadersVisible = headerComponentPage.validateAllHeaderComponentsVisible();
            Assert.assertTrue(areHeadersVisible, "Header components are not visible as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header components validation: " + e.getMessage());
        }
    }
}

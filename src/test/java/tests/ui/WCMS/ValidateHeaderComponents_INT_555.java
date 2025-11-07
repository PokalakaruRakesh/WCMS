package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.HeaderComponentPage;
import tests.ui.base.BaseTest;
import org.testng.Assert;

public class ValidateHeaderComponents_INT_555 extends BaseTest {

    private HeaderComponentPage headerComponentPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // No URL provided in test data, assuming navigation is handled in BaseTest or by default
    }

    @Test(description = "INT-555: Validate header components are visible")
    @Description("INT-555: User should be able to see the header components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_555() {
        try {
            headerComponentPage = page.getInstance(HeaderComponentPage.class);
            boolean allHeaderComponentsVisible = headerComponentPage.validateAllHeaderComponentsVisible();
            Assert.assertTrue(allHeaderComponentsVisible, "Not all header components are visible as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header components validation: " + e.getMessage());
        }
    }
}

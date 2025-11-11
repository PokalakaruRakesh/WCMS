package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.HeaderComponentPage;
import tests.ui.base.BaseTest;
import static org.testng.Assert.assertTrue;

public class ValidateHeaderComponents_INT_124 extends BaseTest {

    private HeaderComponentPage headerComponentPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No URL provided in test data, assuming navigation is handled in BaseTest or by default
    }

    @Test(description = "INT-124: Validate header components are visible")
    @Description("User should be able to see the header components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_124() {
        try {
            headerComponentPage = page.getInstance(HeaderComponentPage.class);
            assertTrue(headerComponentPage.validateAllHeaderComponentsVisible(), "Header components are not visible as expected.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

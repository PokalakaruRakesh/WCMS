package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.Step;

public class HeaderComponentsPage extends BasePage {

    // Locators for header components (placeholders, update as needed)
    private By headerLogo = By.xpath("<PLACEHOLDER_Header_Logo>"); // TODO: Replace with actual locator
    private By headerNavigationMenu = By.xpath("<PLACEHOLDER_Header_Navigation_Menu>"); // TODO: Replace with actual locator
    private By headerUserProfile = By.xpath("<PLACEHOLDER_Header_User_Profile>"); // TODO: Replace with actual locator
    private By headerNotifications = By.xpath("<PLACEHOLDER_Header_Notifications>"); // TODO: Replace with actual locator
    private By headerLogoutButton = By.xpath("<PLACEHOLDER_Header_Logout_Button>"); // TODO: Replace with actual locator

    public HeaderComponentsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Complete validation of header components after login.
     * This method assumes the user is already logged in and on the landing page.
     */
    @Step("Validate header components are displayed after login")
    public void validateHeaderComponentsVisible() {
        try {
            // Wait for header logo
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(headerLogo), 10);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Wait for navigation menu
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(headerNavigationMenu), 10);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Wait for user profile icon
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(headerUserProfile), 10);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Wait for notifications icon (if applicable)
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(headerNotifications), 10);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Wait for logout button
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(headerLogoutButton), 10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            throw new AssertionError("Header components are not displayed as expected: " + e.getMessage());
        }
    }
}

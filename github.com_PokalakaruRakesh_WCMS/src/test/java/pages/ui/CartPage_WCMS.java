package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;

public class CartPage_WCMS extends BasePage {

    public CartPage_WCMS(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By cartLink = By.xpath("//a[@title='Cart']");
    public By cartEmptyHeader = By.xpath("//h1[contains(text(),'Your cart is empty')]");
    public By continueShoppingButton = By.xpath("//a[contains(text(),'Continue Shopping')]");
    public By standardsAndPublicationsHeader = By.xpath("//h1[contains(text(),'Standards & Publications')]");
    public By searchInput = By.xpath("//input[@type='search']");
    public By goButton = By.xpath("//button[.//span[text()='Go']]");

    /**
     * Complete flow for validating cart functionality as per INT-456:
     *  - Navigates to Cart
     *  - Verifies empty cart header
     *  - Clicks Continue Shopping
     *  - Verifies Standards & Publications header
     *  - Enters search term and clicks Go
     *
     * @param searchTerm The search term to enter (e.g., "Steel")
     */
    public void validateCartFunctionality(String searchTerm) {
        try {
            // Click on Cart link
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(cartLink));
            getElement(cartLink).click();
            WCMSICommon.waitForSec(2);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Verify "Your cart is empty" header is displayed
            WaitStatementUtils.waitForElementToBeVisible(driver, getElement(cartEmptyHeader));
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Click on Continue Shopping button
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(continueShoppingButton));
            getElement(continueShoppingButton).click();
            WCMSICommon.waitForSec(2);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Verify Standards & Publications header is visible
            WaitStatementUtils.waitForElementToBeVisible(driver, getElement(standardsAndPublicationsHeader));
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Enter search term in search field
            WebElement searchBox = getElement(searchInput);
            WaitStatementUtils.waitForElementToBeVisible(driver, searchBox);
            searchBox.clear();
            searchBox.sendKeys(searchTerm);
            ScreenshotUtil.takeScreenshotForAllure(driver);

            // Click on Go button
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(goButton));
            getElement(goButton).click();
            WCMSICommon.waitForSec(2);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to complete cart functionality validation flow", e);
        }
    }
}

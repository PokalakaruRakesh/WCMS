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

    /**
     * Complete the user flow for validating login and cart functionality as per INT-765.
     * Steps:
     * 1. Enter username and password, click Sign In
     * 2. Click Cart
     * 3. Verify "Your cart is empty" header
     * 4. Click Continue Shopping
     * 5. Verify "Standards & Publications" header
     * 6. Enter search term and click Go
     *
     * @param username Username to login
     * @param password Password to login
     * @param searchTerm Search term to enter (e.g., "Steel")
     */
    public void completeLoginAndCartFlow(String username, String password, String searchTerm) {
        // LoginPage locators reused as per repository pattern
        By usernameInput = By.id("userName");
        By passwordInput = By.id("encPass");
        By signInButton = By.xpath("//button[contains(text(), 'Sign In')]");

        // CartPage locators
        By cartLink = By.xpath("//a[@title='Cart']");
        By cartEmptyHeader = By.xpath("//h1[contains(text(),'Your cart is empty')]");
        By continueShoppingButton = By.linkText("Continue Shopping");
        By standardsAndPublicationsHeader = By.xpath("//h1[contains(text(),'Standards & Publications')]");
        By searchInput = By.xpath("//input[@type='search']");
        By goButton = By.xpath("//button[contains(@class,'main-search-submit')]");

        // Step 1: Enter credentials and sign in
        waitForElementPresent(usernameInput);
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        waitForElementPresent(passwordInput);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        waitForElementPresent(signInButton);
        driver.findElement(signInButton).click();

        // Step 2: Click Cart
        waitForElementPresent(cartLink);
        driver.findElement(cartLink).click();

        // Step 3: Verify "Your cart is empty" header is displayed
        waitForElementPresent(cartEmptyHeader);
        if (!driver.findElement(cartEmptyHeader).isDisplayed()) {
            throw new AssertionError("'Your cart is empty' header not displayed");
        }

        // Step 4: Click Continue Shopping
        waitForElementPresent(continueShoppingButton);
        driver.findElement(continueShoppingButton).click();

        // Step 5: Verify "Standards & Publications" header is visible
        waitForElementPresent(standardsAndPublicationsHeader);
        if (!driver.findElement(standardsAndPublicationsHeader).isDisplayed()) {
            throw new AssertionError("'Standards & Publications' header not displayed");
        }

        // Step 6: Enter search term and click Go
        waitForElementPresent(searchInput);
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(searchTerm);
        waitForElementPresent(goButton);
        driver.findElement(goButton).click();
    }
}
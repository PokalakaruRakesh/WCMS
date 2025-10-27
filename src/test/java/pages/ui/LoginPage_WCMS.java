package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import org.apache.log4j.Logger;
import tests.ui.base.BaseTest;

public class LoginPage_WCMS extends BasePage {
    public Logger log = Logger.getLogger(BaseTest.class);

    // Locators for Login Page elements
    private By usernameField = By.id("PLACEHOLDER_username_field"); // TODO: Replace with actual locator
    private By passwordField = By.id("PLACEHOLDER_password_field"); // TODO: Replace with actual locator
    private By loginButton = By.id("PLACEHOLDER_login_button"); // TODO: Replace with actual locator
    private By loginErrorMessage = By.id("PLACEHOLDER_login_error_message"); // TODO: Replace with actual locator
    private By successfulLoginIndicator = By.id("PLACEHOLDER_successful_login_indicator"); // TODO: Replace with actual locator

    public LoginPage_WCMS(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter username in the username field
     * @param username String
     */
    public void enterUsername(String username) {
        waitForElementPresent(usernameField);
        WebElement usernameElem = driver.findElement(usernameField);
        usernameElem.clear();
        usernameElem.sendKeys(username);
    }

    /**
     * Enter password in the password field
     * @param password String
     */
    public void enterPassword(String password) {
        waitForElementPresent(passwordField);
        WebElement passwordElem = driver.findElement(passwordField);
        passwordElem.clear();
        passwordElem.sendKeys(password);
    }

    /**
     * Click on the Login button
     */
    public void clickLoginButton() {
        clickOnMethod(loginButton);
    }

    /**
     * Perform login action with username and password
     * @param username String
     * @param password String
     */
    public void loginToApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Check if login error message is displayed
     * @return boolean
     */
    public boolean isLoginErrorMessageDisplayed() {
        try {
            waitForElementPresent(loginErrorMessage);
            return driver.findElement(loginErrorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if login was successful by verifying presence of a post-login indicator
     * @return boolean
     */
    public boolean isLoginSuccessful() {
        try {
            waitForElementPresent(successfulLoginIndicator);
            return driver.findElement(successfulLoginIndicator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get login error message text
     * @return String
     */
    public String getLoginErrorMessageText() {
        waitForElementPresent(loginErrorMessage);
        return driver.findElement(loginErrorMessage).getText();
    }
}

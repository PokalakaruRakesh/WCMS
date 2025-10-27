package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;

/**
 * Page Object for Login functionality (TC-N001: Title not provided)
 * Follows repository conventions: By locators, constructor injection, helper utils, no PageFactory
 */
public class LoginPage_WCMS extends BasePage {

    // Locators (placeholders, as actual locators are not specified)
    private By usernameField = By.id("PLACEHOLDER_username_field"); // TODO: Replace with actual locator
    private By passwordField = By.id("PLACEHOLDER_password_field"); // TODO: Replace with actual locator
    private By loginButton = By.id("PLACEHOLDER_login_button"); // TODO: Replace with actual locator
    private By loginErrorMessage = By.id("PLACEHOLDER_login_error_message"); // TODO: Replace with actual locator
    private By rememberMeCheckbox = By.id("PLACEHOLDER_remember_me_checkbox"); // TODO: Replace with actual locator

    public LoginPage_WCMS(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter username in the username field
     * @param username Username to enter
     */
    public void enterUsername(String username) {
        WaitStatementUtils.waitForElementToBeClickable(driver, usernameField);
        WebElement usernameElem = driver.findElement(usernameField);
        usernameElem.clear();
        usernameElem.sendKeys(username);
    }

    /**
     * Enter password in the password field
     * @param password Password to enter
     */
    public void enterPassword(String password) {
        WaitStatementUtils.waitForElementToBeClickable(driver, passwordField);
        WebElement passwordElem = driver.findElement(passwordField);
        passwordElem.clear();
        passwordElem.sendKeys(password);
    }

    /**
     * Click the Login button
     */
    public void clickLoginButton() {
        WaitStatementUtils.waitForElementToBeClickable(driver, loginButton);
        driver.findElement(loginButton).click();
        WCMSICommon.waitForSec(2);
    }

    /**
     * Click the Remember Me checkbox
     */
    public void clickRememberMeCheckbox() {
        WaitStatementUtils.waitForElementToBeClickable(driver, rememberMeCheckbox);
        driver.findElement(rememberMeCheckbox).click();
    }

    /**
     * Get the login error message text (if login fails)
     * @return Error message text
     */
    public String getLoginErrorMessage() {
        WaitStatementUtils.waitForElementToBeClickable(driver, loginErrorMessage);
        return driver.findElement(loginErrorMessage).getText();
    }

    /**
     * Perform login with username and password
     * @param username Username
     * @param password Password
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}

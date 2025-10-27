package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;

public class LoginPage extends BasePage {

    // Placeholder locators for login elements
    private By usernameField = By.id("PLACEHOLDER_username_field"); // TODO: Replace with actual locator
    private By passwordField = By.id("PLACEHOLDER_password_field"); // TODO: Replace with actual locator
    private By loginButton = By.id("PLACEHOLDER_login_button"); // TODO: Replace with actual locator
    private By loginErrorMessage = By.id("PLACEHOLDER_login_error_message"); // TODO: Replace with actual locator
    private By rememberMeCheckbox = By.id("PLACEHOLDER_remember_me_checkbox"); // TODO: Replace with actual locator

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        waitForElementPresent(usernameField);
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElementPresent(passwordField);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        waitForElementPresent(loginButton);
        driver.findElement(loginButton).click();
    }

    public void clickRememberMeCheckbox() {
        waitForElementPresent(rememberMeCheckbox);
        driver.findElement(rememberMeCheckbox).click();
    }

    public String getLoginErrorMessage() {
        waitForElementPresent(loginErrorMessage);
        return driver.findElement(loginErrorMessage).getText();
    }

    public boolean isLoginButtonEnabled() {
        waitForElementPresent(loginButton);
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isUsernameFieldDisplayed() {
        waitForElementPresent(usernameField);
        return driver.findElement(usernameField).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        waitForElementPresent(passwordField);
        return driver.findElement(passwordField).isDisplayed();
    }

    public boolean isRememberMeCheckboxDisplayed() {
        waitForElementPresent(rememberMeCheckbox);
        return driver.findElement(rememberMeCheckbox).isDisplayed();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        // Optionally, add wait for successful login or dashboard page load
    }
}

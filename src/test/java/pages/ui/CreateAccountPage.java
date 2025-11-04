package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;

public class CreateAccountPage extends BasePage {
    private WebDriver driver;

    // Locators
    private By firstNameInput = By.id("firstname");
    private By middleNameInput = By.id("middlename");
    private By lastNameInput = By.id("lastname");
    private By organizationInput = By.id("additional_organization");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("password-confirmation");
    private By createAccountButton = By.id("send2");
    private By cancelLink = By.linkText("Cancel");
    private By confirmationMessage = By.xpath("//div[contains(@class,'message-success') or contains(@class,'messages')]"); // TODO: Replace with actual locator if needed

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Complete the Create Account flow as per INT-999 test case.
     * This method fills all required fields, handles various input scenarios, and submits the form.
     *
     * @param firstName         First Name value (valid or invalid)
     * @param middleName        Middle Name value
     * @param lastName          Last Name value
     * @param organization      Organization/Company value
     * @param email             Email value (valid or invalid)
     * @param password          Password value (weak or strong)
     * @param confirmPassword   Confirm Password value
     * @param submit            If true, click Submit; if false, click Cancel
     */
    @Step("Complete Create Account flow with all details and submit/cancel")
    public void completeCreateAccountFlow(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword, boolean submit) {
        try {
            // Fill First Name
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(firstNameInput), 10);
            WebElement firstNameElem = driver.findElement(firstNameInput);
            firstNameElem.clear();
            firstNameElem.sendKeys(firstName);

            // Fill Middle Name
            WebElement middleNameElem = driver.findElement(middleNameInput);
            middleNameElem.clear();
            middleNameElem.sendKeys(middleName);

            // Fill Last Name
            WebElement lastNameElem = driver.findElement(lastNameInput);
            lastNameElem.clear();
            lastNameElem.sendKeys(lastName);

            // Fill Organization
            WebElement orgElem = driver.findElement(organizationInput);
            orgElem.clear();
            orgElem.sendKeys(organization);

            // Fill Email
            WebElement emailElem = driver.findElement(emailInput);
            emailElem.clear();
            emailElem.sendKeys(email);

            // Fill Password
            WebElement passwordElem = driver.findElement(passwordInput);
            passwordElem.clear();
            passwordElem.sendKeys(password);

            // Fill Confirm Password
            WebElement confirmPasswordElem = driver.findElement(confirmPasswordInput);
            confirmPasswordElem.clear();
            confirmPasswordElem.sendKeys(confirmPassword);

            ScreenshotUtil.takeScreenshotForAllure(driver);

            if (submit) {
                // Click Create Account
                WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(createAccountButton));
                driver.findElement(createAccountButton).click();
            } else {
                // Click Cancel
                WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(cancelLink));
                driver.findElement(cancelLink).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if confirmation message is displayed after successful account creation.
     * @return true if confirmation message is displayed, false otherwise
     */
    public boolean isConfirmationMessageDisplayed() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(confirmationMessage), 10);
            return driver.findElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ====================== NEW METHODS ADDED BELOW (per requirements) ======================

    /**
     * Complete the Create Account flow with all required details and submit the form.
     * This method performs the entire account creation process as per the test case INT-999.
     */
    @Step("Create a new account with provided details and submit the form")
    public void createAccount(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword) {
        waitForElementPresent(firstNameInput);
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);

        waitForElementPresent(middleNameInput);
        driver.findElement(middleNameInput).clear();
        driver.findElement(middleNameInput).sendKeys(middleName);

        waitForElementPresent(lastNameInput);
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);

        waitForElementPresent(organizationInput);
        driver.findElement(organizationInput).clear();
        driver.findElement(organizationInput).sendKeys(organization);

        waitForElementPresent(emailInput);
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);

        waitForElementPresent(passwordInput);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);

        waitForElementPresent(confirmPasswordInput);
        driver.findElement(confirmPasswordInput).clear();
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);

        waitForElementPresent(createAccountButton);
        driver.findElement(createAccountButton).click();
    }

    /**
     * Clicks the Cancel link on the Create Account form.
     */
    public void clickCancel() {
        waitForElementPresent(cancelLink);
        driver.findElement(cancelLink).click();
    }

    /**
     * Gets the confirmation message displayed after successful account creation.
     * @return Confirmation message text
     */
    public String getConfirmationMessage() {
        waitForElementPresent(confirmationMessage);
        return driver.findElement(confirmationMessage).getText();
    }

    /**
     * Waits for the specified element to be present and visible on the page.
     * @param locator The By locator of the element to wait for
     */
    private void waitForElementPresent(By locator) {
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(locator), 10);
    }
}
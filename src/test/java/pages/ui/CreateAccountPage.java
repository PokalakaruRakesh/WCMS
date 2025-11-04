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

    // ================== ADDED METHODS BELOW (per new requirements) ==================

    // Locators for Create Account form (overrides for new methods only)
    private By createAccountButtonNew = By.xpath("//button[@id='send2' and @title='Create Account']");
    private By confirmationMessageNew = By.xpath("//div[contains(@class,'message-success') or contains(@class,'success')]"); // TODO: Replace with actual locator if needed

    /**
     * Complete the Create Account flow with all required and optional fields.
     * This method covers the comprehensive flow for the INT-999 test case.
     *
     * @param firstName        First Name
     * @param middleName       Middle Name (optional)
     * @param lastName         Last Name
     * @param organization     Organization/Company (optional)
     * @param email            Email Address
     * @param password         Password
     * @param confirmPassword  Confirm Password
     */
    @Step("Create a new account with all details and submit the form")
    public void createAccount(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword) {
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(firstNameInput), 15);
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);

        if (middleName != null && !middleName.isEmpty()) {
            driver.findElement(middleNameInput).clear();
            driver.findElement(middleNameInput).sendKeys(middleName);
        }

        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);

        if (organization != null && !organization.isEmpty()) {
            driver.findElement(organizationInput).clear();
            driver.findElement(organizationInput).sendKeys(organization);
        }

        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);

        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);

        driver.findElement(confirmPasswordInput).clear();
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);

        ReusableMethods.scrollIntoView(driver.findElement(createAccountButtonNew), driver);
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(createAccountButtonNew));
        driver.findElement(createAccountButtonNew).click();
    }

    /**
     * Verifies if the account creation confirmation message is displayed.
     *
     * @return true if confirmation message is displayed, false otherwise
     */
    public boolean isAccountCreationConfirmationDisplayed() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(confirmationMessageNew), 15);
            return driver.findElement(confirmationMessageNew).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
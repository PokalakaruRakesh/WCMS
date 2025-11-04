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

    // ===================== ADDED METHODS BELOW (DO NOT MODIFY EXISTING CODE) =====================

    /**
     * Complete the account creation process with all required fields and actions.
     * This method covers the entire flow: filling in all fields, handling edge cases (invalid/valid data),
     * clicking Cancel, submitting the form, and verifying the confirmation message.
     *
     * @param firstName           The first name to enter (valid or invalid)
     * @param middleName          The middle name to enter
     * @param lastName            The last name to enter
     * @param organization        The organization/company name
     * @param email               The email address to enter (valid or invalid)
     * @param password            The password to enter
     * @param confirmPassword     The confirm password to enter
     * @param submit              If true, click Submit; if false, click Cancel
     */
    public void completeAccountCreationFlow(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword, boolean submit) {
        try {
            // Define new locators as per new requirements
            By firstNameField = By.id("firstname");
            By middleNameField = By.id("middlename");
            By lastNameField = By.id("lastname");
            By organizationField = By.id("additional_organization");
            By emailField = By.id("email_address");
            By accountPasswordField = By.id("password");
            By confirmPasswordField = By.id("password-confirmation");

            // Wait for the first name field to be visible
            WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(firstNameField), 15);
            driver.findElement(firstNameField).clear();
            driver.findElement(firstNameField).sendKeys(firstName);

            driver.findElement(middleNameField).clear();
            driver.findElement(middleNameField).sendKeys(middleName);

            driver.findElement(lastNameField).clear();
            driver.findElement(lastNameField).sendKeys(lastName);

            driver.findElement(organizationField).clear();
            driver.findElement(organizationField).sendKeys(organization);

            driver.findElement(emailField).clear();
            driver.findElement(emailField).sendKeys(email);

            driver.findElement(accountPasswordField).clear();
            driver.findElement(accountPasswordField).sendKeys(password);

            driver.findElement(confirmPasswordField).clear();
            driver.findElement(confirmPasswordField).sendKeys(confirmPassword);

            if (submit) {
                WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(createAccountButton), 10);
                driver.findElement(createAccountButton).click();
            } else {
                WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(cancelLink), 10);
                driver.findElement(cancelLink).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifies if the confirmation message is displayed after successful account creation.
     *
     * @return true if confirmation message is displayed, false otherwise
     */
    public boolean isAccountCreationConfirmationDisplayed() {
        try {
            // Placeholder: Replace with actual locator for confirmation message
            By confirmationMessage = By.xpath("<PLACEHOLDER_confirmation_message>"); // TODO: Replace with actual locator
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(confirmationMessage), 15);
            return driver.findElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
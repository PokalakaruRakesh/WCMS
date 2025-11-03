package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;

public class CreateAccountPage extends BasePage {

    // Locators for Create Account form fields and actions
    private By firstNameField = By.id("firstname");
    private By middleNameField = By.id("middlename");
    private By lastNameField = By.id("lastname");
    private By organizationField = By.id("additional_organization");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By createAccountButton = By.xpath("//form[@id='form-validate']//button[@id='send2']");
    private By cancelLink = By.linkText("Cancel");
    // Placeholder for confirmation message (should be updated with actual locator if available)
    private By confirmationMessage = By.xpath("//div[contains(@class, 'message-success') or contains(text(),'confirmation')] "); // TODO: Replace with actual locator

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Complete the account creation process with provided details")
    public void createAccount(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword) {
        typeFirstName(firstName);
        typeMiddleName(middleName);
        typeLastName(lastName);
        typeOrganization(organization);
        typeEmail(email);
        typePassword(password);
        typeConfirmPassword(confirmPassword);
        clickCreateAccount();
    }

    public void typeFirstName(String firstName) {
        WebElement el = getElement(firstNameField);
        el.clear();
        el.sendKeys(firstName);
    }

    public void typeMiddleName(String middleName) {
        WebElement el = getElement(middleNameField);
        el.clear();
        el.sendKeys(middleName);
    }

    public void typeLastName(String lastName) {
        WebElement el = getElement(lastNameField);
        el.clear();
        el.sendKeys(lastName);
    }

    public void typeOrganization(String organization) {
        WebElement el = getElement(organizationField);
        el.clear();
        el.sendKeys(organization);
    }

    public void typeEmail(String email) {
        WebElement el = getElement(emailField);
        el.clear();
        el.sendKeys(email);
    }

    public void typePassword(String password) {
        WebElement el = getElement(passwordField);
        el.clear();
        el.sendKeys(password);
    }

    public void typeConfirmPassword(String confirmPassword) {
        WebElement el = getElement(confirmPasswordField);
        el.clear();
        el.sendKeys(confirmPassword);
    }

    public void clickCreateAccount() {
        WebElement btn = getElement(createAccountButton);
        WaitStatementUtils.waitForElementToBeClickable(driver, btn);
        btn.click();
    }

    public void clickCancel() {
        WebElement link = getElement(cancelLink);
        WaitStatementUtils.waitForElementToBeClickable(driver, link);
        link.click();
    }

    public boolean isConfirmationMessageDisplayed() {
        try {
            waitForElementPresent(confirmationMessage);
            return getElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Additional helper methods for negative scenarios
    public void clearAllFields() {
        getElement(firstNameField).clear();
        getElement(middleNameField).clear();
        getElement(lastNameField).clear();
        getElement(organizationField).clear();
        getElement(emailField).clear();
        getElement(passwordField).clear();
        getElement(confirmPasswordField).clear();
    }

    public void submitWithBlankFields() {
        clearAllFields();
        clickCreateAccount();
    }

    public void submitWithInvalidEmail(String email) {
        typeEmail(email);
        clickCreateAccount();
    }

    public void submitWithMismatchedPasswords(String password, String confirmPassword) {
        typePassword(password);
        typeConfirmPassword(confirmPassword);
        clickCreateAccount();
    }
}

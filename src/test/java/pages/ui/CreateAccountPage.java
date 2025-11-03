package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;

public class CreateAccountPage {
    private WebDriver driver;

    // Locators
    private By firstnameInput = By.id("firstname");
    private By middlenameInput = By.id("middlename");
    private By lastnameInput = By.id("lastname");
    private By organizationInput = By.id("additional_organization");
    private By emailAddressInput = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By createAccountSubmitButton = By.id("send2");
    private By cancelLink = By.linkText("Cancel");
    private By confirmationMessage = By.xpath("//div[contains(@class,'message-success') or contains(@class,'messages')]"); // TODO: Replace with actual locator if needed

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill in the create account form and submit")
    public void createAccount(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword) {
        driver.findElement(firstnameInput).clear();
        driver.findElement(firstnameInput).sendKeys(firstName);
        driver.findElement(middlenameInput).clear();
        driver.findElement(middlenameInput).sendKeys(middleName);
        driver.findElement(lastnameInput).clear();
        driver.findElement(lastnameInput).sendKeys(lastName);
        driver.findElement(organizationInput).clear();
        driver.findElement(organizationInput).sendKeys(organization);
        driver.findElement(emailAddressInput).clear();
        driver.findElement(emailAddressInput).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(createAccountSubmitButton));
        driver.findElement(createAccountSubmitButton).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstnameInput).clear();
        driver.findElement(firstnameInput).sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        driver.findElement(middlenameInput).clear();
        driver.findElement(middlenameInput).sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastnameInput).clear();
        driver.findElement(lastnameInput).sendKeys(lastName);
    }

    public void enterOrganization(String organization) {
        driver.findElement(organizationInput).clear();
        driver.findElement(organizationInput).sendKeys(organization);
    }

    public void enterEmail(String email) {
        driver.findElement(emailAddressInput).clear();
        driver.findElement(emailAddressInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickCreateAccountButton() {
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(createAccountSubmitButton));
        driver.findElement(createAccountSubmitButton).click();
    }

    public void clickCancelButton() {
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(cancelLink));
        driver.findElement(cancelLink).click();
    }

    public boolean isConfirmationMessageDisplayed() {
        try {
            WaitStatementUtils.waitForElementPresent(driver, confirmationMessage);
            return driver.findElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getConfirmationMessageText() {
        try {
            WaitStatementUtils.waitForElementPresent(driver, confirmationMessage);
            return driver.findElement(confirmationMessage).getText();
        } catch (Exception e) {
            return null;
        }
    }

    // Additional field validation methods for negative scenarios
    public void clearAllFields() {
        driver.findElement(firstnameInput).clear();
        driver.findElement(middlenameInput).clear();
        driver.findElement(lastnameInput).clear();
        driver.findElement(organizationInput).clear();
        driver.findElement(emailAddressInput).clear();
        driver.findElement(passwordField).clear();
        driver.findElement(confirmPasswordField).clear();
    }

    public void submitForm() {
        clickCreateAccountButton();
    }
}

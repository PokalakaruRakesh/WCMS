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
    private By firstNameInput = By.id("firstname");
    private By middleNameInput = By.id("middlename");
    private By lastNameInput = By.id("lastname");
    private By organizationInput = By.id("additional_organization");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("password-confirmation");
    private By createAccountButton = By.id("send2");
    private By cancelLink = By.xpath("//a[text()='Cancel']");
    // Confirmation message placeholder (update with actual locator if available)
    private By confirmationMessage = By.xpath("<PLACEHOLDER_confirmation_message>"); // TODO: Replace with actual locator

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Create account with provided details")
    public void createAccount(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword) {
        WaitStatementUtils.waitForElementPresent(driver, driver.findElement(firstNameInput));
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(middleNameInput).clear();
        driver.findElement(middleNameInput).sendKeys(middleName);
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(organizationInput).clear();
        driver.findElement(organizationInput).sendKeys(organization);
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).clear();
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(createAccountButton));
        driver.findElement(createAccountButton).click();
    }

    public void enterFirstName(String firstName) {
        WaitStatementUtils.waitForElementPresent(driver, driver.findElement(firstNameInput));
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        driver.findElement(middleNameInput).clear();
        driver.findElement(middleNameInput).sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterOrganization(String organization) {
        driver.findElement(organizationInput).clear();
        driver.findElement(organizationInput).sendKeys(organization);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordInput).clear();
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }

    public void clickCreateAccount() {
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(createAccountButton));
        driver.findElement(createAccountButton).click();
    }

    public void clickCancel() {
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(cancelLink));
        driver.findElement(cancelLink).click();
    }

    public boolean isConfirmationMessageDisplayed() {
        try {
            WaitStatementUtils.waitForElementPresent(driver, driver.findElement(confirmationMessage));
            return driver.findElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

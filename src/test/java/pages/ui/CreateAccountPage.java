package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;

public class CreateAccountPage extends BasePage {

    // Locators
    private By firstNameInput = By.id("firstname");
    private By middleNameInput = By.id("middlename");
    private By lastNameInput = By.id("lastname");
    private By organizationInput = By.id("additional_organization");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("password-confirmation");
    private By createAccountButton = By.xpath("//button[@title='Create Account']");
    private By cancelLink = By.linkText("Cancel");
    private By confirmationMessage = By.xpath("//div[contains(@class,'message-success') or contains(text(),'Thank you for registering')]"); // TODO: Replace with actual locator if needed

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Create a new account with all required details")
    public void createAccount(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword) {
        waitForElementPresent(firstNameInput);
        getElement(firstNameInput).clear();
        getElement(firstNameInput).sendKeys(firstName);
        
        waitForElementPresent(middleNameInput);
        getElement(middleNameInput).clear();
        getElement(middleNameInput).sendKeys(middleName);
        
        waitForElementPresent(lastNameInput);
        getElement(lastNameInput).clear();
        getElement(lastNameInput).sendKeys(lastName);
        
        waitForElementPresent(organizationInput);
        getElement(organizationInput).clear();
        getElement(organizationInput).sendKeys(organization);
        
        waitForElementPresent(emailInput);
        getElement(emailInput).clear();
        getElement(emailInput).sendKeys(email);
        
        waitForElementPresent(passwordInput);
        getElement(passwordInput).clear();
        getElement(passwordInput).sendKeys(password);
        
        waitForElementPresent(confirmPasswordInput);
        getElement(confirmPasswordInput).clear();
        getElement(confirmPasswordInput).sendKeys(confirmPassword);
        
        waitForElementPresent(createAccountButton);
        getElement(createAccountButton).click();
    }

    @Step("Cancel account creation")
    public void cancelAccountCreation() {
        waitForElementPresent(cancelLink);
        getElement(cancelLink).click();
    }

    @Step("Check if confirmation message is displayed after account creation")
    public boolean isConfirmationMessageDisplayed() {
        try {
            waitForElementPresent(confirmationMessage);
            return getElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

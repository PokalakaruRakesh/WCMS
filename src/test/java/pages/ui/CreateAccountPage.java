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
    private By createAccountButton = By.id("send2");
    private By cancelLink = By.xpath("//a[@href='https://stage-store.astm.org/']");
    private By confirmationMessage = By.xpath("//div[contains(@class,'message-success') or contains(text(),'confirmation')] "); // TODO: Replace with actual locator if available

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill Create Account form with provided details")
    public void fillCreateAccountForm(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword) {
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
    }

    @Step("Click Create Account button")
    public void clickCreateAccountButton() {
        waitForElementPresent(createAccountButton);
        WaitStatementUtils.waitForElementToBeClickable(driver, getElement(createAccountButton));
        getElement(createAccountButton).click();
    }

    @Step("Click Cancel link on Create Account page")
    public void clickCancelLink() {
        waitForElementPresent(cancelLink);
        getElement(cancelLink).click();
    }

    @Step("Leave required fields blank and click Submit")
    public void submitWithBlankFields() {
        waitForElementPresent(createAccountButton);
        getElement(createAccountButton).click();
    }

    @Step("Get confirmation message after account creation")
    public String getConfirmationMessage() {
        waitForElementPresent(confirmationMessage);
        return getElement(confirmationMessage).getText();
    }

    // Additional helper methods for negative/edge cases
    public void enterFirstName(String firstName) {
        waitForElementPresent(firstNameInput);
        getElement(firstNameInput).clear();
        getElement(firstNameInput).sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        waitForElementPresent(middleNameInput);
        getElement(middleNameInput).clear();
        getElement(middleNameInput).sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        waitForElementPresent(lastNameInput);
        getElement(lastNameInput).clear();
        getElement(lastNameInput).sendKeys(lastName);
    }

    public void enterOrganization(String organization) {
        waitForElementPresent(organizationInput);
        getElement(organizationInput).clear();
        getElement(organizationInput).sendKeys(organization);
    }

    public void enterEmail(String email) {
        waitForElementPresent(emailInput);
        getElement(emailInput).clear();
        getElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForElementPresent(passwordInput);
        getElement(passwordInput).clear();
        getElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        waitForElementPresent(confirmPasswordInput);
        getElement(confirmPasswordInput).clear();
        getElement(confirmPasswordInput).sendKeys(confirmPassword);
    }
}

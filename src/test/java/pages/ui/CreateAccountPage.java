package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class CreateAccountPage {
    private WebDriver driver;

    // Locators
    private By firstNameInput = By.id("firstname");
    private By middleNameInput = By.id("middlename");
    private By lastNameInput = By.id("lastname");
    private By organizationInput = By.id("additional_organization");
    private By emailAddressInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("password-confirmation");
    private By createAccountButton = By.id("send2"); // The Create Account button
    private By cancelLink = By.xpath("//a[@href='https://stage-store.astm.org/']");
    private By confirmationMessage = By.xpath("//div[contains(@class,'message-success') or contains(text(),'confirmation')]" ); // TODO: Replace with actual locator for confirmation message

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Complete account creation flow with provided details")
    public void createAccount(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(middleNameInput).clear();
        driver.findElement(middleNameInput).sendKeys(middleName);
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(organizationInput).clear();
        driver.findElement(organizationInput).sendKeys(organization);
        driver.findElement(emailAddressInput).clear();
        driver.findElement(emailAddressInput).sendKeys(email);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).clear();
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(createAccountButton), 10);
        driver.findElement(createAccountButton).click();
    }

    @Step("Click Cancel link on Create Account page")
    public void clickCancel() {
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(cancelLink), 10);
        driver.findElement(cancelLink).click();
    }

    @Step("Check if confirmation message is displayed after account creation")
    public boolean isConfirmationMessageDisplayed() {
        try {
            WaitStatementUtils.waitForElementPresent(driver, confirmationMessage, 10);
            WebElement msg = driver.findElement(confirmationMessage);
            return msg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

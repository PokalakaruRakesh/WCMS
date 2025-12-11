package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;

public class ContactCreationPage extends BasePage {

    // Locators for required fields and actions
    private By firstNameInput = By.name("first_name");
    private By lastNameInput = By.name("last_name");
    private By emailAddressInput = By.name("value"); // Email address field
    private By emailDescriptionInput = By.name("name"); // Email description field
    private By addEmailButton = By.xpath("//button[contains(@class, 'icon button')]");
    private By phoneNumberInput = By.xpath("<PLACEHOLDER_phone_number_input>"); // TODO: Replace with actual locator
    private By companyInput = By.xpath("<PLACEHOLDER_company_input>"); // TODO: Replace with actual locator
    private By positionInput = By.xpath("<PLACEHOLDER_position_input>"); // TODO: Replace with actual locator
    private By saveButton = By.xpath("//button[contains(@class, 'linkedin button') and text()='Save']");
    private By firstNameError = By.xpath("//label[contains(.,'First Name')]/span[contains(@class,'inline-error-msg')]");
    private By emailError = By.xpath("//label[contains(.,'Email')]/following-sibling::div//span[contains(@class,'inline-error-msg')]");

    public ContactCreationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Attempt to save a contact with empty required fields and verify validation messages")
    public void completeEmptyRequiredFieldsValidation(String phoneNumber, String company, String position) {
        // Leave First Name and Email fields empty
        waitForElementPresent(phoneNumberInput);
        driver.findElement(phoneNumberInput).clear();
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);

        waitForElementPresent(companyInput);
        driver.findElement(companyInput).clear();
        driver.findElement(companyInput).sendKeys(company);

        waitForElementPresent(positionInput);
        driver.findElement(positionInput).clear();
        driver.findElement(positionInput).sendKeys(position);

        waitForElementPresent(saveButton);
        driver.findElement(saveButton).click();
    }

    public boolean isFirstNameErrorDisplayed() {
        try {
            waitForElementPresent(firstNameError);
            return driver.findElement(firstNameError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getFirstNameErrorText() {
        waitForElementPresent(firstNameError);
        return driver.findElement(firstNameError).getText();
    }

    public boolean isEmailErrorDisplayed() {
        try {
            waitForElementPresent(emailError);
            return driver.findElement(emailError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmailErrorText() {
        waitForElementPresent(emailError);
        return driver.findElement(emailError).getText();
    }
}

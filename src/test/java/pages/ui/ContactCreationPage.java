package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;

/**
 * Page Object for Contact Creation screen (CRM) - supports invalid email format rejection scenario (TC-N002).
 * Follows repository conventions: locators as By fields, comprehensive method for the flow, proper waits and error handling.
 */
public class ContactCreationPage extends BasePage {

    // Locators (from provided mapping and test case context)
    private By firstNameInput = By.name("first_name");
    private By lastNameInput = By.name("last_name");
    private By emailAddressInput = By.name("value"); // Email address field in the form
    private By emailTypeInput = By.name("name"); // Email type (Personal, Business, etc.)
    private By addEmailButton = By.xpath("//button[contains(@class, 'icon button')]");
    private By saveButton = By.xpath("//button[contains(., 'Save')]");
    private By categoryDropdown = By.name("category");
    // Placeholder for error message (since not specified in locators)
    private By emailErrorMessage = By.xpath("//span[contains(@class,'inline-error-msg') and contains(text(),'email')]"); // TODO: Replace with actual locator if needed

    public ContactCreationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Complete the contact creation flow with invalid email and verify error message is displayed.
     * This is the comprehensive method for TC-N002: Invalid Email Format Rejection.
     *
     * @param firstName   First Name (valid)
     * @param lastName    Last Name (valid)
     * @param email       Invalid email format (e.g., "invalidemail.com")
     * @param emailType   Email type (e.g., "Personal")
     * @param category    Category to select (e.g., "Lead")
     * @return true if error message for invalid email is displayed, false otherwise
     */
    @Step("Attempt to create a contact with invalid email and verify error message is shown")
    public boolean createContactWithInvalidEmailAndVerifyError(String firstName, String lastName, String email, String emailType, String category) {
        // Fill First Name
        waitForElementPresent(firstNameInput);
        WebElement firstNameElem = driver.findElement(firstNameInput);
        firstNameElem.clear();
        firstNameElem.sendKeys(firstName);

        // Fill Last Name
        waitForElementPresent(lastNameInput);
        WebElement lastNameElem = driver.findElement(lastNameInput);
        lastNameElem.clear();
        lastNameElem.sendKeys(lastName);

        // Fill Email Address
        waitForElementPresent(emailAddressInput);
        WebElement emailElem = driver.findElement(emailAddressInput);
        emailElem.clear();
        emailElem.sendKeys(email);

        // Fill Email Type (optional, if required)
        if (emailType != null && !emailType.isEmpty()) {
            waitForElementPresent(emailTypeInput);
            WebElement emailTypeElem = driver.findElement(emailTypeInput);
            emailTypeElem.clear();
            emailTypeElem.sendKeys(emailType);
        }

        // Optionally click Add Email if needed (depends on UI behavior)
        // Uncomment if required:
        // waitForElementPresent(addEmailButton);
        // driver.findElement(addEmailButton).click();

        // Select Category (if required)
        if (category != null && !category.isEmpty()) {
            waitForElementPresent(categoryDropdown);
            driver.findElement(categoryDropdown).click();
            // Select the category option by visible text
            By categoryOption = By.xpath("//div[@role='option' and .//span[text()='" + category + "']]");
            waitForElementPresent(categoryOption);
            driver.findElement(categoryOption).click();
        }

        // Click Save
        waitForElementPresent(saveButton);
        driver.findElement(saveButton).click();

        // Wait for error message related to invalid email
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(emailErrorMessage), 10);
            String errorMsg = driver.findElement(emailErrorMessage).getText();
            // Optionally, check for specific error text (e.g., "invalid email format")
            return errorMsg != null && !errorMsg.trim().isEmpty();
        } catch (Exception e) {
            // Error message not found
            return false;
        }
    }
}

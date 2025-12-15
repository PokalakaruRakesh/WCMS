package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage(WebDriver driver) {
        super(driver);
    }

    // Locators (from provided locators and HTML snippet)
    public By firstNameInput = By.name("first_name");
    public By lastNameInput = By.name("last_name");
    public By emailAddressInput = By.name("value"); // The main email address input
    public By emailTypeInput = By.name("name"); // e.g. Personal, Business, etc.
    public By addEmailButton = By.xpath("//button[contains(@class, 'icon button')]//i[@class='add icon']");
    public By saveButton = By.xpath("//button[contains(@class, 'linkedin button') and text()='Save']");
    public By errorMessage = By.xpath("//span[contains(@class, 'inline-error-msg') or contains(@class, 'invalid-feedback') or contains(@class, 'error')] | //div[contains(@class, 'error') or contains(@class, 'inline-error-msg')] | //span[contains(text(),'invalid') or contains(text(),'Invalid')]"); // Placeholder, may need adjustment

    /**
     * Complete the contact creation form with provided details and attempt to save with invalid email format.
     * This method performs the full workflow for the 'Invalid Email Format Rejection' test case.
     *
     * @param firstName   First Name value
     * @param lastName    Last Name value
     * @param email       Email value (should be invalid format for this test)
     * @param emailType   Email type (e.g. Personal, Business, etc.)
     */
    public void createContactWithInvalidEmail(String firstName, String lastName, String email, String emailType) {
        // Fill First Name
        WebElement firstNameElem = getElement(firstNameInput);
        firstNameElem.clear();
        firstNameElem.sendKeys(firstName);

        // Fill Last Name
        WebElement lastNameElem = getElement(lastNameInput);
        lastNameElem.clear();
        lastNameElem.sendKeys(lastName);

        // Fill Email Address
        WebElement emailAddressElem = getElement(emailAddressInput);
        emailAddressElem.clear();
        emailAddressElem.sendKeys(email);

        // Fill Email Type (if applicable)
        WebElement emailTypeElem = getElement(emailTypeInput);
        emailTypeElem.clear();
        emailTypeElem.sendKeys(emailType);

        // Optionally click Add Email Button if required by UI
        // getElement(addEmailButton).click();

        // Click Save
        clickOnMethod(saveButton);
    }

    /**
     * Returns the error message displayed for invalid email format.
     * @return String error message text, or empty string if none found.
     */
    public String getInvalidEmailErrorMessage() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(errorMessage), 10);
            return getElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }
}

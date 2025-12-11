package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.Step;

public class ContactCreationPage extends BasePage {

    // Locators (from provided test case context)
    private By firstNameInput = By.name("first_name");
    private By lastNameInput = By.name("last_name");
    private By emailValueInput = By.name("value"); // Email address input
    private By emailNameInput = By.name("name"); // Email type/name (Personal, Business, etc.)
    private By saveButton = By.xpath("//button[contains(@class, 'linkedin button') and contains(., 'Save')]");
    private By errorMessage = By.xpath("//span[contains(@class,'inline-error-msg') or contains(@class,'invalid-feedback') or contains(text(),'invalid')]"); // TODO: Refine if specific error locator is known
    private By companyInput = By.xpath("<PLACEHOLDER_companyInput>"); // TODO: Replace with actual locator
    private By positionInput = By.xpath("<PLACEHOLDER_positionInput>"); // TODO: Replace with actual locator

    public ContactCreationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Complete the contact creation flow with invalid email and verify error message.
     * This method performs:
     * 1. Fills in all required fields (Name, Phone, Company, Position, etc.)
     * 2. Enters an invalid email format
     * 3. Clicks Save
     * 4. Verifies the error message for invalid email format is displayed
     *
     * @param firstName First name of contact
     * @param lastName Last name of contact
     * @param company Company name
     * @param position Position/title
     * @param emailInvalid Invalid email (e.g., "invalidemail.com")
     * @param emailType Email type (e.g., "Personal", "Business", etc.)
     * @return true if error message is displayed, false otherwise
     */
    @Step("Attempt to create contact with invalid email and verify error message is shown")
    public boolean createContactWithInvalidEmailAndVerifyError(String firstName, String lastName, String company, String position, String emailInvalid, String emailType) {
        try {
            // Fill First Name
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(firstNameInput));
            getElement(firstNameInput).clear();
            getElement(firstNameInput).sendKeys(firstName);

            // Fill Last Name
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(lastNameInput));
            getElement(lastNameInput).clear();
            getElement(lastNameInput).sendKeys(lastName);

            // Fill Company
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(companyInput));
            getElement(companyInput).clear();
            getElement(companyInput).sendKeys(company);

            // Fill Position
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(positionInput));
            getElement(positionInput).clear();
            getElement(positionInput).sendKeys(position);

            // Fill Email Address (invalid)
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(emailValueInput));
            getElement(emailValueInput).clear();
            getElement(emailValueInput).sendKeys(emailInvalid);

            // Fill Email Type/Name (optional)
            if (emailType != null && !emailType.isEmpty()) {
                getElement(emailNameInput).clear();
                getElement(emailNameInput).sendKeys(emailType);
            }

            // Click Save
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(saveButton));
            getElement(saveButton).click();
            WCMSICommon.waitForSec(2);

            // Check for error message
            boolean errorDisplayed = false;
            try {
                WebElement errorElem = getElement(errorMessage);
                errorDisplayed = errorElem.isDisplayed() && errorElem.getText().toLowerCase().contains("invalid");
                ScreenshotUtil.takeScreenshotForAllure(driver);
            } catch (Exception e) {
                errorDisplayed = false;
            }
            return errorDisplayed;
        } catch (Exception ex) {
            ex.printStackTrace();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return false;
        }
    }
}

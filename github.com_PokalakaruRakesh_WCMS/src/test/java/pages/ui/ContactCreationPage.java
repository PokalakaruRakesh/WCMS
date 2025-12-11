package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;

/**
 * Page Object for CRM Contact Creation screen (for Invalid Email Format Rejection scenario TC-N002)
 * Follows comprehensive method pattern as per repository standards.
 */
public class ContactCreationPage extends BasePage {

    // Locators
    private By firstNameInput = By.name("first_name");
    private By lastNameInput = By.name("last_name");
    private By emailAddressInput = By.name("value"); // Email address field
    private By emailDescriptionInput = By.name("name"); // Email description field
    private By addEmailButton = By.xpath("//button[contains(@class, 'ui tiny basic icon button')]");
    private By categoryDropdown = By.xpath("//div[@class='ui selection dropdown']");
    private By saveButton = By.xpath("//button[contains(@class, 'ui linkedin button') and contains(., 'Save')]");
    private By emailErrorMessage = By.xpath("//label[contains(text(),'Email')]/following-sibling::div//span[contains(@class,'inline-error-msg')] | //div[contains(@class,'error') and contains(text(),'email')] | //span[contains(@class,'error') and contains(text(),'email')]"); // TODO: Adjust as per actual error message locator

    public ContactCreationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Complete the contact creation flow with invalid email format and attempt to save.
     * Fills all required fields with valid data except email, which is intentionally invalid.
     *
     * @param firstName    First Name (valid)
     * @param lastName     Last Name (valid)
     * @param email        Invalid email (e.g., 'invalidemail.com')
     * @param emailDesc    Email description (optional)
     * @param category     Category to select (e.g., 'Lead', 'Customer', etc.)
     */
    @Step("Complete contact creation with invalid email and attempt to save")
    public void completeContactCreationWithInvalidEmail(String firstName, String lastName, String email, String emailDesc, String category) {
        // Enter First Name
        WebElement firstNameElem = getElement(firstNameInput);
        firstNameElem.clear();
        firstNameElem.sendKeys(firstName);

        // Enter Last Name
        WebElement lastNameElem = getElement(lastNameInput);
        lastNameElem.clear();
        lastNameElem.sendKeys(lastName);

        // Enter Email Address
        WebElement emailElem = getElement(emailAddressInput);
        emailElem.clear();
        emailElem.sendKeys(email);

        // Enter Email Description (if provided)
        if (emailDesc != null && !emailDesc.isEmpty()) {
            WebElement emailDescElem = getElement(emailDescriptionInput);
            emailDescElem.clear();
            emailDescElem.sendKeys(emailDesc);
        }

        // Optionally, click Add Email Button if required by UI (skip if not needed)
        // clickOnMethod(addEmailButton);

        // Select Category
        clickOnMethod(categoryDropdown);
        // Select the category option by visible text
        By categoryOption = By.xpath("//div[@role='option' and contains(@class,'item') and span[text()='" + category + "']]");
        clickOnMethod(categoryOption);

        // Click Save
        clickOnMethod(saveButton);
    }

    /**
     * Returns the error message displayed for invalid email format.
     *
     * @return Error message text, or null if not found
     */
    public String getEmailFormatErrorMessage() {
        try {
            WebElement errorElem = getElement(emailErrorMessage);
            return errorElem.getText();
        } catch (Exception e) {
            return null;
        }
    }
}

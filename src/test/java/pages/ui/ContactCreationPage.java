package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By firstNameInput = By.name("first_name");
    private By lastNameInput = By.name("last_name");
    private By emailAddressInput = By.name("value");
    private By emailTypeInput = By.name("name");
    private By addEmailButton = By.xpath("//button[contains(@class, 'icon') and contains(@class, 'add')]");
    private By categoryDropdown = By.xpath("//div[@name='category' and @role='listbox']");
    private By saveButton = By.xpath("//button[contains(@class, 'linkedin') and contains(., 'Save')]");
    private By errorMessage = By.xpath("//span[contains(@class,'inline-error-msg') or contains(text(),'invalid') or contains(text(),'Invalid')]"); // TODO: Refine if more specific locator is available

    /**
     * Complete the contact creation flow with invalid email and verify error message.
     *
     * @param firstName      First name of the contact
     * @param lastName       Last name of the contact
     * @param emailAddress   Invalid email address to test rejection
     * @param emailType      Email type (e.g. Personal, Business)
     * @param category       Category to select (e.g. Lead, Customer, etc.)
     * @return true if invalid email error message is displayed, false otherwise
     */
    @Step("Create contact with invalid email and verify error message is displayed")
    public boolean createContactWithInvalidEmail(String firstName, String lastName, String emailAddress, String emailType, String category) {
        // Enter First Name
        WebElement firstNameElem = getElement(firstNameInput);
        firstNameElem.clear();
        firstNameElem.sendKeys(firstName);

        // Enter Last Name
        WebElement lastNameElem = getElement(lastNameInput);
        lastNameElem.clear();
        lastNameElem.sendKeys(lastName);

        // Enter Email Address
        WebElement emailAddressElem = getElement(emailAddressInput);
        emailAddressElem.clear();
        emailAddressElem.sendKeys(emailAddress);

        // Enter Email Type (optional, if required)
        WebElement emailTypeElem = getElement(emailTypeInput);
        emailTypeElem.clear();
        emailTypeElem.sendKeys(emailType);

        // Optionally click Add Email Button if the UI requires
        try {
            WebElement addEmailBtn = getElement(addEmailButton);
            if (addEmailBtn.isDisplayed() && addEmailBtn.isEnabled()) {
                addEmailBtn.click();
            }
        } catch (Exception e) {
            // Button may not be required; ignore if not present
        }

        // Select Category from dropdown
        WebElement categoryElem = getElement(categoryDropdown);
        categoryElem.click();
        // Select the category option
        By categoryOption = By.xpath("//div[@name='category' and @role='option']//span[text()='" + category + "']");
        WebElement categoryOptionElem = getElement(categoryOption);
        categoryOptionElem.click();

        // Click Save Button
        WebElement saveBtn = getElement(saveButton);
        saveBtn.click();

        // Wait for error message to appear
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, getElement(errorMessage), 10);
            WebElement errorElem = getElement(errorMessage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            return errorElem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

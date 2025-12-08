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
    private By emailAddressInput = By.xpath("//input[@placeholder='Email address']");
    private By emailTypeInput = By.xpath("//input[@placeholder='Personal email, Business, Alt...']");
    private By addEmailButton = By.xpath("//button[contains(@class,'icon button') and .//i[contains(@class,'add')]]");
    private By categoryDropdown = By.xpath("//div[@role='listbox']");
    private By saveButton = By.xpath("//button[contains(@class,'linkedin') and contains(.,'Save')]");
    private By errorMessage = By.xpath("//span[contains(@class,'inline-error-msg') and contains(text(),'invalid')]"); // TODO: Adjust if error message locator is different

    /**
     * Complete the contact creation flow with invalid email and verify error message is displayed.
     * This method performs the entire scenario for 'Invalid Email Format Rejection'.
     * @param firstName First Name to enter
     * @param lastName Last Name to enter
     * @param email Invalid email format to enter (e.g., 'invalidemail.com')
     * @param emailType Email type description (e.g., 'Personal')
     * @param category Category to select (e.g., 'Lead')
     * @return true if invalid email error message is displayed, false otherwise
     */
    @Step("Attempt to create contact with invalid email and verify error message is displayed")
    public boolean completeContactCreationWithInvalidEmail(String firstName, String lastName, String email, String emailType, String category) {
        // Enter First Name
        getElement(firstNameInput).clear();
        getElement(firstNameInput).sendKeys(firstName);

        // Enter Last Name
        getElement(lastNameInput).clear();
        getElement(lastNameInput).sendKeys(lastName);

        // Enter Email Address
        getElement(emailAddressInput).clear();
        getElement(emailAddressInput).sendKeys(email);

        // Enter Email Type (if required)
        if (emailType != null && !emailType.isEmpty()) {
            getElement(emailTypeInput).clear();
            getElement(emailTypeInput).sendKeys(emailType);
        }

        // Optionally click Add Email Button if needed
        // getElement(addEmailButton).click();

        // Select Category (if required)
        if (category != null && !category.isEmpty()) {
            getElement(categoryDropdown).click();
            By categoryOption = By.xpath("//div[@role='option']//span[text()='" + category + "']");
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(categoryOption), 10);
            driver.findElement(categoryOption).click();
        }

        // Click Save Button
        getElement(saveButton).click();

        // Wait for error message to appear
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(errorMessage), 10);
            return getElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

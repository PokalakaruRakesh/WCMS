package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage(WebDriver driver) {
        super(driver);
    }

    // Locators for contact creation form fields and actions
    public By firstNameInput = By.name("first_name");
    public By lastNameInput = By.name("last_name");
    public By emailAddressInput = By.name("value");
    public By emailTypeInput = By.name("name");
    public By addEmailButton = By.xpath("//button[contains(@class, 'icon')]");
    public By categoryDropdown = By.xpath("//div[@role='listbox']");
    public By saveButton = By.xpath("//button[contains(@class, 'linkedin') and .//i[contains(@class,'save')]]");
    public By successMessage = By.xpath("//div[contains(@class,'message') and contains(text(),'success')]"); // TODO: Update with actual message locator if available

    /**
     * Complete the workflow to create a new contact with valid data.
     * Fills all required fields and submits the form.
     *
     * @param firstName   Contact's first name
     * @param lastName    Contact's last name
     * @param email       Contact's email address
     * @param emailType   Email type (e.g., Personal, Business)
     * @param category    Category to select (e.g., Lead, Customer, Contact, Affiliate)
     */
    public void createNewContact(String firstName, String lastName, String email, String emailType, String category) {
        getElement(firstNameInput).clear();
        getElement(firstNameInput).sendKeys(firstName);

        getElement(lastNameInput).clear();
        getElement(lastNameInput).sendKeys(lastName);

        getElement(emailAddressInput).clear();
        getElement(emailAddressInput).sendKeys(email);

        getElement(emailTypeInput).clear();
        getElement(emailTypeInput).sendKeys(emailType);

        clickOnMethod(addEmailButton);

        // Select category from dropdown
        clickOnMethod(categoryDropdown);
        By categoryOption = By.xpath("//div[@role='option']//span[text()='" + category + "']");
        clickOnMethod(categoryOption);

        // Click Save button
        clickOnMethod(saveButton);
    }

    /**
     * Checks if the success message is displayed after saving a new contact.
     * @return true if message is displayed, false otherwise
     */
    public boolean isSuccessMessageDisplayed() {
        try {
            return getElement(successMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class ContactCreationPage extends BasePage {
    private WebDriver driver;

    // Locators
    private By firstNameInput = By.name("first_name");
    private By lastNameInput = By.name("last_name");
    private By emailAddressInput = By.name("value"); // Email Address Input (main required email field)
    private By emailNameInput = By.name("name"); // Email Name Input (label for email, not required)
    private By addEmailButton = By.xpath("//button[contains(@class, 'icon button')]/i[@class='add icon']");
    private By categoryDropdown = By.xpath("//div[@class='ui selection dropdown']");
    private By saveButton = By.xpath("//button[contains(text(),'Save')]");
    private By firstNameError = By.xpath("//label[contains(text(),'First Name')]/span[contains(@class,'inline-error-msg')]");
    private By emailError = By.xpath("//label[contains(text(),'Email')]/following::span[contains(@class,'inline-error-msg')][1]");

    public ContactCreationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Complete flow for validating empty required fields (Name and Email) on Contact Creation.
     * Leaves First Name and Email empty, fills other fields, clicks Save, and verifies error messages.
     * @param lastName Last Name to enter (optional)
     * @param category Category to select (optional)
     */
    @Step("Validate empty required fields on Contact Creation (Name and Email)")
    public void validateEmptyRequiredFields(String lastName, String category) {
        // Leave First Name and Email fields empty
        // Optionally fill Last Name
        if (lastName != null && !lastName.isEmpty()) {
            driver.findElement(lastNameInput).clear();
            driver.findElement(lastNameInput).sendKeys(lastName);
        }
        // Optionally select Category
        if (category != null && !category.isEmpty()) {
            driver.findElement(categoryDropdown).click();
            By categoryOption = By.xpath("//div[@role='option' and .//span[text()='" + category + "']]");
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(categoryOption), 10);
            driver.findElement(categoryOption).click();
        }
        // Click Save
        driver.findElement(saveButton).click();
        // Wait for error messages
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(firstNameError), 10);
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(emailError), 10);
    }

    /**
     * Returns the error message displayed for First Name field.
     */
    public String getFirstNameErrorMessage() {
        WebElement error = driver.findElement(firstNameError);
        return error.isDisplayed() ? error.getText() : "";
    }

    /**
     * Returns the error message displayed for Email field.
     */
    public String getEmailErrorMessage() {
        WebElement error = driver.findElement(emailError);
        return error.isDisplayed() ? error.getText() : "";
    }
}

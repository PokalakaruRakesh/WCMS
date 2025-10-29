package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends BasePage {

    // Locators (placeholders, as actual locators are not specified)
    private By createAccountHeader = By.xpath("//h1[contains(text(),'Create Account')]"); // TODO: Replace with actual locator if different
    private By firstNameField = By.id("PLACEHOLDER_first_name_field"); // TODO: Replace with actual locator
    private By lastNameField = By.id("PLACEHOLDER_last_name_field"); // TODO: Replace with actual locator
    private By emailField = By.id("PLACEHOLDER_email_field"); // TODO: Replace with actual locator
    private By passwordField = By.id("PLACEHOLDER_password_field"); // TODO: Replace with actual locator
    private By createAccountButton = By.id("PLACEHOLDER_create_account_button"); // TODO: Replace with actual locator

    private final String expectedCreateAccountUrl = "https://store.astm.org/customer/account/create/?acc_class=b2c&acc_type=b2c";

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifies that the current URL matches the expected Create Account page URL.
     * @return true if the URL matches, false otherwise
     */
    public boolean isAtCreateAccountPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        log.info("Current URL: " + currentUrl);
        return expectedCreateAccountUrl.equalsIgnoreCase(currentUrl);
    }

    /**
     * Waits for the Create Account page to load by checking for the presence of the header.
     */
    public void waitForCreateAccountPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountHeader));
    }

    // Placeholder methods for interacting with the Create Account form (if needed in future steps)
    public void enterFirstName(String firstName) {
        waitForElementPresent(firstNameField);
        getElement(firstNameField).clear();
        getElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitForElementPresent(lastNameField);
        getElement(lastNameField).clear();
        getElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        waitForElementPresent(emailField);
        getElement(emailField).clear();
        getElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForElementPresent(passwordField);
        getElement(passwordField).clear();
        getElement(passwordField).sendKeys(password);
    }

    public void clickCreateAccountButton() {
        clickOnMethod(createAccountButton);
    }
}

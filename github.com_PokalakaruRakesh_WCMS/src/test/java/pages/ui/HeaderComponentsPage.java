package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentsPage extends BasePage {

    // Locators for header components (placeholders, update as needed)
    private By contactsLink = By.linkText("Contacts");
    private By createButton = By.xpath("//button[contains(@class, 'linkedin button') and text()='Create']");
    private By logOutLink = By.linkText("Log Out");
    private By settingsIcon = By.cssSelector("i.settings.icon"); // TODO: Replace with actual locator if needed
    private By userIcon = By.cssSelector("i.large.user.red.icon"); // TODO: Replace with actual locator if needed

    public HeaderComponentsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates that all expected header components are visible after login.
     * This method waits for and asserts the presence of key header elements.
     */
    @Step("Validate header components are visible after login")
    public boolean validateHeaderComponentsVisible() {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(contactsLink), 10);
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(createButton), 10);
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(logOutLink), 10);
            // Optionally validate settings and user icon if required
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(settingsIcon), 10);
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(userIcon), 10);
            return driver.findElement(contactsLink).isDisplayed() &&
                   driver.findElement(createButton).isDisplayed() &&
                   driver.findElement(logOutLink).isDisplayed() &&
                   driver.findElement(settingsIcon).isDisplayed() &&
                   driver.findElement(userIcon).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

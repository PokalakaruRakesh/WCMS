package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Page Object for validating header components as per INT-123.
 * This class provides a comprehensive method to validate all header components after login.
 */
public class HeaderComponentPage extends BasePage {

    // Locators for header components (use actual locators if available, else placeholders)
    private By contactsLink = By.linkText("Contacts");
    private By createButton = By.linkText("Create");
    private By settingsIcon = By.className("settings");
    private By logOutLink = By.linkText("Log Out");
    // Add more header component locators as required

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates the presence and visibility of all header components after successful login.
     * This method covers the complete validation flow for INT-123.
     */
    @Step("Validate all header components are visible and accessible after login")
    public void validateHeaderComponents() {
        List<String> missingComponents = new ArrayList<>();

        try {
            waitForElementPresent(contactsLink);
            if (!driver.findElement(contactsLink).isDisplayed()) {
                missingComponents.add("Contacts Link");
            }
        } catch (Exception e) {
            missingComponents.add("Contacts Link");
        }

        try {
            waitForElementPresent(createButton);
            if (!driver.findElement(createButton).isDisplayed()) {
                missingComponents.add("Create Button");
            }
        } catch (Exception e) {
            missingComponents.add("Create Button");
        }

        try {
            waitForElementPresent(settingsIcon);
            if (!driver.findElement(settingsIcon).isDisplayed()) {
                missingComponents.add("Settings Icon");
            }
        } catch (Exception e) {
            missingComponents.add("Settings Icon");
        }

        try {
            waitForElementPresent(logOutLink);
            if (!driver.findElement(logOutLink).isDisplayed()) {
                missingComponents.add("Log Out Link");
            }
        } catch (Exception e) {
            missingComponents.add("Log Out Link");
        }

        // Add more header component checks as needed

        if (!missingComponents.isEmpty()) {
            throw new AssertionError("Missing or not visible header components: " + String.join(", ", missingComponents));
        }
    }
}

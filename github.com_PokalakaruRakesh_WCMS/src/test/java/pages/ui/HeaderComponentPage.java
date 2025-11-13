package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {

    // Locators for header components
    public By homeLink = By.linkText("Home");
    public By aboutAstmButton = By.xpath("//button[contains(., 'About ASTM')]");
    public By membershipAndParticipationButton = By.xpath("//button[contains(., 'Membership & Participation')]");
    public By standardsAndSolutionsButton = By.xpath("//button[contains(., 'Standards & Solutions')]");
    public By newsButton = By.xpath("//button[contains(., 'News')]");
    public By helpButton = By.xpath("//button[contains(., 'Help')]");
    public By faqLink = By.linkText("FAQ");
    public By submenuCloseButton = By.xpath("//button[@data-testid='collapse-submenu-button']");

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates that all main header components are visible and interactable.
     * This method performs the comprehensive validation for INT-124.
     */
    @Step("Validate all main header components are visible and interactable on the header")
    public void validateHeaderComponents() {
        // Wait for and validate Home link
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(homeLink), 10);
        if (!driver.findElement(homeLink).isDisplayed()) {
            throw new AssertionError("Home link is not visible in the header");
        }

        // Wait for and validate About ASTM button
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(aboutAstmButton), 10);
        if (!driver.findElement(aboutAstmButton).isDisplayed()) {
            throw new AssertionError("About ASTM button is not visible in the header");
        }

        // Wait for and validate Membership & Participation button
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(membershipAndParticipationButton), 10);
        if (!driver.findElement(membershipAndParticipationButton).isDisplayed()) {
            throw new AssertionError("Membership & Participation button is not visible in the header");
        }

        // Wait for and validate Standards & Solutions button
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(standardsAndSolutionsButton), 10);
        if (!driver.findElement(standardsAndSolutionsButton).isDisplayed()) {
            throw new AssertionError("Standards & Solutions button is not visible in the header");
        }

        // Wait for and validate News button
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(newsButton), 10);
        if (!driver.findElement(newsButton).isDisplayed()) {
            throw new AssertionError("News button is not visible in the header");
        }

        // Wait for and validate Help button
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(helpButton), 10);
        if (!driver.findElement(helpButton).isDisplayed()) {
            throw new AssertionError("Help button is not visible in the header");
        }

        // Wait for and validate FAQ link
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(faqLink), 10);
        if (!driver.findElement(faqLink).isDisplayed()) {
            throw new AssertionError("FAQ link is not visible in the header");
        }
    }
}

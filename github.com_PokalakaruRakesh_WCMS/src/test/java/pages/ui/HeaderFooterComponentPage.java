package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderFooterComponentPage extends BasePage {

    // Header Locators
    private By homeLink = By.linkText("Home");
    private By aboutASTMButton = By.xpath("//button[text()='About ASTM']");
    private By membershipParticipationButton = By.xpath("//button[text()='Membership & Participation']");
    private By standardsSolutionsButton = By.xpath("//button[text()='Standards & Solutions']");
    private By newsButton = By.xpath("//button[text()='News']");
    private By helpButton = By.xpath("//button[text()='Help']");
    private By faqLink = By.linkText("FAQ");
    private By closeSubmenuButton = By.xpath("//button[@data-testid='collapse-submenu-button']");

    // Footer Locators
    private By aboutASTMFooterLink = By.linkText("About ASTM");
    private By governanceLink = By.linkText("Governance");
    private By globalCooperationLink = By.linkText("Global Cooperation");
    private By corporateCitizenshipLink = By.linkText("Corporate Citizenship");
    private By historyLink = By.linkText("History");
    private By regionalOfficesAndWebsitesLink = By.linkText("Regional Offices and Websites");
    private By diversityEquityInclusionBelongingLink = By.linkText("Diversity, Equity, Inclusion & Belonging");
    private By cultureCareersLink = By.linkText("Culture & Careers");
    private By membershipParticipationFooterLink = By.linkText("Membership & Participation");
    private By standardsSolutionsFooterLink = By.linkText("Standards & Solutions");
    private By newsFooterLink = By.linkText("News");
    private By helpFooterLink = By.linkText("Help");
    private By policiesFooterLink = By.linkText("Policies");

    public HeaderFooterComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate header and footer components on the ASTM homepage")
    public void validateHeaderAndFooterComponents() {
        // Header validations
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(homeLink), 15);
        getElement(homeLink).isDisplayed();
        getElement(aboutASTMButton).isDisplayed();
        getElement(membershipParticipationButton).isDisplayed();
        getElement(standardsSolutionsButton).isDisplayed();
        getElement(newsButton).isDisplayed();
        getElement(helpButton).isDisplayed();
        getElement(faqLink).isDisplayed();

        // Optionally, click buttons and validate submenus if required
        // Example: getElement(aboutASTMButton).click();
        // getElement(closeSubmenuButton).click();

        // Footer validations
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(aboutASTMFooterLink), 15);
        getElement(aboutASTMFooterLink).isDisplayed();
        getElement(governanceLink).isDisplayed();
        getElement(globalCooperationLink).isDisplayed();
        getElement(corporateCitizenshipLink).isDisplayed();
        getElement(historyLink).isDisplayed();
        getElement(regionalOfficesAndWebsitesLink).isDisplayed();
        getElement(diversityEquityInclusionBelongingLink).isDisplayed();
        getElement(cultureCareersLink).isDisplayed();
        getElement(membershipParticipationFooterLink).isDisplayed();
        getElement(standardsSolutionsFooterLink).isDisplayed();
        getElement(newsFooterLink).isDisplayed();
        getElement(helpFooterLink).isDisplayed();
        getElement(policiesFooterLink).isDisplayed();
    }
}

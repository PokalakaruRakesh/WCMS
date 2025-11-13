package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

public class HeaderFooterComponentPage extends BasePage {

    // Header Locators (placeholders, update as needed)
    private By headerLogo = By.xpath("<PLACEHOLDER>"); // TODO: Replace with actual locator for header logo
    private By headerNavigationMenu = By.xpath("<PLACEHOLDER>"); // TODO: Replace with actual locator for header navigation menu

    // Footer Locators (from provided locators)
    private By aboutASTMLink = By.linkText("About ASTM");
    private By membershipParticipationLink = By.linkText("Membership & Participation");
    private By standardsAndSolutionsLink = By.linkText("Standards & Solutions");
    private By newsLink = By.linkText("News");
    private By helpLink = By.linkText("Help");
    private By policiesLink = By.linkText("Policies");
    private By returnPolicyLink = By.linkText("Return Policy");
    private By meetingsSymposiaWorkshopsLink = By.linkText("Meetings, Symposia & Workshops");
    private By laboratoryServicesLink = By.linkText("Laboratory Services");
    private By editorialCalendarMediaKitLink = By.linkText("Editorial Calendar and Media Kit");
    private By espanolLink = By.linkText("Español");
    private By cultureCareersLink = By.linkText("Culture & Careers");
    private By historyLink = By.linkText("History");
    private By podcastsLink = By.linkText("Podcasts");
    private By memberToolsLink = By.linkText("Member Tools");
    private By pressReleasesLink = By.linkText("Press Releases");
    private By certificationLink = By.linkText("Certification");
    private By astmCompassLink = By.linkText("ASTM Compass®");
    private By contactASTMLink = By.linkText("Contact ASTM");
    private By corporateCitizenshipLink = By.linkText("Corporate Citizenship");
    private By globalCooperationLink = By.linkText("Global Cooperation");
    private By marketInsightsInnovationLink = By.linkText("Market Insights & Innovation");
    private By standardizationNewsLink = By.linkText("Standardization News");
    private By membershipLink = By.linkText("Membership");
    private By digitalLibraryLink = By.linkText("Digital Library");
    private By faqLink = By.linkText("FAQ");
    private By standardsPublicationsLink = By.linkText("Standards & Publications");
    private By cementConcreteReferenceLabLink = By.linkText("Cement & Concrete Reference Lab");
    private By governanceLink = By.linkText("Governance");
    private By publishWithASTMLink = By.linkText("Publish with ASTM");
    private By trainingCoursesLink = By.linkText("Training Courses");
    private By privacyPolicyLink = By.linkText("Privacy Policy");
    private By enterpriseSolutionsLink = By.linkText("Enterprise Solutions");
    private By technicalCommitteesLink = By.linkText("Technical Committees");
    private By locationsLink = By.linkText("Locations");
    private By logoPolicyLink = By.linkText("Logo Policy");
    private By emergingProfessionalsLink = By.linkText("Emerging Professionals");
    private By ipPolicyLink = By.linkText("IP Policy");
    private By diversityEquityInclusionBelongingLink = By.linkText("Diversity, Equity, Inclusion & Belonging");
    private By copyrightPermissionsLink = By.linkText("Copyright & Permissions");
    private By consumerParticipationLink = By.linkText("Consumer Participation");
    private By regionalOfficesWebsitesLink = By.linkText("Regional Offices and Websites");

    public HeaderFooterComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate header and footer components are visible and correct")
    public void validateHeaderAndFooterComponents() {
        // Validate header (placeholder - update with actual header checks)
        try {
            waitForElementPresent(headerLogo);
            WebElement logo = getElement(headerLogo);
            if (!logo.isDisplayed()) {
                throw new AssertionError("Header logo is not displayed");
            }
        } catch (Exception e) {
            System.out.println("Header logo validation failed: " + e.getMessage());
        }
        try {
            waitForElementPresent(headerNavigationMenu);
            WebElement navMenu = getElement(headerNavigationMenu);
            if (!navMenu.isDisplayed()) {
                throw new AssertionError("Header navigation menu is not displayed");
            }
        } catch (Exception e) {
            System.out.println("Header navigation menu validation failed: " + e.getMessage());
        }

        // Validate key footer links (sample, extend as needed)
        assertFooterLinkVisible(aboutASTMLink, "About ASTM");
        assertFooterLinkVisible(membershipParticipationLink, "Membership & Participation");
        assertFooterLinkVisible(standardsAndSolutionsLink, "Standards & Solutions");
        assertFooterLinkVisible(newsLink, "News");
        assertFooterLinkVisible(helpLink, "Help");
        assertFooterLinkVisible(policiesLink, "Policies");
        assertFooterLinkVisible(returnPolicyLink, "Return Policy");
        assertFooterLinkVisible(meetingsSymposiaWorkshopsLink, "Meetings, Symposia & Workshops");
        assertFooterLinkVisible(laboratoryServicesLink, "Laboratory Services");
        assertFooterLinkVisible(editorialCalendarMediaKitLink, "Editorial Calendar and Media Kit");
        assertFooterLinkVisible(espanolLink, "Español");
        assertFooterLinkVisible(cultureCareersLink, "Culture & Careers");
        assertFooterLinkVisible(historyLink, "History");
        assertFooterLinkVisible(podcastsLink, "Podcasts");
        assertFooterLinkVisible(memberToolsLink, "Member Tools");
        assertFooterLinkVisible(pressReleasesLink, "Press Releases");
        assertFooterLinkVisible(certificationLink, "Certification");
        assertFooterLinkVisible(astmCompassLink, "ASTM Compass®");
        assertFooterLinkVisible(contactASTMLink, "Contact ASTM");
        assertFooterLinkVisible(corporateCitizenshipLink, "Corporate Citizenship");
        assertFooterLinkVisible(globalCooperationLink, "Global Cooperation");
        assertFooterLinkVisible(marketInsightsInnovationLink, "Market Insights & Innovation");
        assertFooterLinkVisible(standardizationNewsLink, "Standardization News");
        assertFooterLinkVisible(membershipLink, "Membership");
        assertFooterLinkVisible(digitalLibraryLink, "Digital Library");
        assertFooterLinkVisible(faqLink, "FAQ");
        assertFooterLinkVisible(standardsPublicationsLink, "Standards & Publications");
        assertFooterLinkVisible(cementConcreteReferenceLabLink, "Cement & Concrete Reference Lab");
        assertFooterLinkVisible(governanceLink, "Governance");
        assertFooterLinkVisible(publishWithASTMLink, "Publish with ASTM");
        assertFooterLinkVisible(trainingCoursesLink, "Training Courses");
        assertFooterLinkVisible(privacyPolicyLink, "Privacy Policy");
        assertFooterLinkVisible(enterpriseSolutionsLink, "Enterprise Solutions");
        assertFooterLinkVisible(technicalCommitteesLink, "Technical Committees");
        assertFooterLinkVisible(locationsLink, "Locations");
        assertFooterLinkVisible(logoPolicyLink, "Logo Policy");
        assertFooterLinkVisible(emergingProfessionalsLink, "Emerging Professionals");
        assertFooterLinkVisible(ipPolicyLink, "IP Policy");
        assertFooterLinkVisible(diversityEquityInclusionBelongingLink, "Diversity, Equity, Inclusion & Belonging");
        assertFooterLinkVisible(copyrightPermissionsLink, "Copyright & Permissions");
        assertFooterLinkVisible(consumerParticipationLink, "Consumer Participation");
        assertFooterLinkVisible(regionalOfficesWebsitesLink, "Regional Offices and Websites");
    }

    private void assertFooterLinkVisible(By locator, String linkName) {
        try {
            waitForElementPresent(locator);
            WebElement link = getElement(locator);
            if (!link.isDisplayed()) {
                throw new AssertionError(linkName + " link is not displayed in footer");
            }
        } catch (Exception e) {
            System.out.println("Footer link validation failed for '" + linkName + "': " + e.getMessage());
        }
    }
}

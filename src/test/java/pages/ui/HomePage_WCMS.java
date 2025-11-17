package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage_WCMS extends BasePage {

    public HomePage_WCMS(WebDriver driver) {
        super(driver);
    }

    public By learnMoreaboutAstm = By.xpath("//a[@title='Learn More About ASTM ']");
    // The Latest
    public By standardizationNewsLearnMore = By.xpath("//a[@href='/standardization-news' and text()='Learn More']");
    public By standardizationNewsGetDigitalEdition = By.xpath("//h6[contains(text(),'Standardization News')]/../../a[text()='Get Digital Edition']");
    public By standardImpactLearMore = By.xpath("//a[@href='https://standards-impact.buzzsprout.com/']");
    public By standardImpactListen = By.xpath("//h6[contains(text(),'Standards Impact')]/../../a[text()='Listen']");
    public By labManagerAcademyLearnMore = By.xpath("//div[contains(@class, 'ImageCards_imageCardsContainer')]//div[3]//a[1]");
    public By icam2024LearMore = By.xpath("//div[contains(@class,'ImageCards_imageCardsContainer')]//div[4]//a[1]");
    public By aboutAstmLearnMore = By.xpath("//a[@class='d-block mt-auto'][normalize-space()='Learn More About ASTM']");
    public By membershipAndPartnershipLearnMore = By.xpath("//a[normalize-space()='Learn More About Membership & Participation']");
    public By standardizationImpactReportLearnMore1 = By.xpath("(//h6[contains(text(),'Standardization Impact Report')]/../../a[text()='Learn More'])[1]");
    //Standards & Solutions
    public By astmCompassLearnMore = By.xpath("//a[contains(@title,'Learn More About ASTM Compass')]");
    public By annualBookLearnMore = By.xpath("//h6[text()='Annual Book of ASTM Standards']/../../a[@title='Learn More']");
    public By astmDigitalLearnMore = By.xpath("//h6[contains(text(),'ASTM Digital Library')]/../../a[@title='Learn More']");
    public By astmSpeacBuilderLearnMore = By.xpath("//h6[text()='ASTM SpecBuilder']/../../a[@title='Learn More']");
    // Working
    public By internationalStandardLearnMore = By.xpath("//h6[text()='International Standards']/../../a[@title='Learn More']");
    // Market Insights & Innovation
    public By astmXcellerateLearnMore = By.xpath("//a[@href='https://astmxcellerate.com/']");
    public By centersofExcellenceLearnMore = By.xpath("//a[contains(@href,'/standards-and-solutions/market-insights-and-innovation/innovation')]");
    public By standardizationImpactReportLearnMore = By.xpath("//h6[text()='Standardization Impact Report']/ancestor::div/a[text()='Learn More']");
    public By marketIntelligenceLearnMore = By.xpath("//a[contains(@href,'https://wohlersassociates.com/reports/')]");
    public By laboratoryServicesLearnMore = By.xpath("//a[contains(@title,'Learn More About Laboratory Services')]");
    public By trainingServicesLearnMore = By.xpath("//a[contains(@title,'Learn More About Training and Certification')]");
    public By globalCooperationLearnMore = By.xpath("//a[contains(@title,'Learn More About Global Cooperation')]");
    public By astmSubscription = By.xpath("//a[contains(@href,'astm-subscription')]");


    public By IPPolicy = By.xpath("//a[text()='IP Policy (PDF)']");
    public By AIPolicy = By.xpath("//a[text()='AI Policy']");
    public By UseOfAIQuestions = By.xpath("//a[text()='Submit a Use of AI Question']");
    public By LogoPolicy = By.xpath("//a[text()='Logo Policy']");
    public By LinkingPolicy = By.xpath("//a[text()='Linking Policy (PDF)']");
    public By PoliciesPrivacyPolicy = By.xpath("//h2[text()='Policies']/..//a[text()='Privacy Policy']");
    public By ReturnPolicy = By.xpath("//h2[text()='Policies']/..//a[text()='Return Policy']");
    public By VeteranPolicy = By.xpath("//a[@href='/policies/veteran-and-disabilities-policy' and @target='_self']");
    public By EqualEmploymentPolicy = By.xpath("//a[@href='/policies/equal-opportunity-policy' and @target='_self']");
    public By EmploymentLawPolicy = By.xpath("//a[text()='Equal Employment Opportunity is the Law']");
    public By PayTransparency = By.xpath("//a[text()='Pay Transparency - Nondiscrimination Provision']");
    public By EEOLaw = By.xpath("//a[contains(@href, 'OFCCP_EEO_Supplement_Final_JRF_QA_508c.pdf') and text()[contains(., 'EEO is the Law')]]");
    public By PolicyFAQ = By.xpath("//a[@href='/policies/tpt-faq' and @target='_self']");
    public By InstructorInterests = By.xpath("//a[@href='/policies/instructor-proprietary-interests' and @target='_self']");

    /**
     * Clicks on all buttons and links on the Home Page to validate their functionality.
     * This method iterates over all known clickable elements and clicks them one by one.
     * For elements not yet defined, placeholder locators are used and should be updated.
     *
     * Note: This method is intended for WM-317: Validate Home Page Functionality
     */
    public void validateAllButtonsAndLinks() {
        // Example: Click on Learn More About ASTM
        clickOnMethod(learnMoreaboutAstm);
        clickOnMethod(standardizationNewsLearnMore);
        clickOnMethod(standardizationNewsGetDigitalEdition);
        clickOnMethod(standardImpactLearMore);
        clickOnMethod(standardImpactListen);
        clickOnMethod(labManagerAcademyLearnMore);
        clickOnMethod(icam2024LearMore);
        clickOnMethod(aboutAstmLearnMore);
        clickOnMethod(membershipAndPartnershipLearnMore);
        clickOnMethod(standardizationImpactReportLearnMore1);
        clickOnMethod(astmCompassLearnMore);
        clickOnMethod(annualBookLearnMore);
        clickOnMethod(astmDigitalLearnMore);
        clickOnMethod(astmSpeacBuilderLearnMore);
        clickOnMethod(internationalStandardLearnMore);
        clickOnMethod(astmXcellerateLearnMore);
        clickOnMethod(centersofExcellenceLearnMore);
        clickOnMethod(standardizationImpactReportLearnMore);
        clickOnMethod(marketIntelligenceLearnMore);
        clickOnMethod(laboratoryServicesLearnMore);
        clickOnMethod(trainingServicesLearnMore);
        clickOnMethod(globalCooperationLearnMore);
        clickOnMethod(astmSubscription);
        clickOnMethod(IPPolicy);
        clickOnMethod(AIPolicy);
        clickOnMethod(UseOfAIQuestions);
        clickOnMethod(LogoPolicy);
        clickOnMethod(LinkingPolicy);
        clickOnMethod(PoliciesPrivacyPolicy);
        clickOnMethod(ReturnPolicy);
        clickOnMethod(VeteranPolicy);
        clickOnMethod(EqualEmploymentPolicy);
        clickOnMethod(EmploymentLawPolicy);
        clickOnMethod(PayTransparency);
        clickOnMethod(EEOLaw);
        clickOnMethod(PolicyFAQ);
        clickOnMethod(InstructorInterests);
        // TODO: Add more clicks for any additional buttons/links as needed
        // For placeholder locators:
        // clickOnMethod(placeholderButton1);
        // clickOnMethod(placeholderLink2);
    }

    // Example placeholder locators for missing elements (replace with actual locators)
    private By placeholderButton1 = By.id("PLACEHOLDER_button1"); // TODO: Replace with actual locator
    private By placeholderLink2 = By.xpath("//a[@id='PLACEHOLDER_link2']"); // TODO: Replace with actual locator

    /**
     * Clicks a button or link by its visible text. Useful for generic validation.
     * @param linkText The visible text of the button or link
     */
    public void clickButtonOrLinkByText(String linkText) {
        By locator = By.xpath("//a[normalize-space(text())='" + linkText + "'] | //button[normalize-space(text())='" + linkText + "']");
        clickOnMethod(locator);
    }

    /**
     * Verifies if a button or link is present and enabled on the Home Page.
     * @param locator The By locator of the element
     * @return true if present and enabled, false otherwise
     */
    public boolean isButtonOrLinkPresentAndEnabled(By locator) {
        try {
            waitForElementPresent(locator);
            return getElement(locator).isDisplayed() && getElement(locator).isEnabled();
        } catch (Exception e) {
            log.info("Element not present or not enabled: " + locator.toString());
            return false;
        }
    }

    /**
     * Validates that all critical buttons and links are present and enabled on the Home Page.
     * Throws AssertionError if any are missing or disabled.
     */
    public void validateAllCriticalButtonsAndLinksPresent() {
        assert isButtonOrLinkPresentAndEnabled(learnMoreaboutAstm) : "Learn More About ASTM link is missing or disabled";
        assert isButtonOrLinkPresentAndEnabled(standardizationNewsLearnMore) : "Standardization News Learn More link is missing or disabled";
        assert isButtonOrLinkPresentAndEnabled(standardizationNewsGetDigitalEdition) : "Standardization News Get Digital Edition link is missing or disabled";
        // ...repeat for all other critical elements
        // For placeholder locators:
        // assert isButtonOrLinkPresentAndEnabled(placeholderButton1) : "Placeholder Button 1 is missing or disabled";
    }

}
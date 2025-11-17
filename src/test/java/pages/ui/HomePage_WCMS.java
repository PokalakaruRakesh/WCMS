package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

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
     * Comprehensive method to validate the functionality and accessibility of all links and buttons on the home page.
     * This method iterates through all defined clickable elements (links/buttons), clicks each, verifies navigation,
     * and navigates back to the home page, as per WM-317 test case.
     *
     * @param expectedLinksWithTitles An array of objects containing locator, expected URL, and expected title for each link/button.
     */
    public void validateAllHomePageLinksAndButtons(List<LinkValidationData> expectedLinksWithTitles) {
        for (LinkValidationData linkData : expectedLinksWithTitles) {
            try {
                // Wait for element to be present
                waitForElementPresent(linkData.getLocator());
                // Scroll into view and click
                clickOnMethod(linkData.getLocator());
                // Optionally: handle new tab/window if required
                // Validate URL and/or title
                if (linkData.isOpensInNewTab()) {
                    String originalWindow = driver.getWindowHandle();
                    for (String windowHandle : driver.getWindowHandles()) {
                        if (!windowHandle.equals(originalWindow)) {
                            driver.switchTo().window(windowHandle);
                            break;
                        }
                    }
                    if (linkData.getExpectedUrl() != null && !linkData.getExpectedUrl().isEmpty()) {
                        if (!driver.getCurrentUrl().contains(linkData.getExpectedUrl())) {
                            throw new AssertionError("URL mismatch for link: " + linkData.getElementName());
                        }
                    }
                    if (linkData.getExpectedTitle() != null && !linkData.getExpectedTitle().isEmpty()) {
                        if (!driver.getTitle().contains(linkData.getExpectedTitle())) {
                            throw new AssertionError("Title mismatch for link: " + linkData.getElementName());
                        }
                    }
                    driver.close();
                    driver.switchTo().window(originalWindow);
                } else {
                    if (linkData.getExpectedUrl() != null && !linkData.getExpectedUrl().isEmpty()) {
                        if (!driver.getCurrentUrl().contains(linkData.getExpectedUrl())) {
                            throw new AssertionError("URL mismatch for link: " + linkData.getElementName());
                        }
                    }
                    if (linkData.getExpectedTitle() != null && !linkData.getExpectedTitle().isEmpty()) {
                        if (!driver.getTitle().contains(linkData.getExpectedTitle())) {
                            throw new AssertionError("Title mismatch for link: " + linkData.getElementName());
                        }
                    }
                    driver.navigate().back();
                }
            } catch (Exception e) {
                throw new AssertionError("Validation failed for link/button: " + linkData.getElementName() + "\n" + e.getMessage(), e);
            }
        }
    }

    /**
     * Data class to represent link/button validation data for home page links/buttons.
     * Should be defined as a static inner class or as a top-level class in the same package.
     */
    public static class LinkValidationData {
        private By locator;
        private String expectedUrl;
        private String expectedTitle;
        private String elementName;
        private boolean opensInNewTab;

        public LinkValidationData(By locator, String expectedUrl, String expectedTitle, String elementName, boolean opensInNewTab) {
            this.locator = locator;
            this.expectedUrl = expectedUrl;
            this.expectedTitle = expectedTitle;
            this.elementName = elementName;
            this.opensInNewTab = opensInNewTab;
        }

        public By getLocator() {
            return locator;
        }
        public String getExpectedUrl() {
            return expectedUrl;
        }
        public String getExpectedTitle() {
            return expectedTitle;
        }
        public String getElementName() {
            return elementName;
        }
        public boolean isOpensInNewTab() {
            return opensInNewTab;
        }
    }
}
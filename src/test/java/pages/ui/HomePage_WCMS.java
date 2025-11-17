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
     * Comprehensive method to validate that all main navigation buttons and links on the home page are working correctly.
     * This method is designed for the test case: WM-317 - Validate Home Page Functionality.
     * It sequentially clicks each main button/link and verifies navigation or visibility as appropriate.
     *
     * NOTE: This method assumes the driver is already on the home page.
     * It uses existing locators and click/wait patterns from BasePage.
     */
    public void validateAllHomePageButtonsAndLinks() {
        // Validate 'Home' navigation link
        clickOnMethod(By.xpath("//a[@href='/' and text()='Home']"));
        waitForPageTitle("Home");

        // Validate 'About' dropdown button
        clickOnMethod(By.xpath("//button[@title='About']"));
        // Optionally, verify dropdown appears (placeholder, as dropdown content locator is not specified)
        // waitForElementPresent(By.xpath("<PLACEHOLDER_AboutDropdownContent>"));

        // Validate 'Standards' dropdown button
        clickOnMethod(By.xpath("//button[@title='Standards']"));
        // waitForElementPresent(By.xpath("<PLACEHOLDER_StandardsDropdownContent>"));

        // Validate 'Technology' dropdown button
        clickOnMethod(By.xpath("//button[@title='Technology']"));
        // waitForElementPresent(By.xpath("<PLACEHOLDER_TechnologyDropdownContent>"));

        // Validate 'Laboratory Services' dropdown button
        clickOnMethod(By.xpath("//button[@title='Laboratory Services']"));
        // waitForElementPresent(By.xpath("<PLACEHOLDER_LabServicesDropdownContent>"));

        // Validate 'Solutions' dropdown button
        clickOnMethod(By.xpath("//button[@title='Solutions']"));
        // waitForElementPresent(By.xpath("<PLACEHOLDER_SolutionsDropdownContent>"));

        // Validate 'Industry' dropdown button
        clickOnMethod(By.xpath("//button[@title='Industry']"));
        // waitForElementPresent(By.xpath("<PLACEHOLDER_IndustryDropdownContent>"));

        // Validate 'Training' dropdown button
        clickOnMethod(By.xpath("//button[@title='Training']"));
        // waitForElementPresent(By.xpath("<PLACEHOLDER_TrainingDropdownContent>"));

        // Validate 'Contact Us' button in header
        clickOnMethod(By.xpath("//a[@href='/contact-us']"));
        waitForPageTitle("Contact Us");
        driver.navigate().back();
        waitForPageTitle("Home");

        // Validate 'Return to astm.org' link (opens in new tab)
        String originalWindow = driver.getWindowHandle();
        clickOnMethod(By.xpath("//a[@href='https://astm.org']"));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Optionally, verify new tab title or URL
        // waitForPageTitle("ASTM International");
        driver.close();
        driver.switchTo().window(originalWindow);
        waitForPageTitle("Home");

        // Validate 'Students & Technical Inquiries' link (opens in new tab)
        clickOnMethod(By.xpath("//a[@href='/global-cooperation/contact-global-cooperation']"));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // waitForPageTitle("Students & Technical Inquiries");
        driver.close();
        driver.switchTo().window(originalWindow);
        waitForPageTitle("Home");

        // Validate language selector buttons (EN, ES, PT, JA, KO, ZH)
        clickOnMethod(By.xpath("//button[@aria-label='Switch to EN']"));
        clickOnMethod(By.xpath("//button[@aria-label='Switch to ES']"));
        clickOnMethod(By.xpath("//button[@aria-label='Switch to PT']"));
        clickOnMethod(By.xpath("//button[@aria-label='Switch to JA']"));
        clickOnMethod(By.xpath("//button[@aria-label='Switch to KO']"));
        clickOnMethod(By.xpath("//button[@aria-label='Switch to ZH']"));

        // Validate 'UNE EN-ISO Standards' card 'Learn More' link
        clickOnMethod(By.xpath("//a[@href='/standards/une-aenor/']"));
        waitForPageTitle("UNE EN-ISO Standards");
        driver.navigate().back();
        waitForPageTitle("Home");

        // Validate 'ASTM Diesel Fuel #2 Training Program' card 'Learn More' link
        clickOnMethod(By.xpath("//a[@href='/training/diesel-2/']"));
        waitForPageTitle("ASTM Diesel Fuel #2 Training Program");
        driver.navigate().back();
        waitForPageTitle("Home");

        // Validate 'ASTM Medical & Surgical Devices' card 'Learn More' link
        clickOnMethod(By.xpath("//a[@href='/industry/medical-device/']"));
        waitForPageTitle("ASTM Medical & Surgical Devices");
        driver.navigate().back();
        waitForPageTitle("Home");
    }

}
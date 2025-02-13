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
    public By standardImpactLearMore = By.xpath("//a[@href='https://standards-impact.buzzsprout.com/']");
    public By labManagerAcademyLearnMore = By.xpath("//div[contains(@class, 'ImageCards_imageCardsContainer')]//div[3]//a[1]");
    public By icam2024LearMore = By.xpath("//div[contains(@class,'ImageCards_imageCardsContainer')]//div[4]//a[1]");
    public By aboutAstmLearnMore = By.xpath("//a[@class='d-block mt-auto'][normalize-space()='Learn More About ASTM']");
    public By membershipAndPartnershipLearnMore = By.xpath("//a[normalize-space()='Learn More About Membership & Participation']");
    //Standards & Solutions
    public By astmCompassLearnMore = By.xpath("//a[contains(@title,'Learn More About ASTM Compass')]");
    public By annualBookLearnMore = By.xpath("//h6[text()='Annual Book of ASTM Standards']/../../a[@title='Learn More']");
    public By astmDigitalLearnMore = By.xpath("//h6[text()='ASTM Digital Library on Silver chair']/../../a[@title='Learn More']");
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
}










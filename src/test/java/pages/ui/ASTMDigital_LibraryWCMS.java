package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ASTMDigital_LibraryWCMS extends BasePage {
    public ASTMDigital_LibraryWCMS(WebDriver driver) {
        super(driver);
    }
    public By ASMEDigitalCollection = By.xpath("//a[normalize-space()='ASME Digital Collection']");
    public By AutherLearnMore = By.xpath("//h4[text()='Authors']/following-sibling::div/a[text()='Learn More']");
    public By DiscoverASTMCompass = By.xpath("//a[@title='Discover ASTM Compass']");
    public By ContactUs = By.xpath("//a[@title='Contact Us']");
    //Content Overview
    public By PeerReviewedLearnMore = By.xpath("//h6[text()='Peer-Reviewed Symposia Papers and Conference Proceedings']/ancestor::div/a[text()='Learn More']");
    public By ManualsMonographsLearnMore = By.xpath("//h6[text()='Manuals, Monographs, & Data Series']/ancestor::div/a[text()='Learn More']");
    public By JournalsLearnMore = By.xpath("//h6[text()='Journals']/ancestor::div/a[text()='Learn More']");
    public By TechnicalReportsLearnMore = By.xpath("//h6[contains(text(),'Technical Reports')]/ancestor::div/a[text()='Learn More']");
    //a[@href='/membership-participation/technical-committees/interlaboratory-studies-program']
    public By InterlaboratoryStudyProgram = By.xpath("//h6[contains(text(),'Technical Reports')]/ancestor::div/a[text()='Learn More']");
    public By RegisterForNewILSProgram = By.xpath("//a[text()='Register for a New ILS Program']");
    public By ActiveILSProgramList = By.xpath("//a[text()='Active ILS Program List']");
    public By  FAQs= By.xpath("//a[text()='FAQs']");
    public By  Contact= By.xpath("//a[text()='Contact']");
    public By  SectionA21= By.xpath("//a[text()='Section A.21']");
    public By  RuggednessTesting= By.xpath("//a[text()='Ruggedness Testing;']");
    public By  PilotTesting= By.xpath("//a[text()='Pilot Testing']");
    public By  PrecisionBiasTemplate= By.xpath("//a[text()='Precision and Bias Template']");
    public By  RepeatabilityPrecisionTemplate= By.xpath("//a[text()='Repeatability Precision Template']");
    public By  ASTMFormAndStyleManual= By.xpath("//a[text()='ASTM Form and Style Manual']");
    public By  Contactus= By.xpath("//a[text()='Contact us']");
    public By  DownloadResearchReportTemplate= By.xpath("//a[contains(text(),'Download Research Report Template')]");
    public By  submitToOurILSTeam= By.xpath("//a[contains(text(),'submit to our ILS team')]");
    public By  ContactASTM= By.xpath("//a[text()='Contact ASTM']");
    public By  InterlaboratoryStudiesProgram= By.xpath("//a[text()='Download the infographic: Interlaboratory Studies Program']");
}

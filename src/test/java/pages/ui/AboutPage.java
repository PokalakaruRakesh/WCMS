package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AboutPage extends BasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getLearnMoreLinksUnderTiles(String section){
        return driver.findElements(By.xpath("//h4[text()='"+section+"']/../div//a[text()='Learn More']"));
    }
    public By viewOpenOpportunitiesLink = By.xpath("//a[@title='VIEW OPEN OPPORTUNITIES']");
    public By CultureCareersLearnMoreLink = By.xpath("//*[text()='Culture and Careers']/../../following::a[text()='Learn More']");
    public By interactiveTimelineLink = By.xpath("//a[@href='/about/history']");
    public By viewBtnUnderHistory = By.xpath("//h4[text()='History']/..//a[contains(@title,'View')]");
    public By learnMoreBtnUnderGlobalCooperation = By.xpath("//h4[text()='Global Cooperation']/../a[text()='Learn More']");

    public By viewBtnUnderGovernance= By.xpath("//h4[text()='Governance']/..//a[@title='View']");
    public By governanceBoardOfdirectors= By.xpath("//h4[text()='Governance']/../div//a[text()='Learn More']");

    public By videoLink = By.xpath("(//iframe[@title='Video'])[1]");
    public WebElement getVideoLink(){
        return  driver.findElement(videoLink);
    }

    public By Over12000ASTMStandards  = By.xpath("//a[text()='over 12,000 ASTM standards']");
    public By WelcomeEncourageParticipation  = By.xpath("//a[text()='welcome and encourage participation']");
    public By ThroughMoreThan140Technical  = By.xpath("//a[text()='Through more than 140 technical standards-writing committees']");
    public By ASTMStandardsOverview  = By.xpath("//a[text()='ASTM standards']");
    public By GuidingPrinciples  = By.xpath("//a[text()='guiding principles of the World Trade Organization']");
    public By CertificationAndDeclaration  = By.xpath("//a[text()='certification and declaration']");
    public By EquipmentInstitute  = By.xpath("//a[text()='through our subsidiary, the Safety Equipment Institute']");
    public By TechnicalTrainingPrograms  = By.xpath("//a[text()='through our subsidiary, the Safety Equipment Institute']");
    public By ProficiencyTesting  = By.xpath("//a[text()='proficiency testing']");

    public By HelpingOurWorld = By.xpath("//a[contains(text(),'Download ASTM')]");

    public By TVGPApplication = By.xpath("//a[text()='Download the TVGP Application (PDF)']");
    public By GetInTouchEmail = By.xpath("//a[text()='Contact Global Cooperation']");

    public By OECDCaseStudy = By.xpath("//a[text()='Download the OECD Case Study (PDF)']");
    public By APEC = By.xpath("//a[text()='Asia-Pacific Economic Cooperation (APEC)']");
    public By IFC = By.xpath("//a[text()='International Finance Corporation (IFC)']");
    public By MCC = By.xpath("//a[text()='Millennium Challenge Corporation (MCC)']");
    public By StandarsAlliance = By.xpath("//a[text()='Standards Alliance']");
    public By UnitedNationsUN = By.xpath("//a[text()='United Nations (UN)']");
    public By PPECollaboration = By.xpath("//a[contains(text(),'PPE Collaboration')]");




}

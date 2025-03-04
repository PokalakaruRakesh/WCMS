package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaboratoryServices_WCMS extends BasePage {
    public LaboratoryServices_WCMS(WebDriver driver) {
        super(driver);
    }
    public static By videolink=By.xpath("//a[text()='ASTM International Laboratory Services']']");
    public static WebElement getVideoLink(){
        return  driver.findElement(videolink);
    }
    public By LaboratoryServicesOverview= By.xpath("//a[@title='Laboratory Services Overview']");
    public By OnDemandWebinar= By.xpath("//a[@title='OnDemand Webinar']");
    public By SubscribeNewsletter= By.xpath("//a[@title='Subscribe to Newsletter']");
    public By Contact= By.xpath("//a[@title='Contact']");
    public By ProficiencyTestingLearnMore= By.xpath("//h3[text()='Proficiency Testing Program']/../..//a[text()='Learn More']");
    public By ReferenceMaterialsLearnMore= By.xpath("//h2[text()='Reference Materials']/../..//a[text()='Learn More']");
    public By ContactUs= By.xpath("(//a[text()='Contact Us'])");
    public By ASTMInsightSQC= By.xpath("(//a[@title='Learn More' and @href='/standards-and-solutions/laboratory-services/astm-insight-sqc'])");
    public By StandardOperatingProcedures= By.xpath("//a[@title='Learn More' and @href='/standards-and-solutions/laboratory-services/standard-operating-procedures-sop']");
    public By AssessmentChecklists= By.xpath("(//a[@href='/standards-and-solutions/laboratory-services/test-method-assessment-checklists-tma'])[2]");
    public By CementConcreteReferenceLaboratory= By.xpath("//a[@title='Learn More' and @href='http://www.ccrl.us/']");
    public By DevelopInternalDocuments= By.xpath("(//a[@title='Learn More'])[7]");
    public By GetStandardsOnline= By.xpath("(//a[@title='Learn More'])[8]");
    public By TrainWithExperts= By.xpath("(//a[@title='Learn More'])[9]");
    public By videoLink1 = By.xpath("(//img[contains(@alt,'Video')])[2]");
    public By SOPsLearnMoreLink = By.xpath("//h6[contains(text(),'Standard Operating Procedures')]/../../a[text()='Learn More']");
    public By ViewReferenceMaterials = By.xpath("//a[text()='View Reference Materials']");
    public By ReferenceMaterialsCatalog = By.xpath("//a[text()='Reference Materials Catalog (PDF)']");
    public By ContactSales = By.xpath("(//a[text()='Contact Sales'])[1]");
    public By LaboratoryServicesOverviewPDF = By.xpath("//a[text()='Laboratory Services Overview (PDF)']");
    public By AccessNewASTMStandardContactSalesLink = By.xpath("//h2[contains(text(),'Access new ASTM Standard')]/../..//a[text()='Contact Sales']");

    public WebElement getVideoLink1() {
        return driver.findElement(videoLink1);
    }

}

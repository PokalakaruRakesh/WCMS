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
    public By ProficiencyTestingLearnMore= By.xpath("(//a[@data-testid='button-content-box-cta-button-0'])[1]");
    public By ReferenceMaterialsLearnMore= By.xpath("(//a[@data-testid='button-content-box-cta-button-0'])[2]");
    public By ContactUs= By.xpath("(//a[text()='Contact Us'])");
    public By ASTMInsightSQC= By.xpath("(//a[@title='Learn More' and @href='/standards-and-solutions/laboratory-services/astm-insight-sqc'])");
    public By StandardOperatingProcedures= By.xpath("//a[@title='Learn More' and @href='/standards-and-solutions/laboratory-services/standard-operating-procedures-sop']");
    public By AssessmentChecklists= By.xpath("//a[@href='/standards-and-solutions/laboratory-services/test-method-assessment-checklists-tma']");
    public By CementConcreteReferenceLaboratory= By.xpath("//a[@title='Learn More' and @href='http://www.ccrl.us/']");
    public By DevelopInternalDocuments= By.xpath("(//a[@title='Learn More'])[7]");
    public By GetStandardsOnline= By.xpath("(//a[@title='Learn More'])[8]");
    public By TrainWithExperts= By.xpath("(//a[@title='Learn More'])[9]");

}

package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainingByIndustryWCMS extends BasePage{
    public TrainingByIndustryWCMS(WebDriver driver) {
        super(driver);
    }
    public By TrainWholeTeam= By.xpath("//a[@title='Train Your Whole Team']");
    public By EBook= By.xpath("//a[@title='eBook: Expertly Driven Training']");
    public By LearningSupportFAQs= By.xpath("//a[normalize-space()='Learning Support & FAQs']");
    public By LabManagerAcademy= By.xpath("//a[normalize-space()='Learn more']");
    //Industry Links
    public By AdditiveManufacturing= By.xpath("//a[normalize-space()='Additive Manufacturing']");
    public By BuildingConstruction= By.xpath("//a[normalize-space()='Building & Construction']");
    public By Cannabis= By.xpath("//a[normalize-space()='Cannabis']");
    public By Coal= By.xpath("//a[normalize-space()='Coal']");
    public By Corrosion= By.xpath("//a[normalize-space()='Corrosion']");
    public By D4057Sampling= By.xpath("//a[normalize-space()='D4057 Sampling']");
    public By EmergingTechnologies= By.xpath("//a[normalize-space()='Emerging Technologies']");
    public By Energy= By.xpath("//a[normalize-space()='Energy (Petroleum)']");
    public By Environment= By.xpath("//a[normalize-space()='Environment']");
    public By LabFieldFundamentals= By.xpath("//a[normalize-space()='Lab & Field Fundamentals']");
    public By LightSportAircraft= By.xpath("//a[normalize-space()='Light Sport Aircraft']");
    public By LPG= By.xpath("//a[normalize-space()='LPG']");
    public By Metals= By.xpath("//a[normalize-space()='Metals']");
    public By Oxygen= By.xpath("//a[normalize-space()='Oxygen']");
    public By Plastics= By.xpath("//a[normalize-space()='Plastics']");
    public By Rubber= By.xpath("//a[normalize-space()='Rubber']");
    public By Statistics= By.xpath("//a[normalize-space()='Statistics']");
    public By Textiles= By.xpath("//a[normalize-space()='Textiles']");

    public By ViewTrainingCatalog= By.xpath("//a[contains(@title, 'View Training Catalog')]");
    public By BecomeSponsor= By.xpath("//a[@title='Become a sponsor']");
    public By Accreditations= By.xpath("//h6[contains(text(),'Accreditations')]/ancestor::div/a[text()='Learn More']");
    public By accreditationsContactUs= By.xpath("//h4[text()='ASTM Training and eLearning Accreditations']/..//a[text()='Contact Us']");
    public By DigitalBadging= By.xpath("//h6[contains(text(),'Digital Badging for eLearning')]/ancestor::div/a[text()='Learn More']");
    public By ContinuingEducation= By.xpath("//h6[contains(text(),'Continuing Education – Professional Engineers')]/ancestor::div/a[text()='Learn More']");
    public By Credentialing= By.xpath("//h6[contains(text(),'Credentialing Program Registry')]/ancestor::div/a[text()='Learn More']");



}

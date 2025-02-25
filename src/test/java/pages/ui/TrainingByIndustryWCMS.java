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


    public By TrainYour= By.xpath("//h6[contains(text(),'Train Your')]/..//a[text()='Contact Us']");
    public By TheArtPerfectAnalysis= By.xpath("//a[text()='The Art of Perfect Analysis']");
    public By PrecisionAndBias= By.xpath("//a[text()='Precision and Bias']");
    public By TripsSlips= By.xpath("//a[contains(text(),'Trips, Slips')]");
    public By PreMathBasics= By.xpath("//a[text()='Pre-Math Basics']");
    public By MathBasicsAsphalt= By.xpath("//a[text()='Math Basics for Asphalt']");
    public By MathBasicsConcrete= By.xpath("//a[text()='Math Basics for Concrete']");
    public By StrengthTesting= By.xpath("//a[text()='Math Basics for Concrete Strength Testing']");
    public By MathBasicsSoil= By.xpath("//a[text()='Math Basics for Soils']");
    public By QualityManagement= By.xpath("//a[text()='Quality Management 101 Series']");
    public By GeneralIndustry= By.xpath("//a[text()='My Virtual Safety Trainer for General Industry']");
    public By TrainerForConstruction= By.xpath("//a[text()='My Virtual Safety Trainer for Construction']");

    public By LabManagementCertificate= By.xpath("//a[contains(text(),'Lab Management Certificate')]");
    public By HowManageLabStaff= By.xpath("//a[contains(text(),'How to Manage Lab Staff')]");
    public By BetterLabLeader= By.xpath("//a[contains(text(),'How to Be a Better Lab Leader')]");
    public By LabOperations= By.xpath("//a[contains(text(),'Lab Operations')]");
    public By LabManagement= By.xpath("//a[contains(text(),'How to Improve Lab Management')]");
    public By TrainYourWholeTeam= By.xpath("//h4[contains(text(),'Train Your')]/..//a[text()='Contact Us']");



}

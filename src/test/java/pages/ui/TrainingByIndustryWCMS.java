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

    public By RubberContactUs = By.xpath("(//a[@title='Contact Us'])[1]");
    public By RubberTraining = By.xpath("//a[text()='Live Training']");
    public By RubberContactUs2 = By.xpath("(//a[@title='Contact Us'])[2]");

    public By CoalContactUs = By.xpath("(//a[@title='Contact Us'])[1]");
    public By CoalTraining = By.xpath("//a[text()='Coal Chemistry Technician Training']");
    public By CoalContactUs2 = By.xpath("(//a[@title='Contact Us'])[2]");

    public By AirCraftContactUs = By.xpath("(//a[@title='Contact Us'])[1]");
    public By AirCraftTraining = By.xpath("");
    public By AirCraftContactUs2 = By.xpath("(//a[@title='Contact Us'])[2]");

    public By TextilesContactUs = By.xpath("(//a[text()='Contact Us'])[1]");
    public By TextileStandards = By.xpath("//a[contains(text(), 'ASTM Textile Standards for Yarns and Sewing Threads')]");
    public By ChildrenSleepwear = By.xpath("(//a[contains(text(), \"Flammability of Children's Sleepwear\")])[1]");
    public By UpholsteredFurniture = By.xpath("//a[contains(text(), \"Flammability of Upholstered Furniture\")]");
    public By WearingApparel = By.xpath("//a[contains(text(),'Flammability of Wearing Apparel')]");
    public By QualityPerformanceStandards = By.xpath("//a[contains(text(),'Textiles: Quality and Performance Standards')]");
    public By TextilesContactUs2 = By.xpath("(//a[text()='Contact Us'])[2]");

    public By PlasticsContactUs = By.xpath("(//a[@title='Contact Us'])[1]");
    public By SustainableMaterials = By.xpath("//a[contains(text(),'Sustainable Materials') and contains(text(),'Biodegradability')]");
    public By MajorTestingTechniques = By.xpath("//a[contains(text(),'Major Testing Techniques for Plastics')]");
    public By TestingPlasticsBasics = By.xpath("//a[contains(text(),'The Basics of Testing Plastics')]");
    public By PlasticsContactUs2 = By.xpath("(//a[@title='Contact Us'])[2]");

    public By OxygenContactUs = By.xpath("(//a[@title='Contact Us'])[1]");
    public By FireHazardslive = By.xpath("(//h4[text()='Training available Live or OnDemand:']/following::a[text()='Live Training'])[1]");
    public By FireHazardsELearning = By.xpath("(//a[text()='eLearning'])[1]");
    public By OxygenSystemLive = By.xpath("(//h4[text()='Training available Live or OnDemand:']/following::a[text()='Live Training'])[2]");
    public By OxygenSystemELearning = By.xpath("(//a[text()='eLearning'])[2]");
    public By OxygenContactUs2 = By.xpath("(//a[@title='Contact Us'])[2]");


    public By StatisticsContactUs = By.xpath("(//a[@title='Contact Us'])[1]");
    public By CoursesLivetraining = By.xpath("(//h4[text()='Courses available Live or OnDemand:']/following::a[text()='Live Training'])[1]");
    public By CoursesElearning = By.xpath("(//h4[text()='Courses available Live or OnDemand:']/following::a[text()='eLearning'])[1]");
    public By UnderstandLiveTraining = By.xpath("(//h4[text()='Courses available Live or OnDemand:']/following::a[text()='Live Training'])[2]");
    public By UnderstandElearning = By.xpath("(//h4[text()='Courses available Live or OnDemand:']/following::a[text()='eLearning'])[2]");
    public By Webinar = By.xpath("(//a[contains(text(), 'Ordinary Linear Regression')])");
    public By ArtOfPerfectAnalysis = By.xpath("(//a[contains(text(), 'The Art of Perfect Analysis')])[1]");
    public By Precisionbias = By.xpath("(//a[contains(text(), 'Precision and Bias')])[1]");
    public By StatisticsContactUs2 = By.xpath("(//a[@title='Contact Us'])[2]");

    public By ProfessionalEngineer = By.xpath("//a[@title='Learn More' and contains(@href, '/training-courses/pe-continuing-education')]");
    public By ContactUsProfessionalEng = By.xpath("//a[contains(text(), 'Contact us')]");
    public By Certificate = By.xpath("//a[contains(text(), 'Click here for the ASTM Certificate of Attendance')]");
    public By SubscriptionHere = By.xpath("//a[text()='here']");

    public By CorrosionContactUs = By.xpath("(//a[@title='Contact Us'])[1]");
    public By ApplicationASTMB117 = By.xpath("//a[contains(text(),'Understanding and Application of ASTM B117')]");
    public By ElectrochemicalTechniques = By.xpath("//a[contains(text(),'Corrosion Testing, Measurement, and Monitoring')]");
    public By CorrosionInhibitors = By.xpath("//a[contains(text(),'Corrosion Inhibitors for Oil and Gas Industry')]");
    public By B117StandardPractice = By.xpath("//a[contains(text(),'ASTM B117 Standard Practice')]");
    public By G85StandardPractice = By.xpath("//a[contains(text(),'ASTM G85 Standard Practice')]");
    public By ModuloLearningPara = By.xpath("//a[contains(text(),'Modulo eLearning para ASTM B117')]");
    public By CorrosionContactUs2 = By.xpath("(//a[@title='Contact Us'])[2]");

    public By EmergingContactUs = By.xpath("(//a[@title='Contact Us'])[1]");
    public By WebinarOnDemand = By.xpath("//a[contains(text(),'Applications for Exoskeletons Webinar')]");
    public By ExoskeletonPPEInterface = By.xpath("//a[contains(text(),'Exoskeleton and PPE Interface Challenges')]");
    public By DataManagementProgram = By.xpath("//a[contains(text(),'Additive Manufacturing Data Management')]");
    public By DesignProgram = By.xpath("//a[contains(text(),'Additive Manufacturing Design Program')]");
    public By ProcessesProgram = By.xpath("//a[contains(text(),'Additive Manufacturing Processes Program')]");
    public By MetalsProgram = By.xpath("//a[contains(text(),'Additive Manufacturing with Metals Program')]");
    public By BedFusionProgram = By.xpath("//a[contains(text(),'Additive Manufacturing Laser Powder Bed Fusion Program')]");
    public By SafetyCertificate = By.xpath("//a[contains(text(),'Additive Manufacturing Safety Certificate Course')]");
    public By TestingProgram = By.xpath("//a[contains(text(),'Additive Manufacturing Testing Program')]");
    public By AdditiveCertification = By.xpath("//a[contains(text(),'Additive Manufacturing Qualification')]");
    public By ManufacturingELearning = By.xpath("//a[contains(text(),'Principles of Additive Manufacturing')]");
    public By WordWebinarOnDemand = By.xpath("//a[contains(@href, 'astm-tpt-817')]");
    public By AutonomyDesign = By.xpath("//a[contains(text(),'Autonomy Design and Operations in Aviation')]");
    public By DevelopmentalPillars = By.xpath("//a[contains(text(),'Developmental Pillars of Increased Autonomy')]");
    public By F3586Remote = By.xpath("//a[contains(text(),'How to Use ASTM F3586 Remote ID Means of Compliance')]");
    public By EmergingContactUs2 = By.xpath("(//a[@title='Contact Us'])[2]");







    public By PerformanceGrading= By.xpath("//h4[contains(text(),'Live Courses')]/..//a[contains(text(),'ASTM/ACES Performance Grading')]");
    public By BrownfieldsRedevelopment= By.xpath("//a[contains(text(),'Brownfields Redevelopment')]");
}

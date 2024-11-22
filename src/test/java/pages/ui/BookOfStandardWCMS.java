package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookOfStandardWCMS extends BasePage {

    public BookOfStandardWCMS(WebDriver driver) {
        super(driver);
    }
    public By subscribeAstmCompass= By.xpath("//a[contains(text(),'subscribe to an online volume via ASTM Compass')]");
    public By DiscoverASTMCompass= By.xpath("//a[@title='Discover ASTM Compass']");
    public By contactUS= By.xpath("//a[@title='Contact Us']");
    //Book of ASTM Standards by Section
    public By CompleteSetAllSectionsVolumes= By.xpath("//a[normalize-space()='Complete Set - All sections and volumes']");
    public By IronSteelProducts= By.xpath("//a[normalize-space()='Iron and Steel Products']");
    public By NonferrousMetalProducts= By.xpath("//a[normalize-space()='Nonferrous Metal Products']");
    public By MetalsTestMethodsAnalyticalProcedures= By.xpath("//a[normalize-space()='Metals Test Methods and Analytical Procedures']");
    public By Construction= By.xpath("//a[normalize-space()='Construction']");
    public By PetroleumProductsLubricantsFossilFuels= By.xpath("//a[normalize-space()='Petroleum Products, Lubricants, and Fossil Fuels']");
    public By PaintsRelatedCoatingsAromatics= By.xpath("//a[normalize-space()='Paints, Related Coatings, and Aromatics']");
    public By Textiles= By.xpath("//a[normalize-space()='Textiles']");
    public By Plastics= By.xpath("//a[normalize-space()='Plastics']");
    public By Rubber= By.xpath("//a[normalize-space()='Rubber']");
    public By ElectricalInsulationElectronics= By.xpath("//a[normalize-space()='Electrical Insulation and Electronics']");
    public By WaterEnvironmentalTechnology= By.xpath("//a[normalize-space()='Water and Environmental Technology']");
    public By NuclearSolarGeothermalEnergy= By.xpath("//a[normalize-space()='Nuclear, Solar, and Geothermal Energy']");
    public By MedicalDeviceServices= By.xpath("//a[normalize-space()='Medical Device and Services']");
    public By GeneralMethodsInstrumentation= By.xpath("//a[normalize-space()='General Methods and Instrumentation']");
    public By GeneralProductsChemicalSpecialtiesEndUseProducts= By.xpath("//a[normalize-space()='General Products, Chemical Specialties, and End Use Products']");









}

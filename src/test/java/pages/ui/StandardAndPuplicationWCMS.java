package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StandardAndPuplicationWCMS extends BasePage {
    public StandardAndPuplicationWCMS(WebDriver driver) {
        super(driver);
    }
    public By BrowseByCategory=By.xpath("//a[@title='Browse by Category']");
    public By SignUpTracker=By.xpath("//a[normalize-space()='Sign Up for Tracker']");
    public By BookAstmStandard=By.xpath("//h5[text()='Book of ASTM Standards']/ancestor::div/a[text()='Learn More']");
    public By ASTMCompass=By.xpath("//h5[contains(text(),'ASTM Compass')]/ancestor::div/a[text()='Learn More']");
    public By ASTMDigitalLibrary=By.xpath("//a[@href='/standards-and-solutions/digital-library'][normalize-space()='Learn More']");
    public By Adjuncts=By.xpath("//a[contains(@title,'Adjuncts')]");
    public By ReferenceRadiographs = By.xpath("//a[@title='Reference Radiographs ']");
    public By ResearchReportsCommittee= By.xpath("//a[@title='Research Reports by Committee']");
    public By ViewUOPStandards= By.xpath("//a[@title='View UOP Standards']");
    public By ASMEDigitalCollection= By.xpath("//a[contains(text(),'ASME Digital Collection')]");
    public By PeerReviewedSymposiaPapersSTPs= By.xpath("//h6[contains(text(),'Peer-Reviewed Symposia Papers &  STPs')]/ancestor::div/a[text()='Learn More']");
    public By ManualsMonographsDataSeries= By.xpath("//h6[contains(text(),'Manuals, Monographs & Data Series')]/ancestor::div/a[text()='Learn More']");
    public By Journals= By.xpath("//h6[contains(text(),'Journals')]/ancestor::div/a[text()='Learn More']");
    public By TechnicalReports= By.xpath("//h6[contains(text(),'Technical Reports')]/ancestor::div/a[text()='Learn More']");
    public By OpenReadingRoom= By.xpath("//a[@title='Open Reading Room']");
    public By ViewCOVIDRelated= By.xpath("//a[@title='View COVID-19 Related Standards']");
    public By ShopRequestStandard= By.xpath("//a[contains(text(),'subscribe to an online volume via ASTM Compass')]");
    public By ContactUs= By.xpath("//a[@title='Contact Us']");

    public By BOSCatalogViewOnline= By.xpath("//h4[text()='ASTM 2024 BOS Catalog']/../..//a[text()='View Online']");
    public By ASTMAdvantageViewOnline= By.xpath("//p[contains(text(),'The ASTM Advantage')]/../../a[text()='View Online ']");
    public By ReferenceMaterialsViewOnline= By.xpath("//p[contains(text(),'Reference Materials')]/../../a[text()='View Online']");
    public By eLearningBrochureViewOnline= By.xpath("//p[contains(text(),'eLearning Brochure')]/../../a[text()='View Online']");
}

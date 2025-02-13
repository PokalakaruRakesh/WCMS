package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TechnicalCommitteesWCMS extends BasePage {

    public TechnicalCommitteesWCMS(WebDriver driver) {
        super(driver);
    }

    public By joinNow = By.xpath("//a[contains(text(),'Join Now')]");
    public By TechnicalCommitteeeFullList = By.xpath("//a[contains(text(),'Technical Committeee Full List')]");
    public By workItemfullListView = By.xpath("//a[@href='/membership-participation/technical-committees/work-items-full-list' and @title='View']");
    public By InitiateNewStandardsActivity = By.xpath("//a[@href='/membership-participation/technical-committees/new-standards-development' and @title='View']");
    public By SocietyReview = By.xpath("//a[@href='/society-review' and @title='View']");
    public By ANSIPublicReview = By.xpath("//a[@href='/membership-participation/technical-committees/ansi-review' and @title='View']");
    public By SCCPublicReview = By.xpath("//a[@href='/scc-public-review' and @title='View']");
    public By InterlaboratoryStudyProgram = By.xpath("//a[@href='/membership-participation/technical-committees/interlaboratory-studies-program']");
    public By EmergingProfessionalsProgram = By.xpath("//a[@href='/membership-participation/emerging-professionals'][normalize-space()='Learn More']");
    public By LabServices = By.xpath("//a[@href='/standards-and-solutions/laboratory-services'][normalize-space()='Learn More']");
    public By SustainabilityReferenceDatabase = By.xpath("//a[@href='/membership-participation/technical-committees/sustainability-reference']");
    public By PoliciesProcedures = By.xpath("//a[contains(text(),'Policies & Procedures')]");

}

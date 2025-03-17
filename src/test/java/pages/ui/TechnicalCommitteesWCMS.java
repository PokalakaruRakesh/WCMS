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
    public By InitiateNewStandardsActivity = By.xpath("//a[contains(@href,'/new-standards-development') and @title='View']");
    public By SocietyReview = By.xpath("//a[contains(@href,'/society-review') and @title='View']");
    public By ANSIPublicReview = By.xpath("//a[@href='/membership-participation/technical-committees/ansi-review' and @title='View']");
    public By SCCPublicReview = By.xpath("//a[contains(@href,'/scc-public-review') and @title='View']");
    public By InterlaboratoryStudyProgram = By.xpath("//a[@href='/membership-participation/technical-committees/interlaboratory-studies-program']");
    public By InterlaboratoryStudyProgramLink = By.xpath("//h6[text()='Interlaboratory Study Program (ILS)']/../../a[text()='Learn More']");
    public By EmergingProfessionalsProgram = By.xpath("//a[@href='/membership-participation/emerging-professionals'][normalize-space()='Learn More']");
    public By LabServices = By.xpath("//a[@href='/standards-and-solutions/laboratory-services'][normalize-space()='Learn More']");
    public By SustainabilityReferenceDatabase = By.xpath("//a[@href='/membership-participation/technical-committees/sustainability-reference']");
    public By PoliciesProcedures = By.xpath("//a[contains(text(),'Policies & Procedures')]");
    public By StaffEmail = By.xpath("//a[@href='mailto:mzamorski@astm.org']");
    public By SocietyAwards = By.xpath("//a[text()='Learn more about Society Awards.']");
    public By SocietyRecognized = By.xpath("//a[text()='Learn more about Society Recognized Committee Awards.']");
    public By TechnicalCommitteeAwards = By.xpath("//a[text()='Learn more about Technical Committee Awards.']");
    public By DownloadListPreviousRecipients = By.xpath("//a[@title='Download List of Previous Recipients By Award Name']");

    public By committeeF15 = By.xpath("//a[contains(text(),'/membership-participation/technical-committees/committee-f15')]");
    public By DownloadWorkProgram = By.xpath("//a[text()='Download Work Program']");
    public By PublicReviewMail = By.xpath("//a[contains(text(),'accreditation@astm.org')]");

    public By DownloadBallotActions = By.xpath("//a[text()='Download Ballot Actions']");
    public By SocietyReviewMail = By.xpath("//a[text()='socrev@astm.org']");

    public By TestMethodsSpecificationsLink = By.xpath("//a[contains(text(),'Test methods, specifications')]");
    public By PetroleumSteelLink = By.xpath("//a[contains(text(),'petroleum, steel')]");
    public By LightSportAircraftLink = By.xpath("//a[contains(text(),'Light Sport Aircraft & FAA')]");

    public By FormAndStyleLink = By.xpath("//a[contains(text(),'Form and Style Manual')]");
    public By RegulationsGoverningLink = By.xpath("//a[contains(text(),'Regulations Governing')]");
    public By DraftStandardTemplatesLink = By.xpath("//a[contains(text(),'Draft Standard Templates')]");
    public By RedBookLink = By.xpath("//a[contains(text(),'Red Book')]");
    public By StrategicPlanningLink = By.xpath("//a[contains(text(),'Strategic Planning Manual')]");
    public By ProxyFormLink = By.xpath("//a[contains(text(),'Proxy Form')]");
    public By CertificateAttendanceLink = By.xpath("//a[contains(text(),'Certificate of Attendance')]");
    public By SymposiumProposalLink = By.xpath("//a[contains(text(),'Symposium Proposal Form')]");
    public By DirectionsPreparingLink = By.xpath("//a[contains(text(),'Directions for Preparing')]");

    //Draft Standard Templates
    public By TestMethods = By.xpath("//a[text()='Test Methods']");
    public By Specifications = By.xpath("//a[text()='Specifications']");
    public By GuidesPractices = By.xpath("//a[text()='Guides/Practices']");
    public By Classification = By.xpath("//a[text()='Classification']");
    public By Terminology = By.xpath("//a[text()='Terminology']");
    public By ResearchReport = By.xpath("//a[text()='Research Report']");
    public By TemplateFeatures = By.xpath("//a[text()='Template Features']");
    public By TheFormStyle = By.xpath("//a[contains(text(),'The Form and Style')]");
    public By TechnicalSupport = By.xpath("//a[contains(text(),'Technical Support')]");
    public By TemplateQuestions = By.xpath("//a[contains(text(),'Template Questions')]");
}

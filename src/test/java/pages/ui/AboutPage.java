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

    public By BoardOfDirectors = By.xpath("//a[contains(@href, '21188-2024-Board-Book-Web.pdf') and text()='Download']");
    public By SeniorStaff = By.xpath("//a[contains(@href, 'Senior-Staff-2024.pdf') and text()='Download']");
    public By AnnualReport = By.xpath("//a[contains(@href, '2023-ASTM-Annual-Report.pdf') and text()='Download']");
    public By AnnualBusinessMeeting = By.xpath("//a[contains(@href, '2024-Annual-Business-Meeting.pdf') and text()='Download']");
    public By ASTMByLaws = By.xpath("//a[contains(@href, 'Bylaws102019E.pdf') and text()='Download the ASTM Bylaws PDF']");
    public By ASTMCharter = By.xpath("//a[contains(@href, 'CHARTER.pdf') and contains(text(), 'Download')]");
    public By ASTMBoardBookPDF = By.xpath("//a[contains(@href, '21188-2024-Board-Book-Web.pdf') and contains(text(), 'Download')]");


    public By CultureCareers = By.xpath("//a[contains(@href, '/about/careers') and contains(@data-testid, 'navLink-Culture')]");
    public By ViewOpenOpportunities = By.xpath("//a[contains(text(), 'View Open Opportunities')]");
    public By AccessibilityHrEmail = By.xpath(" //h4[text()='Accessibility']/following::a[contains(@href, 'mailto:hr@astm.org')][1]");
    public By LearnAboutDiversity = By.xpath("//a[contains(text(),'Learn more about Diversity, Equity')]");
    public By DiversityHrEmail = By.xpath("//h4[text()='Diversity, Equity, Inclusion, and Belonging']/following::a[contains(@href, 'mailto:hr@astm.org')][1]");
    public By DiversityHrEmail2 = By.xpath("//h4[text()='Diversity, Equity, Inclusion, and Belonging']/following::a[contains(@href, 'mailto:hr@astm.org')][2]");
    public By EVerifyEnglish = By.xpath("//a[@href[contains(.,'EverifyPosterEnglish.pdf')]]");
    public By EVerifySpanish = By.xpath("//a[contains(@href, 'EverifyPosterSpanish.pdf')]");
    public By WorkPlaceDiscrimination  = By.xpath("//a[contains(@href, 'EEOC_KnowYourRights_2022.pdf')]");
    public By RTW = By.xpath("//a[contains(@href, 'RTW_Poster_English_Version.pdf')]");
    public By RTWS = By.xpath("//a[contains(@href, 'RTW_Poster_Spanish_Version.pdf')]");
    public By ReviewEEOS = By.xpath("//a[contains(@href, '/policies/equal-opportunity-policy') and @target='_self']");
    public By ReviewVeteran = By.xpath("//a[contains(@href, '/policies/veteran-and-disabilities-policy') and @target='_self']");

    public By GlobalVideoLink = By.xpath("//div[@class='ytp-cued-thumbnail-overlay-image' and contains(@style, 'Ikt-aYVdDR8')]\n");
    public WebElement VideoLink(){
        return  driver.findElement(videoLink);
    }

    public By SupportingGlobal = By.xpath("//a[contains(@title, 'Download Supporting Global Growth')]");
    public By MOUMemberList = By.xpath("//a[contains(@title, 'Download MoU Members List')]");
    public By InResidenceTrainingPrograms = By.xpath("//a[contains(@title, 'Download MoU Members List')]");
    public By OnineTrainingLearnMore = By.xpath("//a[@href='/about/global-cooperation/online-training' and contains(text(), 'Learn More')]");
    public By InternationalPartners = By.xpath("//a[@href='/about/global-cooperation/international-partners' and contains(@class, 'mt-auto')]");
    public By UAEChapterLearn = By.xpath("//a[@href='https://astmuae.org/' and contains(text(), 'Learn More')]");





    public By LearnMoreAboutASTMMembership = By.xpath("//a[contains(text(),'Learn more about ASTM membership')]");
    public By BoardOfDirectorsLink = By.xpath("//a[contains(text(),'Board of Directors')]");
    public By EmploymentOpportunityLink = By.xpath("//a[contains(text(),'Employment Opportunity')]");


    //White Papers page
    public By RolesAndResponsibilitiesLink = By.xpath("//a[contains(text(),'Roles and Responsibilities')]");
    public By GlobalCollaborationLink = By.xpath("//a[contains(text(),'Global Collaboration')]");
    public By StandardsDevelopmentLink = By.xpath("//a[contains(text(),'Standards Development')]");
    public By StrengtheningTransatlanticLink = By.xpath("//a[contains(text(),'Strengthening Transatlantic')]");





}

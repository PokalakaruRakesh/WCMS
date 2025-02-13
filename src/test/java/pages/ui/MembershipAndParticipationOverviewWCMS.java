package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MembershipAndParticipationOverviewWCMS extends BasePage {

    public MembershipAndParticipationOverviewWCMS(WebDriver driver) {
        super(driver);
    }
    public By ParticipatingMembership = By.xpath("(//a[@title='Learn More' and contains(@href, 'application')])[1]");
    public By OrganizationalMembership = By.xpath("(//a[@title='Learn More' and contains(@href, 'application')])[2]");
    public By InformationalMembership = By.xpath("//*[contains(text(), 'Informational Membership')]//following::a[contains(text(), 'Learn More')][1]");
    public By StudentMembership = By.xpath("//*[contains(text(), 'Student Membership')]//following::a[contains(text(), 'Learn More')][1]");
    public By DirectCommitteeParticipation = By.xpath("//*[contains(text(), 'Direct Committee Participation')]//following::a[contains(text(), 'Learn More')][1]");
    public By PublicationDiscounts = By.xpath("//*[contains(text(), 'Publication Discounts')]//following::a[contains(text(), 'Learn More')][1]");
    public By StandardizationNews = By.xpath("//a[@href='/standardization-news'][normalize-space()='Learn More']");
    public By ExploreBenefitsJoin = By.xpath("//a[@title='Explore Benefits - Join']");
    public By MyCommittees = By.xpath("//*[contains(text(), 'My Committees')]//following::a[contains(text(), 'Learn More')][1]");
    public By ASTMCompass = By.xpath("//a[@href='/standards-and-solutions/enterprise-solutions/astm-compass'][normalize-space()='Learn More']");
    public By GetPublished = By.xpath("(//*[contains(text(), 'Learn More')])[18]");
    public By TechnicalCommitteesLearnMore = By.xpath("//*[contains(text(), 'Committees develop and maintain ASTM standards')]//following::a[contains(text(), 'Learn More')][1]");
    public By MeetingsSymposiaWorkshopsLearMore = By.xpath("//*[contains(text(), 'Committees develop and maintain ASTM standards')]//following::a[contains(text(), 'Learn More')][2]");
    public By MemberOfficerTrainingLearnMore= By.xpath("//*[contains(text(), 'Committees develop and maintain ASTM standards')]//following::a[contains(text(), 'Learn More')][3]");
    public By StudentsLearnMore = By.xpath("//*[contains(text(), 'Committees develop and maintain ASTM standards')]//following::a[contains(text(), 'Learn More')][4]");
    public By ConsumerParticipationLearnMore = By.xpath("//*[contains(text(), 'Committees develop and maintain ASTM standards')]//following::a[contains(text(), 'Learn More')][5]");
}

package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MembershipWCMS extends BasePage {
    public MembershipWCMS(WebDriver driver) {
        super(driver);
    }

    // Membership Learn More Links
    public By ParticipatingMembership = By.xpath("(//a[@title='Learn More' and contains(@href, 'application')])[1]");
    public By OrganizationalMembership = By.xpath("(//a[@title='Learn More' and contains(@href, 'application')])[2]");
    public By InformationalMembership = By.xpath("//*[contains(text(), 'Informational Membership')]//following::a[contains(text(), 'Learn More')][1]");
    public By StudentMembership = By.xpath("//*[contains(text(), 'Student Membership')]//following::a[contains(text(), 'Learn More')][1]");


    // Join an ASTM Technical Committee
    public By JoinASTMTechnicalCommittee = By.xpath("(//a[@href='/membership-participation/technical-committees'])[2]");
    public By EmergingProfessionals = By.xpath("//a[@title='Learn More' and @href='/membership-participation/emerging-professionals']");
    public By MemberResources = By.xpath("//a[contains(text(), 'Learn More About ASTM Technical Committees')]");

    //Member Training & Tools
    public By VirtualClassroomMembers = By.xpath("//h6[contains(text(),'Virtual Classroom for Members')]/ancestor::div/a[text()='Learn More']");
    public By NewMemberOrientation = By.xpath("//h6[contains(text(),'New Member Orientation')]/ancestor::div/a[text()='Learn More']");
    //ASTMIntroStandards 404 error on QA Server
    public By ASTMIntroStandards = By.xpath("//h6[contains(text(),'ASTM 101: Intro to Standards')]/ancestor::div/a[text()='Learn More']");
    public By TechnicalCommitteeResources = By.xpath("//h6[contains(text(),'Technical Committee Resources')]/ancestor::div/a[text()='Learn More']");
    public By KeyDocumentsForms = By.xpath("//h6[contains(text(),'Key Documents & Forms')]/ancestor::div/a[text()='Learn More']");
    public By MembershipFAQs = By.xpath("//h6[contains(text(),'Membership FAQs')]/ancestor::div/a[text()='Learn More']");
    public By RenewReinstateMembership = By.xpath("//h6[contains(text(),'Renew or Reinstate Membership')]/ancestor::div/a[text()='Learn More']");
    public By ContactASTMMember = By.xpath("//h6[contains(text(),'Contact ASTM Member')]/ancestor::div/a[text()='Learn More']");

}

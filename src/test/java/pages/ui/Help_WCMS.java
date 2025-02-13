package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Help_WCMS extends BasePage {
    public Help_WCMS(WebDriver driver) {
        super(driver);
    }

    public By InvoiceRequests = By.xpath("//h6[contains(text(),'Invoice')]/../../a");
    public By LoginProblemsPasswordReset = By.xpath("//h6[contains(text(),'Login Problems')]/../../a[text()='Learn More']");
    public By ASTMOnlinePaymentPortalFAQPage = By.xpath("//h6[contains(text(),'FAQ')]/../../a[text()='Learn More']");
    // About ASTM
    public By Aboutus = By.xpath("//a[contains(@href, '/about') and contains(text(), 'About us')]");
    public By WhatASTM = By.xpath("//a[contains(@href, '/about/fact-sheet') and contains(text(), 'What is ASTM?')]");
    public By WhatNewASTM = By.xpath("//a[contains(text(),'new at ASTM')]");
    public By ElectronicLicenseAgreement = By.xpath("//a[contains(@href, 'License_Agreement.pdf') and contains(text(), 'Electronic License Agreement')]");
    public By TermsandConditionsChart = By.xpath("//a[contains(@href, 'Terms_of_Use_Terms_Conditions_Chart.pdf') and contains(text(), 'Terms and Conditions Chart')]\n");
    //Policies
    public By PrivacyPolicy = By.xpath("(//a[normalize-space()='Privacy Policy'])[1]");
    public By CopyrightPermissions = By.xpath("//a[contains(@href, '/copyright-and-permissions') and contains(text(), 'Copyright and Permissions')]");
    public By AIPolicy = By.xpath("//a[contains(@href, 'ASTM_AI_Policy.pdf') and contains(text(), 'AI Policy')]");
    public By OtherPolicies = By.xpath("//a[normalize-space()='Other Policies']");
    //I purchased a subscription, how do I access it?
    public By EmailSubscriptionsettingsLearnMore = By.xpath("//a[contains(@href, 'email-subscription-settings') and contains(text(), 'Learn More')]");
    public By AddRemoveMarketing = By.xpath("//a[contains(@href, '/contact') and contains(text(), 'Contact Us')]");
    public By OrderOnline = By.xpath("//a[contains(@href, '/contact') and contains(text(), 'Contact Us') and contains(@target, '_blank')]");
    //Payments
    public By InvoiceOnlineCreditCard = By.xpath("//a[contains(@href, 'BillTrust%20-%20Credit%20Card.pdf') and contains(text(), 'How do I pay my invoice online with a credit card')]");
    public By OnlinePaymentBilltrustFAQ = By.xpath("//a[contains(@href, 'showLandingPage') and contains(text(), 'Online Payment (Billtrust) FAQ Page')]");
    public By RefundRequest = By.xpath("//a[contains(@href, '/contact') and contains(text(), 'How do I submit a refund request')]");
    //Membership
    public By MembershipTypesBenefits = By.xpath("//a[contains(@href, '/membership-participation/memberships') and contains(text(), 'Membership Types and Benefits')]");
    public By MemberTrainingNewMemberOrientation = By.xpath("//a[contains(@href, '/standards-and-solutions/training-courses/member-training') and contains(text(), 'Member Training and New Member Orientation')]");
    // Regional Offices and Support
    public By RegionalOfficesSupportLearnMore = By.xpath("//a[contains(@href, '/about/locations/regional-offices-and-support') and contains(text(), 'Learn More')]");

    public By EZProxy = By.xpath("//a[contains(text(),'EZProxy')]");
    public By DeletingCookiesCache = By.xpath("//a[contains(text(),'Deleting Cookies and Cache')]");
    public By W9Form = By.xpath("//a[contains(text(),'W-9 Form')]");

    public By Overview = By.xpath("(//a[contains(text(),'Overview')])[2]");
    public By ASTMFactSheet = By.xpath("//a[contains(text(),'ASTM Fact Sheet')]");
    public By ASTMNewsroom = By.xpath("//a[contains(text(),'ASTM Newsroom')]");
    public By MediaContact = By.xpath("//a[contains(text(),'Media Contact')]");
    public By LogoPolicy = By.xpath("//a[contains(text(),'Logo Policy')]");
    public By ReadingRoom = By.xpath("//a[contains(text(),'Reading Room')]");
    public By TermsOfUseAndConditions = By.xpath("//a[normalize-space()='Terms of Use and Conditions']");







}

package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Standard_SolutionOverviewWCMS extends BasePage {

    public Standard_SolutionOverviewWCMS(WebDriver driver) {
        super(driver);
    }
    public By StandardsLearnMore = By.xpath("//a[@title='Learn More' and @href='/standards-and-solutions/bos']");
    public By SubscriptionPortalsLearnMore = By.xpath("//*[contains(text(), 'Subscription Portals')]//following::a[contains(text(), 'Learn More')][1]");
    public By ASTMCompassLearnMore= By.xpath("//a[@href='/standards-and-solutions/enterprise-solutions/astm-compass'][normalize-space()='Learn More']");
    public By ASTMSpecBuilderLearnMore= By.xpath("//a[contains(@href, 'specbuilder') and contains(text(), 'Learn More')]");
    public By InternationalStandardsLearnMore = By.xpath("//a[contains(@href, '/enterprise-solutions/other-publishers') and contains(text(), 'Learn More')]");
    public By MultimediaServicesLearnMore = By.xpath("(//a[@href='/standards-and-solutions/enterprise-solutions/multimedia-services'])[2]");
    public By ASTMXcellerateLearnMore= By.xpath("//a[@href='https://astmxcellerate.com' and @title='Learn More ']");
    public By CentersExcellenceLearnMore = By.xpath("//a[@href='/standards-and-solutions/market-insights-and-innovation'and text()='Learn More']");
    public By StandardizationImpactReportLearnMore = By.xpath("//a[@href='https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-0403/t/page/fm/0' and @title='Learn More']");
    public By LaboratoryServicesLearnMore = By.xpath("//a[@href='/standards-and-solutions/laboratory-services' and text()='Learn More']");
    public By TrainingLearnMore= By.xpath("//a[@href='/standards-and-solutions/training-courses' and text()='Learn More']");
    public By CertificationLearnMore = By.xpath("//a[@href='/standards-and-solutions/certification' and text()='Learn More']");
    public By CementConcreteReferenceLaboratoryLearnMore = By.xpath("//a[@href='http://www.ccrl.us/' and @title='Learn More']");
}

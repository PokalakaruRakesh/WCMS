package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterpriseSolutionWCMS extends BasePage{
    public EnterpriseSolutionWCMS(WebDriver driver) {
        super(driver);
    }
    public By WhyASTM=By.xpath("//a[@title='Why ASTM?']");
    public By ASTMAdvantage=By.xpath("//a[@title='The ASTM advantage']");
    public By ASTMCompass=By.xpath("//h6[contains(text(),'ASTM Compass')]/ancestor::div/a[text()='Learn More']");
    public By SubscriptionPortals=By.xpath("//h6[contains(text(),'Subscription Portals')]/ancestor::div/a[text()='Learn More']");
    public By ASTMSpecBuilder=By.xpath("//h6[contains(text(),'ASTM SpecBuilder')]/ancestor::div/a[text()='Learn More']");
    public By MultimediaServices=By.xpath("//h6[contains(text(),'Multimedia Services')]/ancestor::div/a[text()='Learn More']");
    public By TrainStandardsExperts=By.xpath("//a[@title='Learn More' and contains(@href, '/standards-and-solutions/training-courses')]");
    public By ImproveLaboratoryEfficiency=By.xpath("//a[@title='Learn More' and contains(@href, 'standards-and-solutions/laboratory-services')]");
    public By ASTMDigitalLibrary=By.xpath("//a[@title='Learn More' and contains(@href, '/standards-and-solutions/digital-library')]");
}

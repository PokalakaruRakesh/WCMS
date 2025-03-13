package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublishWithASTMWCMS extends BasePage {

    public PublishWithASTMWCMS(WebDriver driver) {
        super(driver);
    }

    public By DigitalLibrary = By.xpath("//h6[contains(text(),'ASTM Digital Library')]/..//a[text()='ASTM Digital Library']");
    public By OpenAccessPolicy = By.xpath("//h2[contains(text(),'Why Publish')]/..//a[text()='Open Access Policy']");
    public By LearnMoreLink = By.xpath("//h2[contains(text(),'Why Publish')]/..//a[text()='Learn More']");
    public By BooksSoftwareDigitalLibrary = By.xpath("//h2[contains(text(),'Books & Software')]/..//a[text()='ASTM Digital Library']");
    public By BooksSoftwareBookProposalGuide = By.xpath("//h2[contains(text(),'Books & Software')]/..//a[text()='Book Proposal Guide']");
}

package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ASTMDigital_LibraryWCMS extends BasePage {
    public ASTMDigital_LibraryWCMS(WebDriver driver) {
        super(driver);
    }
    public By ASMEDigitalCollection = By.xpath("//a[normalize-space()='ASME Digital Collection']");
    public By AutherLearnMore = By.xpath("//h4[text()='Authors']/following-sibling::div/a[text()='Learn More']");
    public By DiscoverASTMCompass = By.xpath("//a[@title='Discover ASTM Compass']");
    public By ContactUs = By.xpath("//a[@title='Contact Us']");
    //Content Overview
    public By PeerReviewedLearnMore = By.xpath("//h6[text()='Peer-Reviewed Symposia Papers and Conference Proceedings']/ancestor::div/a[text()='Learn More']");
    public By ManualsMonographsLearnMore = By.xpath("//h6[text()='Manuals, Monographs, & Data Series']/ancestor::div/a[text()='Learn More']");
    public By JournalsLearnMore = By.xpath("//h6[text()='Journals']/ancestor::div/a[text()='Learn More']");
    public By TechnicalReportsLearnMore = By.xpath("//h6[contains(text(),'Technical Reports')]/ancestor::div/a[text()='Learn More']");
}

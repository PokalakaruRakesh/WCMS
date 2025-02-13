package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReferenceMaterials_WCMS extends BasePage {
    public ReferenceMaterials_WCMS(WebDriver driver) {
        super(driver);
    }
    public By frame = By.xpath("//iframe[@title='Wistia video player']");
    public By videoLink = By.xpath("(//img[contains(@alt,'Video')])[2]");
    public By ViewReferenceMaterials = By.xpath("//a[text()='View Reference Materials']");
    public By ContactUs= By.xpath("//a[text()='Contact Us']");
    public By ReferenceMaterialsCatalog = By.xpath("//a[text()='Reference Materials Catalog (PDF)']");
    public By QuoteRequest = By.xpath("//a[text()='Quote Request (Word)']");
    public By viewOurCatalog = By.xpath("//a[text()='view our catalog.']");
    public By RequestYourOrderNow = By.xpath("//h4[contains(text(),'Request your samples')]/..//a[text()='Order Now']");

    public WebElement getVideoLink() {
        return driver.findElement(videoLink);
    }
    public WebElement getFrame() {
        return getElement(frame);
    }
}

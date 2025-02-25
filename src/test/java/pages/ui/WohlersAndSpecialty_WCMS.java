package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WohlersAndSpecialty_WCMS extends BasePage {
    public WohlersAndSpecialty_WCMS(WebDriver driver) {
        super(driver);
    }

    public By ResearchDevelopmentLearnMore = By.xpath("//h6[contains(text(),'Research and Development')]/..//a[text()='Learn More']");
    public By PrintingAdditiveOrderNow = By.xpath("//h4[contains(text(),'3D Printing and Additive')]/..//a[text()='Order Now']");
    public By AlsoAvailableLearnMore = By.xpath("//h4[contains(text(),'Also Available')]/..//a[text()='Learn More']");
    public By HowToOrderOrderNow = By.xpath("//h4[contains(text(),'How to Order')]/..//a[text()='Order Now']");
    public By HowToOrderMail = By.xpath("//a[contains(text(),'wa@wohlersassociates.com')]");
}

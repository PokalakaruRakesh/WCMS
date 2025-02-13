package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegionalOfficesWCMS extends BasePage {

    public RegionalOfficesWCMS(WebDriver driver){ super(driver);}

    public By Direction = By.xpath("//a[contains(text(),'Directions')]");
    public By americaLatinaRelgion = By.xpath("//a[contains(text(),'ASTM in the America Latina Region')]");
    public By linkPortuguese = By.xpath("//a[contains(text(),'ASTM in Portuguese')]");
    public By linkJapanese = By.xpath("//a[contains(text(),'ASTM in Japanese')]");
    public By linkKorea = By.xpath("//a[contains(text(),'ASTM in Korea')]");
    public By linkMandarin = By.xpath("//a[contains(text(),'ASTM in Mandarin')]");

}

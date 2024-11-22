package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ASTMCompassWCMS extends BasePage {
    public ASTMCompassWCMS(WebDriver driver) {
        super(driver);
    }

    public By viewDemo = By.xpath("//a[contains(@title,'View Demo')]");
    public By learnMore = By.xpath("//a[contains(@title,'Learn More')]");
    public By astmCompassGuid = By.xpath("//a[contains(@title,'ASTM Compass Guide')]");
    public By compassEbook = By.xpath("//a[contains(@title,'Compass eBook')]");
    public By contactAstmSales = By.xpath("//a[text()='Contact ASTM Sales']");
}

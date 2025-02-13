package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ASTMSpecBuilderWCMS extends BasePage{
    public ASTMSpecBuilderWCMS(WebDriver driver) {
        super(driver);
    }

    public By RequestDemo= By.xpath("//a[@title='Request Demo']");
    public By VieweBook= By.xpath("//a[@title='View eBook: ASTM SpecBuilder']");
    public By GetStarted= By.xpath("//a[normalize-space()='Get Started']");
}

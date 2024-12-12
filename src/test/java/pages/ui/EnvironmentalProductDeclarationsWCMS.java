package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnvironmentalProductDeclarationsWCMS extends BasePage {

    public EnvironmentalProductDeclarationsWCMS(WebDriver driver) {
        super(driver);
    }
    //For WCMS
    public By EnvironmentalProductDeclarations= By.xpath("//h2[text()='Environmental Product Declarations']");
    public By PublishedProductCategoryRules= By.xpath("//h4[contains(text(),'Published Product Category Rules')]");
    public By ProductCategoryRulesText= By.xpath("//p[contains(text(),'Product category rules are defined ')]");
    public By ASTMInternationalPublishedPCR= By.xpath("//h6[text()='ASTM International has published the following PCR.']");
    public By PCRLinks= By.xpath("//h6[text()='ASTM International has published the following PCR.']/../ul//a");
    public By PublishedEnvironmentalProductDeclarations= By.xpath("//h2[text()='Published Environmental Product Declarations']");
    public By EnvironmentalProductText= By.xpath("//p[contains(text(),'An Environmental Product Declaration (EPD) ')]");
    public By EPDLinks= By.xpath("//h2[text()='Published Environmental Product Declarations']/..//ul//a");

    //For Prod
    public By EnvironmentalProductDeclarations1= By.xpath("//h1[contains(text(),'Environmental Product Declarations')]");
    public By ASTMInternationalPublishedPCR1= By.xpath("//p[contains(text(),'ASTM International has published the following PCR.')]");
    public By PCRLinks1= By.xpath("//p[contains(text(),'ASTM International has published the following PCR.')]/../ul[1]//a");
    public By PublishedEnvironmentalProductDeclarations1= By.xpath("//h4[contains(text(),'Published Environmental Product Declarations')]");
    public By EPDLinks1= By.xpath("//h4[contains(text(),'Published Environmental Product Declarations')]/../ul[2]//a");

    public By category= By.xpath("//div[@class='g-col-9 styles_mainContent___k_cj']");
    public By category1= By.xpath("//div[@class='category-view']");



}

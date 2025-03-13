package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CertificationWCMS extends BasePage {

    public CertificationWCMS(WebDriver driver) {
        super(driver);
    }

    public By ProductCertification = By.xpath("//a[text()='Product Certification']");
    public By EnvironmentalProductDeclarations = By.xpath("//h2[text()='Certification']/..//a[text()='Environmental Product Declarations']");
    public By LearnMoreAboutPersonalCertification = By.xpath("//a[text()='Learn More About Personnel Certification']");
    public By HowItWorks = By.xpath("//a[text()='How It Works']");
    public By WhySEI = By.xpath("//a[text()='Ebook: Why SEI']");
    public By ProductCertificationLeranMore = By.xpath("//h4[contains(text(),'Product Certification')]/..//a[text()='Learn More']");
    public By SearchByProduct = By.xpath("//a[text()='Search by product, program and company.']");
    public By LearnMoreAboutSEI = By.xpath("//a[text()='Learn More About SEI ']");
    public By ConstructionMaterials = By.xpath("//a[contains(text(),'Construction Materials Testing')]");
    public By PetroleumLaboratory = By.xpath("//a[contains(text(),'Petroleum Laboratory Professionals')]");
    public By LiabilitiesProfessional = By.xpath("//a[contains(text(),'ASTM Certified Environmental Liabilities Professional')]");
    public By ASTMCertifiedEnvironmental = By.xpath("//a[contains(text(),'ASTM Certified Environmental Professional')]");

    public By PersonnelCertificationLeranMore = By.xpath("//h4[contains(text(),'Personnel Certification')]/..//a[text()='Learn More']");
    public By ASTMCANNQLeranMore = By.xpath("//h4[contains(text(),'ASTM CANNQ')]/..//a[contains(text(),'Learn More')]");
    public By AdditiveManufacturingLeranMore = By.xpath("//h4[contains(text(),'Additive Manufacturing')]/..//a[contains(text(),'Learn More')]");
    public By LearnMoreAboutNCATT = By.xpath("//a[contains(text(),'Learn More about NCATT')]");
    public By EnvironmentalProductLeranMore = By.xpath("//h4[contains(text(),'Environmental Product')]/..//a[contains(text(),'Learn More')]");

}
